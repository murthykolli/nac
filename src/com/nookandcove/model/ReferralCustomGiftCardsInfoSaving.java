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
@Table(name = "referral_custom_gift_cards_info_saving")
public class ReferralCustomGiftCardsInfoSaving implements java.io.Serializable {
	
	// Fields
	
	private long referralCustomGiftCardsInfoSavingId;
	private long referralUserId;	
	private String typeOfCreditName;
	private String referralCustomGiftCard;
	private Double totalCredit;
	private Double remainingCredit;
	private Double usedCredit;	
	private String giftCardStatus;	
	private String status;	
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

	/** default constructor */
	public ReferralCustomGiftCardsInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "referral_custom_gift_cards_info_saving_id", unique = true, nullable = false)
	public long getReferralCustomGiftCardsInfoSavingId() {
		return referralCustomGiftCardsInfoSavingId;
	}

	public void setReferralCustomGiftCardsInfoSavingId(long referralCustomGiftCardsInfoSavingId) {
		this.referralCustomGiftCardsInfoSavingId = referralCustomGiftCardsInfoSavingId;
	}

	@Column(name = "shop_referral_users_info_saving_id", nullable = false)
	public long getReferralUserId() {
		return referralUserId;
	}

	public void setReferralUserId(long referralUserId) {
		this.referralUserId = referralUserId;
	}

	@Column(name = "type_of_credit_name", length = 30)
	public String getTypeOfCreditName() {
		return typeOfCreditName;
	}

	public void setTypeOfCreditName(String typeOfCreditName) {
		this.typeOfCreditName = typeOfCreditName;
	}

	@Column(name = "referral_custom_gift_card", length = 10)
	public String getReferralCustomGiftCard() {
		return referralCustomGiftCard;
	}

	public void setReferralCustomGiftCard(String referralCustomGiftCard) {
		this.referralCustomGiftCard = referralCustomGiftCard;
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