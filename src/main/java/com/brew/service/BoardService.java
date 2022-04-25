package com.brew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.brew.domain.Board;
import com.brew.domain.Reply;
import com.brew.repository.BoardRepository;
import com.brew.repository.ReplyRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private ReplyRepository replyRepository;

	
	public List<Board> findAllBoard() {
		return boardRepository.findAll();
	}
	
	public Page<Board> findAllBoard(Pageable pageable) {
		return boardRepository.findAll(pageable);
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
	
	public void deleteByBoardId(long boardId) {
		boardRepository.deleteById(boardId);
	}
	
	public Reply saveReply(Reply reply) {
		return replyRepository.save(reply);
	}
	
	public void deleteByReplyId(long replyId) {
		replyRepository.deleteById(replyId);
	}
	
	public void deleteAllReplyInBoard(List<Reply> reply) {
		replyRepository.deleteAllInBatch(reply);
	}
	
}

