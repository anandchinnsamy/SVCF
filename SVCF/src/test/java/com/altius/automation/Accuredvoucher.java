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

public class Accuredvoucher {
	WebDriver d;
	Logger logger = Logger.getLogger(Accuredvoucher.class);
	String amount = "1250";

	@BeforeTest()
	public void beforetest() {

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
	public void vocherhover()
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
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[3]/ul/li[11]/a"));
				pw.click();
			logger.info("Hovered on Accured voucher screen successfully");
		} 
		catch (Exception e) {

			logger.error("Not hovered on Accured voucher");

		}
		
	}
	
	@Test(priority=2)
	public void accuredvoucher() throws InterruptedException
	{
		
		Thread.sleep(2000);
		
		
		
		// Selecting Bank
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlHeads_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlHeads_chzn\"]/div/div/input"));
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
		
	
		Thread.sleep(10000);
		
// Amount field
		
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtAmount"));
				pw.sendKeys("1258");
			logger.info("Amount is successfully entered");
		} 
		
		catch (Exception e) {

			logger.error("Amount is not entered");

		} 	 	
		
		Thread.sleep(2000);
		
		// Cheque field
				try {
					 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtChequeNO"));
						pw.sendKeys("1258");
					logger.info("Cheque no is successfully entered");
				} 
				catch (Exception e) {

					logger.error("Cheque is not entered");

				}
				
				// Add field

						try {
							 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$crbtnAdd"));
								pw.click();
							logger.info("Credit transaction is successfully added");
						} 
						catch (Exception e) {

							logger.error("Credit Transaction is not added");

						}
				
			
				Thread.sleep(5000);
				JavascriptExecutor jse = (JavascriptExecutor)d;
				jse.executeScript("window.scrollBy(0,2500)", "");
				// Debit field
				try
				{

					WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlHeadsDebit_chzn\"]/a"));
					Thread.sleep(1000);
					
					designation.click();
					WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlHeadsDebit_chzn\"]/div/div/input"));
					Thread.sleep(1000);

					manager.sendKeys("invest");
					Thread.sleep(1000);

					manager.sendKeys(Keys.TAB);
					
					
					logger.info("Investment is successfully selected for debit trnsactions");
					
				}
				
				catch(Exception e)
				{
					logger.error("Investment is not successfully selected");
				}
				Thread.sleep(12000);
				
		// Amount field
				try {
					 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$debitAmnt"));
						pw.sendKeys("1258");
					logger.info("Amount is successfully entered");
				} 
				catch (Exception e) {

					logger.error("Amount is not entered");

				}
				
				// Purchase date
				try {
					 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtaccdatepur"));
						pw.sendKeys("08032019");
					logger.info("Purchase date is successfully entered");
				} 
				catch (Exception e) {

					logger.error("Purchase date is not entered");

				}
				Thread.sleep(2000);

				// Add field
						try {
							 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$DbbtnAdd"));
								pw.click();
							logger.info("Debit transaction is successfully added");
						} 
						catch (Exception e) {

							logger.error("Debit transaction is not added");

						}

						Thread.sleep(5000);
						JavascriptExecutor jse1 = (JavascriptExecutor)d;
						jse1.executeScript("window.scrollBy(0,2500)", "");

				// Generate button
				try {
					 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$btnGenerate"));
						pw.click();
					logger.info("Generate button is successfully clicked");
				} 
				catch (Exception e) {

					logger.error("Generate button  is not clicked");

				}
				Thread.sleep(6000);
				
				// Yes button
				try {
					 WebElement pw =d.findElement(By.xpath("//*[@id=\"Yes\"]/span"));
						pw.click();
					logger.info("Yes button is clicked sucessfully");
				} 
				catch (Exception e) {

					logger.error("Yes button is not clicked");

				}
				Thread.sleep(8000);
				
}

	@AfterTest()
	public void aftertest()
	{
		d.quit();
		logger.info("Browser is closed sucessfully");
		
		
	}
}



