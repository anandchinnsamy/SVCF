package com.altius.automation;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Collectoraddition {
	 WebDriver d;
	    Logger logger =Logger.getLogger(Collectoraddition.class);
	    
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
	public void OnlyCorrectUNPW() 
	{
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
		WebElement un=d.findElement(By.id("txtUser"));
		WebElement pw=d.findElement(By.id("txtPassword"));
		un.clear();
		pw.clear();


		try {
	    un.sendKeys("admin@svcf.com");
		logger.info("Valid UN is passed to the UN field");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Valid data is not passed to the UN field");

		}
		
		try {	
			
			pw.sendKeys("C*0/Svcf");
			logger.info("Valid password data is passed to the PW field");
		} 
		catch (Exception e) 
		{

			logger.error("Valid password is not passed to the PW field");

		}       
		WebElement click=d.findElement(By.name("btnlogin"));
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
	 @Test(priority =4)
	  public void fieldvalidation() throws InterruptedException
	  {
		// save button
		        for(int i=1;i<=3;i++)
		        {
					d.findElement(By.name("ctl00$cphMainContent$btnAddcollector")).click();
					Thread.sleep(1000);
					
					switch(i)
					{
					case 1:
					{
						
						String empname ="Select Money Collector";
						WebElement emname =d.findElement(By.id("cphMainContent_CompareValidator11"));
						if(empname.equals(emname.getText()))
						{
							logger.info("Money collector field is suceessfully validated");
						}
						else
						{
							logger.error("Money collector field is not validated");
							
						}
					
						break;
					
					}
					
					
					case 2:
					{
						// SR number field
					
						String empname ="Enter Address";
						WebElement emname =d.findElement(By.id("cphMainContent_RequiredFieldValidator3"));
						if(empname.equals(emname.getText()))
						{
							logger.info("Address field is suceessfully validated");
						}
						else
						{
							logger.error("Address field is not validated");
							
						}
					
						break;
					}
					case 3:
					{
						// SR number field
					
						String empname ="Enter Phone Number";
						WebElement emname =d.findElement(By.id("cphMainContent_RequiredFieldValidator4"));
						if(empname.equals(emname.getText()))
						{
							logger.info("Ph no field is suceessfully validated");
						}
						else
						{
							logger.error("Ph no field is not validated");
							
						}
						break;
					}       // case
						}   // switch
					}      // for
					
					}   //  method
	@Test(priority =3)
    public void mousehvering() throws InterruptedException
    
    {
    	try {
            Actions action =new Actions(d);
			WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[5]/a"));
    		action.moveToElement(hover).build().perform();
    		logger.info("Mouse is successfully hovered on module 'Internal'");
    	}
    	catch (Exception e)
    	{
    		logger.error(e);
    		logger.error("Mouse is not successfully hovered on module 'Internal'");
    	}
    	// Hovering on Money/Bil collecctor
    	try {
            Actions action =new Actions(d);
    		WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[5]/ul/li[4]/a"));
    		action.moveToElement(hover).build().perform();
    		logger.info("Mouse is successfully hovered on Money/Bill collector'");
    	}
    	catch (Exception e)
    	{
    		logger.error(e);
    		logger.error("Mouse is not  hovered on Money/Bill collector'");
    	}
    	Thread.sleep(2000);
    	// Hovering on collector addition 
    	Thread.sleep(2000);
    	try {
            Actions action =new Actions(d);
    		WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[5]/ul/li[4]/ul/li[2]/a"));
    		action.moveToElement(hover).build().perform();
    		hover.click();
    		logger.info("Mouse is successfully hovered on Collector addition screen'");
    	}
    	catch (Exception e)
    	{
    		logger.error(e);
    		logger.error("Mouse is not  hovered on Collector addition screen'");
    	}
    	Thread.sleep(2000);
    }
	// Adding collector
	@Test(priority =5)
	public void collectoraddition () throws InterruptedException
	{
	try
	{
	
		Thread.sleep(2000);

		WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlMoneyCollector_chzn\"]/a"));
		Thread.sleep(2000);
		
		designation.click();
		WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlMoneyCollector_chzn\"]/div/div/input"));
		Thread.sleep(2000);

		manager.sendKeys("Anand");
		Thread.sleep(2000);

		manager.sendKeys(Keys.TAB);
	//	designation.selectByIndex(2);
		logger.info("Employee is successfully selected");
	}
	catch(Exception e)
	{
		logger.info("Employee is not successfully selected");

	}
	Thread.sleep(2000);
	// Add button
	
	try {
        Actions action =new Actions(d);
		WebElement hover = d.findElement(By.name("ctl00$cphMainContent$btnAddcollector"));
		hover.click();
		logger.info("Money collector is added successfully");
		
		
	}
	catch (Exception e)
	{
		logger.error(e);
		logger.error("Mouse collector is not added successfully");
	}
}
    
	
	 
    
    @Test(priority =6)
    public void collectorduplicate() throws InterruptedException
    {
	
	// Adding collector
	
	try
	{
	
		Thread.sleep(2000);

		WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlMoneyCollector_chzn\"]/a"));
		Thread.sleep(2000);
		
		designation.click();
		logger.info("List box component is clicked successfully");
	}
	catch(Exception e)
	{
		logger.error("List box component is not clicked ");

		
	}
	// Choosing the employee name
	try
	{
		WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlMoneyCollector_chzn\"]/div/div/input"));
		Thread.sleep(2000);

		manager.sendKeys("Anand");
		Thread.sleep(2000);

		manager.sendKeys(Keys.TAB);
	//	designation.selectByIndex(2);
		logger.info("Money collector is successfully selected");
	}
	catch(Exception e)
	{
		logger.info("Money collector is not selected");

	}
	Thread.sleep(2000);
	// Add button
	
	try {
        Actions action =new Actions(d);
		WebElement hover = d.findElement(By.name("ctl00$cphMainContent$btnAddcollector"));
		hover.click();
		logger.info("Money collector is added successfully");
	}
	catch (Exception e)
	{
		logger.error(e);
		logger.error("Mouse collector is not added successfully");
	}
    }
	@AfterTest()
	public void aftertest()
	{

	d.quit();
		logger.info("Browser is closed successfully");
	}
    
    
}
