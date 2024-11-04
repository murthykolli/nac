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
@Table(name = "client_uploaded_inspire_images_saving")
public class ClientUploadedInspireImagesSaving implements java.io.Serializable {
	
	// Fields

		private long clientUploadedInspireImagesSavingId;
		private long userId;
		private long clientInfoSavingId;
		private byte[] uploadInspiredImagesBlogForDesigner;
		private String uploadInspiredImagesPathForDesigner;
		private String status;
		private Timestamp createdDate; 
		private Timestamp updatedDate;
		
		// Constructors

		/** default constructor */
		public ClientUploadedInspireImagesSaving() {
		}

		// Property accessors
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
			
		@Column(name = "client_uploaded_inspire_images_saving_id", unique = true, nullable = false)
		public long getClientUploadedInspireImagesSavingId() {
			return clientUploadedInspireImagesSavingId;
		}

		public void setClientUploadedInspireImagesSavingId(long clientUploadedInspireImagesSavingId) {
			this.clientUploadedInspireImagesSavingId = clientUploadedInspireImagesSavingId;
		}

		@Column(name = "user_id", nullable = false)
		public long getUserId() {
			return userId;
		}

		public void setUserId(long userId) {
			this.userId = userId;
		}

		@Column(name = "client_info_saving_id", nullable = false)
		public long getClientInfoSavingId() {
			return clientInfoSavingId;
		}

		public void setClientInfoSavingId(long clientInfoSavingId) {
			this.clientInfoSavingId = clientInfoSavingId;
		}

		@Column(name="upload_inspired_images_blog_for_designer", columnDefinition="longblob")
		@Lob
		public byte[] getUploadInspiredImagesBlogForDesigner() {
			return uploadInspiredImagesBlogForDesigner;
		}

		public void setUploadInspiredImagesBlogForDesigner(byte[] uploadInspiredImagesBlogForDesigner) {
			this.uploadInspiredImagesBlogForDesigner = uploadInspiredImagesBlogForDesigner;
		}

		@Column(name = "upload_inspired_images_path_for_designer")
		public String getUploadInspiredImagesPathForDesigner() {
			return uploadInspiredImagesPathForDesigner;
		}

		public void setUploadInspiredImagesPathForDesigner(String uploadInspiredImagesPathForDesigner) {
			this.uploadInspiredImagesPathForDesigner = uploadInspiredImagesPathForDesigner;
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