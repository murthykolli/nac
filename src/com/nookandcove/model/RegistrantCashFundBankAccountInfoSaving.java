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
@Table(name = "registrant_cash_fund_bank_account_info_saving")
public class RegistrantCashFundBankAccountInfoSaving implements java.io.Serializable {
	
	// Fields
	
	private long registrantCashFundBankAccountInfoSavingId;
	private long registrantUserId;	
	
	private String cashFundRoutingNumber;
	private String cashFundAccountNumber;
	private String cashFundFirstName;
	private String cashFundLastName;
	private String cashFundStreetAddress;
	private String cashFundAptOrUnit;
	private String cashFundCity;
	private String cashFundState;
	private String cashFundZipCode;
	private String cashFundPhoneNumber;
	private String cashFundStatus;
		
	private String status;	
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

	/** default constructor */
	public RegistrantCashFundBankAccountInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "registrant_cash_fund_bank_account_info_saving_id", unique = true, nullable = false)
	public long getRegistrantCashFundBankAccountInfoSavingId() {
		return registrantCashFundBankAccountInfoSavingId;
	}

	public void setRegistrantCashFundBankAccountInfoSavingId(long registrantCashFundBankAccountInfoSavingId) {
		this.registrantCashFundBankAccountInfoSavingId = registrantCashFundBankAccountInfoSavingId;
	}

	@Column(name = "registrant_user_id", nullable = false)
	public long getRegistrantUserId() {
		return registrantUserId;
	}
	
	public void setRegistrantUserId(long registrantUserId) {
		this.registrantUserId = registrantUserId;
	}

	@Column(name = "cash_fund_routing_number", length = 20)
	public String getCashFundRoutingNumber() {
		return cashFundRoutingNumber;
	}

	public void setCashFundRoutingNumber(String cashFundRoutingNumber) {
		this.cashFundRoutingNumber = cashFundRoutingNumber;
	}
	@Column(name = "cash_fund_account_number", length = 20)
	public String getCashFundAccountNumber() {
		return cashFundAccountNumber;
	}

	public void setCashFundAccountNumber(String cashFundAccountNumber) {
		this.cashFundAccountNumber = cashFundAccountNumber;
	}

	@Column(name = "cash_fund_first_name", length = 100)	
	public String getCashFundFirstName() {
		return cashFundFirstName;
	}

	public void setCashFundFirstName(String cashFundFirstName) {
		this.cashFundFirstName = cashFundFirstName;
	}

	@Column(name = "cash_fund_last_name", length = 100)
	public String getCashFundLastName() {
		return cashFundLastName;
	}

	public void setCashFundLastName(String cashFundLastName) {
		this.cashFundLastName = cashFundLastName;
	}

	@Column(name = "cash_fund_street_address", length = 260)
	public String getCashFundStreetAddress() {
		return cashFundStreetAddress;
	}

	public void setCashFundStreetAddress(String cashFundStreetAddress) {
		this.cashFundStreetAddress = cashFundStreetAddress;
	}

	@Column(name = "cash_fund_apt_or_unit", length = 60)
	public String getCashFundAptOrUnit() {
		return cashFundAptOrUnit;
	}

	public void setCashFundAptOrUnit(String cashFundAptOrUnit) {
		this.cashFundAptOrUnit = cashFundAptOrUnit;
	}

	@Column(name = "cash_fund_city", length = 100)
	public String getCashFundCity() {
		return cashFundCity;
	}

	public void setCashFundCity(String cashFundCity) {
		this.cashFundCity = cashFundCity;
	}

	@Column(name = "cash_fund_state", length = 100)
	public String getCashFundState() {
		return cashFundState;
	}

	public void setCashFundState(String cashFundState) {
		this.cashFundState = cashFundState;
	}

	@Column(name = "cash_fund_zip_code", length = 10)
	public String getCashFundZipCode() {
		return cashFundZipCode;
	}

	public void setCashFundZipCode(String cashFundZipCode) {
		this.cashFundZipCode = cashFundZipCode;
	}

	@Column(name = "cash_fund_phone_number", length = 15)
	public String getCashFundPhoneNumber() {
		return cashFundPhoneNumber;
	}

	public void setCashFundPhoneNumber(String cashFundPhoneNumber) {
		this.cashFundPhoneNumber = cashFundPhoneNumber;
	}

	@Column(name = "cash_fund_status", length = 60)
	public String getCashFundStatus() {
		return cashFundStatus;
	}

	public void setCashFundStatus(String cashFundStatus) {
		this.cashFundStatus = cashFundStatus;
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