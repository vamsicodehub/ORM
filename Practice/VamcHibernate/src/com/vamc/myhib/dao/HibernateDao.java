package com.vamc.myhib.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.vamc.aurionprohib.bean.CountryBO;
import com.vamc.aurionprohib.bean.CurrencyBO;
import com.vamc.aurionprohib.bean.SystemBankBO;
import com.vamc.myhib.bean.Address;
import com.vamc.myhib.bean.UserDetails;
import com.vamc.myhib.bean.inheritance.CricketFormat;
import com.vamc.myhib.bean.inheritance.ODICricket;
import com.vamc.myhib.bean.inheritance.T20ICricket;
import com.vamc.myhib.bean.inheritance.TestCricket;
import com.vamc.myhib.bean.manytomany.Person;
import com.vamc.myhib.bean.manytomany.Vehicle;
import com.vamc.myhib.bean.onetomany.College;
import com.vamc.myhib.bean.onetomany.Student;
import com.vamc.myhib.bean.onetoone.Company;
import com.vamc.myhib.bean.onetoone.Employee;
import com.vamc.myhib.util.HibernateTransaction;

public class HibernateDao
	{

		public static void main(String[] args)
			{
				// basicEx();
				// onetooneRelationMappings();
				// onetomanyRelationMappings();
				//manytomanyRelationMappings();
				//inheritanceRelation();
				
				//aurionproEx();
				//aurionproEx1();
				//aurionproEx2();
				aurionproEx3();
			}

		private static void aurionproEx3()
			{
					new HibernateTransaction<Void>()
						{

							@Override
							public Void execute(Session session)
								{
									/*CurrencyBO bo = (CurrencyBO) session.get(CurrencyBO.class, 12);
									for(CountryBO countryBO : bo.getCountries())
										{
											System.out.println(countryBO.getCountryName()+"\n");
										}
									
									CountryBO cbo = (CountryBO) session.get(CountryBO.class, 15);
									bo.getCountries().remove(cbo);
									session.saveOrUpdate(bo);*/
									
									CurrencyBO currencyBO = new CurrencyBO();
									currencyBO.setCurrencyCode("INR");

									CountryBO countryBO = new CountryBO();
									countryBO.setCountryName("INDIA");
									
									CountryBO countryBO1 = new CountryBO();
									countryBO1.setCountryName("NEPAL");
									
									currencyBO.getCountries().add(countryBO);
									currencyBO.getCountries().add(countryBO1);
									
									session.saveOrUpdate(currencyBO);
									return null;
								}
							
						}.getResult();
			}
		
		private static void aurionproEx2()
			{
					new HibernateTransaction<Void>()
						{

							@Override
							public Void execute(Session session)
								{
									//List<CountryBO> list = session.createCriteria(CountryBO.class).add(Restrictions.idEq(1)).list();	
									Query query = session.createQuery("from CountryBO where countryId = 1");
									List<CountryBO> list = query.list();
									for(CountryBO countryBO : list)
										{
											for(CurrencyBO currencyBO : countryBO.getCurrencies())
												{
													System.out.println(currencyBO.getCurrencyCode()+"\n");
												}
										}
									return null;
								}
							
						}.getResult();
			}


		private static void aurionproEx1()
			{
				new HibernateTransaction<Void>()
					{

						@Override
						public Void execute(Session session)
							{
								SystemBankBO bankBo = new SystemBankBO();
								bankBo.setBankCode(7+"");
								bankBo.setBankName("ICICI");
								bankBo.setCountryId(4);
								
								session.saveOrUpdate(bankBo);
								//System.out.println(id);
								
								return null;
							}
					}.getResult();
			}

		private static void aurionproEx()
			{
				new HibernateTransaction<Void>()
					{

						@Override
						public Void execute(Session session)
							{
								SystemBankBO bankBo = (SystemBankBO) session.get(SystemBankBO.class, 1);
								
								System.out.println(bankBo.getCountryBO().getCountryName());
								
								return null;
							}
					}.getResult();
			}

		private static void inheritanceRelation()
			{
				new HibernateTransaction<Void>()
					{

						@Override
						public Void execute(Session session)
							{
								TestCricket test = new TestCricket();
								test.setFormat(CricketFormat.TEST);
								test.setNumOfDays(5);
								
								ODICricket odi = new ODICricket();
								odi.setFormat(CricketFormat.ODI);
								odi.setNumOfSessions(2);
								
								T20ICricket t20i = new T20ICricket();
								t20i.setFormat(CricketFormat.T20I);
								t20i.setNumOfHours(4);
								
								session.save(test);
								session.save(odi);
								session.save(t20i);
								return null;
							}
					}.getResult();
			}

		private static void manytomanyRelationMappings()
			{
				new HibernateTransaction<Void>()
					{

						@Override
						public Void execute(Session session)
							{
								Person person = new Person();
								person.setLocation("Airoli");
								person.setName("Vamsi");

								Person person1 = new Person();
								person1.setLocation("Kalyan");
								person1.setName("Supriya");

								Vehicle vehicle = new Vehicle();
								vehicle.setVehicleName("PORSCHE");
								vehicle.setVehicleNumber("LNT2109551");

								Vehicle vehicle1 = new Vehicle();
								vehicle1.setVehicleName("AUDI");
								vehicle1.setVehicleNumber("LNT10612727");

								person.getVehicleCol().add(vehicle);
								person.getVehicleCol().add(vehicle1);
								
								person1.getVehicleCol().add(vehicle);
								person1.getVehicleCol().add(vehicle1);
								
								vehicle.getPersonCol().add(person);
								vehicle.getPersonCol().add(person1);

								session.save(vehicle);
								session.save(person);

								return null;
							}
					}.getResult();
			}

		private static void onetomanyRelationMappings()
			{
				new HibernateTransaction<Void>()
					{

						@Override
						public Void execute(Session session)
							{
								College college = new College();
								college.setLocation("Mumbai");
								college.setName("LTI");

								College college1 = new College();
								college1.setLocation("Mumbai");
								college1.setName("LTIN");

								Student student = new Student();
								student.setCity("Airoli");
								student.setName("Vamsi");

								Student student1 = new Student();
								student1.setCity("Kalyan");
								student1.setName("Supriya");
								// Have to handle the below piece of code properly to establish
								// onetomany/manytoone relationship
								// we have to set both entities to each other to establish the
								// relation properly
								college.getStudentSet().add(student);
								college.getStudentSet().add(student1);
								college1.getStudentSet().add(student);

								student.setCollege(college);
								student1.setCollege(college1);

								// session.save(student);
								// session.save(student1);

								session.save(college);
								// session.save(college1);

								return null;
							}
					}.getResult();
			}

		private static void onetooneRelationMappings()
			{
				new HibernateTransaction<Void>()
					{

						@Override
						public Void execute(Session session)
							{
								Company company = new Company();
								// company.setEmployee(employee);
								company.setLocation("Airoli");
								company.setName("L&T Infotech");

								Employee employee = new Employee();
								employee.setDesignation("Z-1-1");
								employee.setEmpName("Vamsi");
								employee.setCompany(company);

								session.save(employee);
								return null;
							}

					}.getResult();

			}

		private static void basicEx()
			{
				new HibernateTransaction<Void>()
					{
						@Override
						public Void execute(Session session)
							{
								Address add = new Address();
								add.setCity("Vij");
								add.setStreet("Meerjapuram");
								add.setPincode(521111);

								Address add1 = new Address();
								add1.setCity("Kalyan");
								add1.setStreet("East");
								add1.setPincode(421301);

								Address add2 = new Address();
								add2.setCity("Navi Mumbai");
								add2.setStreet("Airoli");
								add2.setPincode(400708);

								Set<Address> addList = new HashSet<Address>();
								addList.add(add2);
								addList.add(add);
								UserDetails user = new UserDetails();
								user.setUserName("Vamu");
								user.setJoiningDate(new Date());
								user.setDescription("From A.P Speaks Telugu");
								user.setHomeAddress(add);
								user.setOfficeAddress(add2);
								user.setAddressList(addList);
								session.save(user);

								Set<Address> addList1 = new HashSet<Address>();
								addList1.add(add2);
								addList1.add(add1);
								UserDetails user1 = new UserDetails();
								user1.setUserName("Suppu");
								user1.setJoiningDate(new Date());
								user1.setDescription("From Maharastra speaks Marathi");
								user1.setHomeAddress(add1);
								user1.setOfficeAddress(add2);
								user1.setAddressList(addList1);
								session.save(user1);

								return null;
							}
					}.getResult();
			}

	}
