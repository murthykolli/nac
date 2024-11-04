package com.nookandcove.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@SuppressWarnings("serial")
@Entity
@Table(name = "gift_card_info_saving")
public class GiftInfoSaving implements java.io.Serializable {

	// Fields

	private long giftCardInfoSavingId;
	private String typeOfPackage;
	private String packagePrice;
	private String merchandiseCredit;
	private String typeOfGiftcard;
	
	private String typeOfDeliveryMethod;	
	private String giftRecipientName;
	private String giftRecipientAddress;
	private String giftRecipientCity;
	private String giftRecipientState;
	private String giftRecipientZipCode;
	private String recEmailarName;
	private String recEmailarAddress;
	
	private String yourName;
	private String yourEmail;
	private String giftMessage;
	private String deliveryDate;	
		
	private String giftCardCouponCode;
	private String couponCodeUsedStatus;
	private String status;
	private String totalPrice;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	private String createdDateInSt;
	private String remainingGiftPrice;
	private String usedGiftStatus;
	
	private String payCardNumber;
	private String accountType;
	private String payExpDate;
	private String nameOnCard;
	private long transactionNumber;
	private String authorizationCode;
	private String paymentStatus;
	private String promoAmount;

	// Constructors

	/** default constructor */
	public GiftInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "gift_card_info_saving_id", unique = true, nullable = false)
	public long getGiftCardInfoSavingId() {
		return giftCardInfoSavingId;
	}

	public void setGiftCardInfoSavingId(long giftCardInfoSavingId) {
		this.giftCardInfoSavingId = giftCardInfoSavingId;
	}
	
	@Column(name = "type_of_package", length = 60)
	public String getTypeOfPackage() {
		return typeOfPackage;
	}

	public void setTypeOfPackage(String typeOfPackage) {
		this.typeOfPackage = typeOfPackage;
	}

	@Column(name = "package_price", length = 12)
	public String getPackagePrice() {
		return packagePrice;
	}

	public void setPackagePrice(String packagePrice) {
		this.packagePrice = packagePrice;
	}

	@Column(name = "merchandise_credit", length = 12)
	public String getMerchandiseCredit() {
		return merchandiseCredit;
	}

	public void setMerchandiseCredit(String merchandiseCredit) {
		this.merchandiseCredit = merchandiseCredit;
	}

	@Column(name = "type_of_giftcard", length = 60)
	public String getTypeOfGiftcard() {
		return typeOfGiftcard;
	}

	public void setTypeOfGiftcard(String typeOfGiftcard) {
		this.typeOfGiftcard = typeOfGiftcard;
	}

	@Column(name = "type_of_delivery_method", length = 60)
	public String getTypeOfDeliveryMethod() {
		return typeOfDeliveryMethod;
	}

	public void setTypeOfDeliveryMethod(String typeOfDeliveryMethod) {
		this.typeOfDeliveryMethod = typeOfDeliveryMethod;
	}

	@Column(name = "gift_recipient_name", length = 60)
	public String getGiftRecipientName() {
		return giftRecipientName;
	}

	public void setGiftRecipientName(String giftRecipientName) {
		this.giftRecipientName = giftRecipientName;
	}

	@Column(name = "gift_recipient_address", length = 60)
	public String getGiftRecipientAddress() {
		return giftRecipientAddress;
	}

	public void setGiftRecipientAddress(String giftRecipientAddress) {
		this.giftRecipientAddress = giftRecipientAddress;
	}

	@Column(name = "gift_recipient_city", length = 60)
	public String getGiftRecipientCity() {
		return giftRecipientCity;
	}

	public void setGiftRecipientCity(String giftRecipientCity) {
		this.giftRecipientCity = giftRecipientCity;
	}

	@Column(name = "gift_recipient_state", length = 60)
	public String getGiftRecipientState() {
		return giftRecipientState;
	}

	public void setGiftRecipientState(String giftRecipientState) {
		this.giftRecipientState = giftRecipientState;
	}

	@Column(name = "gift_recipient_zipcode", length = 11)
	public String getGiftRecipientZipCode() {
		return giftRecipientZipCode;
	}

	public void setGiftRecipientZipCode(String giftRecipientZipCode) {
		this.giftRecipientZipCode = giftRecipientZipCode;
	}

	@Column(name = "rec_emailar_name", length = 60)
	public String getRecEmailarName() {
		return recEmailarName;
	}

	public void setRecEmailarName(String recEmailarName) {
		this.recEmailarName = recEmailarName;
	}

	@Column(name = "rec_emailar_address", length = 60)
	public String getRecEmailarAddress() {
		return recEmailarAddress;
	}

	public void setRecEmailarAddress(String recEmailarAddress) {
		this.recEmailarAddress = recEmailarAddress;
	}

	@Column(name = "your_name", length = 60)
	public String getYourName() {
		return yourName;
	}

	public void setYourName(String yourName) {
		this.yourName = yourName;
	}

	@Column(name = "your_email", length = 60)
	public String getYourEmail() {
		return yourEmail;
	}

	public void setYourEmail(String yourEmail) {
		this.yourEmail = yourEmail;
	}

	@Column(name = "gift_message")
	public String getGiftMessage() {
		return giftMessage;
	}

	public void setGiftMessage(String giftMessage) {
		this.giftMessage = giftMessage;
	}

	@Column(name = "delivery_date", length = 60)
	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Column(name = "gift_card_coupon_code", length = 10)
	public String getGiftCardCouponCode() {
		return giftCardCouponCode;
	}

	public void setGiftCardCouponCode(String giftCardCouponCode) {
		this.giftCardCouponCode = giftCardCouponCode;
	}

	@Column(name = "coupon_code_used_status", length = 10)
	public String getCouponCodeUsedStatus() {
		return couponCodeUsedStatus;
	}

	public void setCouponCodeUsedStatus(String couponCodeUsedStatus) {
		this.couponCodeUsedStatus = couponCodeUsedStatus;
	}

	@Column(name = "total_price", length = 15)
	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
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
	
	@Column(name = "created_date_in_st")
	public String getCreatedDateInSt() {
		return createdDateInSt;
	}

	public void setCreatedDateInSt(String createdDateInSt) {
		this.createdDateInSt = createdDateInSt;
	}

	@Column(name = "updated_date")
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "remaining_gift_price", length = 12)
	public String getRemainingGiftPrice() {
		return remainingGiftPrice;
	}

	public void setRemainingGiftPrice(String remainingGiftPrice) {
		this.remainingGiftPrice = remainingGiftPrice;
	}

	@Column(name = "used_gift_status", length = 10)
	public String getUsedGiftStatus() {
		return usedGiftStatus;
	}

	public void setUsedGiftStatus(String usedGiftStatus) {
		this.usedGiftStatus = usedGiftStatus;
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

	@Column(name = "name_on_card", length = 60)
	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	@Column(name = "transaction_number")
	public long getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(long transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	@Column(name = "authorization_code", length = 30)
	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	@Column(name = "payment_status", length = 100)
	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Column(name = "promo_amount", length = 15)
	public String getPromoAmount() {
		return promoAmount;
	}

	public void setPromoAmount(String promoAmount) {
		this.promoAmount = promoAmount;
	}
	
	

	
}