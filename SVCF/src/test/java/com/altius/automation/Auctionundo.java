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

public class Auctionundo {
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

		try 
		{
			un.sendKeys("admin@svcf.com");
			logger.info("Valid UN is passed to the UN field");
		} catch (Exception e) {
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
		WebElement click = d.findElement(By.name("btnlogin"));
		click.click();
		String URL = "http://182.72.104.66:8080/SVCF/Home.aspx";
		if (d.getCurrentUrl().equals(URL))
		{
			logger.info("User able to login with Correct UN  &PW");
		} 
		else 
		{
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
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/ul/li[2]/ul/li[2]/a"));
				pw.click();
			logger.info("Hovered on auction undo screen successfully");
		} 
		catch (Exception e) {

			logger.error("Not hovered on auction undo vocher");

		}
		
	}
	
	@Test(priority =2)
	public void auctionundo() throws InterruptedException
	{
		
		// Chit
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlGroupNo_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlGroupNo_chzn\"]/div/div/input"));
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
		// Undo action 
		
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$btnload"));
				pw.click();
			logger.info("Undo action button is clicked successflly");
		} 
		catch (Exception e) {

			logger.error("Undo action button is not clicked");

		}
		Thread.sleep(2000);
		// Deleting the chit group
		WebElement pw =d.findElement(By.name("ctl00$cphMainContent$btnyes"));
		pw.click();
		String delete ="1 Action of chit number : ChitGroup has been undo successfully. ";
		
		WebElement del =d.findElement(By.id("cphMainContent_lblHeading"));

		if(delete.equals(del.getText()))
		{
			 WebElement pw1 =d.findElement(By.name("ctl00$cphMainContent$btnyes"));
				pw1.click();
			logger.info("Chit group is undo successfully");
			
		}
		else
		{
			System.out.println("Chit group is not undo ");
			
		}
		
		
		
	}

	@AfterTest()
	public void aftertest() {
		d.quit();
		logger.info("Browser is closed sucessfully");

	}
}
