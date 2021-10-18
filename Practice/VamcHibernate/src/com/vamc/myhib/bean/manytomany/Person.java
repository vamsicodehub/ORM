package com.vamc.myhib.bean.manytomany;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class Person
	{
		private int id;
		private String name;
		private String location;
		private Collection<Vehicle> vehicleCol = new HashSet<Vehicle>();
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="ID")
		public int getId()
			{
				return id;
			}
		public void setId(int id)
			{
				this.id = id;
			}
		@Column(name="NAME")
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
		@ManyToMany(cascade=CascadeType.ALL)
		@JoinTable(joinColumns={@JoinColumn(name="PERSON_ID")},inverseJoinColumns={@JoinColumn(name="VEHICLE_ID")})
		public Collection<Vehicle> getVehicleCol()
			{
				return vehicleCol;
			}
		public void setVehicleCol(Collection<Vehicle> vehicleCol)
			{
				this.vehicleCol = vehicleCol;
			}
	}
