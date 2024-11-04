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
@Table(name = "shop_concept_boards_products_info_saving")
public class ShopConceptBoardsProductsInfoSaving implements java.io.Serializable {
	
	// Fields
	
	private long shopConceptBoardsProductsInfoSavingId;
	private long adminRegistryConceptBoardsFurnitureSpecsSavingId;	
	private String productName;
	private byte[] productUploadedImage;	
	private String productPrice;
	private String productDescription;
	private String productSize;
	private String storeName;
	private String storeUrl;
	private Integer quantity;
	
	private long shopUserPaymentInfoSavingId;
	private String checkoutPaymentStatus;
	
	private long transactionNumber;
	private Integer orderNumber;
	private String shopProductStatus;
	private String trackingLink;
	private String backOrderedDate;
	private String backOrderedText;
	private String status;
	
	private Timestamp refferanceDate;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

	/** default constructor */
	public ShopConceptBoardsProductsInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "shop_concept_boards_products_info_saving_id", unique = true, nullable = false)
	public long getShopConceptBoardsProductsInfoSavingId() {
		return shopConceptBoardsProductsInfoSavingId;
	}

	public void setShopConceptBoardsProductsInfoSavingId(long shopConceptBoardsProductsInfoSavingId) {
		this.shopConceptBoardsProductsInfoSavingId = shopConceptBoardsProductsInfoSavingId;
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

	@Column(name = "product_size", length = 100)
	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	@Column(name="product_uploaded_image", columnDefinition="longblob")
	@Lob
	public byte[] getProductUploadedImage() {
		return productUploadedImage;
	}

	public void setProductUploadedImage(byte[] productUploadedImage) {
		this.productUploadedImage = productUploadedImage;
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
	
	@Column(name = "quantity", length = 10)
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Column(name = "shop_user_payment_info_saving_id")
	public long getShopUserPaymentInfoSavingId() {
		return shopUserPaymentInfoSavingId;
	}

	public void setShopUserPaymentInfoSavingId(long shopUserPaymentInfoSavingId) {
		this.shopUserPaymentInfoSavingId = shopUserPaymentInfoSavingId;
	}

	@Column(name = "checkout_payment_status", length = 100)
	public String getCheckoutPaymentStatus() {
		return checkoutPaymentStatus;
	}

	public void setCheckoutPaymentStatus(String checkoutPaymentStatus) {
		this.checkoutPaymentStatus = checkoutPaymentStatus;
	}

	@Column(name = "transaction_number", length = 20)
	public long getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(long transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	
	@Column(name = "order_number", length = 10)
	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Column(name = "shop_product_status", length = 100)
	public String getShopProductStatus() {
		return shopProductStatus;
	}

	public void setShopProductStatus(String shopProductStatus) {
		this.shopProductStatus = shopProductStatus;
	}

	@Column(name = "tracking_link")
	public String getTrackingLink() {
		return trackingLink;
	}
	
	public void setTrackingLink(String trackingLink) {
		this.trackingLink = trackingLink;
	}

	@Column(name = "back_ordered_date", length = 30)
	public String getBackOrderedDate() {
		return backOrderedDate;
	}

	public void setBackOrderedDate(String backOrderedDate) {
		this.backOrderedDate = backOrderedDate;
	}

	@Column(name = "back_ordered_text", length = 300)
	public String getBackOrderedText() {
		return backOrderedText;
	}

	public void setBackOrderedText(String backOrderedText) {
		this.backOrderedText = backOrderedText;
	}
	
	@Column(name = "status", length = 10)
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "refferance_date")
	public Timestamp getRefferanceDate() {
		return refferanceDate;
	}

	public void setRefferanceDate(Timestamp refferanceDate) {
		this.refferanceDate = refferanceDate;
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
