package com.brew.repository;

import java.util.List;
import java.util.Map;

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
	
	// 페이징 처리된 Page 객체 반환
	// 가게 이름으로 검색
	Page<StoreInfo> findByStoreNameContaining(String storeName, Pageable pagealbe);
	// 카테고리로 검색
	Page<StoreInfo> findByStoreCategoryContaining(String storeCategory, Pageable pagealbe);
	// 도로명 주소로 검색
	Page<StoreInfo> findByStoreRoadAddrContaining(String storeRoadAddr, Pageable pagealbe);
	// 지번 주소로 검색
	Page<StoreInfo> findByStoreAddrContaining(String storeAddr, Pageable pagealbe);
	// 전화번호로 검색
	Page<StoreInfo> findByStoreTelContaining(String storeTel, Pageable pagealbe);
	// 태그로 검색
	Page<StoreInfo> findByStoreTagContaining(String storeTag, Pageable pagealbe);
	
	
	// 페이징 처리된 List 객체 반환
	// 가게 이름으로 검색
	@Query("select s from StoreInfo s where s.storeName like %:storeName%")
	List<StoreInfo> findByStoreName(@Param("storeName") String storeName, Pageable pagealbe);
	// 카테고리로 검색
	@Query("select s from StoreInfo s where s.storeCategory like %:storeCategory%")
	List<StoreInfo> findByStoreCategory(@Param("storeCategory") String storeCategory, Pageable pagealbe);
	// 도로명 주소로 검색
	@Query("select s from StoreInfo s where s.storeRoadAddr like %:storeRoadAddr%")
	List<StoreInfo> findByStoreRoadAddr(@Param("storeRoadAddr") String storeRoadAddr, Pageable pagealbe);
	// 지번 주소로 검색
	@Query("select s from StoreInfo s where s.storeAddr like %:storeAddr%")
	List<StoreInfo> findByStoreAddr(@Param("storeAddr") String storeAddr, Pageable pagealbe);
	// 전화번호로 검색
	@Query("select s from StoreInfo s where s.storeTel like %:storeTel%")
	List<StoreInfo> findByStoreTel(@Param("storeTel") String storeTel, Pageable pagealbe);
	// 태그로 검색
	@Query("select s from StoreInfo s where s.storeTag like %:storeTag%")
	List<StoreInfo> findByStoreTag(@Param("storeTag") String storeTag, Pageable pagealbe);
	
}
