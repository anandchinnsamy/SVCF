package com.altius.automation;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Groupaddition extends Loginpage
{

	//WebDriver d;
	Logger logger = Logger.getLogger(Groupaddition.class);
	String amount = "1250";

	@BeforeTest()
	public void beforetest1() throws InterruptedException {
		

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
	public void groupadditionhover1() throws InterruptedException
	{
		Thread.sleep(5000);
		
        // Hovering in trnsaction screen
		try {
           WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/a"));
           System.out.println("The field is "+pw.getTagName());
			pw.click();
			logger.info("Hovered on group and confidential report module successfully");
		} 
		catch (Exception e) 
		{
            logger.error(e);
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
			
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/ul/li[1]/ul/li[1]/a"));
			 action.moveToElement(pw).build().perform();	
			logger.info("Hovered on Chit Group addition screen successfully");
		} 
		catch (Exception e) {

			logger.error("Not hovered on chit group addition voucher");

		}
		
		try {
			 WebElement pw =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/ul/li[1]/ul/li[1]/ul/li[1]/a"));
				pw.click();
			logger.info("Hovered on Group addition screen successfully");
		} 
		catch (Exception e) {

			logger.error("Not hovered on group addition voucher");

		}
		
	}
	@Test(priority=2)
	public void groupaddition() throws InterruptedException
	{
		// Group name
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtgroup_no"));
				pw.sendKeys(a);
			logger.info("Chit Group is entered successfully");
		
		    } 
		catch (Exception e) 
		{

			logger.error("Chit group is not entered");

		}
		
		// No of installment
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtno_of_months"));
				pw.sendKeys("24");
			logger.info("No of installment  is entered successfully");
		
		    } 
		catch (Exception e) 
		{

			logger.error("No of installment is not entered");

		}
		//Auction  time
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$TimeSelector8"));
			 pw.click();
				pw.sendKeys("05");
				 WebElement pw1 =d.findElement(By.name("ctl00$cphMainContent$TimeSelector1"));
				 pw1.click();
					pw1.sendKeys("07");
				
			logger.info("Auction date  is entered successfully");
		
		    } 
		catch (Exception e) 
		{

			
			logger.error("Auction date is not entered");

		}
		// chit value
		try {
			 Select pw =new Select(d.findElement(By.name("ctl00$cphMainContent$txtchit_value")));
				pw.selectByValue("500000.00");
				
			logger.info("Chit value is selected successfully");
		
		    } 
		catch (Exception e) 
		{

			logger.error("Chit value is not selected");

		}
		// Chit period in months
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtchit_period"));
				pw.sendKeys("12");
				
			logger.info("Chit period in month is entered successfully");
		
		    } 
		catch (Exception e) 
		{

			logger.error("Chit period in month is not entered");

		}
		
		// Chit category
		try {
			 Select pw =new Select(d.findElement(By.name("ctl00$cphMainContent$cmbchit_category")));
				pw.selectByValue("Monthly");
				
			logger.info("Chit category is selected successfully");
		
		    } 
		catch (Exception e) 
		{

			logger.error("Chit category is not selected");

		}
		
		// No of memebers
		
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtno_of_members"));
				pw.sendKeys("12");
				
			logger.info("No of members is entered successfully");
		
		    } 
		catch (Exception e) 
		{

			logger.error("No of members is not entered successfully");

		}
		
		// Duplicate chit group
		
		WebElement pw = d.findElement(By.name("ctl00$cphMainContent$btnaddGroup"));
		pw.click();

		logger.info("Generate button is clicked successfully");
		Thread.sleep(2000);
		d.findElement(By.name("ctl00$cphMainContent$BtnOK")).click();
		
		System.out.println("1");
		
	}
		/*if(d.findElement(By.id("cphMainContent_lblContent")).getText().equals(d.findElement(By.id("cphMainContent_lblContent")).getText()))
		{
			
			logger.info("Chitgroup is creted successfully");
		}
		}
		catch (Exception e)
		{
			
			for (int i = 0; i < 100; i++) 
				
			{  
			Alert alert = d.switchTo().alert();
			System.out.println("7");

			Alert alertt = d.switchTo().alert();
			System.out.println("8");

			System.out.println("The alert text is:" + alert.getText());
			System.out.println("9");

			if ((alertt.getText()).equals(alert.getText()))
			{

				alert.accept();
				

				System.out.println("10");

				System.out.println("11");
					String b = a;
					WebElement allergy = d.findElement(By.name("ctl00$cphMainContent$txtgroup_no"));
				//	 String b =allergy.getAttribute("Value");
				// int i=1;
					System.out.println("12");

				String c = b + i;
				allergy.clear();
				allergy.sendKeys(c);
				System.out.println("13");

				Thread.sleep(2000);
				WebElement pw = d.findElement(By.name("ctl00$cphMainContent$btnaddGroup"));
				pw.click();
				
			//	pw.click();
				System.out.println("14");

				Thread.sleep(2000);
				//
				String Ok1 =d.findElement(By.id("cphMainContent_lblContent")).getText();
				
				String Ok2 =d.findElement(By.id("cphMainContent_lblContent")).getText();
			}
			
				if(d.findElement(By.id("cphMainContent_lblContent")).getText().equals(d.findElement(By.id("cphMainContent_lblContent")).getText()))
				{
					
					logger.info("Chitgroup is created successfully");
					i=102;
					
					
				}

			   
			}
		}*/
	
		
				
				


	@AfterTest()
	public void test1()
	{
		d.quit();
		logger.info("Browser is closed sucessfully");
		
		
	}
	
	public void Login() {
//		Loginpage lp = new Loginpage();
		super.branchname();
	}
	
}
