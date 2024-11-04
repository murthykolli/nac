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
@Table(name = "admin_purchases_info_saving")
public class AdminPurchasesInfoSaving implements java.io.Serializable {
	
	private long adminPurchasesInfoSavingId;
	private long userId;
	private long shoppingCartPaymentInfoSavingId;
	private String clientName;
	private String orderPlaced;
	private String delivery;
	private String paymentStatus;
	private String orderStatus;
	private String status;
	private Timestamp createdDate; 
	private Timestamp updatedDate;
	
	// Constructors

		/** default constructor */
		public AdminPurchasesInfoSaving() {
		}

		// Property accessors
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
				
		@Column(name = "admin_purchases_info_saving_id", unique = true, nullable = false)
		public long getAdminPurchasesInfoSavingId() {
			return adminPurchasesInfoSavingId;
		}

		public void setAdminPurchasesInfoSavingId(long adminPurchasesInfoSavingId) {
			this.adminPurchasesInfoSavingId = adminPurchasesInfoSavingId;
		}
		
		@Column(name = "user_id", nullable = false)
		public long getUserId() {
			return userId;
		}

		public void setUserId(long userId) {
			this.userId = userId;
		}

		@Column(name = "shopping_cart_payment_info_saving_id", nullable = false)
		public long getShoppingCartPaymentInfoSavingId() {
			return shoppingCartPaymentInfoSavingId;
		}

		public void setShoppingCartPaymentInfoSavingId(long shoppingCartPaymentInfoSavingId) {
			this.shoppingCartPaymentInfoSavingId = shoppingCartPaymentInfoSavingId;
		}

		@Column(name = "client_name", length = 60)
		public String getClientName() {
			return clientName;
		}

		public void setClientName(String clientName) {
			this.clientName = clientName;
		}

		@Column(name = "order_placed", length = 60)
		public String getOrderPlaced() {
			return orderPlaced;
		}

		public void setOrderPlaced(String orderPlaced) {
			this.orderPlaced = orderPlaced;
		}

		@Column(name = "delivery", length = 60)
		public String getDelivery() {
			return delivery;
		}

		public void setDelivery(String delivery) {
			this.delivery = delivery;
		}

		@Column(name = "payment_status", length = 60)
		public String getPaymentStatus() {
			return paymentStatus;
		}

		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}

		@Column(name = "order_status", length = 60)
		public String getOrderStatus() {
			return orderStatus;
		}

		public void setOrderStatus(String orderStatus) {
			this.orderStatus = orderStatus;
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
