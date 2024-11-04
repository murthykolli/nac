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
@Table(name = "registry_room_funds_info_saving")
public class RegistryRoomFundsInfoSaving implements java.io.Serializable {
	
	private long registryRoomFundsInfoSavingId;
	private long registrantUserId;
	private String livingRoom;
	private String diningRoom;
	private String bedroom;
	private String homeOffice;
	private String entryway;
	private String nursery;
	private String kidsBedroom;
	private String playArea;
	private String outdoorSpace;
	private String otherDreamSpace;	
	private String status;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
// Constructors

		/** default constructor */
	public RegistryRoomFundsInfoSaving() {
	}

// Property accessors
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
				
		@Column(name = "registry_room_funds_info_saving_id", unique = true, nullable = false)
		
		public long getRegistryRoomFundsInfoSavingId() {
			return registryRoomFundsInfoSavingId;
		}

		public void setRegistryRoomFundsInfoSavingId(long registryRoomFundsInfoSavingId) {
			this.registryRoomFundsInfoSavingId = registryRoomFundsInfoSavingId;
		}
		
		@Column(name = "registrant_user_id", nullable = false)
		
		public long getRegistrantUserId() {
			return registrantUserId;
		}

		public void setRegistrantUserId(long registrantUserId) {
			this.registrantUserId = registrantUserId;
		}		

		@Column(name = "living_room", length = 260)
		public String getLivingRoom() {
			return livingRoom;
		}

		public void setLivingRoom(String livingRoom) {
			this.livingRoom = livingRoom;
		}

		@Column(name = "dining_room", length = 260)
		public String getDiningRoom() {
			return diningRoom;
		}

		public void setDiningRoom(String diningRoom) {
			this.diningRoom = diningRoom;
		}

		@Column(name = "bedroom", length = 260)
		public String getBedroom() {
			return bedroom;
		}

		public void setBedroom(String bedroom) {
			this.bedroom = bedroom;
		}

		@Column(name = "home_office", length = 260)
		public String getHomeOffice() {
			return homeOffice;
		}

		public void setHomeOffice(String homeOffice) {
			this.homeOffice = homeOffice;
		}

		@Column(name = "entryway", length = 260)
		public String getEntryway() {
			return entryway;
		}

		public void setEntryway(String entryway) {
			this.entryway = entryway;
		}

		@Column(name = "nursery", length = 260)
		public String getNursery() {
			return nursery;
		}

		public void setNursery(String nursery) {
			this.nursery = nursery;
		}

		@Column(name = "kids_bedroom", length = 260)
		public String getKidsBedroom() {
			return kidsBedroom;
		}

		public void setKidsBedroom(String kidsBedroom) {
			this.kidsBedroom = kidsBedroom;
		}

		@Column(name = "play_area", length = 260)
		public String getPlayArea() {
			return playArea;
		}

		public void setPlayArea(String playArea) {
			this.playArea = playArea;
		}

		@Column(name = "outdoor_space", length = 260)
		public String getOutdoorSpace() {
			return outdoorSpace;
		}

		public void setOutdoorSpace(String outdoorSpace) {
			this.outdoorSpace = outdoorSpace;
		}

		@Column(name = "other_dream_space", length = 260)
		public String getOtherDreamSpace() {
			return otherDreamSpace;
		}

		public void setOtherDreamSpace(String otherDreamSpace) {
			this.otherDreamSpace = otherDreamSpace;
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
