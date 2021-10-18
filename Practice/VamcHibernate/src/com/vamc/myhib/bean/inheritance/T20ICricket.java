package com.vamc.myhib.bean.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value="T20I")
public class T20ICricket extends Cricket
	{

		int numOfHours;

		@Column(name="NO_OF_HOURS")
		public int getNumOfHours()
			{
				return numOfHours;
			}

		public void setNumOfHours(int numOfHours)
			{
				this.numOfHours = numOfHours;
			}
		
	
	}
