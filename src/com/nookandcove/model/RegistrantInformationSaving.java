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
@Table(name = "registrant_information_saving")
public class RegistrantInformationSaving implements java.io.Serializable {
	
	private long registrantUserId;
	private String regUserName;
	private String eventType;
	private String eventDate;
	private String dateCheckOption;	
	private String regFirstName;
	private String regLastName;
	private String coRegFirstName;
	private String coRegLastName;
	private String password;
	private String passwordSalt;
	private String typeOfUser;	
	private Timestamp lastPasswordChangedDate;
	private String securityPin;
	private Timestamp emailSentDate;	
	private String status;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	private byte[] regPhotoUpload;
	private String regMessage;
	private String regAddress;
	private String regSocialMedia;
	private String regArchiveStatus;
	private String regVendorCouponId;
	private String guestBackgroundImg;
	private byte[] regBackgroundUploadImage;
	
// Constructors

		/** default constructor */
	public RegistrantInformationSaving() {
	}

// Property accessors
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
				
		@Column(name = "registrant_user_id", unique = true, nullable = false)
		
		public long getRegistrantUserId() {
			return registrantUserId;
		}

		public void setRegistrantUserId(long registrantUserId) {
			this.registrantUserId = registrantUserId;
		}

		@Column(name = "reg_user_name", unique = true, nullable = false, length = 60)
		public String getRegUserName() {
			return regUserName;
		}

		public void setRegUserName(String regUserName) {
			this.regUserName = regUserName;
		}

		@Column(name = "event_type", nullable = false, length = 60)
		public String getEventType() {
			return eventType;
		}

		public void setEventType(String eventType) {
			this.eventType = eventType;
		}

		@Column(name = "event_date", length = 30)
		public String getEventDate() {
			return eventDate;
		}

		public void setEventDate(String eventDate) {
			this.eventDate = eventDate;
		}
		
		@Column(name = "date_check_option", length = 60)
		public String getDateCheckOption() {
			return dateCheckOption;
		}

		public void setDateCheckOption(String dateCheckOption) {
			this.dateCheckOption = dateCheckOption;
		}

		@Column(name = "reg_first_name", nullable = false, length = 60)
		public String getRegFirstName() {
			return regFirstName;
		}

		public void setRegFirstName(String regFirstName) {
			this.regFirstName = regFirstName;
		}

		@Column(name = "reg_last_name", nullable = false, length = 30)
		public String getRegLastName() {
			return regLastName;
		}

		public void setRegLastName(String regLastName) {
			this.regLastName = regLastName;
		}

		@Column(name = "co_reg_first_name", length = 60)
		public String getCoRegFirstName() {
			return coRegFirstName;
		}

		public void setCoRegFirstName(String coRegFirstName) {
			this.coRegFirstName = coRegFirstName;
		}

		@Column(name = "co_reg_last_name", length = 30)
		public String getCoRegLastName() {
			return coRegLastName;
		}

		public void setCoRegLastName(String coRegLastName) {
			this.coRegLastName = coRegLastName;
		}

		@Column(name = "password", nullable = false, length = 128)
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Column(name = "password_salt", nullable = false, length = 128)
		public String getPasswordSalt() {
			return passwordSalt;
		}

		public void setPasswordSalt(String passwordSalt) {
			this.passwordSalt = passwordSalt;
		}

		@Column(name = "type_of_user", length = 2)
		public String getTypeOfUser() {
			return typeOfUser;
		}

		public void setTypeOfUser(String typeOfUser) {
			this.typeOfUser = typeOfUser;
		}

		@Column(name = "last_password_changed_date", length = 29)
		public Timestamp getLastPasswordChangedDate() {
			return lastPasswordChangedDate;
		}

		public void setLastPasswordChangedDate(Timestamp lastPasswordChangedDate) {
			this.lastPasswordChangedDate = lastPasswordChangedDate;
		}

		@Column(name = "security_pin", length = 30)
		public String getSecurityPin() {
			return securityPin;
		}

		public void setSecurityPin(String securityPin) {
			this.securityPin = securityPin;
		}

		@Column(name = "email_sent_date", length = 29)
		public Timestamp getEmailSentDate() {
			return emailSentDate;
		}

		public void setEmailSentDate(Timestamp emailSentDate) {
			this.emailSentDate = emailSentDate;
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

		@Column(name="reg_photo_upload", columnDefinition="longblob")
		@Lob
		public byte[] getRegPhotoUpload() {
			return regPhotoUpload;
		}

		public void setRegPhotoUpload(byte[] regPhotoUpload) {
			this.regPhotoUpload = regPhotoUpload;
		}

		@Column(name = "reg_message")
		public String getRegMessage() {
			return regMessage;
		}

		public void setRegMessage(String regMessage) {
			this.regMessage = regMessage;
		}

		@Column(name = "reg_address", length = 60)
		public String getRegAddress() {
			return regAddress;
		}

		public void setRegAddress(String regAddress) {
			this.regAddress = regAddress;
		}

		@Column(name = "guest_background_img", length = 60)
		public String getGuestBackgroundImg() {
			return guestBackgroundImg;
		}

		public void setGuestBackgroundImg(String guestBackgroundImg) {
			this.guestBackgroundImg = guestBackgroundImg;
		}

		@Column(name = "reg_social_media", length = 60)
		public String getRegSocialMedia() {
			return regSocialMedia;
		}

		public void setRegSocialMedia(String regSocialMedia) {
			this.regSocialMedia = regSocialMedia;
		}

		@Column(name = "reg_archive_status", length = 60)
		public String getRegArchiveStatus() {
			return regArchiveStatus;
		}

		public void setRegArchiveStatus(String regArchiveStatus) {
			this.regArchiveStatus = regArchiveStatus;
		}

		@Column(name = "reg_vendor_coupon_id", length = 60)
		public String getRegVendorCouponId() {
			return regVendorCouponId;
		}

		public void setRegVendorCouponId(String regVendorCouponId) {
			this.regVendorCouponId = regVendorCouponId;
		}

		@Column(name="reg_background_upload_image", columnDefinition="longblob")
		@Lob
		public byte[] getRegBackgroundUploadImage() {
			return regBackgroundUploadImage;
		}

		public void setRegBackgroundUploadImage(byte[] regBackgroundUploadImage) {
			this.regBackgroundUploadImage = regBackgroundUploadImage;
		}
		
		
				
}
