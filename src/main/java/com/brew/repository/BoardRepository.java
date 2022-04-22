package com.brew.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brew.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, String>{
	
<<<<<<< HEAD
	// 카테고리로 검색
	Page<Board> findByBoardCategory(String boardCategory, Pageable pagealbe);
	
	// 게시판 아이디로 검색
	Board findByBoardId(String boardId);
	
}
=======
}
>>>>>>> origin/jinho_branch
