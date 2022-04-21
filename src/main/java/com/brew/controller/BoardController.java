package com.brew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brew.domain.Board;
import com.brew.domain.StoreInfo;
import com.brew.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	public String boardSearchResult(Model model, @PageableDefault(page=0, size=10) Pageable pageable) {
		String boardCategory = "검색 결과";
		String boardCategoryCode = "searchResult";
		// List<Board> boardAll = boardService.findPageByTitleAndContent();
		return "view/board/boardMain";
	}
	
	@RequestMapping("/hotPage")
	public String boardHotPage(Model model, @PageableDefault(page=0, size=10) Pageable pageable) {
		String boardCategory = "Hot게시판";
		String boardCategoryCode = "hotPage";
		
		return this.boardPagination(model, pageable, boardCategory, boardCategoryCode);
	}
	
	public String boardPagination(Model model, Pageable pageable, String boardCategory, String boardCategoryCode) {
		model.addAttribute("boardCategory", boardCategory);
		// 카테고리에 속하는 목록들만 불러옴.
		Page<Board> board = boardService.findByBoardCategory(boardCategoryCode, pageable);
		int boardTotalPages = board.getTotalPages();
		// 시각적인 현재 페이지
		int nowPage = board.getPageable().getPageNumber()+1;
		// 시각적인 맨 첫 페이지, 맨 끝 페이지
		int startPage = 1;
		int endPage = board.getTotalPages();
		// 10페이지 단위로 나눌 예정.
		int currentStart = (nowPage/10)*10 + 1;
		int	currentLast = currentStart + 9 < boardTotalPages ? currentStart + 9 : boardTotalPages;
		
//		System.out.println(boardTotalPages);
//		System.out.println(nowPage);
//		System.out.println(startPage);
//		System.out.println(endPage);
//		System.out.println(currentStart);
//		System.out.println(currentLast);
		
		model.addAttribute("boardList", board);
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
	public String boardFreePage(Model model, @PageableDefault(page=0, size=10) Pageable pageable) {
		String boardCategory = "자유게시판";
		String boardCategoryCode = "freePage";
		return this.boardPagination(model, pageable, boardCategory, boardCategoryCode);
	}
	
	@RequestMapping("/recommendStore")
	public String boardRecommendStore(Model model, @PageableDefault(page=0, size=10) Pageable pageable) {
		String boardCategory = "추천맛집";
		String boardCategoryCode = "recommendStore";
		return this.boardPagination(model, pageable, boardCategory, boardCategoryCode);
	}
	
	@RequestMapping("/serviceCenter")
	public String boardServiceCenter(Model model, @PageableDefault(page=0, size=10) Pageable pageable) {
		String boardCategory = "고객센터";
		String boardCategoryCode = "serviceCenter";
		return this.boardPagination(model, pageable, boardCategory, boardCategoryCode);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String boardDetailPage(Model model, @PageableDefault(page=0, size=10) Pageable pageable, String BoardId) {

		Board board = boardService.findByBoardId(BoardId);
		model.addAttribute("board", board);
		
		return "view/board/boardPage";
	}
	
}
