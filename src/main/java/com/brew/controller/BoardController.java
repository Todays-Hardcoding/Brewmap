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
		@SortDefault(sort = "board_date", direction = Direction.DESC)
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
	public String boardSearchTitleAndContent(Model model, @PageableDefault(page=0, size=10) Pageable pageable, @RequestParam String keyword, String boardCategoryCode) {
		String boardCategory = "검색결과";
		// String boardCategoryCode = "searchTitleAndContent";
		Page<Board> searchResult = boardService.findPageByTitleAndContent(keyword, pageable, boardCategoryCode);
		model.addAttribute("keyword", keyword);
		// model.addAttribute("boardList", searchResult);
		// return "redirect:" + boardCategoryCode;
		return this.boardPagination(model, pageable, boardCategory, boardCategoryCode, searchResult);
	}
	
	// 리뷰 수 많은 순서대로 보여짐. 술집랭킹 페이지
	@RequestMapping("/hotPage")
	public String boardHotPage(Model model, @PageableDefault(page=0, size=10) @SortDefault.SortDefaults({
		@SortDefault(sort="review_count", direction = Direction.DESC)
	}) Pageable pageable) {
		String boardCategory = "술집랭킹";
		String boardCategoryCode = "hotPage";
		
		// 리뷰 임의로 만들어서 리뷰 많은 순으로 정렬되는 지 확인 위함. -> 하나라도 있어야 카운트 되니까(무조건 boot에서 넣어야 측정됨.)
		int reviewStar = 3;
		String reviewComment = "제발 좀 빌드 돼라";
		String userId = "abc"; // db에 있는 유저 아이디
		String storeCode = "1099354434"; // 평일주점
		StoreInfo storeInfo = storeInfoService.findByStoreCode(storeCode);
		User user = userservice.findByUserId(userId);
		Review review = Review.builder().storeInfo(storeInfo).user(user).reviewStar(reviewStar).reviewComment(reviewComment).build();
		reviewService.saveReview(review);
		// 확인 완료
		
		// 리뷰 많은 순으로 전체 술집 목록을 불러옴.
		Page<StoreInfo> storeList = storeInfoService.findAllStores(pageable);
		// 페이징 및 출력함수 호출
		return this.storeListPagination(model, pageable, boardCategory, boardCategoryCode, storeList);
	}	
	
	// pagination 메소드
	public String storeListPagination(Model model, Pageable pageable, String boardCategory, String boardCategoryCode, Page<StoreInfo> storeList) {
		model.addAttribute("boardCategory", boardCategory);
		
		int TotalPages = storeList.getTotalPages();
		// 시각적인 현재 페이지
		int nowPage = storeList.getPageable().getPageNumber()+1;
		// 시각적인 맨 첫 페이지, 맨 끝 페이지
		int startPage = 1;
		int endPage = storeList.getTotalPages();
		// 10페이지 단위로 나눌 예정.
		int currentStart = (nowPage/10)*10 + 1;
		int	currentLast = currentStart + 9 < TotalPages ? currentStart + 9 : TotalPages;
		
		model.addAttribute("boardList", storeList);
		model.addAttribute("boardTotalPages", TotalPages);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("currentStart", currentStart);
		model.addAttribute("currentLast", currentLast);
		model.addAttribute("boardCategoryCode", boardCategoryCode);
		return "view/board/boardHotPageMain";
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
