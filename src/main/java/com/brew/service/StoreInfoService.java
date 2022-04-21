package com.brew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.brew.domain.StoreInfo;
import com.brew.repository.StoreInfoRepository;

@Service
public class StoreInfoService {

	@Autowired
	private StoreInfoRepository storeInfoRepository;

	// 모든 가게 정보를 반환하는 메소드
	public List<StoreInfo> findAllStore() {
		return storeInfoRepository.findAll();
	}
	
	public List<StoreInfo> findListByKeyword(String keyword, Pageable pageable) {
		return storeInfoRepository.findListByKeyword(keyword, pageable);
	}

	public Page<StoreInfo> findPageByKeyword(String keyword, Pageable pageable) {
		return storeInfoRepository.findPageByKeyword(keyword, pageable);
	}

	// 페이징된 Page 객체를 반환하는 검색 메소드
	public Page<StoreInfo> findStorePage(String keyword, Pageable pageable) {

		List<StoreInfo> stores = storeInfoRepository.findAll();

		// 검색 로직
		for (StoreInfo store : stores) {
			if (store.getStoreName().contains(keyword)) {
				return storeInfoRepository.findByStoreNameContaining(keyword, pageable);
			} else if (store.getStoreCategory().contains(keyword)) {
				return storeInfoRepository.findByStoreCategoryContaining(keyword, pageable);
			} else if (store.getStoreRoadAddr().contains(keyword)) {
				return storeInfoRepository.findByStoreRoadAddrContaining(keyword, pageable);
			} else if (store.getStoreAddr().contains(keyword)) {
				return storeInfoRepository.findByStoreAddrContaining(keyword, pageable);
			}  else if (store.getStoreTel().contains(keyword)) {
				return storeInfoRepository.findByStoreTelContaining(keyword, pageable);
			} else if (store.getStoreTag().contains(keyword)) {
				return storeInfoRepository.findByStoreTagContaining(keyword, pageable);
			}
		}
		return storeInfoRepository.findByStoreAddrContaining("강남", pageable);
	}
	
	// 페이징된 List 객체를 반환하는 검색 메소드
	public List<StoreInfo> findStoreList(String keyword, Pageable pageable) {

		List<StoreInfo> stores = storeInfoRepository.findAll();

		// 검색 로직
		for (StoreInfo store : stores) {
			if (store.getStoreName().contains(keyword)) {
				return storeInfoRepository.findByStoreName(keyword, pageable);
			} else if (store.getStoreCategory().contains(keyword)) {
				return storeInfoRepository.findByStoreCategory(keyword, pageable);
			} else if (store.getStoreRoadAddr().contains(keyword)) {
				return storeInfoRepository.findByStoreRoadAddr(keyword, pageable);
			} else if (store.getStoreAddr().contains(keyword)) {
				return storeInfoRepository.findByStoreAddr(keyword, pageable);
			} else if (store.getStoreTel().contains(keyword)) {
				return storeInfoRepository.findByStoreTel(keyword, pageable);
			} else if (store.getStoreTag().contains(keyword)) {
				return storeInfoRepository.findByStoreTag(keyword, pageable);
			}
		}
		return storeInfoRepository.findByStoreAddr("강남", pageable);
	}

}
