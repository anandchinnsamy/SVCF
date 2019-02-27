package com.altius.automation;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Editemployee {
	
	 WebDriver d;
	    Logger logger =Logger.getLogger(Editemployee.class);
	    
	    @BeforeTest
	    public void beforetest() throws InterruptedException
	    {
	    	PropertyConfigurator.configure("log4jproperties.txt");

	    	System.setProperty("webdriver.chrome.driver", "../SVCF/src/test/resources/chromedriver.exe");
	    	d = new ChromeDriver();
		    d.get("http://182.72.104.66:8080/SVCF/Login.aspx#");
		    Thread.sleep(2000);
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
	    
	@Test(priority =1)
	public void editemployee() throws InterruptedException
	{

		// editemployee screen
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
		// Hovering view/edit screen
		try {

			WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[5]/ul/li[5]/ul/li[2]/a"));
			action.moveToElement(hover).build().perform();
			hover.click();
			logger.info("Mouse is successfully clicked on screen 'Employee' View/Edit screen");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Mouse is successfully  not clicked on screen 'Employee' View/Edit screen");
		}
		Thread.sleep(2000);
		
		
	}
	@Test(priority =2)
	public void employeesearch() throws InterruptedException
	{

		// editemployee screen
		Actions action = new Actions(d);

			WebElement hover = d.findElement(By.id("cphMainContent_gridBranch_DXFREditorcol3_I"));
			hover.sendKeys("Anand");
			Thread.sleep(5000);
			String Employee ="Anand";
			WebElement emp = d.findElement(By.xpath("//*[@id=\"cphMainContent_gridBranch_DXDataRow0\"]/td[3]"));
			if(Employee.equals(emp.getText()))
			{
			logger.info("Employee is created successfully'");
			}
			else
			{
				logger.error("Employee is not created successfully");
				
			}
	}
	@Test(priority =3)
	public void employeeupdate() throws InterruptedException
	{

		Actions action = new Actions(d);

		try {

			WebElement hover = d.findElement(By.xpath("//*[@id=\"cphMainContent_gridBranch_DXDataRow1\"]/td[1]/img[1]"));
			hover.click();
			logger.info("Update button is successfully clicked");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Update button is not successfully clicked");
		}
	// Changing the SR num 0 to 1258
		try {

			WebElement hover = d.findElement(By.id("cphMainContent_gridBranch_ef1_ASPxTextBox5_1_I"));
			hover.clear();
			hover.sendKeys("1258");
			logger.info("SR num is successfully entered");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("SR num is not entered");
		}
		// Clicking the update button
		try {

			WebElement hover = d.findElement(By.id("cphMainContent_gridBranch_ef1_ASPxTextBox5_1_I"));
			hover.clear();
			hover.sendKeys("1258");
			logger.info("SR num is successfully entered");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("SR num is not entered");
		}
	
	
	}

	@AfterTest()
	public void aftertest()
	{

	d.quit();
	}
}
