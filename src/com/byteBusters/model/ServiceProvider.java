package com.byteBusters.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity 
@Component
public class ServiceProvider 
{
	@Id
	private String contact;
	private String name;
	private int Age;
	private String Address;
	private String pincode;
	private String area;
	private String city;
	private String email;
	private String password;
	private String cateogry;
	private String serviceType;
	private String openTime;
	private String closeTime;
	private String serviecProviderStatus = "Pending";
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCateogry() {
		return cateogry;
	}
	public void setCateogry(String cateogry) {
		this.cateogry = cateogry;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public String getServiecProviderStatus() {
		return serviecProviderStatus;
	}
	public void setServiecProviderStatus(String serviecProviderStatus) {
		this.serviecProviderStatus = serviecProviderStatus;
	}
	@Override
	public String toString() {
		return "ServiceProvider [contact=" + contact + ", name=" + name + ", Age=" + Age + ", Address=" + Address
				+ ", pincode=" + pincode + ", area=" + area + ", city=" + city + ", email=" + email + ", password="
				+ password + ", cateogry=" + cateogry + ", serviceType=" + serviceType + ", openTime=" + openTime
				+ ", closeTime=" + closeTime + ", serviecProviderStatus=" + serviecProviderStatus + "]";
	}
	public ServiceProvider(String contact, String name, int age, String address, String pincode, String area,
			String city, String email, String password, String cateogry, String serviceType, String openTime,
			String closeTime, String serviecProviderStatus) {
		super();
		this.contact = contact;
		this.name = name;
		Age = age;
		Address = address;
		this.pincode = pincode;
		this.area = area;
		this.city = city;
		this.email = email;
		this.password = password;
		this.cateogry = cateogry;
		this.serviceType = serviceType;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.serviecProviderStatus = serviecProviderStatus;
	}
	public ServiceProvider() {
		super();
	}
	
	
	
	
	
	
	
	

}
