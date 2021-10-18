package com.vamc.myhib.bean.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student
	{
		private int id;
		private String name;
		private String city;
		
		private College college;
		
		@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
		@JoinColumn(name="COLLEGE_ID",nullable=true,referencedColumnName="COLLEGE_ID")
		public College getCollege()
			{
				return college;
			}
		public void setCollege(College college)
			{
				this.college = college;
			}
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="STUDENT_ID",nullable=false,length=10)
			public int getId()
			{
				return id;
			}
		public void setId(int id)
			{
				this.id = id;
			}
		@Column(name="STUDENT_NAME")
		public String getName()
			{
				return name;
			}
		public void setName(String name)
			{
				this.name = name;
			}
		@Column(name="STUDENT_LOC")
		public String getCity()
			{
				return city;
			}
		public void setCity(String city)
			{
				this.city = city;
			}
		

	}
