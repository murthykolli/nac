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
@Table(name = "guest_user_payment_info_saving")
public class GuestUserPaymentInfoSaving implements java.io.Serializable {
	
	// Fields
	
	private long guestUserPaymentInfoSavingId;
	private long registrantUserId;
	
	private String payCardNumber;
	private String accountType;
	private String payExpDate;
	private String payCvvNumber;
	private String nameOnCard;	
	
	private String billFullName;
	private String billAddress1;
	private String billAddress2;
	private String billCity;  
	private String billState;
	private String billZip;
	private String billCountry;
	private String billPhNumber;
	private String guestEmail;	
	private String totalAmount;	
	private String status;
	private String guestUserFullName;
		
	private String checkoutPaymentStatus;	
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	private long transactionNumber;
	private String authorizationCode;
	private String createdDateInSt;
	private String guestMessage;
	private String shippingFee;
	private String taxFee;
	private String conceptBoardsPrice;
	private String finishingTouchesPrice;
	private String roomFundsPrice;
	private String cashFundsPrice;
	private String totalHandlingFee;
	private String defaultCouponPrice;
	
	// Constructors

	/** default constructor */
	public GuestUserPaymentInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "guest_user_payment_info_saving_id", unique = true, nullable = false)
	public long getGuestUserPaymentInfoSavingId() {
		return guestUserPaymentInfoSavingId;
	}

	public void setGuestUserPaymentInfoSavingId(long guestUserPaymentInfoSavingId) {
		this.guestUserPaymentInfoSavingId = guestUserPaymentInfoSavingId;
	}

	@Column(name = "registrant_user_id", nullable = false)
	public long getRegistrantUserId() {
		return registrantUserId;
	}

	public void setRegistrantUserId(long registrantUserId) {
		this.registrantUserId = registrantUserId;
	}
	
	@Column(name = "pay_card_number", length = 20)
	public String getPayCardNumber() {
		return payCardNumber;
	}

	public void setPayCardNumber(String payCardNumber) {
		this.payCardNumber = payCardNumber;
	}

	@Column(name = "account_type", length = 60)
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Column(name = "pay_exp_date", length = 20)
	public String getPayExpDate() {
		return payExpDate;
	}

	public void setPayExpDate(String payExpDate) {
		this.payExpDate = payExpDate;
	}

	@Column(name = "pay_cvv_number", length = 10)
	public String getPayCvvNumber() {
		return payCvvNumber;
	}

	public void setPayCvvNumber(String payCvvNumber) {
		this.payCvvNumber = payCvvNumber;
	}

	@Column(name = "name_on_card", length = 60)
	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	@Column(name = "bill_full_name", length = 60)
	public String getBillFullName() {
		return billFullName;
	}

	public void setBillFullName(String billFullName) {
		this.billFullName = billFullName;
	}

	@Column(name = "bill_address1", length = 100)
	public String getBillAddress1() {
		return billAddress1;
	}

	public void setBillAddress1(String billAddress1) {
		this.billAddress1 = billAddress1;
	}

	@Column(name = "bill_address2", length = 100)
	public String getBillAddress2() {
		return billAddress2;
	}

	public void setBillAddress2(String billAddress2) {
		this.billAddress2 = billAddress2;
	}

	@Column(name = "bill_city", length = 50)
	public String getBillCity() {
		return billCity;
	}

	public void setBillCity(String billCity) {
		this.billCity = billCity;
	}

	@Column(name = "bill_state", length = 50)
	public String getBillState() {
		return billState;
	}

	public void setBillState(String billState) {
		this.billState = billState;
	}

	@Column(name = "bill_zip", length = 10)
	public String getBillZip() {
		return billZip;
	}

	public void setBillZip(String billZip) {
		this.billZip = billZip;
	}
	
	@Column(name = "guest_email", length = 60)
	public String getGuestEmail() {
		return guestEmail;
	}

	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}

	@Column(name = "bill_country", length = 50)
	public String getBillCountry() {
		return billCountry;
	}

	public void setBillCountry(String billCountry) {
		this.billCountry = billCountry;
	}

	@Column(name = "bill_ph_number", length = 15)
	public String getBillPhNumber() {
		return billPhNumber;
	}

	public void setBillPhNumber(String billPhNumber) {
		this.billPhNumber = billPhNumber;
	}

	@Column(name = "total_amount", length = 15)
	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@Column(name = "checkout_payment_status", length = 100)
	public String getCheckoutPaymentStatus() {
		return checkoutPaymentStatus;
	}

	public void setCheckoutPaymentStatus(String checkoutPaymentStatus) {
		this.checkoutPaymentStatus = checkoutPaymentStatus;
	}

	@Column(name = "status", length = 10)
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

	@Column(name = "transaction_number")
	public long getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(long transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	@Column(name = "authorization_code", length = 100)
	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	@Column(name = "created_date_in_st")
	public String getCreatedDateInSt() {
		return createdDateInSt;
	}

	public void setCreatedDateInSt(String createdDateInSt) {
		this.createdDateInSt = createdDateInSt;
	}

	@Column(name = "guest_message", length = 300)
	public String getGuestMessage() {
		return guestMessage;
	}

	public void setGuestMessage(String guestMessage) {
		this.guestMessage = guestMessage;
	}

	@Column(name = "shipping_fee", length = 15)
	public String getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(String shippingFee) {
		this.shippingFee = shippingFee;
	}

	@Column(name = "tax_fee", length = 15)
	public String getTaxFee() {
		return taxFee;
	}

	public void setTaxFee(String taxFee) {
		this.taxFee = taxFee;
	}

	@Column(name = "concept_boards_price", length = 15)
	public String getConceptBoardsPrice() {
		return conceptBoardsPrice;
	}

	public void setConceptBoardsPrice(String conceptBoardsPrice) {
		this.conceptBoardsPrice = conceptBoardsPrice;
	}

	@Column(name = "finishing_touches_price", length = 15)
	public String getFinishingTouchesPrice() {
		return finishingTouchesPrice;
	}

	public void setFinishingTouchesPrice(String finishingTouchesPrice) {
		this.finishingTouchesPrice = finishingTouchesPrice;
	}

	@Column(name = "room_funds_price", length = 15)
	public String getRoomFundsPrice() {
		return roomFundsPrice;
	}

	public void setRoomFundsPrice(String roomFundsPrice) {
		this.roomFundsPrice = roomFundsPrice;
	}

	@Column(name = "cash_funds_price", length = 15)
	public String getCashFundsPrice() {
		return cashFundsPrice;
	}

	public void setCashFundsPrice(String cashFundsPrice) {
		this.cashFundsPrice = cashFundsPrice;
	}

	@Column(name = "total_handling_fee", length = 15)
	public String getTotalHandlingFee() {
		return totalHandlingFee;
	}

	public void setTotalHandlingFee(String totalHandlingFee) {
		this.totalHandlingFee = totalHandlingFee;
	}

	@Column(name = "guest_user_full_name", length = 60)
	public String getGuestUserFullName() {
		return guestUserFullName;
	}

	public void setGuestUserFullName(String guestUserFullName) {
		this.guestUserFullName = guestUserFullName;
	}

	@Column(name = "default_coupon_price", length = 15)
	public String getDefaultCouponPrice() {
		return defaultCouponPrice;
	}

	public void setDefaultCouponPrice(String defaultCouponPrice) {
		this.defaultCouponPrice = defaultCouponPrice;
	}
	
	
}