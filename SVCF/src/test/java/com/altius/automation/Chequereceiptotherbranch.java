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

public class Chequereceiptotherbranch {
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

	@Test(priority = 1)
	public void Transactionshover() throws InterruptedException {
		Thread.sleep(5000);

		try {
			// Transaction hover
			Actions action = new Actions(d);
			// *[@id="smoothmenu_h"]/ul/li[2]/a
			WebElement branch = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/a"));
			action.moveToElement(branch).build().perform();

			logger.info("Hovered on 'Transaction' module successfully");
		}

		catch (Exception e) {
			logger.error("Not Hovered on 'Transaction' module ");

		}

		// Receipt details
		try {
			// Receipt details hover
			Actions action = new Actions(d);
			Thread.sleep(1000);
			// *[@id="smoothmenu_h"]/ul/li[2]/ul/li[1]/a
			WebElement branch = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[1]/a"));
			action.moveToElement(branch).build().perform();

			logger.info("Hovered on 'Receipt details' screen successfully");
		}

		catch (Exception e) {
			logger.error("Not Hovered on 'receipt details' screen ");

		}
		// CRR
		try {
			// CRR hover
			Actions action = new Actions(d);
			Thread.sleep(1000);

			WebElement branch = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[1]/ul/li[2]/a"));
			action.moveToElement(branch).build().perform();

			logger.info("Hovered on 'CRR' screen successfully");
		}

		catch (Exception e) {
			logger.error("Not Hovered on 'CRR' screen ");

		}
		// Cash receipt current branch
		try {
			// Receipt details hover
			Actions action = new Actions(d);
			Thread.sleep(1000);

			WebElement branch = d
					.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[1]/ul/li[2]/ul/li[2]/a"));
			action.moveToElement(branch).build().perform();
			branch.click();

			logger.info("Hovered on 'Cheque other branch' screen successfully");
		}

		catch (Exception e) {
			logger.error("Not Hovered on 'Cheque other branch' screen ");

		}

	}

	@Test(priority = 2)
	public void CRRinsert() throws InterruptedException {
		Thread.sleep(5000);

		try {

			WebElement designation = d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlColloctorName_chzn\"]/a"));
			Thread.sleep(1000);

			designation.click();
			WebElement manager = d
					.findElement(By.xpath("//*[@id=\"cphMainContent_ddlColloctorName_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("kennady");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			// designation.selectByIndex(2);
			logger.info("Collector name is successfully selected");

		}

		catch (Exception e) {
			logger.error("Collector name is not successfully selected");
		}

		// Received by
		try {

			WebElement designation = d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlEmployee_chzn\"]/a"));
			Thread.sleep(1000);

			designation.click();
			WebElement manager = d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlEmployee_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("kennady");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			// designation.selectByIndex(2);
			logger.info("Received by is successfully selected");

		}

		catch (Exception e) {
			logger.error("Received by is not selected");
		}
		// Total amount
		try {
			Thread.sleep(1000);

			WebElement branch = d.findElement(By.name("ctl00$cphMainContent$txtTotalAmount"));

			branch.sendKeys(amount);
			logger.info("Amount is successfully entered");
		}

		catch (Exception e) {
			logger.error("Amount is not entered");

		}

		// Receipt date
		try {
			Thread.sleep(1000);

			WebElement branch = d.findElement(By.name("ctl00$cphMainContent$txtReceivedDate"));

			branch.sendKeys("10102018");
			logger.info("Receipt date is successfully entered");
		}

		catch (Exception e) {
			logger.error("Receipt is not entered");

		}
	}

	@Test(priority = 3)
	public void transactions() throws InterruptedException {
		Thread.sleep(5000);

		try {
		
			WebElement designation = d.findElement(By.xpath("//*[@id=\"cphMainContent_listbranch_chzn\"]/a"));
			Thread.sleep(1000);

			designation.click();
			WebElement manager = d.findElement(By.xpath("//*[@id=\"cphMainContent_listbranch_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("Coimbatore");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);

			// designation.selectByIndex(2);
			logger.info("Coimbatore is successfully selected");

		}

		catch (Exception e) {
			logger.error("Coimbatore is not selected");
		}

		d.findElement(By.id("txtsrch")).sendKeys(Keys.TAB);
		
		// drop down field

		try {
			Thread.sleep(1000);

			Select branch =new Select( d.findElement(By.xpath("//*[@id=\"abc1\"]")));
			branch.selectByIndex(1);

			logger.info("option is successfully Selected");
		}

		catch (Exception e) {
			logger.error("Option is not Selected");

		}
		try {
			Thread.sleep(1000);

			WebElement branch = d.findElement(By.name("ctl00$cphMainContent$txtAmount"));

			branch.sendKeys(amount);
			logger.info("Amount is successfully entered");
		}

		catch (Exception e)
        {
			logger.error("Amount is not entered");

		}
		
		
		// Add button
		try {
			Thread.sleep(1000);

			WebElement branch = d.findElement(By.name("ctl00$cphMainContent$Button3"));

			branch.click();
			logger.info("Add button is clicked successfully");
		}

		catch (Exception e) {
			logger.error("Add button is not clicked");

		}

		// cheque number
		try {
			Thread.sleep(1000);

			WebElement branch = d.findElement(By.name("ctl00$cphMainContent$txtCheque"));

			branch.sendKeys("12459");
			branch.sendKeys(Keys.TAB);
			logger.info("Cheque Number is entered successfully");
		}

		catch (Exception e) {
			logger.error("Cheque Number is not entered");

		}

		// bank head
         Thread.sleep(3000);
		try {
			
			WebElement designation = d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlBankHead_chzn\"]/a"));
			Thread.sleep(1000);

			designation.click();
			WebElement manager = d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlBankHead_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("city");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);

			logger.info("Bank is successfully selected");

		}

		catch (Exception e) {
			logger.error("Bank is not selected");

		}
		// Cheque date

		try {
			Thread.sleep(3000);

			WebElement branch = d.findElement(By.name("ctl00$cphMainContent$txtDateinCheque"));

			branch.sendKeys("10102018");
			logger.info("Cheque date is entered successfully");
		}

		catch (Exception e) {
			logger.error("Cheque date is not entered");

		}
		// Generate button

		try {
			Thread.sleep(3000);

			WebElement branch = d.findElement(By.name("ctl00$cphMainContent$btnGenerate"));

			branch.click();
			logger.info("Generate button is clicked successfully");
		}

		catch (Exception e) {
			logger.error("Generate button is not clicked");

		}
		// Yes button
		try {
			Thread.sleep(4000);

			WebElement branch = d.findElement(By.name("ctl00$cphMainContent$Button1"));

			branch.click();
			logger.info("Cheque receipt for other branch is added successfully");
		}

		catch (Exception e) {
			logger.error("Cheque receipt is not added");

		}
	}

	@AfterTest()
	public void aftertest() {

		d.quit();
		logger.info("Browser is closed successfully");

	}

}
