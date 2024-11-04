package com.nookandcove.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "items_list_for_space_info")
public class ItemsListForSpaceInfo implements java.io.Serializable {

	// Fields

	private long itemsListForSpaceInfoId; 
	private String nameOfItem; 
	private String typeOfRefferance; 
	private String typeOfSpace;
	private String status;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

	/** default constructor */
	public ItemsListForSpaceInfo() {
	}

	// Property accessors
	@Id	
	@Column(name = "items_list_for_space_info_id", unique = true, nullable = false)	
	public long getItemsListForSpaceInfoId() {
		return itemsListForSpaceInfoId;
	}

	public void setItemsListForSpaceInfoId(long itemsListForSpaceInfoId) {
		this.itemsListForSpaceInfoId = itemsListForSpaceInfoId;
	}
	
	@Column(name = "name_of_item", length = 60)
	public String getNameOfItem() {
		return nameOfItem;
	}

	public void setNameOfItem(String nameOfItem) {
		this.nameOfItem = nameOfItem;
	}

	@Column(name = "type_of_refferance", length = 60)
	public String getTypeOfRefferance() {
		return typeOfRefferance;
	}

	public void setTypeOfRefferance(String typeOfRefferance) {
		this.typeOfRefferance = typeOfRefferance;
	}	
	
	@Column(name = "type_of_space", length = 60)
	public String getTypeOfSpace() {
		return typeOfSpace;
	}

	public void setTypeOfSpace(String typeOfSpace) {
		this.typeOfSpace = typeOfSpace;
	}

	@Column(name = "status", length = 60)
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