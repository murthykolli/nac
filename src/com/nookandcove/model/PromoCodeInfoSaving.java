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
@Table(name = "promo_code_info_saving")
public class PromoCodeInfoSaving implements java.io.Serializable {
	
	private long promoCodeInfoSavingId;
	private String promoCode;
	private String discount;
	private String promoNote;
	private String status;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

		/** default constructor */
		public PromoCodeInfoSaving() {
		}

		// Property accessors
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
				
		@Column(name = "promo_code_info_saving_id", unique = true, nullable = false)
		public long getPromoCodeInfoSavingId() {
			return promoCodeInfoSavingId;
		}

		public void setPromoCodeInfoSavingId(long promoCodeInfoSavingId) {
			this.promoCodeInfoSavingId = promoCodeInfoSavingId;
		}
		
		@Column(name = "promo_code", length = 60)
		public String getPromoCode() {
			return promoCode;
		}

		public void setPromoCode(String promoCode) {
			this.promoCode = promoCode;
		}
		
		@Column(name = "discount", length = 15)
		public String getDiscount() {
			return discount;
		}

		public void setDiscount(String discount) {
			this.discount = discount;
		}
		
		@Column(name = "promo_note")
		public String getPromoNote() {
			return promoNote;
		}

		public void setPromoNote(String promoNote) {
			this.promoNote = promoNote;
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
