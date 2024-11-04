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
@Table(name = "admin_registry_concept_boards_furniture_specs_saving")
public class AdminRegistryConceptBoardsFurnitureSpecsSaving implements java.io.Serializable {
	
	// Fields
	
	private long adminRegistryConceptBoardsFurnitureSpecsSavingId;
	private long adminRegistryConceptBoardsSavingId;
	private long adminDesignerCommonReferenceId;
	private String adminDesignerCommonReferenceName;
	private String adminApprovalStatus;
	private String productName;
	private String productSize1;
	private String productDescription1;
	private String productPrice1;
	private String productSize2;
	private String productDescription2;
	private String productPrice2;
	private String productSize3;
	private String productDescription3;
	private String productPrice3;
	private String productSize4;
	private String productDescription4;
	private String productPrice4;
	private String productSize5;
	private String productDescription5;
	private String productPrice5;
	private String storeName;
	private String brandName;
	private String storeUrl;
	private String skuName;
	private byte[] productUploadedImage1;
	private byte[] productUploadedImage2;
	private byte[] productUploadedImage3;
	private byte[] productUploadedImage4;
	private String furnitureSpecsStatus;
	private String status;
	private String adminStockCheckStatus;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

	/** default constructor */
	public AdminRegistryConceptBoardsFurnitureSpecsSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "admin_registry_concept_boards_furniture_specs_saving_id", unique = true, nullable = false)
	public long getAdminRegistryConceptBoardsFurnitureSpecsSavingId() {
		return adminRegistryConceptBoardsFurnitureSpecsSavingId;
	}

	public void setAdminRegistryConceptBoardsFurnitureSpecsSavingId(long adminRegistryConceptBoardsFurnitureSpecsSavingId) {
		this.adminRegistryConceptBoardsFurnitureSpecsSavingId = adminRegistryConceptBoardsFurnitureSpecsSavingId;
	}

	@Column(name = "admin_registry_concept_boards_saving_id")
	public long getAdminRegistryConceptBoardsSavingId() {
		return adminRegistryConceptBoardsSavingId;
	}

	public void setAdminRegistryConceptBoardsSavingId(long adminRegistryConceptBoardsSavingId) {
		this.adminRegistryConceptBoardsSavingId = adminRegistryConceptBoardsSavingId;
	}

	@Column(name = "admin_designer_common_reference_id")
	public long getAdminDesignerCommonReferenceId() {
		return adminDesignerCommonReferenceId;
	}

	public void setAdminDesignerCommonReferenceId(long adminDesignerCommonReferenceId) {
		this.adminDesignerCommonReferenceId = adminDesignerCommonReferenceId;
	}

	@Column(name = "admin_designer_common_reference_name", length = 100)
	public String getAdminDesignerCommonReferenceName() {
		return adminDesignerCommonReferenceName;
	}

	public void setAdminDesignerCommonReferenceName(String adminDesignerCommonReferenceName) {
		this.adminDesignerCommonReferenceName = adminDesignerCommonReferenceName;
	}

	@Column(name = "admin_approval_status", length = 30)
	public String getAdminApprovalStatus() {
		return adminApprovalStatus;
	}

	public void setAdminApprovalStatus(String adminApprovalStatus) {
		this.adminApprovalStatus = adminApprovalStatus;
	}
	
	@Column(name = "product_name", length = 100)
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "product_size1", length = 100)
	public String getProductSize1() {
		return productSize1;
	}

	public void setProductSize1(String productSize1) {
		this.productSize1 = productSize1;
	}

	@Column(name = "product_size2", length = 100)
	public String getProductSize2() {
		return productSize2;
	}

	public void setProductSize2(String productSize2) {
		this.productSize2 = productSize2;
	}

	@Column(name = "product_size3", length = 100)
	public String getProductSize3() {
		return productSize3;
	}

	public void setProductSize3(String productSize3) {
		this.productSize3 = productSize3;
	}

	@Column(name = "product_size4", length = 100)
	public String getProductSize4() {
		return productSize4;
	}

	public void setProductSize4(String productSize4) {
		this.productSize4 = productSize4;
	}

	@Column(name = "product_size5", length = 100)
	public String getProductSize5() {
		return productSize5;
	}

	public void setProductSize5(String productSize5) {
		this.productSize5 = productSize5;
	}

	@Column(name = "product_description1")
	public String getProductDescription1() {
		return productDescription1;
	}

	public void setProductDescription1(String productDescription1) {
		this.productDescription1 = productDescription1;
	}

	@Column(name = "product_price1", length = 15)
	public String getProductPrice1() {
		return productPrice1;
	}

	public void setProductPrice1(String productPrice1) {
		this.productPrice1 = productPrice1;
	}

	@Column(name = "product_description2")
	public String getProductDescription2() {
		return productDescription2;
	}

	public void setProductDescription2(String productDescription2) {
		this.productDescription2 = productDescription2;
	}

	@Column(name = "product_price2", length = 15)
	public String getProductPrice2() {
		return productPrice2;
	}

	public void setProductPrice2(String productPrice2) {
		this.productPrice2 = productPrice2;
	}

	@Column(name = "product_description3")
	public String getProductDescription3() {
		return productDescription3;
	}

	public void setProductDescription3(String productDescription3) {
		this.productDescription3 = productDescription3;
	}

	@Column(name = "product_price3", length = 15)
	public String getProductPrice3() {
		return productPrice3;
	}

	public void setProductPrice3(String productPrice3) {
		this.productPrice3 = productPrice3;
	}

	@Column(name = "product_description4")
	public String getProductDescription4() {
		return productDescription4;
	}

	public void setProductDescription4(String productDescription4) {
		this.productDescription4 = productDescription4;
	}

	@Column(name = "product_price4", length = 15)
	public String getProductPrice4() {
		return productPrice4;
	}

	public void setProductPrice4(String productPrice4) {
		this.productPrice4 = productPrice4;
	}

	@Column(name = "product_description5")
	public String getProductDescription5() {
		return productDescription5;
	}

	public void setProductDescription5(String productDescription5) {
		this.productDescription5 = productDescription5;
	}

	@Column(name = "product_price5", length = 15)
	public String getProductPrice5() {
		return productPrice5;
	}

	public void setProductPrice5(String productPrice5) {
		this.productPrice5 = productPrice5;
	}

	@Column(name = "brand_name", length = 100)
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

	@Column(name = "sku_name", length = 160)
	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	@Column(name="product_uploaded_image1", columnDefinition="longblob")
	@Lob
	public byte[] getProductUploadedImage1() {
		return productUploadedImage1;
	}

	public void setProductUploadedImage1(byte[] productUploadedImage1) {
		this.productUploadedImage1 = productUploadedImage1;
	}

	@Column(name="product_uploaded_image2", columnDefinition="longblob")
	@Lob
	public byte[] getProductUploadedImage2() {
		return productUploadedImage2;
	}

	public void setProductUploadedImage2(byte[] productUploadedImage2) {
		this.productUploadedImage2 = productUploadedImage2;
	}

	@Column(name="product_uploaded_image3", columnDefinition="longblob")
	@Lob
	public byte[] getProductUploadedImage3() {
		return productUploadedImage3;
	}

	public void setProductUploadedImage3(byte[] productUploadedImage3) {
		this.productUploadedImage3 = productUploadedImage3;
	}

	@Column(name="product_uploaded_image4", columnDefinition="longblob")
	@Lob
	public byte[] getProductUploadedImage4() {
		return productUploadedImage4;
	}

	public void setProductUploadedImage4(byte[] productUploadedImage4) {
		this.productUploadedImage4 = productUploadedImage4;
	}

	@Column(name = "furniture_specs_status", length = 30)
	public String getFurnitureSpecsStatus() {
		return furnitureSpecsStatus;
	}

	public void setFurnitureSpecsStatus(String furnitureSpecsStatus) {
		this.furnitureSpecsStatus = furnitureSpecsStatus;
	}

	@Column(name = "status", length = 10)
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "admin_stock_check_status", length = 30)
	public String getAdminStockCheckStatus() {
		return adminStockCheckStatus;
	}

	public void setAdminStockCheckStatus(String adminStockCheckStatus) {
		this.adminStockCheckStatus = adminStockCheckStatus;
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
