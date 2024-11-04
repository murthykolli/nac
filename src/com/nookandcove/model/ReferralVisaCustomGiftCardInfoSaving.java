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
@Table(name = "referral_visa_custom_gift_card_info_saving")
public class ReferralVisaCustomGiftCardInfoSaving implements java.io.Serializable {
	
	// Fields
	
	private long referralVisaCustomGiftCardInfoSavingId;
	private long referralUserId;
	private String referralUserFullName;
	private String referralUserEmail;
	private Double rewardAmount;
	private String visaGiftCardStatus;
	private String visaGiftCardIdsList;
	private String status;
	private Timestamp issuedDate;
	private Timestamp createdDate;
	private Timestamp referralCreatedDate;
	private Timestamp updatedDate;
	
	// Constructors

	/** default constructor */
	public ReferralVisaCustomGiftCardInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "referral_visa_custom_gift_card_info_saving_id", unique = true, nullable = false)
	public long getReferralVisaCustomGiftCardInfoSavingId() {
		return referralVisaCustomGiftCardInfoSavingId;
	}

	public void setReferralVisaCustomGiftCardInfoSavingId(long referralVisaCustomGiftCardInfoSavingId) {
		this.referralVisaCustomGiftCardInfoSavingId = referralVisaCustomGiftCardInfoSavingId;
	}

	@Column(name = "shop_referral_users_info_saving_id", nullable = false)
	public long getReferralUserId() {
		return referralUserId;
	}

	public void setReferralUserId(long referralUserId) {
		this.referralUserId = referralUserId;
	}

	@Column(name = "reward_amount")
	public Double getRewardAmount() {
		return rewardAmount;
	}

	public void setRewardAmount(Double rewardAmount) {
		this.rewardAmount = rewardAmount;
	}

	@Column(name = "visa_gift_card_ids_list", length = 200)
	public String getVisaGiftCardIdsList() {
		return visaGiftCardIdsList;
	}

	public void setVisaGiftCardIdsList(String visaGiftCardIdsList) {
		this.visaGiftCardIdsList = visaGiftCardIdsList;
	}

	@Column(name = "status", length = 30)
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "visa_gift_card_status", length = 30)
	public String getVisaGiftCardStatus() {
		return visaGiftCardStatus;
	}

	public void setVisaGiftCardStatus(String visaGiftCardStatus) {
		this.visaGiftCardStatus = visaGiftCardStatus;
	}

	@Column(name = "issued_date")
	public Timestamp getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Timestamp issuedDate) {
		this.issuedDate = issuedDate;
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

	@Column(name = "referral_user_full_name", length = 80)
	public String getReferralUserFullName() {
		return referralUserFullName;
	}

	public void setReferralUserFullName(String referralUserFullName) {
		this.referralUserFullName = referralUserFullName;
	}

	@Column(name = "referral_user_email", length = 120)
	public String getReferralUserEmail() {
		return referralUserEmail;
	}

	public void setReferralUserEmail(String referralUserEmail) {
		this.referralUserEmail = referralUserEmail;
	}

	@Column(name = "referral_created_date")
	public Timestamp getReferralCreatedDate() {
		return referralCreatedDate;
	}

	public void setReferralCreatedDate(Timestamp referralCreatedDate) {
		this.referralCreatedDate = referralCreatedDate;
	}

	
}