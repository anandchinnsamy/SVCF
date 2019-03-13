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

public class Adjustments {
	WebDriver d;
	Logger logger = Logger.getLogger(Filingvoucher.class);
	String amount = "1250";

	@BeforeTest()
	public void beforetest() {
		

		PropertyConfigurator.configure("log4jproperties.txt");

		System.setProperty("webdriver.chrome.driver", "../SVCF/src/test/resources/chromedriver.exe");
		d = new ChromeDriver();

		d.get("http://182.72.104.66:8080/SVCF/Login.aspx#");
	//	d.manage().window().maximize();

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
	public void groupadditionhover() throws InterruptedException
	{
        // Hovering in trnsaction screen
		try {
           WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/a"));
			pw.click();
			logger.info("Hovered on trnsaction module successfully");
		} 
		catch (Exception e) 
		{

			logger.error("Not hovered on transaction report module");

		}
		// Payment details hovering
	
		try {
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[4]/a"));
				pw.click();
			logger.info("Hovered on received adjustment/advices screen successfully");
		}
		catch (Exception e) {

			logger.error("Not hovered on received adjustment/advices screen");

		}
		try {
			Actions action =new Actions(d);
			
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[4]/ul/li[2]/a"));
			 action.moveToElement(pw).click().build().perform();	
			 
			logger.info("Hovered on Adjustment screen successfully");
		} 
		catch (Exception e) {

			logger.error("Not hovered on Adjustment screen");

		}
	
	}
	
	@Test(priority =2)
	public void adjustment() throws InterruptedException {
		
		try
		{
			//*[@id="cphMainContent_ddlStatus_chzn"]/a
			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlStatus_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlStatus_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("waiting");
			Thread.sleep(4000);		

			manager.sendKeys(Keys.TAB);
			
		//	designation.selectByIndex(2);
			logger.info("Waiting status is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Waiting status is not successfully selected");
		}
		// Load button

		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$btnLoad"));
				pw.click();
			logger.info("Load button is clicked successfully");
		}
		catch (Exception e) {

			logger.error("Load button is not clicked");
		}
       Thread.sleep(3000);
       
       // Approval
       try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$GridView1$ctl02$btnReject"));
				pw.click();
			logger.info("Approve button is clicked successfully");
		}
		catch (Exception e) {

			logger.error("Approve button is not clicked");
		
		}
       Thread.sleep(5000);
       
       // Accept window
       try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_GridGuardians_ddlDebit_0_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_GridGuardians_ddlDebit_0_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("banks");
			Thread.sleep(4000);		

			manager.sendKeys(Keys.TAB);
			
		//	designation.selectByIndex(2);
			logger.info("Bank is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Bank is not successfully selected");
		}
       
       
       // Debit amount
       try {
    	   String amt=d.findElement(By.id("cphMainContent_lbldebitamount")).getText();
    	   
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$GridGuardians$ctl02$txtAmountDebit"));
				pw.sendKeys(amt);
			logger.info("Debit amount is entered successfully");
	       }
     
		catch (Exception e) 
        {

			logger.error("Debit amount is not entered");
		
		}
       //Date and ok fileds
       try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtDate"));
				pw.sendKeys("11032019");
				 WebElement pw1 =d.findElement(By.name("ctl00$cphMainContent$btnAcceptOK"));
					pw1.click();
			logger.info("Date and Ok button is clicked successfully");
	       }
       
		catch (Exception e) 
        {

			logger.error("Date  and ok button is not clicked");
		
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
