package com.altius.automation;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Payment {
	WebDriver d;
	Logger logger = Logger.getLogger(CashReceiptOtherBranch.class);
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
		d.manage().window().maximize();

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
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[2]/a"));
				pw.click();
			logger.info("Hovered on payment option screen successfully");
		} catch (Exception e) {

			logger.error("Not hovered on payment option screen");

		}
		try {
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[2]/ul/li[1]/a"));
				pw.click();
			logger.info("Hovered on payment  screen successfully");
		} catch (Exception e) {

			logger.error("Not hovered on payment  screen");

		}
		
		
	}
	

	@Test(priority=2)
	public void payment() throws InterruptedException
	{
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlGroupNumber_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlGroupNumber_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("MLT30");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			
		//	designation.selectByIndex(2);
			logger.info("MLT30 is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("MLT30 is not successfully selected");
		}
		
		// Member name
	   Thread.sleep(10000);
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlMemberName_chzn\"]/a"));
			Thread.sleep(1000);
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlMemberName_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("MLT");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			logger.info("Memeber is successfully selected");
		}
		
		catch(Exception e)
		{
			logger.error("Member is not successfully selected");
			
		}
		// Gurantor name
		Thread.sleep(12000);

		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$GR_Type"));
				pw.click();
				
			logger.info("Gurantee  is  successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Gurantee is not successfully selected");

		}
		// payment on
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtDate"));
				pw.sendKeys("02022019");
				
			logger.info("Payment date is  successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Payment date is not successfully selected");

		}
		// Approved date
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtPaymentonDate"));
				pw.sendKeys("03022019");
			logger.info("Approval date is  successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Approval date is not successfully selected");

		}
		
		// Cheque number
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtChequeDDno"));
				pw.sendKeys("1258");
			logger.info("Cheque number is  successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("cheque number is not successfully selected");

		}
		// Applied on
		
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtApplyedOn"));
				pw.sendKeys("02022019");
				
			logger.info("Payment date is  successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Payment date is not successfully selected");

		}
		
		// Description
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtDescription"));
				pw.sendKeys("Payment");
				
			logger.info("Description is  successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Description is not successfully selected");

		}
		// Admin sanction number
		
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtAOSanctiion"));
				pw.sendKeys("34");
				
			logger.info("Sanction number is  successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Sanction number is not successfully entered");

		}
		
		// Document detail
		
		try {
			 WebElement pw =d.findElement(By.id("cphMainContent_GrDocument_1"));
				pw.click();
				
			logger.info("Clean option  is  successfully selected");
		} 
		catch (Exception e) 
		{

			logger.error("Clean option is not selected");
			
		}
		
		// Bank detail
		Thread.sleep(7000);
		JavascriptExecutor jse = (JavascriptExecutor)d;
		jse.executeScript("window.scrollBy(0,2500)", "");
		
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlBankName_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlBankName_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("City");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			logger.info("Bank is successfully selected");
		}
		
		catch(Exception e)
		{
			logger.error("Bank is not successfully selected");
			
		}
		
		
		Thread.sleep(2000);
		// Final payment
		
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$btnPayment"));
				pw.click();
				
			logger.info("Payment button is  clicked successfully");
		    Thread.sleep(6000);

		} 
		catch (Exception e) 
		{

			logger.error(" Payment button is not clicked done");

		}
		
		// Yes button
		Thread.sleep(2000);

		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$BtnOK"));
				pw.click();
				
			logger.info("Final payment is  successfully done");
		    

		} 
		catch (Exception e) 
		{

			logger.error("Final payment is not successfully done");

		}
		
		// ok button
		Thread.sleep(6000);
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$Button2"));
				pw.click();
				
			logger.info("Ok button is clicked successfully");
		    

		} 
		catch (Exception e) 
		{

			logger.error("ok button is not clicked");

		}
	}
	@AfterTest()
	public void aftertest()
	{
 
	d.quit();	
	logger.info("Browser is closed successfully");
	}

}
	
	

