package com.altius.automation;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Employeeaddition {
	 WebDriver d;
	    Logger logger =Logger.getLogger(Employeeaddition.class);

	@BeforeTest()
   	public void browserlauching()
   	{
		PropertyConfigurator.configure("log4jproperties.txt");

	System.setProperty("webdriver.chrome.driver", "../SVCF/src/test/resources/chromedriver.exe");
	d = new ChromeDriver();
	
	d.get("http://182.72.104.66:8080/SVCF/Login.aspx#");
   	}
	
	@Test(priority =1)
	public void branchname()
	{
       try
       {
		Select branch =new Select(d.findElement(By.id("ddlBranch")));
		branch.selectByVisibleText("CentralOffice");
		logger.info("Central office option is selected successfully");
       }
       
       catch(Exception e )
		{
			logger.error("Central office option is not selected");
			
			
		}
	}
	@Test(priority =2)
	public void OnlyCorrectUNPW() {
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
		WebElement un=d.findElement(By.id("txtUser"));
		WebElement pw=d.findElement(By.id("txtPassword"));
		un.clear();
		pw.clear();


		try {
	    un.sendKeys("admin@svcf.com");
		logger.info("Valid UN is passed to the UN field");
		}
		catch (Exception e) {
			logger.error(e);
			logger.error("Valid data is not passed to the UN field");

		}
		
		try {	
			
			pw.sendKeys("C*0/Svcf");
			logger.info("Valid password data is passed to the PW field");
		} 
		catch (Exception e) {

			logger.error("Valid password is not passed to the PW field");

		}        WebElement click=d.findElement(By.name("btnlogin"));
         click.click();
         String URL ="http://182.72.104.66:8080/SVCF/Home.aspx";
         if(d.getCurrentUrl().equals(URL))
         {
			logger.info("User able to login with Correct UN  &PW");
         }
         else
         {
        	 logger.error("User is not able to login with correct UN and PW");
        	 
         }

	}
	  @Test(priority =3)
	  public void employeeaddition() throws InterruptedException
	  {
		  Thread.sleep(5000);
		  // Hover on module Internal
		Actions action = new Actions(d);

		try {

			WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[5]/a"));
			action.moveToElement(hover).build().perform();
			logger.info("Mouse is successfully hovered on module 'Internal'");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Mouse is not successfully hovered on module 'Internal'");
		}
		  //  Hover on employee
		Thread.sleep(2000);

		try {

			WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[5]/ul/li[5]/a"));
			action.moveToElement(hover).build().perform();
			logger.info("Mouse is successfully hovered on screen 'Employee'");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Mouse is not successfully hovered on screen 'Employee'");
		}
		Thread.sleep(2000);
		// Employee addition
		try {

			WebElement hover = d.findElement(By.linkText("Employee Addition"));
			hover.click();
			logger.info("Employee addition screen is successfully clicked");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Employee addition screen is not successfully clicked");
		}
	  }
	  
	  @Test(priority =4)
	  public void fieldvalidation() throws InterruptedException
	  {
		// save button
		        for(int i=1;i<=9;i++)
		        {
					d.findElement(By.name("ctl00$cphMainContent$btnEmployee")).click();
					Thread.sleep(1000);
					
					switch(i)
					{
					case 1:
					{
						
						String empname ="Enter Employee Name";
						WebElement emname =d.findElement(By.id("cphMainContent_RequiredFieldValidator2"));
						if(empname.equals(emname.getText()))
						{
							logger.info("Employee name field is suceessfully validated");
						}
						else
						{
							logger.error("Employee name field is not suceessfully validated");
							
						}
						// Employee name field
						try
						{

		    			 	WebElement bank =d.findElement(By.name("ctl00$cphMainContent$txtemp_Name"));
		    			 	bank.sendKeys("Anand");
		    			 	logger.info("Employee name is successfully entered");
		    			
						}
						
						catch(Exception e)
						{
							logger.error("Employee name is not successfully entered");
							
						}
						break;
					
					
					
					}
					
					
					case 2:
					{
						// SR number field
						try
						{
							WebElement invoice=d.findElement(By.id("cphMainContent_txtSrNumber"));
							invoice.sendKeys("BT1324");
							logger.info("SR num is successfully entered");
							
						}
						
						catch(Exception e)
						{
							logger.error("SR num is not entered");
							
						}
						break;
					}
					
					case 3:
					{
						// Date field
						
						try
						{

		    			 WebElement bank =d.findElement(By.id("cphMainContent_txtDateofJoining"));
		    			 	bank.sendKeys("03/10/2019");
		    			 	logger.info("Date is successfully entered");
		    			
						}
						
						catch(Exception e)
						{
							logger.error("Date is not successfully  entered");
							
						}
						break;
					}
					
					case 4:
					{
						
						// Address field
						String SR ="Enter Employee Address";
						WebElement SRnum =d.findElement(By.id("cphMainContent_RequiredFieldValidator3"));
						if(SR.equals(SRnum.getText()))
						{
							logger.info(" Address is suceessfully validated");
						}
						else
						{
							logger.error("Address field is not suceessfully validated");
							
						}
						try
						{
							WebElement invoice=d.findElement(By.id("cphMainContent_txtemp_Address"));
							invoice.sendKeys("Coimbatore - 641019");
							logger.info("Address is successfully entered");
							
						}
						
						catch(Exception e)
						{
							logger.error("Address is not entered");
							
						}
					        break;	
					}
					
					case 5:
					{			
						Thread.sleep(2000);

						// Designation 
						String SR ="Enter Designation";
						WebElement SRnum =d.findElement(By.xpath("//*[@id=\"cphMainContent_RequiredFieldValidator4\"]"));
						if(SR.equals(SRnum.getText()))
						{
							logger.info("Designation field is suceessfully validated");
						}
						else
						{
							logger.error("Designation field is not suceessfully validated");
							
						}
						try
						{
							WebElement invoice=d.findElement(By.id("cphMainContent_txtEmp_Designation"));
							invoice.sendKeys("Manager");
							logger.info("Designation is successfully entered");
							
						}
						
						catch(Exception e)
						{
							logger.error("Designation is not successfully entered");
							
						}
						break;

					}

					case 6:
					{			
						Thread.sleep(2000);

						// E mail
					
						try
						{
							WebElement invoice=d.findElement(By.id("cphMainContent_txtEmail"));
							invoice.sendKeys("abc@gmail.com");
							logger.info("E mail is successfully entered");
							
						}
						
						catch(Exception e)
						{
							logger.error("Email is not successfully entered");
							
						}
						break;

					}
					case 7:
					{
						
						// phone no field
						String SR ="Enter Phone No.";
						WebElement SRnum =d.findElement(By.id("cphMainContent_RequiredFieldValidator6"));
						if(SR.equals(SRnum.getText()))
						{
							logger.info("ph no field is suceessfully validated");
						}
						else
						{
							logger.error("ph no field is not suceessfully validated");
							
						}
						try
						{
							WebElement invoice=d.findElement(By.id("cphMainContent_txtemp_PhoneNo"));
							invoice.sendKeys("9874563210");
							logger.info("Ph no is successfully entered");
							
						}
						
						catch(Exception e)
						{
							logger.error("Ph no is not entered");
							
						}
					        break;	
					}
					case 8:
					{
						
						// phone no field
						String SR ="Enter Salary";
						WebElement SRnum =d.findElement(By.id("cphMainContent_RequiredFieldValidator5"));
						if(SR.equals(SRnum.getText()))
						{
							logger.info("Salary field is suceessfully validated");
						}
						else
						{
							logger.error("Salary field is not suceessfully validated");
							
						}
						try
						{
							WebElement invoice=d.findElement(By.id("cphMainContent_txtemp_Salary"));
							invoice.sendKeys("10000");
							logger.info("Salary is successfully entered");
							
						}
						
						catch(Exception e)
						{
							logger.error("Salary is not entered");
							
						}
					        break;	
					
					}
					case 9:
					{
						d.findElement(By.name("ctl00$cphMainContent$btnEmployee")).click();

						Thread.sleep(5000);
						// phone no field
						String SR ="Employee Name : Anand Inserted Successfully";
						WebElement SRnum =d.findElement(By.id("cphMainContent_lblContent"));
						if(SR.equals(SRnum.getText()))
						{
							logger.info("Employee  is suceessfully inserted");
						}
						else
						{
							logger.error("Employee is not successfully inserted");
							
						}
						Thread.sleep(2000);
						try
						{
							Actions action = new Actions(d);
							WebElement invoice=d.findElement(By.id("cphMainContent_btn_Yes"));
							action.moveToElement(invoice).build().perform();
							invoice.click();
							logger.info("Ok button is clicked successfully");
							
						}
						
						catch(Exception e)
						{
							logger.error("Ok button is not clicked successfully");
							
						}
					        break;	

					
					
					}}
				
		        }}
	 @Test(priority =5)
	  public static void emplyeededit() throws InterruptedException
	  
	  {
		 Editemployee em =new Editemployee();
	      em.beforetest();
		  em.editemployee();
		  em.employeesearch();
		  
	  }
		        
	  
	  
		@AfterTest()
		public void aftertest()
		{

		d.quit();
			logger.info("Browser is closed successfully");
		}
	
}
