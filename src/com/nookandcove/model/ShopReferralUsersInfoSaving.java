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
@Table(name = "shop_referral_users_info_saving")
public class ShopReferralUsersInfoSaving implements java.io.Serializable {
	
	private long referralUserId;
	private String referralUserEmail;	
	private String referralFirstName;
	private String referralLastName;
	private String referralBusinessName;
	private String vendorCategory;
	private String otherCategory;
	private String referralWebsite;
	private String referralSocialMediaInfo;
	private String referralPhoneNumber;
	private String referralPassword;
	private String passwordSalt;
	private Timestamp lastPasswordChangedDate;
	private String securityPin;
	private Timestamp emailSentDate;
	private String referralCouponCode;
	private String referralCustomGiftCard;
	private String adminReferralNote;
	private String status;
	private String wpStatus;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	private String referralSocialMedia;
	private String referralStreetAddress;
	private String referralStreetLine;
	private String referralCityName;
	private String referralStateName;
	private String referralZipCode;
		
// Constructors

		/** default constructor */
	public ShopReferralUsersInfoSaving() {
	}

// Property accessors
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
				
		@Column(name = "shop_referral_users_info_saving_id", unique = true, nullable = false)		
		public long getReferralUserId() {
			return referralUserId;
		}

		public void setReferralUserId(long referralUserId) {
			this.referralUserId = referralUserId;
		}

		@Column(name = "referral_user_email", unique = true, nullable = false, length = 60)
		public String getReferralUserEmail() {
			return referralUserEmail;
		}

		public void setReferralUserEmail(String referralUserEmail) {
			this.referralUserEmail = referralUserEmail;
		}

		@Column(name = "referral_first_name", length = 60)
		public String getReferralFirstName() {
			return referralFirstName;
		}

		public void setReferralFirstName(String referralFirstName) {
			this.referralFirstName = referralFirstName;
		}

		@Column(name = "referral_last_name", length = 30)
		public String getReferralLastName() {
			return referralLastName;
		}

		public void setReferralLastName(String referralLastName) {
			this.referralLastName = referralLastName;
		}

		@Column(name = "referral_business_name", length = 160)
		public String getReferralBusinessName() {
			return referralBusinessName;
		}

		public void setReferralBusinessName(String referralBusinessName) {
			this.referralBusinessName = referralBusinessName;
		}

		@Column(name = "referral_vendor_category", length = 100)
		public String getVendorCategory() {
			return vendorCategory;
		}

		public void setVendorCategory(String vendorCategory) {
			this.vendorCategory = vendorCategory;
		}

		@Column(name = "referral_other_category", length = 100)
		public String getOtherCategory() {
			return otherCategory;
		}

		public void setOtherCategory(String otherCategory) {
			this.otherCategory = otherCategory;
		}

		@Column(name = "referral_website", length = 160)
		public String getReferralWebsite() {
			return referralWebsite;
		}

		public void setReferralWebsite(String referralWebsite) {
			this.referralWebsite = referralWebsite;
		}

		@Column(name = "referral_fb_or_inst_info", length = 100)
		public String getReferralSocialMediaInfo() {
			return referralSocialMediaInfo;
		}

		public void setReferralSocialMediaInfo(String referralSocialMediaInfo) {
			this.referralSocialMediaInfo = referralSocialMediaInfo;
		}

		@Column(name = "referral_phone_number", length = 15)
		public String getReferralPhoneNumber() {
			return referralPhoneNumber;
		}

		public void setReferralPhoneNumber(String referralPhoneNumber) {
			this.referralPhoneNumber = referralPhoneNumber;
		}

		@Column(name = "referral_coupon_code", length = 10)
		public String getReferralCouponCode() {
			return referralCouponCode;
		}

		public void setReferralCouponCode(String referralCouponCode) {
			this.referralCouponCode = referralCouponCode;
		}
		
		@Column(name = "referral_custom_gift_card", length = 10)
		public String getReferralCustomGiftCard() {
			return referralCustomGiftCard;
		}

		public void setReferralCustomGiftCard(String referralCustomGiftCard) {
			this.referralCustomGiftCard = referralCustomGiftCard;
		}

		@Column(name = "password", length = 128)
		public String getReferralPassword() {
			return referralPassword;
		}

		public void setReferralPassword(String referralPassword) {
			this.referralPassword = referralPassword;
		}

		@Column(name = "password_salt", length = 128)
		public String getPasswordSalt() {
			return passwordSalt;
		}

		public void setPasswordSalt(String passwordSalt) {
			this.passwordSalt = passwordSalt;
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
		
		@Column(name = "admin_referral_note")
		public String getAdminReferralNote() {
			return adminReferralNote;
		}

		public void setAdminReferralNote(String adminReferralNote) {
			this.adminReferralNote = adminReferralNote;
		}

		@Column(name = "status", length = 10)
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		@Column(name = "wp_status", length = 10)
		public String getWpStatus() {
			return wpStatus;
		}

		public void setWpStatus(String wpStatus) {
			this.wpStatus = wpStatus;
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

		@Column(name = "referral_social_media", length = 60)
		public String getReferralSocialMedia() {
			return referralSocialMedia;
		}

		public void setReferralSocialMedia(String referralSocialMedia) {
			this.referralSocialMedia = referralSocialMedia;
		}

		@Column(name = "referral_street_address", length = 200)
		public String getReferralStreetAddress() {
			return referralStreetAddress;
		}

		public void setReferralStreetAddress(String referralStreetAddress) {
			this.referralStreetAddress = referralStreetAddress;
		}

		@Column(name = "referral_street_line", length = 200)
		public String getReferralStreetLine() {
			return referralStreetLine;
		}

		public void setReferralStreetLine(String referralStreetLine) {
			this.referralStreetLine = referralStreetLine;
		}

		@Column(name = "referral_city_name", length = 100)
		public String getReferralCityName() {
			return referralCityName;
		}

		public void setReferralCityName(String referralCityName) {
			this.referralCityName = referralCityName;
		}

		@Column(name = "referral_state_name", length = 100)
		public String getReferralStateName() {
			return referralStateName;
		}

		public void setReferralStateName(String referralStateName) {
			this.referralStateName = referralStateName;
		}

		@Column(name = "referral_zip_code", length = 10)
		public String getReferralZipCode() {
			return referralZipCode;
		}

		public void setReferralZipCode(String referralZipCode) {
			this.referralZipCode = referralZipCode;
		}
				
}
