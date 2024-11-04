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
@Table(name = "admin_registry_concept_boards_saving")
public class AdminRegistryConceptBoardsSaving implements java.io.Serializable {
	
	// Fields
	
	private long adminRegistryConceptBoardsSavingId;
	private long adminDesignerCommonReferenceId;
	private String adminDesignerCommonReferenceName;
	private String adminApprovalStatus;
	private String room;
	private String style;
	private long designerInfoSavingId;
	private String designerName;
	private String price;
	private String mostPopularCB;
	private byte[] conceptBoardsImage;	
	private String conceptStatus;
	private String furnitureSpecsStatus;
	private Integer furnitureSpecsCount;
	private String status;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

	/** default constructor */
	public AdminRegistryConceptBoardsSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "admin_registry_concept_boards_saving_id", unique = true, nullable = false)
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

	@Column(name = "room", length = 100)
	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	@Column(name = "style", length = 100)
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Column(name = "designer_info_saving_id")
	public long getDesignerInfoSavingId() {
		return designerInfoSavingId;
	}

	public void setDesignerInfoSavingId(long designerInfoSavingId) {
		this.designerInfoSavingId = designerInfoSavingId;
	}
	
	@Column(name="concept_boards_image", columnDefinition="longblob")
	@Lob
	public byte[] getConceptBoardsImage() {
		return conceptBoardsImage;
	}

	public void setConceptBoardsImage(byte[] conceptBoardsImage) {
		this.conceptBoardsImage = conceptBoardsImage;
	}

	@Column(name = "designer_name", length = 100)
	public String getDesignerName() {
		return designerName;
	}

	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}
	
	@Column(name = "price", length = 30)
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Column(name = "most_popular_cb", length = 50)
	public String getMostPopularCB() {
		return mostPopularCB;
	}

	public void setMostPopularCB(String mostPopularCB) {
		this.mostPopularCB = mostPopularCB;
	}

	@Column(name = "concept_status", length = 30)
	public String getConceptStatus() {
		return conceptStatus;
	}

	public void setConceptStatus(String conceptStatus) {
		this.conceptStatus = conceptStatus;
	}

	@Column(name = "furniture_specs_status", length = 30)
	public String getFurnitureSpecsStatus() {
		return furnitureSpecsStatus;
	}

	public void setFurnitureSpecsStatus(String furnitureSpecsStatus) {
		this.furnitureSpecsStatus = furnitureSpecsStatus;
	}
	
	@Column(name = "furniture_specs_count", length = 30)
	public Integer getFurnitureSpecsCount() {
		return furnitureSpecsCount;
	}

	public void setFurnitureSpecsCount(Integer furnitureSpecsCount) {
		this.furnitureSpecsCount = furnitureSpecsCount;
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
