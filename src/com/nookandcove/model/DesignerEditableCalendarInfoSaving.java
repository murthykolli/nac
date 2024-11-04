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
@Table(name = "designer_editable_calendar_info_saving")
public class DesignerEditableCalendarInfoSaving implements java.io.Serializable {

	// Fields

	private long designerEditableCalendarInfoSavingId;
	private long designerInfoSavingId;
	private long clientInfoSavingId;
	private String clientName;
	private String clientInfoText;
	private String clientData;
	private String clientYear;
	private String clientMonth;
	private String clientDay;
	private String dateInString;
	private String status;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

	public DesignerEditableCalendarInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "designer_editable_calendar_info_saving_id", unique = true, nullable = false)
	public long getDesignerEditableCalendarInfoSavingId() {
		return designerEditableCalendarInfoSavingId;
	}

	public void setDesignerEditableCalendarInfoSavingId(long designerEditableCalendarInfoSavingId) {
		this.designerEditableCalendarInfoSavingId = designerEditableCalendarInfoSavingId;
	}

	@Column(name = "designer_info_saving_id", nullable = false)
	public long getDesignerInfoSavingId() {
		return designerInfoSavingId;
	}

	public void setDesignerInfoSavingId(long designerInfoSavingId) {
		this.designerInfoSavingId = designerInfoSavingId;
	}
	
	@Column(name = "client_info_saving_id", nullable = false)
	public long getClientInfoSavingId() {
		return clientInfoSavingId;
	}

	public void setClientInfoSavingId(long clientInfoSavingId) {
		this.clientInfoSavingId = clientInfoSavingId;
	}

	@Column(name = "client_name", length = 60)
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Column(name = "client_info_text")
	public String getClientInfoText() {
		return clientInfoText;
	}

	public void setClientInfoText(String clientInfoText) {
		this.clientInfoText = clientInfoText;
	}
	
	@Column(name = "client_data")
	public String getClientData() {
		return clientData;
	}

	public void setClientData(String clientData) {
		this.clientData = clientData;
	}
	
	@Column(name = "year", length = 60)
	public String getClientYear() {
		return clientYear;
	}

	public void setClientYear(String clientYear) {
		this.clientYear = clientYear;
	}

	@Column(name = "month", length = 60)
	public String getClientMonth() {
		return clientMonth;
	}

	public void setClientMonth(String clientMonth) {
		this.clientMonth = clientMonth;
	}

	@Column(name = "day", length = 60)
	public String getClientDay() {
		return clientDay;
	}

	public void setClientDay(String clientDay) {
		this.clientDay = clientDay;
	}

	@Column(name = "date_in_string", length = 60)
	public String getDateInString() {
		return dateInString;
	}

	public void setDateInString(String dateInString) {
		this.dateInString = dateInString;
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

}