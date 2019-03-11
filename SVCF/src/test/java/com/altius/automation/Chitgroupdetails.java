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

public class Chitgroupdetails {
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
           WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/a"));
			pw.click();
			logger.info("Hovered on group and confidential report module successfully");
		} 
		catch (Exception e) 
		{

			logger.error("Not hovered on group and confidential report module");

		}
		// Payment details hovering
	
		try {
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/ul/li[1]/a"));
				pw.click();
			logger.info("Hovered on chit group screen successfully");
		}
		catch (Exception e) {

			logger.error("Not hovered on Chit group screen");

		}
		try {
			Actions action =new Actions(d);
			
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/ul/li[1]/ul/li[3]/a"));
			 action.moveToElement(pw).click().build().perform();	
			 
			logger.info("Hovered on Chit Group screen successfully");
		} 
		catch (Exception e) {

			logger.error("Not hovered on chit group screen");

		}
	
	}
	@Test(priority =2)
	public void chitreport() throws InterruptedException {
		
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlGroupNumber_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlGroupNumber_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("Chitgroup");
			Thread.sleep(1000);		

			manager.sendKeys(Keys.TAB);
			
		//	designation.selectByIndex(2);
			logger.info("Chit Group is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Chit Group is not successfully selected");
		}
		// Go buttom
		try {
			Actions action =new Actions(d);
			
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$BtnStatisticsGo"));
			 action.moveToElement(pw).click().build().perform();	
			 
			logger.info("Go button is clicked successfully");
			
			Thread.sleep(4000);
		} 
		catch (Exception e) {

			logger.error("Go button is not clicked");

		}
	}
	@AfterTest()
	public void aftertest()
	{
		d.quit();
		logger.info("Browser is closed sucessfully");
		
		
	}
}
