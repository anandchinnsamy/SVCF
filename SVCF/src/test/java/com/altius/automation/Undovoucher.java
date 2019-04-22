package com.altius.automation;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Undovoucher {
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
	public void mousehover()
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
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[3]/ul/li[12]/a"));
				pw.click();
			logger.info("Hovered on Undo voucher screen successfully");
		} 
		catch (Exception e) {

			logger.error("Not hovered on Undo voucher");

		}
		
	}
	@Test(priority =2)
	public void undovoucher() throws InterruptedException
	{
		// Date field and load button
		Thread.sleep(3000);
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$deChoosenDate"));
			    pw.clear();
				pw.sendKeys("08032019");
				 WebElement pw1 =d.findElement(By.name("ctl00$cphMainContent$txtToDate"));
				 pw1.clear();
					pw1.sendKeys("08032019");
			logger.info("Date is choosed successfully");
		} 
		catch (Exception e) {

			logger.error("Date is not choosed");

		}
		Thread.sleep(2000);
		
		// Load  button
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$btnLoad"));
				pw.click();
			logger.info("Load button is clicked successfully");
		} 
		catch (Exception e) {

			logger.error("Load button is not clicked");

		}
		Thread.sleep(4000);
		
		// Selecting the check box
		try {
			 WebElement pw =d.findElement(By.id("cphMainContent_grid_DXSelBtn0_D"));
				pw.click();
			logger.info("Option is selcted successfully");
		} 
		catch (Exception e) {

			logger.error("Option is not selected");

		}
		// Delete
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$ASPxButton1"));
				pw.click();
			logger.info("Hovered on Undo voucher screen successfully");
		} 
		catch (Exception e) {

			logger.error("Not hovered on Undo voucher");

		}
		
		Thread.sleep(4000);
		
		JavascriptExecutor jse1 = (JavascriptExecutor)d;
		jse1.executeScript("window.scrollBy(0,2500)", "");
		// Yes button
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$Button1"));
				pw.click();
			logger.info("Yes button is clicked successfully");
		} 
		catch (Exception e) {

			logger.error("Yes button is not clicked");

		}
		Thread.sleep(3000);
		// Content
		String del ="Transaction Deleted Successfully!!!";
		WebElement delete =d.findElement(By.id("cphMainContent_lblContentConfirmation"));
		
		if(del.equals(delete.getText()))
		{
			
			logger.info("Entry deleted successfully");
		}
		else
		{
			logger.error("Entry is not deleted");
		}
	}

	

	@AfterTest()
	public void aftertest()
	{
		d.quit();
		logger.info("Browser is closed sucessfully");
		
		
	}
}
