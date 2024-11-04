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
@Table(name = "registrant_concept_boards_contributed_products_info_saving")
public class RegistrantConceptBoardsContributedProductsInfoSaving implements java.io.Serializable {
	
	// Fields
	
	private long registrantConceptBoardsContributedProductsInfoSavingId;
	private long registrantUserId;
	private long adminRegistryConceptBoardsFurnitureSpecsSavingId;	
	private String productName;
	private byte[] productUploadedImage;	
	private String productPrice;
	private String allTaxsTotalPrice;
	private String productDescription;
	private String productHeading;
	private String storeName;
	private String storeUrl;
	private String contributedPrice;
	private Integer quantity;	
	private String contributedStatus;
	private String remainingTotalPrice;
	private String backOrderedText;
	private String status;
	private String trackingLink;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

	/** default constructor */
	public RegistrantConceptBoardsContributedProductsInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "registrant_concept_boards_contributed_products_info_saving_id", unique = true, nullable = false)
	public long getRegistrantConceptBoardsContributedProductsInfoSavingId() {
		return registrantConceptBoardsContributedProductsInfoSavingId;
	}

	public void setRegistrantConceptBoardsContributedProductsInfoSavingId(long registrantConceptBoardsContributedProductsInfoSavingId) {
		this.registrantConceptBoardsContributedProductsInfoSavingId = registrantConceptBoardsContributedProductsInfoSavingId;
	}	
	
	@Column(name = "registrant_user_id", nullable = false)
	public long getRegistrantUserId() {
		return registrantUserId;
	}

	public void setRegistrantUserId(long registrantUserId) {
		this.registrantUserId = registrantUserId;
	}

	@Column(name = "admin_registry_concept_boards_furniture_specs_saving_id", nullable = false)
	public long getAdminRegistryConceptBoardsFurnitureSpecsSavingId() {
		return adminRegistryConceptBoardsFurnitureSpecsSavingId;
	}

	public void setAdminRegistryConceptBoardsFurnitureSpecsSavingId(long adminRegistryConceptBoardsFurnitureSpecsSavingId) {
		this.adminRegistryConceptBoardsFurnitureSpecsSavingId = adminRegistryConceptBoardsFurnitureSpecsSavingId;
	}

	@Column(name = "product_name", length = 100)
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "product_price", length = 15)
	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	
	@Column(name = "product_description")
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Column(name = "product_heading", length = 100)
	public String getProductHeading() {
		return productHeading;
	}

	public void setProductHeading(String productHeading) {
		this.productHeading = productHeading;
	}

	@Column(name="product_uploaded_image", columnDefinition="longblob")
	@Lob
	public byte[] getProductUploadedImage() {
		return productUploadedImage;
	}

	public void setProductUploadedImage(byte[] productUploadedImage) {
		this.productUploadedImage = productUploadedImage;
	}
	
	@Column(name = "contributed_price", length = 15)
	public String getContributedPrice() {
		return contributedPrice;
	}

	public void setContributedPrice(String contributedPrice) {
		this.contributedPrice = contributedPrice;
	}

	@Column(name = "quantity", length = 10)
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "contributed_status", length = 100)
	public String getContributedStatus() {
		return contributedStatus;
	}

	public void setContributedStatus(String contributedStatus) {
		this.contributedStatus = contributedStatus;
	}

	@Column(name = "status", length = 20)
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "all_taxs_total_price", length = 15)
	public String getAllTaxsTotalPrice() {
		return allTaxsTotalPrice;
	}

	public void setAllTaxsTotalPrice(String allTaxsTotalPrice) {
		this.allTaxsTotalPrice = allTaxsTotalPrice;
	}

	@Column(name = "remaining_total_price", length = 15)
	public String getRemainingTotalPrice() {
		return remainingTotalPrice;
	}

	public void setRemainingTotalPrice(String remainingTotalPrice) {
		this.remainingTotalPrice = remainingTotalPrice;
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

	@Column(name = "tracking_link")
	public String getTrackingLink() {
		return trackingLink;
	}

	public void setTrackingLink(String trackingLink) {
		this.trackingLink = trackingLink;
	}

	@Column(name = "back_ordered_text", length = 300)
	public String getBackOrderedText() {
		return backOrderedText;
	}

	public void setBackOrderedText(String backOrderedText) {
		this.backOrderedText = backOrderedText;
	}

	@Column(name = "store_name", length = 100)
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	@Column(name = "store_url")
	public String getStoreUrl() {
		return storeUrl;
	}

	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}
}
