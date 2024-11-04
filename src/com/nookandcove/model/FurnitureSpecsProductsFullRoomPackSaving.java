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
@Table(name = "furniture_specs_products_full_room_pack_saving")
public class FurnitureSpecsProductsFullRoomPackSaving implements java.io.Serializable {
	
	// Fields
	
	private long furnitureSpecsProductsFullRoomPackSavingId;
	private long clientInfoSavingId;
	private long designerInfoSavingId;	
	private String conceptsRenderingsRefferance;
	private String productName;
	private String productPrice;
	private int productQuantity;
	private String storeName;
	private String storeURL;
	private String skuName;
	private String productDescription;
	private String assemblyRequiredStatus;
	private byte[] productImage;
	private String status;
	private String revRendStatus;
	private String secRendStatus;
	private String roomRendStatus;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

	/** default constructor */
	public FurnitureSpecsProductsFullRoomPackSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "furniture_specs_products_full_room_pack_saving_id", unique = true, nullable = false)
	public long getFurnitureSpecsProductsFullRoomPackSavingId() {
		return furnitureSpecsProductsFullRoomPackSavingId;
	}

	public void setFurnitureSpecsProductsFullRoomPackSavingId(long furnitureSpecsProductsFullRoomPackSavingId) {
		this.furnitureSpecsProductsFullRoomPackSavingId = furnitureSpecsProductsFullRoomPackSavingId;
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

	@Column(name="product_image", columnDefinition="longblob")
	@Lob
	public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	@Column(name = "concepts_renderings_refferance", length = 100)
	public String getConceptsRenderingsRefferance() {
		return conceptsRenderingsRefferance;
	}

	public void setConceptsRenderingsRefferance(String conceptsRenderingsRefferance) {
		this.conceptsRenderingsRefferance = conceptsRenderingsRefferance;
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

	@Column(name = "product_quantity", length = 15)
	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Column(name = "product_description")
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Column(name = "assembly_required_status", length = 30)
	public String getAssemblyRequiredStatus() {
		return assemblyRequiredStatus;
	}

	public void setAssemblyRequiredStatus(String assemblyRequiredStatus) {
		this.assemblyRequiredStatus = assemblyRequiredStatus;
	}

	@Column(name = "store", length = 100)
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	@Column(name = "store_url")
	public String getStoreURL() {
		return storeURL;
	}

	public void setStoreURL(String storeURL) {
		this.storeURL = storeURL;
	}

	@Column(name = "sku_name")
	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	@Column(name = "status", length = 10)
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "rev_rend_status", length = 30)
	public String getRevRendStatus() {
		return revRendStatus;
	}

	public void setRevRendStatus(String revRendStatus) {
		this.revRendStatus = revRendStatus;
	}

	@Column(name = "sec_rend_status", length = 30)
	public String getSecRendStatus() {
		return secRendStatus;
	}

	public void setSecRendStatus(String secRendStatus) {
		this.secRendStatus = secRendStatus;
	}

	@Column(name = "room_rend_status", length = 30)
	public String getRoomRendStatus() {
		return roomRendStatus;
	}

	public void setRoomRendStatus(String roomRendStatus) {
		this.roomRendStatus = roomRendStatus;
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
