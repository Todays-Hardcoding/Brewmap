
package com.brew.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brew.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{
	
	// 카테고리로 검색
	Page<Board> findByBoardCategory(String boardCategoryCode, Pageable pagealbe);
	
	// 게시판 제목+내용 검색
	@Query(value = "select * from board where "
			+ "board_title like %:keyword% or "
			+ "board_content like %:keyword%"
			, nativeQuery = true)
	Page<Board> findPageByTitleAndContent(@Param("keyword") String keyword, Pageable pageable);
	
	// 작성자로 검색
	
	// 게시판 아이디로 검색
	Board findByBoardId(long boardId);
<<<<<<< HEAD
}
=======
}

>>>>>>> branch 'GY' of https://github.com/Todays-Hardcoding/Brewmap.git
