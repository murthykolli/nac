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
@Table(name = "guest_registry_cash_funds_payment_info_saving")
public class GuestRegistryCashFundsPaymentInfoSaving implements java.io.Serializable {
	
	// Fields
	
	private long guestRegistryCashFundsPaymentInfoSavingId;
	private long registrantUserId;
	private long registryCashFundsInfoSavingId;
	private String contributedCashFundPrice;
	private String cashFundName;
	private String totalAmount;
	private String cashFundStatus;	
	private String status;
	private String cashFundHandlingFee;
	private long guestUserPaymentInfoSavingId;
	private String checkoutPaymentStatus;
	private String guestEmail;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	private Timestamp refferanceDate;
	private Timestamp transferCompletedDate;
	
	// Constructors

	/** default constructor */
	public GuestRegistryCashFundsPaymentInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "guest_registry_cash_funds_payment_info_saving_id", unique = true, nullable = false)
	public long getGuestRegistryCashFundsPaymentInfoSavingId() {
		return guestRegistryCashFundsPaymentInfoSavingId;
	}

	public void setGuestRegistryCashFundsPaymentInfoSavingId(long guestRegistryCashFundsPaymentInfoSavingId) {
		this.guestRegistryCashFundsPaymentInfoSavingId = guestRegistryCashFundsPaymentInfoSavingId;
	}

	@Column(name = "registrant_user_id", nullable = false)
	public long getRegistrantUserId() {
		return registrantUserId;
	}

	public void setRegistrantUserId(long registrantUserId) {
		this.registrantUserId = registrantUserId;
	}
	
	@Column(name = "registry_cash_funds_info_saving_id", nullable = false)
	public long getRegistryCashFundsInfoSavingId() {
		return registryCashFundsInfoSavingId;
	}

	public void setRegistryCashFundsInfoSavingId(long registryCashFundsInfoSavingId) {
		this.registryCashFundsInfoSavingId = registryCashFundsInfoSavingId;
	}

	@Column(name = "cash_fund_name", length = 260)
	public String getCashFundName() {
		return cashFundName;
	}

	public void setCashFundName(String cashFundName) {
		this.cashFundName = cashFundName;
	}
			
	@Column(name = "total_amount", length = 15)
	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column(name = "guest_user_payment_info_saving_id")
	public long getGuestUserPaymentInfoSavingId() {
		return guestUserPaymentInfoSavingId;
	}

	public void setGuestUserPaymentInfoSavingId(long guestUserPaymentInfoSavingId) {
		this.guestUserPaymentInfoSavingId = guestUserPaymentInfoSavingId;
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

	@Column(name = "contributed_cash_fund_price", length = 15)
	public String getContributedCashFundPrice() {
		return contributedCashFundPrice;
	}

	public void setContributedCashFundPrice(String contributedCashFundPrice) {
		this.contributedCashFundPrice = contributedCashFundPrice;
	}

	@Column(name = "guest_email", length = 60)
	public String getGuestEmail() {
		return guestEmail;
	}

	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}

	@Column(name = "cash_fund_handling_fee", length = 15)
	public String getCashFundHandlingFee() {
		return cashFundHandlingFee;
	}

	public void setCashFundHandlingFee(String cashFundHandlingFee) {
		this.cashFundHandlingFee = cashFundHandlingFee;
	}

	@Column(name = "transfer_completed_date")
	public Timestamp getTransferCompletedDate() {
		return transferCompletedDate;
	}

	public void setTransferCompletedDate(Timestamp transferCompletedDate) {
		this.transferCompletedDate = transferCompletedDate;
	}

	@Column(name = "refferance_date")
	public Timestamp getRefferanceDate() {
		return refferanceDate;
	}

	public void setRefferanceDate(Timestamp refferanceDate) {
		this.refferanceDate = refferanceDate;
	}
	
	
}
