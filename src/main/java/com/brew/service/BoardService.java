package com.brew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.brew.domain.Board;
import com.brew.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;

	
	public List<Board> findAllBoard() {
		return boardRepository.findAll();
	}
	
	public Page<Board> findByBoardCategory(String boardCategoryCode, Pageable pageable) {
        return boardRepository.findByBoardCategory(boardCategoryCode, pageable);
    }
	
	public Page<Board> findPageByTitleAndContent(@Param("keyword") String keyword, Pageable pageable){
		return boardRepository.findPageByTitleAndContent(keyword, pageable);
	}
		
	public Board findByBoardId(long boardId) {
        return boardRepository.findByBoardId(boardId);
    }
	
	public Board saveBoard(Board board) {
		return boardRepository.save(board);
	}

	public Page<Board> findAllBoard(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	public void deleteByBoardId(long boardId) {
		boardRepository.deleteById(boardId);
	};
}
