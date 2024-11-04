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
@Table(name = "client_info_saving")
public class ClientInfoSaving implements java.io.Serializable {

	// Fields

	private long clientInfoSavingId; 
	private long userId;
	private long paymentInfoSavingId;
	private String typeOfSpace; 
	private String typeOfStyle;	
	private String designPackage;
	private String packagePrice;
	private String budget; 
	private String spaceDimension;	
	private String typeOfColor;
	private String likeColor;
	private String dislikeColor;
	private String typeOfItemsList; 
	private String otherItems;
	private String alreadyHaveItems;
	private String typeOfArtAppeals;
	private String moreAboutSpace;
	private String shareYourInspire;		
	private long designerInfoSavingId;
	private String paymentStatus;
	private String status;
	private Timestamp designerAssignedDate;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	private String clientAskedDesignerName;
	private String adminAssiNewDesigner;
	private String roomStatus;
	private String desigerNotes;
	private String clHearAboutUs;
		  

	// Constructors

	/** default constructor */
	public ClientInfoSaving() {
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "client_info_saving_id", unique = true, nullable = false)
	public long getClientInfoSavingId() {
		return clientInfoSavingId;
	}

	public void setClientInfoSavingId(long clientInfoSavingId) {
		this.clientInfoSavingId = clientInfoSavingId;
	}

	@Column(name = "user_id", nullable = false)
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name = "type_of_space", length = 60)
	public String getTypeOfSpace() {
		return typeOfSpace;
	}

	public void setTypeOfSpace(String typeOfSpace) {
		this.typeOfSpace = typeOfSpace;
	}

	@Column(name = "type_of_style", length = 60)
	public String getTypeOfStyle() {
		return typeOfStyle;
	}

	public void setTypeOfStyle(String typeOfStyle) {
		this.typeOfStyle = typeOfStyle;
	}

	@Column(name = "budget", length = 30)
	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	@Column(name = "design_package", length = 100)
	public String getDesignPackage() {
		return designPackage;
	}

	public void setDesignPackage(String designPackage) {
		this.designPackage = designPackage;
	}

	@Column(name = "space_dimension")
	public String getSpaceDimension() {
		return spaceDimension;
	}

	public void setSpaceDimension(String spaceDimension) {
		this.spaceDimension = spaceDimension;
	}

	@Column(name = "type_of_items_list")
	public String getTypeOfItemsList() {
		return typeOfItemsList;
	}

	public void setTypeOfItemsList(String typeOfItemsList) {
		this.typeOfItemsList = typeOfItemsList;
	}

	@Column(name = "other_items")
	public String getOtherItems() {
		return otherItems;
	}

	public void setOtherItems(String otherItems) {
		this.otherItems = otherItems;
	}

	@Column(name = "designer_info_saving_id")
	public long getDesignerInfoSavingId() {
		return designerInfoSavingId;
	}

	public void setDesignerInfoSavingId(long designerInfoSavingId) {
		this.designerInfoSavingId = designerInfoSavingId;
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

	@Column(name = "designer_assigned_date")
	public Timestamp getDesignerAssignedDate() {
		return designerAssignedDate;
	}
		
	public void setDesignerAssignedDate(Timestamp designerAssignedDate) {
		this.designerAssignedDate = designerAssignedDate;
	}

	@Column(name = "payment_info_saving_id", length = 20)
	public long getPaymentInfoSavingId() {
		return paymentInfoSavingId;
	}

	public void setPaymentInfoSavingId(long paymentInfoSavingId) {
		this.paymentInfoSavingId = paymentInfoSavingId;
	}

	@Column(name = "package_price", length = 12)
	public String getPackagePrice() {
		return packagePrice;
	}

	public void setPackagePrice(String packagePrice) {
		this.packagePrice = packagePrice;
	}

	@Column(name = "type_of_color", length = 100)
	public String getTypeOfColor() {
		return typeOfColor;
	}

	public void setTypeOfColor(String typeOfColor) {
		this.typeOfColor = typeOfColor;
	}

	@Column(name = "like_color", length = 260)
	public String getLikeColor() {
		return likeColor;
	}

	public void setLikeColor(String likeColor) {
		this.likeColor = likeColor;
	}

	@Column(name = "dislike_color", length = 260)
	public String getDislikeColor() {
		return dislikeColor;
	}

	public void setDislikeColor(String dislikeColor) {
		this.dislikeColor = dislikeColor;
	}

	@Column(name = "already_have_items")
	public String getAlreadyHaveItems() {
		return alreadyHaveItems;
	}

	public void setAlreadyHaveItems(String alreadyHaveItems) {
		this.alreadyHaveItems = alreadyHaveItems;
	}

	@Column(name = "more_about_space")
	public String getMoreAboutSpace() {
		return moreAboutSpace;
	}

	public void setMoreAboutSpace(String moreAboutSpace) {
		this.moreAboutSpace = moreAboutSpace;
	}

	@Column(name = "share_your_inspire")
	public String getShareYourInspire() {
		return shareYourInspire;
	}

	public void setShareYourInspire(String shareYourInspire) {
		this.shareYourInspire = shareYourInspire;
	}

	@Column(name = "type_of_art_appeals", length = 100)
	public String getTypeOfArtAppeals() {
		return typeOfArtAppeals;
	}

	public void setTypeOfArtAppeals(String typeOfArtAppeals) {
		this.typeOfArtAppeals = typeOfArtAppeals;
	}

	@Column(name = "payment_status", length = 60)
	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Column(name = "client_asked_designer_name", length = 100)
	public String getClientAskedDesignerName() {
		return clientAskedDesignerName;
	}

	public void setClientAskedDesignerName(String clientAskedDesignerName) {
		this.clientAskedDesignerName = clientAskedDesignerName;
	}

	@Column(name = "admin_assi_new_designer", length = 60)
	public String getAdminAssiNewDesigner() {
		return adminAssiNewDesigner;
	}

	public void setAdminAssiNewDesigner(String adminAssiNewDesigner) {
		this.adminAssiNewDesigner = adminAssiNewDesigner;
	}

	@Column(name = "room_status", length = 60)
	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	@Column(name = "desiger_notes")
	public String getDesigerNotes() {
		return desigerNotes;
	}

	public void setDesigerNotes(String desigerNotes) {
		this.desigerNotes = desigerNotes;
	}

	@Column(name = "cl_hear_about_us", length = 260)
	public String getClHearAboutUs() {
		return clHearAboutUs;
	}

	public void setClHearAboutUs(String clHearAboutUs) {
		this.clHearAboutUs = clHearAboutUs;
	}
	
		

}