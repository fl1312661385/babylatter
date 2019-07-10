package com.bysj.work.babylatter.model;

import java.security.KeyStore.PrivateKeyEntry;

public class Bill {
	/**
	*@author fengliang
	*2019年4月10日
	*com.bysj.work.babylatter.model
	*/
	private Integer billId;
	private Integer userId;
	private Integer orderId;
	private String userName;
	private String productName;
	private Integer quantity;
	private String orderPrice;
	private String creatTime;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", userId=" + userId + ", orderId=" + orderId + ", creatTime=" + creatTime
				+ "]";
	}
	
}
