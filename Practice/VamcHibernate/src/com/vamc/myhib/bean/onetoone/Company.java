package com.vamc.myhib.bean.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMPANY")
public class Company 
{
	private int id;
	private String name;
	private String location;
	private Employee employee;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COMPANY_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="COMPANY_NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="LOCATION")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@OneToOne(cascade=CascadeType.ALL,mappedBy="company")
	//@OneToOne(cascade=CascadeType.ALL)
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
