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
@Table(name = "registrant_concept_boards_individual_payment_saving")
public class RegistrantConceptBoardsIndividualPaymentSaving implements java.io.Serializable {
	
	// Fields
	
	private long registrantConceptBoardsIndividualPaymentSavingId;
	private long registrantUserId;
	private long registrantConceptBoardsIndividualProductsInfoSavingId;
	private Integer giftedQuantity;
	private String individualStatus;
	private long registrantPaymentInfoSavingId;
	private String checkoutPaymentStatus;
	private String trackingLink;
	private String backOrderedText;
	private String status;
	private Timestamp refferanceDate;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

	/** default constructor */
	public RegistrantConceptBoardsIndividualPaymentSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "registrant_concept_boards_individual_payment_saving_id", unique = true, nullable = false)
	public long getRegistrantConceptBoardsIndividualPaymentSavingId() {
		return registrantConceptBoardsIndividualPaymentSavingId;
	}

	public void setRegistrantConceptBoardsIndividualPaymentSavingId(long registrantConceptBoardsIndividualPaymentSavingId) {
		this.registrantConceptBoardsIndividualPaymentSavingId = registrantConceptBoardsIndividualPaymentSavingId;
	}	
	
	@Column(name = "registrant_user_id", nullable = false)
	public long getRegistrantUserId() {
		return registrantUserId;
	}

	public void setRegistrantUserId(long registrantUserId) {
		this.registrantUserId = registrantUserId;
	}

	@Column(name = "registrant_concept_boards_individual_products_info_saving_id", nullable = false)
	public long getRegistrantConceptBoardsIndividualProductsInfoSavingId() {
		return registrantConceptBoardsIndividualProductsInfoSavingId;
	}

	public void setRegistrantConceptBoardsIndividualProductsInfoSavingId(long registrantConceptBoardsIndividualProductsInfoSavingId) {
		this.registrantConceptBoardsIndividualProductsInfoSavingId = registrantConceptBoardsIndividualProductsInfoSavingId;
	}

	@Column(name = "tracking_link")
	public String getTrackingLink() {
		return trackingLink;
	}
	
	public void setTrackingLink(String trackingLink) {
		this.trackingLink = trackingLink;
	}
	
	@Column(name = "status", length = 20)
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "registrant_payment_info_saving_id")
	public long getRegistrantPaymentInfoSavingId() {
		return registrantPaymentInfoSavingId;
	}

	public void setRegistrantPaymentInfoSavingId(long registrantPaymentInfoSavingId) {
		this.registrantPaymentInfoSavingId = registrantPaymentInfoSavingId;
	}
	
	@Column(name = "checkout_payment_status", length = 100)
	public String getCheckoutPaymentStatus() {
		return checkoutPaymentStatus;
	}

	public void setCheckoutPaymentStatus(String checkoutPaymentStatus) {
		this.checkoutPaymentStatus = checkoutPaymentStatus;
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

	@Column(name = "refferance_date")
	public Timestamp getRefferanceDate() {
		return refferanceDate;
	}

	public void setRefferanceDate(Timestamp refferanceDate) {
		this.refferanceDate = refferanceDate;
	}

	@Column(name = "individual_status", length = 100)
	public String getIndividualStatus() {
		return individualStatus;
	}

	public void setIndividualStatus(String individualStatus) {
		this.individualStatus = individualStatus;
	}
	
	@Column(name = "gifted_quantity", length = 10)
	public Integer getGiftedQuantity() {
		return giftedQuantity;
	}

	public void setGiftedQuantity(Integer giftedQuantity) {
		this.giftedQuantity = giftedQuantity;
	}

	@Column(name = "back_ordered_text", length = 300)
	public String getBackOrderedText() {
		return backOrderedText;
	}

	public void setBackOrderedText(String backOrderedText) {
		this.backOrderedText = backOrderedText;
	}

	
}
