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
@Table(name = "shopping_cart_payment_info_saving")
public class ShoppingCartPaymentInfoSaving implements java.io.Serializable {
	
	// Fields
	
	private long shoppingCartPaymentInfoSavingId;
	private long userId;
	
	private String shipFullName;
	private String shipAddress1;
	private String shipAddress2;
	private String shipCity;  
	private String shipState;
	private String shipZip;
	private String shipCountry;
	private String shipPhNumber;
	
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
	
	private String estimatedAmount; 
	private String promoAmount;
	private String giftAmount;
	private String totalPaybleAmount;	
	
	private String status;
	private String checkoutPaymentStatus;
	private String reviewOrderStatus;
	private String checkboxStatus;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	private long transactionNumber;
	private String authorizationCode;
	private String giftCouponCodes;
	private String cartGiftAmount;
	private String orderedStatus;
	private String deliveredStatus;
	private String createdDateInSt;
	
	// Constructors

	/** default constructor */
	public ShoppingCartPaymentInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "shopping_cart_payment_info_saving_id", unique = true, nullable = false)
	public long getShoppingCartPaymentInfoSavingId() {
		return shoppingCartPaymentInfoSavingId;
	}

	public void setShoppingCartPaymentInfoSavingId(long shoppingCartPaymentInfoSavingId) {
		this.shoppingCartPaymentInfoSavingId = shoppingCartPaymentInfoSavingId;
	}

	@Column(name = "user_id", nullable = false)
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	@Column(name = "ship_full_name", length = 60)
	public String getShipFullName() {
		return shipFullName;
	}

	public void setShipFullName(String shipFullName) {
		this.shipFullName = shipFullName;
	}

	@Column(name = "ship_address1", length = 100)
	public String getShipAddress1() {
		return shipAddress1;
	}

	public void setShipAddress1(String shipAddress1) {
		this.shipAddress1 = shipAddress1;
	}

	@Column(name = "ship_address2", length = 100)
	public String getShipAddress2() {
		return shipAddress2;
	}

	public void setShipAddress2(String shipAddress2) {
		this.shipAddress2 = shipAddress2;
	}

	@Column(name = "ship_city", length = 50)
	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	@Column(name = "ship_state", length = 50)
	public String getShipState() {
		return shipState;
	}

	public void setShipState(String shipState) {
		this.shipState = shipState;
	}

	@Column(name = "ship_zip", length = 10)
	public String getShipZip() {
		return shipZip;
	}

	public void setShipZip(String shipZip) {
		this.shipZip = shipZip;
	}

	@Column(name = "ship_country", length = 50)
	public String getShipCountry() {
		return shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

	@Column(name = "ship_ph_number", length = 15)
	public String getShipPhNumber() {
		return shipPhNumber;
	}

	public void setShipPhNumber(String shipPhNumber) {
		this.shipPhNumber = shipPhNumber;
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

	@Column(name = "estimated_amount", length = 15)
	public String getEstimatedAmount() {
		return estimatedAmount;
	}

	public void setEstimatedAmount(String estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}

	@Column(name = "promo_amount", length = 15)
	public String getPromoAmount() {
		return promoAmount;
	}

	public void setPromoAmount(String promoAmount) {
		this.promoAmount = promoAmount;
	}

	@Column(name = "gift_amount", length = 15)
	public String getGiftAmount() {
		return giftAmount;
	}

	public void setGiftAmount(String giftAmount) {
		this.giftAmount = giftAmount;
	}

	@Column(name = "total_payble_amount", length = 15)
	public String getTotalPaybleAmount() {
		return totalPaybleAmount;
	}

	public void setTotalPaybleAmount(String totalPaybleAmount) {
		this.totalPaybleAmount = totalPaybleAmount;
	}
	
	@Column(name = "checkout_payment_status", length = 100)
	public String getCheckoutPaymentStatus() {
		return checkoutPaymentStatus;
	}

	public void setCheckoutPaymentStatus(String checkoutPaymentStatus) {
		this.checkoutPaymentStatus = checkoutPaymentStatus;
	}

	@Column(name = "checkbox_status", length = 10)
	public String getCheckboxStatus() {
		return checkboxStatus;
	}

	public void setCheckboxStatus(String checkboxStatus) {
		this.checkboxStatus = checkboxStatus;
	}

	@Column(name = "status", length = 10)
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "review_order_status", length = 30)
	public String getReviewOrderStatus() {
		return reviewOrderStatus;
	}

	public void setReviewOrderStatus(String reviewOrderStatus) {
		this.reviewOrderStatus = reviewOrderStatus;
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

	@Column(name = "gift_coupon_codes")
	public String getGiftCouponCodes() {
		return giftCouponCodes;
	}

	public void setGiftCouponCodes(String giftCouponCodes) {
		this.giftCouponCodes = giftCouponCodes;
	}

	@Column(name = "cart_gift_amount", length = 15)
	public String getCartGiftAmount() {
		return cartGiftAmount;
	}

	public void setCartGiftAmount(String cartGiftAmount) {
		this.cartGiftAmount = cartGiftAmount;
	}
	

	@Column(name = "ordered_status", length = 20)
	public String getOrderedStatus() {
		return orderedStatus;
	}

	public void setOrderedStatus(String orderedStatus) {
		this.orderedStatus = orderedStatus;
	}

	@Column(name = "delivered_status", length = 20)
	public String getDeliveredStatus() {
		return deliveredStatus;
	}

	public void setDeliveredStatus(String deliveredStatus) {
		this.deliveredStatus = deliveredStatus;
	}

	@Column(name = "created_date_in_st")
	public String getCreatedDateInSt() {
		return createdDateInSt;
	}

	public void setCreatedDateInSt(String createdDateInSt) {
		this.createdDateInSt = createdDateInSt;
	}
	
}
