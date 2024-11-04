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
@Table(name = "registry_room_funds_payment_info_saving")
public class RegistryRoomFundsPaymentInfoSaving implements java.io.Serializable {
	
	// Fields
	
	private long roomFundsPaymentInfoSavingId;
	private long registrantUserId;	
	private String selectedRoomFundsInfo;
	private String contributedRoomFundAmount;
	private String totalAmount;	
	private String spaceHandlingFee;
	private Integer paymentCartNo;
	private String status;
	private long registrantPaymentInfoSavingId;
	private String checkoutPaymentStatus;	
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

	/** default constructor */
	public RegistryRoomFundsPaymentInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "room_funds_payment_info_saving_id", unique = true, nullable = false)
	public long getRoomFundsPaymentInfoSavingId() {
		return roomFundsPaymentInfoSavingId;
	}

	public void setRoomFundsPaymentInfoSavingId(long roomFundsPaymentInfoSavingId) {
		this.roomFundsPaymentInfoSavingId = roomFundsPaymentInfoSavingId;
	}

	@Column(name = "registrant_user_id", nullable = false)
	public long getRegistrantUserId() {
		return registrantUserId;
	}

	public void setRegistrantUserId(long registrantUserId) {
		this.registrantUserId = registrantUserId;
	}
	
	@Column(name = "total_amount", length = 15)
	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column(name = "registrant_payment_info_saving_id")
	public long getRegistrantPaymentInfoSavingId() {
		return registrantPaymentInfoSavingId;
	}

	public void setRegistrantPaymentInfoSavingId(long registrantPaymentInfoSavingId) {
		this.registrantPaymentInfoSavingId = registrantPaymentInfoSavingId;
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

	@Column(name = "selected_room_funds_info")
	public String getSelectedRoomFundsInfo() {
		return selectedRoomFundsInfo;
	}

	public void setSelectedRoomFundsInfo(String selectedRoomFundsInfo) {
		this.selectedRoomFundsInfo = selectedRoomFundsInfo;
	}

	@Column(name = "payment_cart_no", length = 20)
	public Integer getPaymentCartNo() {
		return paymentCartNo;
	}

	public void setPaymentCartNo(Integer paymentCartNo) {
		this.paymentCartNo = paymentCartNo;
	}

	@Column(name = "contributed_room_fund_amount", length = 15)
	public String getContributedRoomFundAmount() {
		return contributedRoomFundAmount;
	}

	public void setContributedRoomFundAmount(String contributedRoomFundAmount) {
		this.contributedRoomFundAmount = contributedRoomFundAmount;
	}

	@Column(name = "space_handling_fee", length = 15)
	public String getSpaceHandlingFee() {
		return spaceHandlingFee;
	}

	public void setSpaceHandlingFee(String spaceHandlingFee) {
		this.spaceHandlingFee = spaceHandlingFee;
	}
	
	
	
	
}
