package com.brew.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brew.domain.StoreInfo;

@Repository
public interface StoreInfoRepository extends JpaRepository<StoreInfo, String> {
	
	@Query(value = "select * from store_info where "
			+ "store_name like %:keyword% or "
			+ "store_category like %:keyword% or "
			+ "store_road_addr like %:keyword% or "
			+ "store_addr like %:keyword% or "
			+ "store_tel like %:keyword% or "
			+ "store_tag like %:keyword%", nativeQuery = true)
	List<StoreInfo> findListByKeyword(@Param("keyword") String keyword, Pageable pageable);
	
	@Query(value = "select * from store_info where "
			+ "store_name like %:keyword% or "
			+ "store_category like %:keyword% or "
			+ "store_road_addr like %:keyword% or "
			+ "store_addr like %:keyword% or "
			+ "store_tel like %:keyword% or "
			+ "store_tag like %:keyword%", nativeQuery = true)
	Page<StoreInfo> findPageByKeyword(@Param("keyword") String keyword, Pageable pageable);
	
	@Query(value = "select * from store_info", nativeQuery = true)
	Page<StoreInfo> findAllStores(Pageable pageable);
	
	@Query(value = "select * from store_info", nativeQuery = true)
	Page<StoreInfo> findCloseStores(@Param("lat") String lat, @Param("lon") String lon, Pageable pageable);
	
	// 가게 코드 검색
	@Query("select s from StoreInfo s where s.storeCode like %:storeCode%")
	StoreInfo findByStoreCode(@Param("storeCode") String storeCode);
	
	// 술집 랭킹
	@Query(value = "select * "
			 	 + "from Store_info A, (select store_code, count(*) cnt "
			 	 					+ "from review "
			 	 					+ "where review_date between date_add(now(), interval -1 day) and now() "
			 	 					+ "group by store_code) B "
			 	 + "where A.store_code = B.store_code "
			 	 + "order by B.cnt desc", nativeQuery = true)
	Page<StoreInfo> findHotStores(Pageable pageable);
	
	
	// 리스트 페이지 이름으로 정렬하기
	@Query("select s from StoreInfo s ORDER BY s.storeName ASC")
	List<StoreInfo> sortByStoreName();

		
}