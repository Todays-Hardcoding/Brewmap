package com.brew.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@DynamicUpdate
public class StoreInfo {
	
	@OneToMany(mappedBy = "storeInfo")
	@JsonManagedReference
	private List<Review> review;

	@NotNull
	@Column
	private String storeCategory;

	@Id
	@NotNull
	@Column
	private String storeCode;

	@NotNull
	@Column
	private String storeName;

	@NotNull
	@Column
	private String storeTel;

	@NotNull
	@Column
	private String storeRoadAddr;

	@NotNull
	@Column
	private String storeAddr;

	@Column
	private LocalDateTime storeRegdate;

	@NotNull
	@Column
	private double storeLatitude;

	@NotNull
	@Column
	private double storeLongitude;

	@Column
	private String storeTag;

	@Column
	private Float storeStaravg;
	
	@PrePersist
	@PreUpdate
	public void createdAt() {
		this.storeRegdate = LocalDateTime.now();
		this.storeStaravg = (float) 3.0;
	}

	@Builder
	public StoreInfo(String storeCategory, String storeCode, String storeName, String storeRoadAddr, String storeTel,
			String storeAddr, LocalDateTime storeRegDate, double storeLatitude, double storeLongitude, String storeTag,
			Float storeStaravg) {
		super();
		this.storeCategory = storeCategory;
		this.storeCode = storeCode;
		this.storeName = storeName;
		this.storeTel = storeTel;
		this.storeRoadAddr = storeRoadAddr;
		this.storeAddr = storeAddr;
		this.storeRegdate = storeRegDate;
		this.storeLatitude = storeLatitude;
		this.storeLongitude = storeLongitude;
		this.storeTag = storeTag;
		this.storeStaravg = storeStaravg;
	}	

}