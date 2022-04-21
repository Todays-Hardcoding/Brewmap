package com.brew.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brew.domain.Board;
import com.brew.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	public Page<Board> findByBoardCategory(String boardCategory, Pageable pageable) {
        return boardRepository.findByBoardCategory(boardCategory, pageable);
    }
	
	public Board findByBoardId(String boardId) {
        return boardRepository.findByBoardId(boardId);
    }
}
