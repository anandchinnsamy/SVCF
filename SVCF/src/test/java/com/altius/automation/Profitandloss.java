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

public class Profitandloss {
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
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[5]/a"));
				pw.click();
			logger.info("Hovered on suggest transaction screen successfully");
		}
		catch (Exception e) {

			logger.error("Not hovered on suggest transaction screen");

		}
		try {
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[5]/ul/li[4]/a"));
				pw.click();
			logger.info("Hovered on profit and loss screen successfully");
		} 
		catch (Exception e) {

			logger.error("Not hovered on profit and loss vocher");

		}
		
	}
	
	@Test(priority=2)
	public void profitandloss() throws InterruptedException
	{
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_GridGuardians_ddlHeads_0_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_GridGuardians_ddlHeads_0_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("banks");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			
			logger.info("Bank name is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Bank name is not successfully selected");
		}
		Thread.sleep(10000);
		
// Amount field
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$GridGuardians$ctl02$txtAmount"));
				pw.sendKeys("1258");
			logger.info("Amount is successfully entered");

		    } 
		catch (Exception e) {

			logger.error("Amount is not entered");

		}
		
		Thread.sleep(5000);
		// Cheque no field
				try {
					 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$GridGuardians$ctl02$txtChequeNO"));
						pw.sendKeys("1258");
					logger.info("Cheque no is successfully entered");
				} 
				catch (Exception e) {

					logger.error("Cheque is not entered");

				}
				
				
				// Debit field
				try
				{

					WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_GridGuardiansDebit_ddlHeadsDebit_0_chzn\"]/a"));
					Thread.sleep(1000);
					
					designation.click();
					WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_GridGuardiansDebit_ddlHeadsDebit_0_chzn\"]/div/div/input"));
					Thread.sleep(1000);

					manager.sendKeys("profit");
					Thread.sleep(1000);

					manager.sendKeys(Keys.TAB);
					
					
					logger.info("Profit and loss  is successfully selected for debit");
					
				}
				
				catch(Exception e)
				{
					logger.error("Profit and loss is not successfully selected");
				}
				Thread.sleep(10000);
				
		// Amount field
				try {
					 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$GridGuardiansDebit$ctl02$txtAmountDebit"));
						pw.sendKeys("1258");
					logger.info("Amount is successfully entered");
				} 
				catch (Exception e) {

					logger.error("Amount is not entered");

				}
				Thread.sleep(2000);
				
				// Generate button
				try {
					 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$btnGenerate"));
						pw.click();
					logger.info("Generate is successfully clicked");
				} 
				catch (Exception e) {

					logger.error("Genearte is not clicked");

				}
				Thread.sleep(2000);
				// Yes button
				try {
					 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$btnYes"));
						pw.sendKeys("1258");
					logger.info(" Profit and loss screen is inserted sucessfully");
				} 
				catch (Exception e) {

					logger.error("Profit and loss screen is not inerted");

				}
				
}

	@AfterTest()
	public void aftertest()
	{
		d.quit();
		logger.info("Browser is closed sucessfully");
		
		
	}
}