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
@Table(name = "user_information")
public class UserInformation implements java.io.Serializable {

	// Fields

	private long userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String passwordSalt;
	private String typeOfUser;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	private Timestamp lastPasswordChangedDate;
	private String securityPin;
	private Timestamp emailSentDate;
	private String adminType;
	private String desnPersonalBio;
	private String desnLocation;
	private String desnCredential;

	// Constructors

	/** default constructor */
	public UserInformation() {
	}

	// Property accessors
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "user_name", unique = true, nullable = false, length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", nullable = false, length = 128)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "first_name", length = 60)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 128)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
	
	@Column(name = "phone_number", length = 15)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "password_salt", nullable = false, length = 128)
	public String getPasswordSalt() {
		return this.passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	@Column(name = "type_of_user", length = 2)
	public String getTypeOfUser() {
		return this.typeOfUser;
	}

	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}

	@Column(name = "created_date", nullable = false, length = 29)
	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}	

	@Column(name = "last_password_changed_date", length = 29)
	public Timestamp getLastPasswordChangedDate() {
		return this.lastPasswordChangedDate;
	}

	public void setLastPasswordChangedDate(Timestamp lastPasswordChangedDate) {
		this.lastPasswordChangedDate = lastPasswordChangedDate;
	}

	@Column(name = "security_pin", length = 30)
	public String getSecurityPin() {
		return this.securityPin;
	}

	public void setSecurityPin(String securityPin) {
		this.securityPin = securityPin;
	}

	@Column(name = "email_sent_date", length = 29)
	public Timestamp getEmailSentDate() {
		return this.emailSentDate;
	}

	public void setEmailSentDate(Timestamp emailSentDate) {
		this.emailSentDate = emailSentDate;
	}

	@Column(name = "admin_type", length = 50)
	public String getAdminType() {
		return this.adminType;
	}

	public void setAdminType(String adminType) {
		this.adminType = adminType;
	}

	@Column(name = "designer_personal_bio")
	public String getDesnPersonalBio() {
		return desnPersonalBio;
	}

	public void setDesnPersonalBio(String desnPersonalBio) {
		this.desnPersonalBio = desnPersonalBio;
	}

	@Column(name = "designer_location")
	public String getDesnLocation() {
		return desnLocation;
	}

	public void setDesnLocation(String desnLocation) {
		this.desnLocation = desnLocation;
	}

	@Column(name = "designer_credentials")
	public String getDesnCredential() {
		return desnCredential;
	}

	public void setDesnCredential(String desnCredential) {
		this.desnCredential = desnCredential;
	}
	
	@Column(name = "updated_date")
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
}