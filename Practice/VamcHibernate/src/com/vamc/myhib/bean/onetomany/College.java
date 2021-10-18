package com.vamc.myhib.bean.onetomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COLLEGE")
public class College
	{
		private int collegeId;
		private String name;
		private String location;
		
		Set<Student> studentSet = new HashSet<Student>();
		
		@OneToMany(cascade=CascadeType.ALL,mappedBy="college")
		public Set<Student> getStudentSet()
			{
				return studentSet;
			}
		public void setStudentSet(Set<Student> studentSet)
			{
				this.studentSet = studentSet;
			}
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="COLLEGE_ID",nullable=false,length=10)
		public int getCollegeId()
			{
				return collegeId;
			}
		public void setCollegeId(int collegeId)
			{
				this.collegeId = collegeId;
			}
		@Column(name="COLLEGE_NAME")
		public String getName()
			{
				return name;
			}
		public void setName(String name)
			{
				this.name = name;
			}
		@Column(name="LOCATION")
		public String getLocation()
			{
				return location;
			}
		public void setLocation(String location)
			{
				this.location = location;
			}
	}
