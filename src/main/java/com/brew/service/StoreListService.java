package com.brew.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brew.domain.StoreInfo;
import com.brew.repository.StoreInfoRepository;

@Service
public class StoreListService {
	
	@Autowired
	private StoreInfoRepository storeInfoRepository;
	
	public Page<StoreInfo> getInfoList(Pageable pageable) {
		return storeInfoRepository.findAll(pageable);
	}
}
