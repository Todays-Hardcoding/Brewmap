package com.brew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brew.domain.Board;
import com.brew.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/hotPage")
	public String boardHotPage(Model model, @PageableDefault(page=0, size=10) Pageable pageable) {
		String boardCategory = "Hot게시판";
		String boardCategoryEng = "hotPage";
		model.addAttribute("boardCategory", boardCategory);
		Page<Board> board = boardService.findByBoardCategory(boardCategory, pageable);
		int boardTotalPages = board.getPageable().getPageNumber();
		int nowPage = board.getPageable().getPageNumber() + 1;
		int startPage = Math.max(nowPage-2, 1);
		int endPage = Math.min(nowPage+2, board.getTotalPages());
		int currentStart = (int) (Math.floor(nowPage/10)*10 + 1);
		int	currentLast = currentStart + 9 < boardTotalPages ? currentStart + 9 : boardTotalPages;
		
		model.addAttribute("boardList", board);
		model.addAttribute("boardTotalPages", boardTotalPages);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("currentStart", currentStart);
		model.addAttribute("currentLast", currentLast);
		model.addAttribute("boardCategoryEng", boardCategoryEng);
		return "view/board/boardMain";
	}
	
	@RequestMapping("/freePage")
	public String boardFreePage(Model model, @PageableDefault(page=0, size=10) Pageable pageable) {
		String boardCategory = "자유게시판";
		Page<Board> board = boardService.findByBoardCategory(boardCategory, pageable);
		model.addAttribute("boardList", board);
		return "view/board/boardMain";
	}
	
	@RequestMapping("/recommendStore")
	public String boardRecommendStore(Model model, @PageableDefault(page=0, size=10) Pageable pageable) {
		String boardCategory = "추천맛집";
		Page<Board> board = boardService.findByBoardCategory(boardCategory, pageable);
		model.addAttribute("boardList", board);
		return "view/board/boardMain";
	}
	
	@RequestMapping("/serviceCenter")
	public String boardServiceCenter(Model model, @PageableDefault(page=0, size=10) Pageable pageable) {
		String boardCategory = "고객센터";
		Page<Board> board = boardService.findByBoardCategory(boardCategory, pageable);
		model.addAttribute("boardList", board);
		return "view/board/boardMain";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String boardDetailPage(Model model, @PageableDefault(page=0, size=10) Pageable pageable, String BoardId) {

		Board board = boardService.findByBoardId(BoardId);
		model.addAttribute("board", board);
		
		return "view/board/boardPage";
	}
	
}
