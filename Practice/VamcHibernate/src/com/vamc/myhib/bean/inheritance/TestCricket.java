package com.vamc.myhib.bean.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TEST_CRICKET")
//@DiscriminatorValue(value="TEST")
public class TestCricket extends Cricket
	{
		int numOfDays;
		

		@Column(name="NO_OF_DAYS")
		public int getNumOfDays()
			{
				return numOfDays;
			}

		public void setNumOfDays(int numOfDays)
			{
				this.numOfDays = numOfDays;
			}

	}
