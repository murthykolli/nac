package com.nookandcove.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "registrant_custom_gift_card_code_saving")
public class RegistrantCustomGiftCardCodeSaving implements java.io.Serializable {
	
	// Fields
	
	private long registrantCustomGiftCardCodeSavingId;
	private long registrantUserId;	
	private String giftCardCode;
	private Double totalCredit;
	private Double remainingCredit;
	private Double usedCredit;	
	private String giftCardStatus;	
	private String status;	
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

	/** default constructor */
	public RegistrantCustomGiftCardCodeSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "registrant_custom_gift_card_code_saving_id", unique = true, nullable = false)
	public long getRegistrantCustomGiftCardCodeSavingId() {
		return registrantCustomGiftCardCodeSavingId;
	}

	public void setRegistrantCustomGiftCardCodeSavingId(long registrantCustomGiftCardCodeSavingId) {
		this.registrantCustomGiftCardCodeSavingId = registrantCustomGiftCardCodeSavingId;
	}

	@Column(name = "registrant_user_id", nullable = false)
	public long getRegistrantUserId() {
		return registrantUserId;
	}

	public void setRegistrantUserId(long registrantUserId) {
		this.registrantUserId = registrantUserId;
	}	

	@Column(name = "gift_card_code", length = 10)
	public String getGiftCardCode() {
		return giftCardCode;
	}

	public void setGiftCardCode(String giftCardCode) {
		this.giftCardCode = giftCardCode;
	}

	@Column(name = "total_credit")
	public Double getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(Double totalCredit) {
		this.totalCredit = totalCredit;
	}

	@Column(name = "remaining_credit")
	public Double getRemainingCredit() {
		return remainingCredit;
	}

	public void setRemainingCredit(Double remainingCredit) {
		this.remainingCredit = remainingCredit;
	}

	@Column(name = "used_credit")
	public Double getUsedCredit() {
		return usedCredit;
	}

	public void setUsedCredit(Double usedCredit) {
		this.usedCredit = usedCredit;
	}

	@Column(name = "gift_card_status", length = 60)
	public String getGiftCardStatus() {
		return giftCardStatus;
	}

	public void setGiftCardStatus(String giftCardStatus) {
		this.giftCardStatus = giftCardStatus;
	}

	@Column(name = "status", length = 30)
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "created_date")
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_date")
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	
}