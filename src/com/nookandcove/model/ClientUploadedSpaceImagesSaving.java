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
@Table(name = "client_uploaded_space_images_saving")
public class ClientUploadedSpaceImagesSaving implements java.io.Serializable {

	// Fields

		private long clientUploadedSpaceImagesSavingId;
		private long userId;
		private long clientInfoSavingId;
		private byte[] uploadSpaceImagesBlogForDesigner;
		private String uploadSpaceImagesPathForDesigner;
		private String status;
		private Timestamp createdDate; 
		private Timestamp updatedDate;
		
		// Constructors

		/** default constructor */
		public ClientUploadedSpaceImagesSaving() {
		}

		// Property accessors
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		@Column(name = "client_uploaded_space_images_saving_id", unique = true, nullable = false)
		public long getClientUploadedSpaceImagesSavingId() {
			return clientUploadedSpaceImagesSavingId;
		}

		public void setClientUploadedSpaceImagesSavingId(long clientUploadedSpaceImagesSavingId) {
			this.clientUploadedSpaceImagesSavingId = clientUploadedSpaceImagesSavingId;
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

		@Column(name="upload_space_images_blog_for_designer", columnDefinition="longblob")
		@Lob
		public byte[] getUploadSpaceImagesBlogForDesigner() {
			return uploadSpaceImagesBlogForDesigner;
		}

		public void setUploadSpaceImagesBlogForDesigner(byte[] uploadSpaceImagesBlogForDesigner) {
			this.uploadSpaceImagesBlogForDesigner = uploadSpaceImagesBlogForDesigner;
		}

		@Column(name = "upload_space_images_path_for_designer")
		public String getUploadSpaceImagesPathForDesigner() {
			return uploadSpaceImagesPathForDesigner;
		}

		public void setUploadSpaceImagesPathForDesigner(String uploadSpaceImagesPathForDesigner) {
			this.uploadSpaceImagesPathForDesigner = uploadSpaceImagesPathForDesigner;
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