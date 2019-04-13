package com.altius.automation;

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

public class Subscriberaddition extends Agreementandauctiondetails{
//	WebDriver d;
	Logger logger = Logger.getLogger(Auctionedit.class);

	@BeforeTest
	public void beforetest4() throws InterruptedException {
		PropertyConfigurator.configure("log4jproperties.txt");

		System.setProperty("webdriver.chrome.driver", "../SVCF/src/test/resources/chromedriver.exe");
		d = new ChromeDriver();
		d.get("http://182.72.104.66:8080/SVCF/Login.aspx#");
		Thread.sleep(2000);
		try {
			Select branch = new Select(d.findElement(By.id("ddlBranch")));
			branch.selectByVisibleText("CentralOffice");
			logger.info("Central office option is selected successfully");
		}

		catch (Exception e) {
			logger.error("Central office option is not selected");

		}
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

	@Test(priority = 1)
	public void subscriberhover() throws InterruptedException {

		// editauction screen
		Actions action = new Actions(d);

		try {

			WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[4]/a"));
			action.moveToElement(hover).build().perform();
			logger.info("Mouse is successfully hovered on module 'Member'");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Mouse is not successfully hovered on module 'Member'");
		}
		// Hover on auction
		Thread.sleep(2000);

		try {

			WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[4]/ul/li/a"));
			action.moveToElement(hover).build().perform();
			logger.info("Mouse is successfully hovered on for Aadhar screen");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Mouse is not successfully hovered on Aadhar screen");
		}
		Thread.sleep(2000);

		// Hovering view/edit screen
		try {

			WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[4]/ul/li/ul/li[1]/a"));
			action.moveToElement(hover).build().perform();
			hover.click();
			logger.info("Mouse is successfully clicked on Aadhar addtion screen");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Mouse is successfully  not clicked on Aadhar addtion screen");
		}
		Thread.sleep(2000);

	}

	@Test(priority = 2)
	public void Aadharaddition() throws InterruptedException {

		// File upload name

		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$fileuploadImage"));
			hover.sendKeys("C:\\Anand\\BUG_008.png");
			logger.info("Image is successfully selected");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Image is not selected");
		}

		// subscribers name
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$txtSubscriberName"));
			hover.sendKeys(name);
			logger.info("Subscriber is  entered successfully");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Subscriber is not entered");
		}
		// Category
		try {

			WebElement designation = d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlCategory_chzn\"]/a"));
			Thread.sleep(1000);

			designation.click();
			WebElement manager = d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlCategory_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("indi");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);

			// designation.selectByIndex(2);
			logger.info("Category is successfully selected");

		}

		catch (Exception e) {
			logger.error("Category is not successfully selected");
		}
		Thread.sleep(4000);

		// Proof of identity
		try {

			WebElement designation = d.findElement(By.xpath("//*[@id=\"cphMainContent_DdlAddrProof_chzn\"]/a"));
			Thread.sleep(1000);

			designation.click();
			WebElement manager = d.findElement(By.xpath("//*[@id=\"cphMainContent_DdlAddrProof_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("Aadhar");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);

			// designation.selectByIndex(2);
			logger.info("Branch name is successfully selected");

		}

		catch (Exception e) {
			logger.error("Branch name is not successfully selected");
		}

		// Aadhar card no
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$txtAadharno"));
			hover.sendKeys("257895463215894");
			logger.info("Aadhar is  entered successfully");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Aadhar is not entered");
		}
		// Age
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$TxtAge"));
			hover.sendKeys("35");
			logger.info("Age is  entered successfully");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Age is not entered");
		}
		// D.O.B
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$txtDOB"));
			hover.sendKeys("04101983");
			logger.info("DOB is  entered successfully");
		} catch (Exception e) {
			logger.error(e);
			logger.error("DOB is not entered");
		}
		// Fathers name
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$TxtFathOrHusbName"));
			hover.sendKeys("Vinay");
			logger.info("Fathers  name is  entered successfully");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Fathers name is not entered");
		}
		
		// Mothers name
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$TxtMotherName"));
			hover.sendKeys("Mansa");
			logger.info("Mother name is  entered successfully");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Mother name is not entered");
		}
		// Add button
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$buttonAdd"));
			hover.click();
			logger.info("Add button is clicked successfully");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Add button is not clicked");
		}
		Thread.sleep(2000);
		// Profession/Business
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$txtProfOrBus"));
			hover.sendKeys("Business");
			logger.info("Profession bussiness is entered successfully");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Profession bussiess is not entered");
		}
		
		// Nat/prof busineess
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$txtNatureProfOrBusi"));
			hover.sendKeys("Permenent");
			logger.info("Nature of bussiness is entered successfuly");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Nature of bussiness is not entered ");
		}
		
		// Residential address
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$txtResAddr"));
			hover.sendKeys("coimbatore");
			logger.info("Residential address is entered successfully");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Residential address is not entered");
		}
		// communication address
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$txtAddrComm"));
			hover.sendKeys("coimbatore");
			logger.info("Communication address is entered successfully");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Communication address is not entered");
		}
		// Business / profession address
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$TxtAddrBusiOrProf"));
			hover.sendKeys("coimbatore");
			logger.info("Business address is entered successfully");
		} catch (Exception e) {
			logger.error(e);
			logger.error("Business address is not entered");
		}
		
		
		// Branch name
		try {

			WebElement designation = d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlBranch_chzn\"]/a"));
			Thread.sleep(1000);

			designation.click();
			WebElement manager = d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlBranch_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("central");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);

			// designation.selectByIndex(2);
			logger.info("Branch name is successfully selected");

		}

		catch (Exception e) {
			logger.error("Branch name is not successfully selected");
		}
		
		// Mobile number
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$txtMobNo"));
			hover.sendKeys("9874563210");
			logger.info("Mob no is entered successfully");
		} catch (Exception e) {
			logger.error(e);
			logger.error("mob no address is not entered");
		}
		
		// Monthly income
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$txtMonthInc"));
			hover.sendKeys("9874");
			logger.info("Monthly income is entered successfully");
		} catch (Exception e) {
			logger.error(e);
			logger.error("monthly income address is not entered");
		}
		
		// ADd button
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$btnAdd"));
			hover.click();
			logger.info("Add button is clicked successfully");
		} 
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Add button is not clicked");
		}
		
	/*	String status ="Member : mani Added Successfully";
		WebElement mem =d.findElement(By.id("cphMainContent_lblContent"));
		
		if(status.equals(mem.getText()))
		{
			logger.info("Memeber is added successfully");
			d.findElement(By.name("ctl00$cphMainContent$btnyes")).click();
		
		}
		else
		{
			
			logger.error("Member is not added successfully");
		}*/
		Thread.sleep(2000);
		WebElement mem1 =d.findElement(By.name("ctl00$cphMainContent$btnyes"));
		mem1.click();
		
	}
	
	

	@AfterTest()
	public void aftertest() {

		d.quit();
		logger.info("Browser is closed successfully");
	}
}
