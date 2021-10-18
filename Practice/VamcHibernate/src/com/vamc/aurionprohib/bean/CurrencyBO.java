package com.vamc.aurionprohib.bean;

import java.util.LinkedHashSet;
import java.util.Set;

public class CurrencyBO
	{
		private Integer currencyId;
		private String currencyCode;
		
		Set<CountryBO> countries = new LinkedHashSet<CountryBO>();
		
		public Integer getCurrencyId()
			{
				return currencyId;
			}
		public void setCurrencyId(Integer currencyId)
			{
				this.currencyId = currencyId;
			}
		public String getCurrencyCode()
			{
				return currencyCode;
			}
		public void setCurrencyCode(String currencyCode)
			{
				this.currencyCode = currencyCode;
			}
		public Set<CountryBO> getCountries()
			{
				return countries;
			}
		public void setCountries(Set<CountryBO> countries)
			{
				this.countries = countries;
			}
		
		
}