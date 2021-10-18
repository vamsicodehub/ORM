package com.vamc.myhib.bean.manytomany;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE")
public class Vehicle
	{
		private int id;
		private String vehicleName;
		private String vehicleNumber;
		private Collection<Person> personCol = new HashSet<Person>();
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="VEHICLE_ID")
		public int getId()
			{
				return id;
			}
		public void setId(int id)
			{
				this.id = id;
			}
		@Column(name="VEHICLE_NAME")
		public String getVehicleName()
			{
				return vehicleName;
			}
		public void setVehicleName(String vehicleName)
			{
				this.vehicleName = vehicleName;
			}
		@Column(name="VEHICLE_NUMBER")
		public String getVehicleNumber()
			{
				return vehicleNumber;
			}
		public void setVehicleNumber(String vehicleNumber)
			{
				this.vehicleNumber = vehicleNumber;
			}
		@ManyToMany(cascade=CascadeType.ALL,mappedBy="vehicleCol")
		public Collection<Person> getPersonCol()
			{
				return personCol;
			}
		public void setPersonCol(Collection<Person> personCol)
			{
				this.personCol = personCol;
			}

	}
