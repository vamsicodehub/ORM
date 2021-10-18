package com.vamc.aurionprohib.bean;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

public class CountryBO implements Serializable
	{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private Integer countryId;
		private String CountryName;
		
		Set<CurrencyBO> currencies = new LinkedHashSet<CurrencyBO>();

		public Integer getCountryId()
			{
				return countryId;
			}

		public void setCountryId(Integer countryId)
			{
				this.countryId = countryId;
			}

		public String getCountryName()
			{
				return CountryName;
			}

		public void setCountryName(String countryName)
			{
				CountryName = countryName;
			}

		public Set<CurrencyBO> getCurrencies()
			{
				return currencies;
			}

		public void setCurrencies(Set<CurrencyBO> currencies)
			{
				this.currencies = currencies;
			}
	}
