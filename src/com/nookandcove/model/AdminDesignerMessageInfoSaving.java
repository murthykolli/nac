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
@Table(name = "admin_designer_message_info_saving")
public class AdminDesignerMessageInfoSaving implements java.io.Serializable {
	
	// Fields
	
	private long adminDesignerMessageInfoSavingId;
	private long designerInfoSavingId;	
	private String messageInfo;	
	private String status;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	private String oneTimeRefDate;
	
	// Constructors

	/** default constructor */
	public AdminDesignerMessageInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "admin_designer_message_info_saving_id", unique = true, nullable = false)
	public long getAdminDesignerMessageInfoSavingId() {
		return adminDesignerMessageInfoSavingId;
	}

	public void setAdminDesignerMessageInfoSavingId(long adminDesignerMessageInfoSavingId) {
		this.adminDesignerMessageInfoSavingId = adminDesignerMessageInfoSavingId;
	}

	@Column(name = "designer_info_saving_id")
	public long getDesignerInfoSavingId() {
		return designerInfoSavingId;
	}

	public void setDesignerInfoSavingId(long designerInfoSavingId) {
		this.designerInfoSavingId = designerInfoSavingId;
	}

	@Column(name = "message_info")
	public String getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
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

	@Column(name = "one_time_ref_date", length = 20)
	public String getOneTimeRefDate() {
		return oneTimeRefDate;
	}

	public void setOneTimeRefDate(String oneTimeRefDate) {
		this.oneTimeRefDate = oneTimeRefDate;
	}
		
}
