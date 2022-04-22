package com.brew.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class StoreInfo {
	@OneToMany(mappedBy = "storeInfo")
	private List<Review> review;

	@Column
	private int reviewCount;

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
	private String storeRegdate;

	@NotNull
	@Column
	private double storeLatitude;

	@NotNull
	@Column
	private double storeLongitude;

	@Column
	private String storeTag;

	@PrePersist
	public void createdAt() {
		this.storeRegdate = String.valueOf(LocalDateTime.now());
		this.storeStaravg = (float) 3.0;
		this.reviewCount = review.size();
	}

	@Column
	private Float storeStaravg;

	@Builder
	public StoreInfo(String storeCategory, String storeCode, String storeName, String storeRoadAddr, String storeTel,
			String storeAddr, String storeRegDate, double storeLatitude, double storeLongitude, String storeTag,
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

	@Override
	public String toString() {
		return "StoreInfo [storeCategory=" + storeCategory + ", storeCode=" + storeCode + ", storeName=" + storeName
				+ ", storeTel=" + storeTel + ", storeRoadAddr=" + storeRoadAddr + ", storeAddr=" + storeAddr
				+ ", storeRegdate=" + storeRegdate + ", storeLatitude=" + storeLatitude + ", storeLongitude="
				+ storeLongitude + ", storeTag=" + storeTag + ", storeStaravg=" + storeStaravg + "]";
	}

}
