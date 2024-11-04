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
@Table(name = "guest_room_fund_payment_info_saving")
public class GuestRoomFundPaymentInfoSaving implements java.io.Serializable {
	
	// Fields
	
	private long guestRoomFundPaymentInfoSavingId;
	private long guestUserPaymentInfoSavingId;
	private long registrantUserId;
	private String guestRoomCombValues;
	private String roomFundsPrice;		
	private String spaceHandlingFee;
	private String totalAmount;
	private String checkoutPaymentStatus;
	private String guestEmail;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	private String status;
	
	// Constructors

	/** default constructor */
	public GuestRoomFundPaymentInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "guest_room_fund_payment_info_saving_id", unique = true, nullable = false)
	public long getGuestRoomFundPaymentInfoSavingId() {
		return guestRoomFundPaymentInfoSavingId;
	}

	public void setGuestRoomFundPaymentInfoSavingId(long guestRoomFundPaymentInfoSavingId) {
		this.guestRoomFundPaymentInfoSavingId = guestRoomFundPaymentInfoSavingId;
	}

	@Column(name = "guest_user_payment_info_saving_id", nullable = false)
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

	@Column(name = "guest_room_comb_Values")
	public String getGuestRoomCombValues() {
		return guestRoomCombValues;
	}

	public void setGuestRoomCombValues(String guestRoomCombValues) {
		this.guestRoomCombValues = guestRoomCombValues;
	}

	@Column(name = "room_funds_price", length = 15)
	public String getRoomFundsPrice() {
		return roomFundsPrice;
	}

	public void setRoomFundsPrice(String roomFundsPrice) {
		this.roomFundsPrice = roomFundsPrice;
	}

	@Column(name = "space_handling_fee", length = 15)
	public String getSpaceHandlingFee() {
		return spaceHandlingFee;
	}

	public void setSpaceHandlingFee(String spaceHandlingFee) {
		this.spaceHandlingFee = spaceHandlingFee;
	}

	@Column(name = "guest_email", length = 100)
	public String getGuestEmail() {
		return guestEmail;
	}

	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}
	
	
	
}
