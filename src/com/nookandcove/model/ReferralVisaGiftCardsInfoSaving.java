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
@Table(name = "referral_visa_gift_card_info_saving")
public class ReferralVisaGiftCardsInfoSaving implements java.io.Serializable {
	
	// Fields
	
	private long referralVisaGiftCardsInfoSavingId;
	private long referralUserId;
	private long registrantUserId;
	private String registrantFullName;
	private String typeOfCreditName;
	private String referralUserFullName;
	private String referralUserEmail;
	private Double rewardAmount;
	private String visaGiftCardStatus;
	private String status;
	private Timestamp issuedDate;
	private Timestamp createdDate;
	private Timestamp referralCreatedDate;
	private Timestamp updatedDate;
	
	// Constructors

	/** default constructor */
	public ReferralVisaGiftCardsInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "referral_visa_gift_card_info_saving_id", unique = true, nullable = false)
	public long getReferralVisaGiftCardsInfoSavingId() {
		return referralVisaGiftCardsInfoSavingId;
	}

	public void setReferralVisaGiftCardsInfoSavingId(long referralVisaGiftCardsInfoSavingId) {
		this.referralVisaGiftCardsInfoSavingId = referralVisaGiftCardsInfoSavingId;
	}

	@Column(name = "shop_referral_users_info_saving_id", nullable = false)
	public long getReferralUserId() {
		return referralUserId;
	}

	public void setReferralUserId(long referralUserId) {
		this.referralUserId = referralUserId;
	}

	@Column(name = "registrant_user_id", nullable = false)
	public long getRegistrantUserId() {
		return registrantUserId;
	}

	public void setRegistrantUserId(long registrantUserId) {
		this.registrantUserId = registrantUserId;
	}

	@Column(name = "registrant_full_name", length = 80)
	public String getRegistrantFullName() {
		return registrantFullName;
	}

	public void setRegistrantFullName(String registrantFullName) {
		this.registrantFullName = registrantFullName;
	}

	@Column(name = "type_of_credit_name", length = 30)
	public String getTypeOfCreditName() {
		return typeOfCreditName;
	}

	public void setTypeOfCreditName(String typeOfCreditName) {
		this.typeOfCreditName = typeOfCreditName;
	}

	@Column(name = "reward_amount")
	public Double getRewardAmount() {
		return rewardAmount;
	}

	public void setRewardAmount(Double rewardAmount) {
		this.rewardAmount = rewardAmount;
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