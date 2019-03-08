package com.altius.automation;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Logincredentials {

	 WebDriver d;
	    Logger logger =Logger.getLogger(Logincredentials.class);
	    
	@BeforeTest()
	public void browserlauching()
	{
		PropertyConfigurator.configure("log4jproperties.txt");

	System.setProperty("webdriver.chrome.driver", "../SVCF/src/test/resources/chromedriver.exe");
	d = new ChromeDriver();
	
	d.get("http://182.72.104.66:8080/SVCF/Login.aspx#");
	
	
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

	@Test
	public void test()
	{
	
	}

}
