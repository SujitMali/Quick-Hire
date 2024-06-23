package com.byteBusters.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "user_order")
public class Order 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String bookingDate;
    private String bookingTime;
    private String userName; // Adding user name
    private String userContact; // Adding user contact
    private String userArea; // Adding user area
    private String serviceProviderName; // Adding service provider name
    private String serviceProviderContact; // Adding service provider contact
    private String orderStatus;
	    
    @Override
	public String toString() {
		return "Order [orderId=" + orderId + ", bookingDate=" + bookingDate + ", bookingTime=" + bookingTime
				+ ", userName=" + userName + ", userContact=" + userContact + ", userArea=" + userArea
				+ ", serviceProviderName=" + serviceProviderName + ", serviceProviderContact=" + serviceProviderContact
				+ ", orderStatus=" + orderStatus + "]";
	}
	public Order(int orderId, String bookingDate, String bookingTime, String userName, String userContact,
			String userArea, String serviceProviderName, String serviceProviderContact, String orderStatus) {
		super();
		this.orderId = orderId;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.userName = userName;
		this.userContact = userContact;
		this.userArea = userArea;
		this.serviceProviderName = serviceProviderName;
		this.serviceProviderContact = serviceProviderContact;
		this.orderStatus = orderStatus;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserArea() {
		return userArea;
	}
	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}
	public String getServiceProviderName() {
		return serviceProviderName;
	}
	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}
	public String getServiceProviderContact() {
		return serviceProviderContact;
	}
	public void setServiceProviderContact(String serviceProviderContact) {
		this.serviceProviderContact = serviceProviderContact;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
    
}
