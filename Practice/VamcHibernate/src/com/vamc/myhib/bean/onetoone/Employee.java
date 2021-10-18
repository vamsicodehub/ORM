package com.vamc.myhib.bean.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee
	{
		private int empId;
		private String empName;
		private String designation;
		private Company company;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "EMPLOYEE_ID")
		public int getEmpId()
			{
				return empId;
			}

		public void setEmpId(int empId)
			{
				this.empId = empId;
			}

		@Column(name = "EMPLOYEE_NAME")
		public String getEmpName()
			{
				return empName;
			}

		public void setEmpName(String empName)
			{
				this.empName = empName;
			}

		@Column(name = "DESIGNATION")
		public String getDesignation()
			{
				return designation;
			}

		public void setDesignation(String designation)
			{
				this.designation = designation;
			}

		@OneToOne(cascade = CascadeType.ALL)
		// @JoinTable(name="COMPANY_EMPLOYEE_XREF",joinColumns={@JoinColumn(name="EMPLOYEE_ID")},inverseJoinColumns={@JoinColumn(name="COMPANY_ID")})
		@JoinColumn(name = "EMP_COMP_ID", nullable = false)
		public Company getCompany()
			{
				return company;
			}

		public void setCompany(Company company)
			{
				this.company = company;
			}

	}
