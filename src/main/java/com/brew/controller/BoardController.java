package com.brew.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.brew.domain.Board;
import com.brew.domain.Reply;
import com.brew.domain.User;
import com.brew.service.BoardService;
import com.brew.service.UserService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private UserService userservice;
	
	
	// 글쓰기 버튼 눌렀을 때 작성 창으로 이동하는 메소드(매핑만)
	@RequestMapping("/edit")
	public String boardEdit() {
		return "view/board/boardCreate";
	}
	
	// boardId를 받아 수정 창을 띄움.
	@RequestMapping(value="/editUpdate", method = RequestMethod.GET)
	public String boardEditUpdate(Model model, @RequestParam(defaultValue = "0") long boardId) {
		Board board = boardService.findByBoardId(boardId);
		model.addAttribute("board", board);

		return "view/board/boardEdit";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String boardCreateUpdate(Model model, Pageable pageable, @ModelAttribute Board board, String userId) {
		User user =userservice.findByUserId(userId);
		board.setUser(user);
		String boardCategoryCode = board.getBoardCategory();
//		Board oldBoard = boardService.findByBoardId(board.getBoardId());
//		if(oldBoard != null && !oldBoard.getBoardTitle().equals(board.getBoardTitle())) {
//			oldBoard.setBoardTitle(board.getBoardTitle());
//		}
//		if(oldBoard != null && !oldBoard.getBoardContent().equals(board.getBoardContent())) {
//			oldBoard.setBoardContent(board.getBoardContent());
//		}
		
		boardService.saveBoard(board);					
		return "redirect:"+boardCategoryCode;
	}
	
	// 삭제
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String boardDelete(Model model, @PageableDefault(page=0, size=10) @SortDefault.SortDefaults({
		@SortDefault(sort = "boardDate", direction = Direction.DESC)
	}) Pageable pageable, long boardId) {
		Board board = boardService.findByBoardId(boardId);
		String boardCategoryCode = board.getBoardCategory();
		boardService.deleteAllReplyInBoard(board.getReply());
		boardService.deleteByBoardId(boardId);
		// 페이징 및 출력함수 호출
		return "redirect:"+boardCategoryCode;
	}
	
	// 제목 + 내용 검색 메소드
	@RequestMapping("/searchTitleAndContent")
	public String boardSearchTitleAndContent(Model model, @PageableDefault(page=0, size=10) Pageable pageable, @RequestParam String keyword) {
		String boardCategory = "검색결과";
		String boardCategoryCode = "searchTitleAndContent";
		Page<Board> searchResult = boardService.findPageByTitleAndContent(keyword, pageable);
		model.addAttribute("keyword", keyword);
		return this.boardPagination(model, pageable, boardCategory, boardCategoryCode, searchResult);
	}
	
	// 좋아요 순서대로 보여짐.
	@RequestMapping("/hotPage")
	public String boardHotPage(Model model, @PageableDefault(page=0, size=10) @SortDefault.SortDefaults({
		@SortDefault(sort = "boardLikeCount", direction = Direction.DESC)
	}) Pageable pageable) {
		String boardCategory = "Hot게시판";
		String boardCategoryCode = "hotPage";
		
		// 카테고리에 속하는 목록들만 불러옴.
		Page<Board> boardList = boardService.findAllBoard(pageable);
		// 페이징 및 출력함수 호출
		return this.boardPagination(model, pageable, boardCategory, boardCategoryCode, boardList);
	}	
	
	
	// 페이징 및 출력 통일한 메소드
	public String boardPagination(Model model, Pageable pageable, String boardCategory, String boardCategoryCode, Page<Board> boardList) {
		model.addAttribute("boardCategory", boardCategory);
		
		int boardTotalPages = boardList.getTotalPages();
		// 시각적인 현재 페이지
		int nowPage = boardList.getPageable().getPageNumber()+1;
		// 시각적인 맨 첫 페이지, 맨 끝 페이지
		int startPage = 1;
		int endPage = boardList.getTotalPages();
		// 10페이지 단위로 나눌 예정.
		int currentStart = (nowPage/10)*10 + 1;
		int	currentLast = currentStart + 9 < boardTotalPages ? currentStart + 9 : boardTotalPages;
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardTotalPages", boardTotalPages);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("currentStart", currentStart);
		model.addAttribute("currentLast", currentLast);
		model.addAttribute("boardCategoryCode", boardCategoryCode);
		return "view/board/boardMain";
	}
	
	@RequestMapping("/freePage")
	public String boardFreePage(Model model, @PageableDefault(page=0, size=10) @SortDefault.SortDefaults({
		@SortDefault(sort = "boardDate", direction = Direction.DESC)
	}) Pageable pageable) {
		String boardCategory = "자유게시판";
		String boardCategoryCode = "freePage";
		// 카테고리에 속하는 목록들만 불러옴.
		Page<Board> boardList = boardService.findByBoardCategory(boardCategoryCode, pageable);
		// 페이징 및 출력함수 호출
		return this.boardPagination(model, pageable, boardCategory, boardCategoryCode, boardList);
	}
	
	@RequestMapping("/recommendStore")
	public String boardRecommendStore(Model model, @PageableDefault(page=0, size=10) @SortDefault.SortDefaults({
		@SortDefault(sort = "boardDate", direction = Direction.DESC)
	}) Pageable pageable) {
		String boardCategory = "맛집추천";
		String boardCategoryCode = "recommendStore";
		// 카테고리에 속하는 목록들만 불러옴.
		Page<Board> boardList = boardService.findByBoardCategory(boardCategoryCode, pageable);
		// 페이징 및 출력함수 호출
		return this.boardPagination(model, pageable, boardCategory, boardCategoryCode, boardList);
	}
	
	@RequestMapping("/serviceCenter")
	public String boardServiceCenter(Model model, @PageableDefault(page=0, size=10) @SortDefault.SortDefaults({
		@SortDefault(sort = "boardDate", direction = Direction.DESC)
	}) Pageable pageable) {
		String boardCategory = "고객센터";
		String boardCategoryCode = "serviceCenter";
		// 카테고리에 속하는 목록들만 불러옴.
		Page<Board> boardList = boardService.findByBoardCategory(boardCategoryCode, pageable);
		// 페이징 및 출력함수 호출
		return this.boardPagination(model, pageable, boardCategory, boardCategoryCode, boardList);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String boardDetailPage(Model model, @PageableDefault(page=0, size=10) Pageable pageable, long boardId) {
		Board board = boardService.findByBoardId(boardId);
		model.addAttribute("board", board);
		
		return "view/board/boardPage";
	}
	
	@RequestMapping("/replyInsert")
	public String replyInsert(Model model, long boardId, String replyUser, String replyContent) {
		Board board = boardService.findByBoardId(boardId);
		Reply reply = Reply.builder().board(board).replyUser(replyUser).replyContent(replyContent).build();
		boardService.saveReply(reply);
		model.addAttribute("board", board);
		
		return "redirect:?boardId="+boardId;
	}
	
	@RequestMapping(value="/replyDelete", method=RequestMethod.POST)
	public String replyDelete(Model model, long boardId, long replyId) {
		System.out.println(boardId);
		System.out.println(replyId);
		
		boardService.deleteByReplyId(replyId);
	
		return "redirect:?boardId="+boardId;
	}
}
