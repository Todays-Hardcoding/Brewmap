package com.brew.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brew.domain.Board;
import com.brew.domain.StoreInfo;

@Repository
public interface BoardRepository extends JpaRepository<Board, String>{
	
<<<<<<< HEAD
	// 카테고리로 검색
	Page<Board> findByBoardCategory(String boardCategory, Pageable pagealbe);
	
	// 게시판 아이디로 검색
	Board findByBoardId(String boardId);
	
=======
>>>>>>> 4bd2c59912f605790241b9cc5f706f6e0000cb77
}
