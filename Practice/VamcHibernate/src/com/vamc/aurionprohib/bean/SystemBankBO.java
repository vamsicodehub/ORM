package com.vamc.aurionprohib.bean;

import java.io.Serializable;

public class SystemBankBO implements Serializable
	{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String bankCode;
	private String bankName;
	private int countryId;
	
	private CountryBO countryBO;
	
	public Integer getId()
		{
			return id;
		}
	public void setId(Integer id)
		{
			this.id = id;
		}
	public String getBankCode()
		{
			return bankCode;
		}
	public void setBankCode(String bankCode)
		{
			this.bankCode = bankCode;
		}
	public String getBankName()
		{
			return bankName;
		}
	public void setBankName(String bankName)
		{
			this.bankName = bankName;
		}
	public int getCountryId()
		{
			return countryId;
		}
	public void setCountryId(int countryId)
		{
			this.countryId = countryId;
		}
	public CountryBO getCountryBO()
		{
			return countryBO;
		}
	public void setCountryBO(CountryBO countryBO)
		{
			this.countryBO = countryBO;
		}
	
	

	}
