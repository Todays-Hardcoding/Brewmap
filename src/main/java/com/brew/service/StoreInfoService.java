package com.brew.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public Page<StoreInfo> findAllStores(Pageable pageable) {
		return storeInfoRepository.findAllStores(pageable);
	};
	
	public List<StoreInfo> findListByKeyword(String keyword, Pageable pageable) {
		return storeInfoRepository.findListByKeyword(keyword, pageable);
	}

	public Page<StoreInfo> findPageByKeyword(String keyword, Pageable pageable) {
		return storeInfoRepository.findPageByKeyword(keyword, pageable);
	}
	
	public StoreInfo findByStoreCode(String storeCode) {
		return storeInfoRepository.findByStoreCode(storeCode);
	};
	
	// 술집 랭킹
	public Page<StoreInfo> findHotStores(Pageable pageable) {
		return storeInfoRepository.findHotStores(pageable);
	}

}
