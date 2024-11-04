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
@Table(name = "add_client_products_to_cart_saving")
public class AddClientProductsToCartSaving implements java.io.Serializable {
	
	// Fields
	
	private long addClientProductsToCartSavingId;
	private long userId;
	private long clientInfoSavingId;
	private long designerInfoSavingId;
	private long clientProductsUploadedByDesignerSavingId;
	private byte[] productImageUpload;
	private String conceptsThreedRefferance;
	private String productName;
	private String productPrice;
	private String storeName;
	private String storeURL;
	private int productCount;
	private String skuName;
	private String likeStatus;
	private String status;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	private String productTotalPrice;
	private long shoppingCartPaymentInfoSavingId;
	private String cartUsedStatus;
	private String cartPaymentStatus;
	private String orderedStatus;
	private String deliveredStatus;
	
	// Constructors

	/** default constructor */
	public AddClientProductsToCartSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "add_client_products_to_cart_saving_id", unique = true, nullable = false)
	public long getAddClientProductsToCartSavingId() {
		return addClientProductsToCartSavingId;
	}

	public void setAddClientProductsToCartSavingId(long addClientProductsToCartSavingId) {
		this.addClientProductsToCartSavingId = addClientProductsToCartSavingId;
	}

	@Column(name = "user_id", nullable = false)
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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
	
	@Column(name = "client_products_uploaded_by_designer_saving_id")
	public long getClientProductsUploadedByDesignerSavingId() {
		return clientProductsUploadedByDesignerSavingId;
	}

	public void setClientProductsUploadedByDesignerSavingId(long clientProductsUploadedByDesignerSavingId) {
		this.clientProductsUploadedByDesignerSavingId = clientProductsUploadedByDesignerSavingId;
	}

	@Column(name="product_image_upload", columnDefinition="longblob")
	@Lob
	public byte[] getProductImageUpload() {
		return productImageUpload;
	}

	public void setProductImageUpload(byte[] productImageUpload) {
		this.productImageUpload = productImageUpload;
	}

	@Column(name = "concepts_threed_refferance", length = 100)
	public String getConceptsThreedRefferance() {
		return conceptsThreedRefferance;
	}

	public void setConceptsThreedRefferance(String conceptsThreedRefferance) {
		this.conceptsThreedRefferance = conceptsThreedRefferance;
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

	@Column(name = "store", length = 100)
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	@Column(name = "store_url", length = 60)
	public String getStoreURL() {
		return storeURL;
	}

	public void setStoreURL(String storeURL) {
		this.storeURL = storeURL;
	}

	@Column(name = "product_count", length = 11)
	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	@Column(name = "sku_name")
	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	@Column(name = "like_status", length = 30)
	public String getLikeStatus() {
		return likeStatus;
	}

	public void setLikeStatus(String likeStatus) {
		this.likeStatus = likeStatus;
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
	
	@Column(name = "product_total_price", length = 15)
	public String getProductTotalPrice() {
		return productTotalPrice;
	}

	public void setProductTotalPrice(String productTotalPrice) {
		this.productTotalPrice = productTotalPrice;
	}

	@Column(name = "shopping_cart_payment_info_saving_id")
	public long getShoppingCartPaymentInfoSavingId() {
		return shoppingCartPaymentInfoSavingId;
	}

	public void setShoppingCartPaymentInfoSavingId(long shoppingCartPaymentInfoSavingId) {
		this.shoppingCartPaymentInfoSavingId = shoppingCartPaymentInfoSavingId;
	}
	
	@Column(name = "cart_used_status", length = 60)
	public String getCartUsedStatus() {
		return cartUsedStatus;
	}

	public void setCartUsedStatus(String cartUsedStatus) {
		this.cartUsedStatus = cartUsedStatus;
	}

	@Column(name = "cart_payment_status", length = 100)
	public String getCartPaymentStatus() {
		return cartPaymentStatus;
	}

	public void setCartPaymentStatus(String cartPaymentStatus) {
		this.cartPaymentStatus = cartPaymentStatus;
	}

	@Column(name = "ordered_status", length = 20)
	public String getOrderedStatus() {
		return orderedStatus;
	}

	public void setOrderedStatus(String orderedStatus) {
		this.orderedStatus = orderedStatus;
	}

	@Column(name = "delivered_status", length = 20)
	public String getDeliveredStatus() {
		return deliveredStatus;
	}

	public void setDeliveredStatus(String deliveredStatus) {
		this.deliveredStatus = deliveredStatus;
	}
	
}
