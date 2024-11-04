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
@Table(name = "registrant_shipping_info_saving")
public class RegistrantShippingInfoSaving implements java.io.Serializable {
	
	// Fields
	
	private long registrantShippingInfoSavingId;
	private long registrantUserId;	
	private String registrantFullNname;
	private String shippingAddress;
	private String apartment;
	private String city;  
	private String state;
	private String zip;
	private String phoneNumber;	
	private String shippingStatus;	
	private String status;	
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

	/** default constructor */
	public RegistrantShippingInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "registrant_shipping_info_saving_id", unique = true, nullable = false)
	public long getRegistrantShippingInfoSavingId() {
		return registrantShippingInfoSavingId;
	}

	public void setRegistrantShippingInfoSavingId(long registrantShippingInfoSavingId) {
		this.registrantShippingInfoSavingId = registrantShippingInfoSavingId;
	}

	@Column(name = "registrant_user_id", nullable = false)
	public long getRegistrantUserId() {
		return registrantUserId;
	}

	public void setRegistrantUserId(long registrantUserId) {
		this.registrantUserId = registrantUserId;
	}	

	@Column(name = "registrant_full_name", length = 100)	
	public String getRegistrantFullNname() {
		return registrantFullNname;
	}

	public void setRegistrantFullNname(String registrantFullNname) {
		this.registrantFullNname = registrantFullNname;
	}

	@Column(name = "shipping_address", length = 260)
	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Column(name = "apartment", length = 260)
	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	@Column(name = "city", length = 100)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", length = 100)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "zip", length = 10)
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "phone_number", length = 15)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "shipping_status", length = 60)
	public String getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
	
	@Column(name = "status", length = 30)
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

	
}