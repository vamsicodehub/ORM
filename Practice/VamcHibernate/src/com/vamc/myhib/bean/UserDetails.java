package com.vamc.myhib.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	private int userId;
	private String userName;
	private Date joiningDate;
	private String description;
	private Address homeAddress;
	private Address officeAddress;
	private Set<Address> addressList = new HashSet<Address>();
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="JOINING_DATE")
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	@AttributeOverrides(value={
			@AttributeOverride(name="street",column=@Column(name="OFFICE_STREET_NAME")),
			@AttributeOverride(name="city",column=@Column(name="OFFICE_CITY_NAME")),
			@AttributeOverride(name="pincode",column=@Column(name="OFFICE_PINCODE_NAME")),
			})
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	@ElementCollection
	@JoinTable(name="USER_ADDRESS",
	joinColumns=@JoinColumn(name="USER_ID")//to give user defined join column name else hib will create like userdetails_user_id
	)//Used to give user defined table name else hib will create table name as userdetails_addresslist
	public Set<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(Set<Address> addressList) {
		this.addressList = addressList;
	}

}
