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
@Table(name = "client_package_and_rendering_payment_info_saving")
public class ClientPackageAndRenderingPaymentInfoSaving implements java.io.Serializable {
	
	// Fields
	
	private long clientPackageAndRenderingPaymentInfoSavingId;
	private long userId;
	private long clientInfoSavingId;
	
	private String payCardNumber;
	private String accountType;
	private String payExpDate;
	private String payCvvNumber;
	private String nameOnCard;	
	
	private String typeOfPayment;
	private String paymentStatus;	
	
	private String estimatedAmount; 
	private String promoAmount;
	private String giftAmount;
	private String totalPaybleAmount;	
	
	private String status;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	private long transactionNumber;
	private String authorizationCode;
	private String createdDateInSt;
	
	
	// Constructors

	/** default constructor */
	public ClientPackageAndRenderingPaymentInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "client_package_and_rendering_payment_info_saving_id", unique = true, nullable = false)
	public long getClientPackageAndRenderingPaymentInfoSavingId() {
		return clientPackageAndRenderingPaymentInfoSavingId;
	}

	public void setClientPackageAndRenderingPaymentInfoSavingId(long clientPackageAndRenderingPaymentInfoSavingId) {
		this.clientPackageAndRenderingPaymentInfoSavingId = clientPackageAndRenderingPaymentInfoSavingId;
	}

	@Column(name = "user_id", nullable = false)
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "client_info_saving_id")
	public long getClientInfoSavingId() {
		return clientInfoSavingId;
	}

	public void setClientInfoSavingId(long clientInfoSavingId) {
		this.clientInfoSavingId = clientInfoSavingId;
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

	@Column(name = "type_of_payment", length = 60)
	public String getTypeOfPayment() {
		return typeOfPayment;
	}

	public void setTypeOfPayment(String typeOfPayment) {
		this.typeOfPayment = typeOfPayment;
	}

	@Column(name = "payment_status", length = 100)
	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
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

	@Column(name = "authorization_code", length = 30)
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
	
}
