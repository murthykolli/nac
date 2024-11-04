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
@Table(name = "designer_info_saving")
public class DesignerInfoSaving implements java.io.Serializable {

	// Fields

	private long designerInfoSavingId;
	private long designerId;
	private byte[] designerProfileImageBlob;
	private String quirkyFactsAboutDesigner;
	private String designerFullName;	
	private String status;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	private String desWaitingForClientStatus;
	private Timestamp desWaitingForClientDate;
	
	// Constructors

	/** default constructor */
	public DesignerInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "designer_info_saving_id", unique = true, nullable = false)
	public long getDesignerInfoSavingId() {
		return designerInfoSavingId;
	}

	public void setDesignerInfoSavingId(long designerInfoSavingId) {
		this.designerInfoSavingId = designerInfoSavingId;
	}

	@Column(name = "designer_id", nullable = false)
	public long getDesignerId() {
		return designerId;
	}

	public void setDesignerId(long designerId) {
		this.designerId = designerId;
	}

	@Column(name="designer_profile_image_blob", columnDefinition="longblob")
	@Lob
	public byte[] getDesignerProfileImageBlob() {
		return designerProfileImageBlob;
	}

	public void setDesignerProfileImageBlob(byte[] designerProfileImageBlob) {
		this.designerProfileImageBlob = designerProfileImageBlob;
	}

	@Column(name = "quirky_facts_about_designer")
	public String getQuirkyFactsAboutDesigner() {
		return quirkyFactsAboutDesigner;
	}

	public void setQuirkyFactsAboutDesigner(String quirkyFactsAboutDesigner) {
		this.quirkyFactsAboutDesigner = quirkyFactsAboutDesigner;
	}
	
	@Column(name = "designer_full_name", length = 100)
	public String getDesignerFullName() {
		return designerFullName;
	}

	public void setDesignerFullName(String designerFullName) {
		this.designerFullName = designerFullName;
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

	@Column(name = "des_waiting_for_client_status", length = 100)
	public String getDesWaitingForClientStatus() {
		return desWaitingForClientStatus;
	}

	public void setDesWaitingForClientStatus(String desWaitingForClientStatus) {
		this.desWaitingForClientStatus = desWaitingForClientStatus;
	}

	@Column(name = "des_waiting_for_client_date")
	public Timestamp getDesWaitingForClientDate() {
		return desWaitingForClientDate;
	}

	public void setDesWaitingForClientDate(Timestamp desWaitingForClientDate) {
		this.desWaitingForClientDate = desWaitingForClientDate;
	}
		
	
}