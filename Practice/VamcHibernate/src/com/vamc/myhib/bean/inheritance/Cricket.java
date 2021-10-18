package com.vamc.myhib.bean.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="CRICKET")
@Inheritance(strategy=InheritanceType.JOINED)//GIVING DIFF INHERITANCE STRATEGY, IN THIS CASE BELOW ANNOT IS NOT REQ, HERE ONLY CHILD RELATED COLS ARE CREATED IN THE OTHER TABLES ALONG WITH THE ID
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)//HERE SEPERATE TABLE FOR EACH CHILD CLASS WILL BE CREATED AND EACH TABLE CONTAINS ALL THE COLS INCLUDING PARENT CLASS
//@DiscriminatorColumn(name="CRICKET_TYPE")//TO GIVE USER DEFINED NAME TO THE DISC COL
public class Cricket
	{
		private int Id;
		private CricketFormat format;
		
		@Id
		@GeneratedValue(strategy=GenerationType.TABLE)//HAVE TO GIVE TABLE GENERATION TYPE IN CASE OF TABLE PER CLASS STRATEGY
		@Column(name="ID")
		public int getId()
			{
				return Id;
			}
		public void setId(int id)
			{
				Id = id;
			}
		@Enumerated(EnumType.STRING)
		@Column(name="FORMAT")
		public CricketFormat getFormat()
			{
				return format;
			}
		public void setFormat(CricketFormat format)
			{
				this.format = format;
			}

	}
