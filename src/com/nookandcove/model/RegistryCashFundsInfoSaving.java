package com.nookandcove.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "registry_cash_funds_info_saving")
public class RegistryCashFundsInfoSaving implements java.io.Serializable {
	
	// Fields
	
	private long registryCashFundsInfoSavingId;
	private long registrantUserId;	
	private String cashFundReqAmount;
	private String cashFundName;
	private String cashFundNewName;
	private String cashFundImageUrl;
	private byte[] cashFundUploadImage;
	private String cashFundMessage;
	private String totalContributedAmount;
	private String remainingAmount;
	private String cashFundStatus;	
	private String status;
	private String checkoutPaymentStatus;	
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

	/** default constructor */
	public RegistryCashFundsInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "registry_cash_funds_info_saving_id", unique = true, nullable = false)
	public long getRegistryCashFundsInfoSavingId() {
		return registryCashFundsInfoSavingId;
	}

	public void setRegistryCashFundsInfoSavingId(long registryCashFundsInfoSavingId) {
		this.registryCashFundsInfoSavingId = registryCashFundsInfoSavingId;
	}

	@Column(name = "registrant_user_id", nullable = false)
	public long getRegistrantUserId() {
		return registrantUserId;
	}

	public void setRegistrantUserId(long registrantUserId) {
		this.registrantUserId = registrantUserId;
	}
	
	@Column(name = "remaining_amount", length = 15)
	public String getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(String remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	@Column(name = "checkout_payment_status", length = 100)
	public String getCheckoutPaymentStatus() {
		return checkoutPaymentStatus;
	}

	public void setCheckoutPaymentStatus(String checkoutPaymentStatus) {
		this.checkoutPaymentStatus = checkoutPaymentStatus;
	}
	
	@Column(name = "cash_fund_status", length = 30)
	public String getCashFundStatus() {
		return cashFundStatus;
	}

	public void setCashFundStatus(String cashFundStatus) {
		this.cashFundStatus = cashFundStatus;
	}

	@Column(name = "status", length = 60)
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

	@Column(name = "cash_fund_name", length = 260)
	public String getCashFundName() {
		return cashFundName;
	}

	public void setCashFundName(String cashFundName) {
		this.cashFundName = cashFundName;
	}
	
	@Column(name = "cash_fund_new_name", length = 260)
	public String getCashFundNewName() {
		return cashFundNewName;
	}

	public void setCashFundNewName(String cashFundNewName) {
		this.cashFundNewName = cashFundNewName;
	}

	@Column(name = "cash_fund_image_url", length = 260)
	public String getCashFundImageUrl() {
		return cashFundImageUrl;
	}

	public void setCashFundImageUrl(String cashFundImageUrl) {
		this.cashFundImageUrl = cashFundImageUrl;
	}

	@Column(name = "cash_fund_req_amount", length = 15)
	public String getCashFundReqAmount() {
		return cashFundReqAmount;
	}

	public void setCashFundReqAmount(String cashFundReqAmount) {
		this.cashFundReqAmount = cashFundReqAmount;
	}

	@Column(name = "cash_fund_message", length = 260)
	public String getCashFundMessage() {
		return cashFundMessage;
	}

	public void setCashFundMessage(String cashFundMessage) {
		this.cashFundMessage = cashFundMessage;
	}

	@Column(name="cash_fund_upload_image", columnDefinition="longblob")
	@Lob
	public byte[] getCashFundUploadImage() {
		return cashFundUploadImage;
	}

	public void setCashFundUploadImage(byte[] cashFundUploadImage) {
		this.cashFundUploadImage = cashFundUploadImage;
	}

	@Column(name = "total_contributed_amount", length = 15)
	public String getTotalContributedAmount() {
		return totalContributedAmount;
	}

	public void setTotalContributedAmount(String totalContributedAmount) {
		this.totalContributedAmount = totalContributedAmount;
	}

	
	
	
}
