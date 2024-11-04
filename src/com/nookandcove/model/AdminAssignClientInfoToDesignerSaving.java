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
@Table(name = "admin_assign_client_info_to_designer_saving")
public class AdminAssignClientInfoToDesignerSaving implements java.io.Serializable {

	// Fields
	
	private long adminAssignClientInfoToDesignerSavingId;
	private long clientInfoSavingId;
	private long designerInfoSavingId;
	private byte[] concept1ImageUpload;
	private byte[] concept2ImageUpload;
	private byte[] rendering1ImageUpload;
	private byte[] rendering2ImageUpload;
	private byte[] secondRendering1ImageUpload;
	private byte[] secondRendering2ImageUpload;	
	private byte[] revisedRendering1ImageUpload;
	private byte[] revisedRendering2ImageUpload;
	
	private String concept1LikeStatus;
	private String concept2LikeStatus;
	private String renderingLikeStatus;
	private String secondRenderingLikeStatus;
	private String revisedRenderingLikeStatus;
	
	private String clientRequestedForConcept;
	private String clientRequestedForRendering;
	private String clientPurchasedForSecondRendering;
	private String clientRequestedForRevisedRendering;
	
	private String secondRenderingPaymentStatus;	
	private String designPackCheckListInfo;	
	
	private String adminApprovedForConcept;
	private String adminApprovedForRendering;
	private String adminApprovedForSecondRendering;
	private String adminApprovedForRevisedRendering;
	
	private String designerSubmitConceptsStatus;
	private String designerSubmitRenderingStatus;
	private String designerSubmitSecondRenderingStatus;
	private String designerSubmitRevisedRenderingStatus;
	
	private String newUploads;
	private String conceptStatus;
	private String renderingStatus;
	private String secondRenderingStatus;
	private String revisedRenderingStatus;
	private String designerUploads;
	private long paymentInfoSavingId;
	
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

	/** default constructor */
	public AdminAssignClientInfoToDesignerSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "admin_assign_client_info_to_designer_saving_id", unique = true, nullable = false)
	public long getAdminAssignClientInfoToDesignerSavingId() {
		return adminAssignClientInfoToDesignerSavingId;
	}

	public void setAdminAssignClientInfoToDesignerSavingId(long adminAssignClientInfoToDesignerSavingId) {
		this.adminAssignClientInfoToDesignerSavingId = adminAssignClientInfoToDesignerSavingId;
	}

	@Column(name = "client_info_saving_id")
	public long getClientInfoSavingId() {
		return clientInfoSavingId;
	}

	public void setClientInfoSavingId(long clientInfoSavingId) {
		this.clientInfoSavingId = clientInfoSavingId;
	}

	@Column(name = "designer_info_saving_id")
	public long getDesignerInfoSavingId() {
		return designerInfoSavingId;
	}

	public void setDesignerInfoSavingId(long designerInfoSavingId) {
		this.designerInfoSavingId = designerInfoSavingId;
	}

	@Column(name="concept1_image_upload", columnDefinition="longblob")
	@Lob
	public byte[] getConcept1ImageUpload() {
		return concept1ImageUpload;
	}

	public void setConcept1ImageUpload(byte[] concept1ImageUpload) {
		this.concept1ImageUpload = concept1ImageUpload;
	}

	@Column(name="concept2_image_upload", columnDefinition="longblob")
	@Lob
	public byte[] getConcept2ImageUpload() {
		return concept2ImageUpload;
	}

	public void setConcept2ImageUpload(byte[] concept2ImageUpload) {
		this.concept2ImageUpload = concept2ImageUpload;
	}

	@Column(name="rendering1_image_upload", columnDefinition="longblob")
	@Lob
	public byte[] getRendering1ImageUpload() {
		return rendering1ImageUpload;
	}

	public void setRendering1ImageUpload(byte[] rendering1ImageUpload) {
		this.rendering1ImageUpload = rendering1ImageUpload;
	}

	@Column(name="rendering2_image_upload", columnDefinition="longblob")
	@Lob
	public byte[] getRendering2ImageUpload() {
		return rendering2ImageUpload;
	}

	public void setRendering2ImageUpload(byte[] rendering2ImageUpload) {
		this.rendering2ImageUpload = rendering2ImageUpload;
	}

	@Column(name="second_rendering1_image_upload", columnDefinition="longblob")
	@Lob
	public byte[] getSecondRendering1ImageUpload() {
		return secondRendering1ImageUpload;
	}

	public void setSecondRendering1ImageUpload(byte[] secondRendering1ImageUpload) {
		this.secondRendering1ImageUpload = secondRendering1ImageUpload;
	}

	@Column(name="second_rendering2_image_upload", columnDefinition="longblob")
	@Lob
	public byte[] getSecondRendering2ImageUpload() {
		return secondRendering2ImageUpload;
	}

	public void setSecondRendering2ImageUpload(byte[] secondRendering2ImageUpload) {
		this.secondRendering2ImageUpload = secondRendering2ImageUpload;
	}

	@Column(name = "concept1_like_status", length = 60)
	public String getConcept1LikeStatus() {
		return concept1LikeStatus;
	}

	public void setConcept1LikeStatus(String concept1LikeStatus) {
		this.concept1LikeStatus = concept1LikeStatus;
	}

	@Column(name = "concept2_like_status", length = 60)
	public String getConcept2LikeStatus() {
		return concept2LikeStatus;
	}

	public void setConcept2LikeStatus(String concept2LikeStatus) {
		this.concept2LikeStatus = concept2LikeStatus;
	}

	@Column(name = "rendering_like_status", length = 60)
	public String getRenderingLikeStatus() {
		return renderingLikeStatus;
	}

	public void setRenderingLikeStatus(String renderingLikeStatus) {
		this.renderingLikeStatus = renderingLikeStatus;
	}

	@Column(name = "second_rendering_like_status", length = 60)
	public String getSecondRenderingLikeStatus() {
		return secondRenderingLikeStatus;
	}

	public void setSecondRenderingLikeStatus(String secondRenderingLikeStatus) {
		this.secondRenderingLikeStatus = secondRenderingLikeStatus;
	}

	@Column(name = "client_requested_for_concept", length = 60)
	public String getClientRequestedForConcept() {
		return clientRequestedForConcept;
	}

	public void setClientRequestedForConcept(String clientRequestedForConcept) {
		this.clientRequestedForConcept = clientRequestedForConcept;
	}

	@Column(name = "client_requested_for_rendering", length = 60)
	public String getClientRequestedForRendering() {
		return clientRequestedForRendering;
	}

	public void setClientRequestedForRendering(String clientRequestedForRendering) {
		this.clientRequestedForRendering = clientRequestedForRendering;
	}

	@Column(name = "client_purchased_for_second_rendering", length = 30)
	public String getClientPurchasedForSecondRendering() {
		return clientPurchasedForSecondRendering;
	}

	public void setClientPurchasedForSecondRendering(String clientPurchasedForSecondRendering) {
		this.clientPurchasedForSecondRendering = clientPurchasedForSecondRendering;
	}

	@Column(name = "client_requested_for_revised_rendering", length = 30)
	public String getClientRequestedForRevisedRendering() {
		return clientRequestedForRevisedRendering;
	}

	public void setClientRequestedForRevisedRendering(String clientRequestedForRevisedRendering) {
		this.clientRequestedForRevisedRendering = clientRequestedForRevisedRendering;
	}

	@Column(name = "second_rendering_payment_status", length = 100)
	public String getSecondRenderingPaymentStatus() {
		return secondRenderingPaymentStatus;
	}

	public void setSecondRenderingPaymentStatus(String secondRenderingPaymentStatus) {
		this.secondRenderingPaymentStatus = secondRenderingPaymentStatus;
	}

	@Column(name = "desn_pack_checklist_info")
	public String getDesignPackCheckListInfo() {
		return designPackCheckListInfo;
	}

	public void setDesignPackCheckListInfo(String designPackCheckListInfo) {
		this.designPackCheckListInfo = designPackCheckListInfo;
	}

	@Column(name = "admin_approved_for_concept", length = 60)
	public String getAdminApprovedForConcept() {
		return adminApprovedForConcept;
	}

	public void setAdminApprovedForConcept(String adminApprovedForConcept) {
		this.adminApprovedForConcept = adminApprovedForConcept;
	}

	@Column(name = "admin_approved_for_rendering", length = 60)
	public String getAdminApprovedForRendering() {
		return adminApprovedForRendering;
	}

	public void setAdminApprovedForRendering(String adminApprovedForRendering) {
		this.adminApprovedForRendering = adminApprovedForRendering;
	}

	@Column(name = "admin_approved_for_second_rendering", length = 60)
	public String getAdminApprovedForSecondRendering() {
		return adminApprovedForSecondRendering;
	}

	public void setAdminApprovedForSecondRendering(String adminApprovedForSecondRendering) {
		this.adminApprovedForSecondRendering = adminApprovedForSecondRendering;
	}

	@Column(name = "designer_submit_concepts_status", length = 60)
	public String getDesignerSubmitConceptsStatus() {
		return designerSubmitConceptsStatus;
	}

	public void setDesignerSubmitConceptsStatus(String designerSubmitConceptsStatus) {
		this.designerSubmitConceptsStatus = designerSubmitConceptsStatus;
	}

	@Column(name = "designer_submit_rendering_status", length = 60)
	public String getDesignerSubmitRenderingStatus() {
		return designerSubmitRenderingStatus;
	}

	public void setDesignerSubmitRenderingStatus(String designerSubmitRenderingStatus) {
		this.designerSubmitRenderingStatus = designerSubmitRenderingStatus;
	}

	@Column(name = "designer_submit_second_rendering_status", length = 60)
	public String getDesignerSubmitSecondRenderingStatus() {
		return designerSubmitSecondRenderingStatus;
	}

	public void setDesignerSubmitSecondRenderingStatus(String designerSubmitSecondRenderingStatus) {
		this.designerSubmitSecondRenderingStatus = designerSubmitSecondRenderingStatus;
	}

	@Column(name = "new_uploads", length = 10)
	public String getNewUploads() {
		return newUploads;
	}

	public void setNewUploads(String newUploads) {
		this.newUploads = newUploads;
	}

	@Column(name = "concept_status", length = 50)
	public String getConceptStatus() {
		return conceptStatus;
	}
	
	public void setConceptStatus(String conceptStatus) {
		this.conceptStatus = conceptStatus;
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

	@Column(name="revised_rendering1_image_upload", columnDefinition="longblob")
	@Lob
	public byte[] getRevisedRendering1ImageUpload() {
		return revisedRendering1ImageUpload;
	}

	public void setRevisedRendering1ImageUpload(byte[] revisedRendering1ImageUpload) {
		this.revisedRendering1ImageUpload = revisedRendering1ImageUpload;
	}

	@Column(name="revised_rendering2_image_upload", columnDefinition="longblob")
	@Lob
	public byte[] getRevisedRendering2ImageUpload() {
		return revisedRendering2ImageUpload;
	}

	public void setRevisedRendering2ImageUpload(byte[] revisedRendering2ImageUpload) {
		this.revisedRendering2ImageUpload = revisedRendering2ImageUpload;
	}

	@Column(name = "revised_rendering_like_status", length = 60)
	public String getRevisedRenderingLikeStatus() {
		return revisedRenderingLikeStatus;
	}

	public void setRevisedRenderingLikeStatus(String revisedRenderingLikeStatus) {
		this.revisedRenderingLikeStatus = revisedRenderingLikeStatus;
	}

	@Column(name = "admin_approved_for_revised_rendering", length = 60)
	public String getAdminApprovedForRevisedRendering() {
		return adminApprovedForRevisedRendering;
	}

	public void setAdminApprovedForRevisedRendering(String adminApprovedForRevisedRendering) {
		this.adminApprovedForRevisedRendering = adminApprovedForRevisedRendering;
	}

	@Column(name = "designer_submit_revised_rendering_status", length = 60)
	public String getDesignerSubmitRevisedRenderingStatus() {
		return designerSubmitRevisedRenderingStatus;
	}

	public void setDesignerSubmitRevisedRenderingStatus(String designerSubmitRevisedRenderingStatus) {
		this.designerSubmitRevisedRenderingStatus = designerSubmitRevisedRenderingStatus;
	}

	@Column(name = "rendering_status", length = 50)
	public String getRenderingStatus() {
		return renderingStatus;
	}

	public void setRenderingStatus(String renderingStatus) {
		this.renderingStatus = renderingStatus;
	}

	@Column(name = "second_rendering_status", length = 50)
	public String getSecondRenderingStatus() {
		return secondRenderingStatus;
	}

	public void setSecondRenderingStatus(String secondRenderingStatus) {
		this.secondRenderingStatus = secondRenderingStatus;
	}

	@Column(name = "revised_rendering_status", length = 50)
	public String getRevisedRenderingStatus() {
		return revisedRenderingStatus;
	}

	public void setRevisedRenderingStatus(String revisedRenderingStatus) {
		this.revisedRenderingStatus = revisedRenderingStatus;
	}

	@Column(name = "designer_uploads", length = 50)
	public String getDesignerUploads() {
		return designerUploads;
	}

	public void setDesignerUploads(String designerUploads) {
		this.designerUploads = designerUploads;
	}

	@Column(name = "payment_info_saving_id")
	public long getPaymentInfoSavingId() {
		return paymentInfoSavingId;
	}

	public void setPaymentInfoSavingId(long paymentInfoSavingId) {
		this.paymentInfoSavingId = paymentInfoSavingId;
	}

	

}