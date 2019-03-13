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

public class Loan {
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
	public void paymenthover() throws InterruptedException
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
	    Thread.sleep(1000);
		try {//*[@id="smoothmenu_h"]/ul/li[2]/ul/li[5]/a
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[5]/a"));
				pw.click();
			logger.info("Hovered on suggestion transaction screen successfully");
		} catch (Exception e) {

			logger.error("Not hovered on suggestion transaction screen");

		}
		try {//*[@id="smoothmenu_h"]/ul/li[2]/ul/li[5]/ul/li[1]/a
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[5]/ul/li[1]/a"));
				pw.click();
			logger.info("Hovered on loan screen successfully");
		} catch (Exception e) {

			logger.error("Not hovered on loan screen");

		}
	}
		@Test(priority=2)
		public void loan() throws InterruptedException
		{
			// Type of loan
			try
			{

				WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlLoan_chzn\"]/a"));
				Thread.sleep(1000);
				
				designation.click();
				WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlLoan_chzn\"]/div/div/input"));
				Thread.sleep(1000);

				manager.sendKeys("employee");
				Thread.sleep(1000);

				manager.sendKeys(Keys.TAB);
				
				
			//	designation.selectByIndex(2);
				logger.info("Type of loan is successfully selected");
				
			}
			
		catch (Exception e) {
			logger.error("Type of loan is not successfully selected");
			

		}
			Thread.sleep(6000);

		// Token
		try {

			WebElement designation = d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlTokenNo_chzn\"]/a"));
			Thread.sleep(1000);

			designation.click();
			Thread.sleep(1000);

			WebElement manager = d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlTokenNo_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("pala");
			Thread.sleep(2000);

			manager.sendKeys(Keys.TAB);

			// designation.selectByIndex(2);
			logger.info("Token is successfully selected");

		}

		catch (Exception e) 
		{
			logger.error("Token is not successfully selected");
		}
		
		Thread.sleep(8000);
		// Loan amount

		try
		{
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtAmount"));
				pw.sendKeys("100000");
			logger.info("Loan amount is successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Loan amount is not entered");

		}
		// A.O sanction no
		try
		{
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtAOSanctionNumber"));
				pw.sendKeys("1234");
			logger.info("Sanction number is successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Sanction is not entered");

		}
		
		// Clicking the ok button
		try
		{
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$btnPayLoan"));
				pw.click();
			logger.info("Ok button is clicked successfully");
		} 
		catch (Exception e) 
		{

			logger.error("Ok button is not clicked");

		}
						
						
						
	}
	@AfterTest()
	public void aftertest()
	{
 
	d.quit();	
	logger.info("Browser is closed successfully");
	}

}
