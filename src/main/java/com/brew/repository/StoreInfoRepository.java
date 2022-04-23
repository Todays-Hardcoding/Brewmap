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
	List<StoreInfo> findListByKeyword(@Param("keyword") String keyword, Pageable pagealbe);
	
	@Query(value = "select * from store_info where "
			+ "store_name like %:keyword% or "
			+ "store_category like %:keyword% or "
			+ "store_road_addr like %:keyword% or "
			+ "store_addr like %:keyword% or "
			+ "store_tel like %:keyword% or "
			+ "store_tag like %:keyword%", nativeQuery = true)
	Page<StoreInfo> findPageByKeyword(@Param("keyword") String keyword, Pageable pagealbe);
	
	@Query(value = "select * from store_info", nativeQuery = true)
	Page<StoreInfo> findAllStores(Pageable pagealbe);
	
	@Query(value = "select * from store_info", nativeQuery = true)
	Page<StoreInfo> findCloseStores(@Param("lat") String lat, @Param("lon") String lon, Pageable pagealbe);
	
	// 가게 코드 검색
	@Query("select s from StoreInfo s where s.storeCode like %:storeCode%")
	StoreInfo findByStoreCode(@Param("storeCode") String storeCode);
		
}