package com.vamc.myhib.bean.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value="ODI")//NOT REQ IF THE STARTEGY IS OTHER THAN SINGLE TABLE
public class ODICricket extends Cricket
	{

		int numOfSessions;;

		@Column(name="NO_OF_SESSIONS")
		public int getNumOfSessions()
			{
				return numOfSessions;
			}

		public void setNumOfSessions(int numOfSessions)
			{
				this.numOfSessions = numOfSessions;
			}
		
	

	}
