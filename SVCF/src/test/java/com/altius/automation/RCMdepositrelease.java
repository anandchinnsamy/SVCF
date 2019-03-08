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

public class RCMdepositrelease {
	WebDriver d;
	Logger logger = Logger.getLogger(Filingvoucher.class);
	String amount = "1250";

	@BeforeTest()
	public void beforetest() {
		

		PropertyConfigurator.configure("log4jproperties.txt");

		System.setProperty("webdriver.chrome.driver", "../SVCF/src/test/resources/chromedriver.exe");
		d = new ChromeDriver();

		d.get("http://182.72.104.66:8080/SVCF/Login.aspx#");
//		d.manage().window().maximize();

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
           WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/a"));
			pw.click();
			logger.info("Hovered on trnsaction module successfully");
		} 
		catch (Exception e) 
		{

			logger.error("Not hovered on trnsaction module");

		}
		// Payment details hovering
	
		try {
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[3]/a"));
				pw.click();
			logger.info("Hovered on Voucher screen successfully");
		}
		catch (Exception e) {

			logger.error("Not hovered on Voucher screen");

		}
		try {
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[3]/ul/li[3]/a"));
				pw.click();
			logger.info("Hovered on RCM deposit voucher successfully");
		} 
		catch (Exception e) {

			logger.error("Not hovered on filing Voucher");

		}
		
	}
	
	@Test(priority=2)
	public void RCMdepositrelease() throws InterruptedException
	{
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlGroupNumber_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlGroupNumber_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("MLM");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			
		//	designation.selectByIndex(2);
			logger.info("Chit number is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Chit number is not successfully selected");
		}
		
		// Amount name
	   Thread.sleep(6000);
		try
		{

			WebElement manager =d.findElement(By.name("ctl00$cphMainContent$txtAmount"));
			Thread.sleep(1000);

			manager.sendKeys("1258");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			logger.info("Amount is successfully entered");
		}
		
		catch(Exception e)
		{
			logger.error("Amount is not successfully entered");
			
		}
		
		// credit head
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlBank_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlBank_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("city");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			
			logger.info("Bank is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Bank is not successfully selected");
		}
		Thread.sleep(2000);
		// Cheque number
		try
		{

			WebElement designation =d.findElement(By.name("ctl00$cphMainContent$txtChequeNumber"));
			Thread.sleep(1000);
			
			designation.sendKeys("1258");
			
			logger.info("Cheque number is successfully entered");
			
		}
		
		catch(Exception e)
		{
			logger.error("Cheque number is not entered");
		}
		

		// Ok button
		try
		{

			WebElement designation =d.findElement(By.name("ctl00$cphMainContent$btnPayment"));
			Thread.sleep(1000);
			
			designation.click();
			
			logger.info("Ok button is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Ok buttton is not successfully selected");
		}
		
		// Final yes button
		Thread.sleep(2000);

		try
		{

			WebElement designation =d.findElement(By.name("ctl00$cphMainContent$btnOK"));
			Thread.sleep(1000);
			
			designation.click();
			
			logger.info("Deposited successfully");
			
		}
		
		catch(Exception e)
		{
			logger.error("Not Deposited successfully");
		}
	}

	@AfterTest()
	public void aftertest()
	{

	d.quit();
		logger.info("Browser is closed successfully");
	}
}


