package com.altius.automation;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Auctionfeed {
	WebDriver d;
	Logger logger = Logger.getLogger(Filingvoucher.class);
	String amount = "1250";

	@BeforeTest()
	public void beforetest() {
		/*
		 * Logincredentials lc= new Logincredentials(); lc.browserlauching();
		 */

		PropertyConfigurator.configure("log4jproperties.txt");

		System.setProperty("webdriver.chrome.driver", "../SVCF/src/test/resources/chromedriver.exe");
		d = new ChromeDriver();

		d.get("http://182.72.104.66:8080/SVCF/Login.aspx#");

		try {
			Select branch = new Select(d.findElement(By.id("ddlBranch")));
			branch.selectByVisibleText("CentralOffice");
			logger.info("Central office option is selected successfully");
		}

		catch (Exception e) {
			logger.error("Central office option is not selected");

		}

		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement un = d.findElement(By.id("txtUser"));
		WebElement pw = d.findElement(By.id("txtPassword"));
		un.clear();
		pw.clear();

		try {
			un.sendKeys("admin@svcf.com");
			logger.info("Valid UN is passed to the UN field");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Valid data is not passed to the UN field");

		}

		try {

			pw.sendKeys("C*0/Svcf");
			logger.info("Valid password data is passed to the PW field");
		} catch (Exception e) {

			logger.error("Valid password is not passed to the PW field");

		}
		WebElement click = d.findElement(By.name("btnlogin"));
		click.click();
		String URL = "http://182.72.104.66:8080/SVCF/Home.aspx";
		if (d.getCurrentUrl().equals(URL)) {
			logger.info("User able to login with Correct UN  &PW");
		} else {
			logger.error("User is not able to login with correct UN and PW");

		}

	}
	
	@Test(priority=1)
	public void paymenthover()
	{
        // Hovering in trnsaction screen
		try {
           WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/a"));
			pw.click();
			logger.info("Hovered on group and confidential  module successfully");
		} 
		catch (Exception e) 
		{

			logger.error("Not hovered on groupa and confidential module");

		}
		// Payment details hovering
	
		try {
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/ul/li[2]/a"));
				pw.click();
			logger.info("Hovered on suggest auction screen successfully");
		}
		catch (Exception e) {

			logger.error("Not hovered on suggest auction screen");

		}
		try {
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/ul/li[2]/ul/li[1]/a"));
				pw.click();
			logger.info("Hovered on feed screen successfully");
		} 
		catch (Exception e) {

			logger.error("Not hovered on feed vocher");

		}
		
	}
	
	@Test(priority =2)
	public void auction() throws InterruptedException
	{
		
		// Chit
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlChitNo_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlChitNo_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("Chitgroup");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			
			logger.info("Chit is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Chit is not successfully selected");
		}
		Thread.sleep(6000);
		// Auction type 
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlAuction_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlAuction_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("new");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			
			logger.info("Auction type is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Auction type is not successfully selected");
		}
		Thread.sleep(6000);
		
		// Beneficaiary name
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlBenefName_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlBenefName_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("chitgroup");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			
			logger.info("Beneficiary is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Beneficiary is not successfully selected");
		}
		Thread.sleep(6000);
		// Prized amount
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtPrizamt"));
				pw.sendKeys("10000");
			logger.info("Prozed amount is successfully entered");
		} 
		catch (Exception e) {

			logger.error("Prize is not entered");

		}
		
		// Default interest field
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtDefaultInterset"));
				pw.sendKeys("1000");
			logger.info("Default interest is entered successfully");
		} 
		catch (Exception e) {

			logger.error("Default interest is not entered");

		}
		// Due amount
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtDueAmount"));
				pw.sendKeys("1000");
			logger.info("Due amount is entered succesfully");
		} 
		catch (Exception e) {

			logger.error("Due amount is not entered");

		}
		// Add amount field
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$btnAdd"));
				pw.click();
			logger.info("Add button is clicked successflly");
		} 
		catch (Exception e) {

			logger.error("Add button is not clicked");

		}
		Thread.sleep(3000);
	}
	
	@AfterTest()
	public void aftertest()
	{
		d.quit();
		logger.info("Browser is closed sucessfully");
		
		
	}
}
