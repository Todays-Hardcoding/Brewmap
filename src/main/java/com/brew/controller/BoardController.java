package com.brew.controller;

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
import com.brew.domain.Review;
import com.brew.domain.StoreInfo;
import com.brew.domain.User;
import com.brew.service.BoardService;
import com.brew.service.ReviewService;
import com.brew.service.StoreInfoService;
import com.brew.service.UserService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private StoreInfoService storeInfoService;
	
	@Autowired
	private ReviewService reviewService;
	
	// 글쓰기 창으로
	@RequestMapping("/createPage")
	public String createPage() {
		return "view/board/boardCreate";
	}
	
	// 글수정 창으로
	@RequestMapping(value="/updatePage", method = RequestMethod.GET)
	public String updatePage(Model model, @RequestParam long boardId) {
		Board board = boardService.findByBoardId(boardId);
		model.addAttribute("board", board);

		return "view/board/boardEdit";
	}
	
	// 글쓰기
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String createBoard(Model model, @ModelAttribute Board board, String userId) {
		String boardCategoryCode = board.getBoardCategory();
		User user =userservice.findByUserId(userId);
		board.setUser(user);
		
		boardService.saveBoard(board);
		
		return "redirect:"+boardCategoryCode;
	}
	
	// 글수정
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String updateBoard(Model model, @ModelAttribute Board board, String userId) {
		User user = userservice.findByUserId(userId);
		board.setUser(user);
		
		boardService.saveBoard(board);
		
		return "redirect:?boardId="+ board.getBoardId();
	}
	
	// 삭제
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteBoard(Model model, long boardId) {
		Board board = boardService.findByBoardId(boardId);
		String boardCategoryCode = board.getBoardCategory();
		
		boardService.deleteAllReplyInBoard(board.getReply());
		boardService.deleteByBoardId(boardId);
		
		return "redirect:"+boardCategoryCode;
	}
	
	// 제목 + 내용 검색 메소드
	@RequestMapping("/searchTitleAndContent")
	public String boardSearchTitleAndContent(Model model, @PageableDefault(page=0, size=10) Pageable pageable, @RequestParam String keyword, String boardCategoryCode) {
		String boardCategory = "검색결과";
		// String boardCategoryCode = "searchTitleAndContent";
		Page<Board> searchResult = boardService.findPageByTitleAndContent(boardCategoryCode, keyword, pageable);
		model.addAttribute("keyword", keyword);
		// model.addAttribute("boardList", searchResult);
		// return "redirect:" + boardCategoryCode;
		return this.boardPagination(model, pageable, boardCategory, boardCategoryCode, searchResult);
	}
	
	// 술집랭킹 페이지
	@RequestMapping("/hotPage")
	public String boardHotPage(Model model, @PageableDefault(page=0, size=10) Pageable pageable) {
		String boardCategory = "술집랭킹";
		String boardCategoryCode = "hotPage";
		
		// 리뷰 많은 순으로 전체 술집 목록을 불러옴.
		Page<StoreInfo> storeList = storeInfoService.findHotStores(pageable);
		// 페이징 및 출력함수 호출
		return this.ListPagination(model, pageable, boardCategory, boardCategoryCode, storeList);
	}
	
	// 리뷰 페이지
	@RequestMapping("/reviewPage")
	public String boardreviewPage(Model model, @PageableDefault(page=0, size=10) Pageable pageable) {
		String boardCategory = "술집추천";
		String boardCategoryCode = "reviewPage";
		
		// 최근 일주일 리뷰 목록들을 불러옴
		Page<Review> reviewList = reviewService.findRecentReview(pageable);
		// 페이징 및 출력함수 호출
		return this.ListPagination(model, pageable, boardCategory, boardCategoryCode, reviewList);
	}
	
	// pagination 메소드
	public <T> String ListPagination (Model model, Pageable pageable, String boardCategory, String boardCategoryCode, Page<T> list) {
		model.addAttribute("boardCategory", boardCategory);
		
		int TotalPages = list.getTotalPages();
		// 시각적인 현재 페이지
		int nowPage = list.getPageable().getPageNumber()+1;
		// 시각적인 맨 첫 페이지, 맨 끝 페이지
		int startPage = 1;
		int endPage = list.getTotalPages();
		// 10페이지 단위로 나눌 예정.
		int currentStart = (nowPage/10)*10 + 1;
		int	currentLast = currentStart + 9 < TotalPages ? currentStart + 9 : TotalPages;
		
		model.addAttribute("list", list);
		model.addAttribute("boardTotalPages", TotalPages);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("currentStart", currentStart);
		model.addAttribute("currentLast", currentLast);
		model.addAttribute("boardCategoryCode", boardCategoryCode);
		
		if(boardCategoryCode.equals("reviewPage"))
			return "view/board/boradReviewPage";
		else
			return "view/board/boardHotPage";
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
	
	@RequestMapping("/recommendStore")
	public String boardRecommendStore(Model model, @PageableDefault(page=0, size=10) @SortDefault.SortDefaults({
		@SortDefault(sort = "boardDate", direction = Direction.DESC)
	}) Pageable pageable) {
		String boardCategory = "술집추천";
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
	
	@RequestMapping("/insertReply")
	public String replyInsert(Model model, long boardId, String userId, String replyContent) {
		User user = userservice.findByUserId(userId);
		Board board = boardService.findByBoardId(boardId);
		Reply reply = Reply.builder().user(user).board(board).replyContent(replyContent).build();
		boardService.saveReply(reply);
		model.addAttribute("board", board);
		
		return "redirect:?boardId="+boardId;
	}
	
	@RequestMapping(value="/deleteReply", method=RequestMethod.POST)
	public String replyDelete(Model model, long boardId, long replyId) {
		boardService.deleteByReplyId(replyId);
	
		return "redirect:?boardId="+boardId;
	}
	
	@RequestMapping(value="/likeCount", method=RequestMethod.GET)
	public String likecount(Model model, Long boardId) {
		Board board = boardService.findByBoardId(boardId);
		board.setBoardLikeCount(board.getBoardLikeCount() + 1);
		boardService.saveBoard(board);
		return "redirect:?boardId="+boardId;
	}
	
}