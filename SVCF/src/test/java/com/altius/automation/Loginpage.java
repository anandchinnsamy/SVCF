package com.altius.automation;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Loginpage {
    WebDriver d;
    Logger logger =Logger.getLogger(TestAutomation.class);

	@BeforeTest()
   	public void browserlauching()
   	{
		PropertyConfigurator.configure("log4jproperties.txt");

	System.setProperty("webdriver.chrome.driver", "../SVCF/src/test/resources/chromedriver.exe");
	d = new ChromeDriver();
	
	d.get("http://182.72.104.66:8080/SVCF/Login.aspx#");
   	}
	

		String uname1 = "anand";
		String pwd1 = "anand";
		String uname2 = "anand";
		String pwd2 = "anand";

	@Test(priority =1)
   public void WithoutUNPW() 
	{
			try {

				d.findElement(By.name("btnlogin")).click();
				Thread.sleep(2000);
				Alert alert =d.switchTo().alert();
				alert.accept();
			  
				String URL ="http://182.72.104.66:8080/SVCF/Home.aspx";
			   if(d.getCurrentUrl().equalsIgnoreCase(URL))
				{
				logger.error("User is able to login without UN and Pw");
				Thread.sleep(2000);
	           }
				System.out.println("The URL is :"+d.getCurrentUrl());
			    } 
			catch (Exception e)
			    {
				logger.error(e);
				logger.info("User is unable to login without data");
				
		}}

		@Test(priority =2)
		public void wrongUN() {
			try {

				WebElement un = d.findElement(By.id("txtUser"));
				un.sendKeys("anand");

				logger.info("Invalid data is successfully passed through the Username field");
			  
				d.findElement(By.name("btnlogin")).click();
				Thread.sleep(2000);

				Alert alert =d.switchTo().alert();
				alert.accept();

			} 
			 
			    catch (Exception e) {

				logger.error(e);
				logger.error("Invalid data is not successfully passed through the username field");

			}
			
			try {

				d.findElement(By.name("btnlogin")).click();
				Thread.sleep(2000);

				Alert alert =d.switchTo().alert();
				alert.accept();
				
				logger.info("Submit button is successfully cliked after invalid data is passed through the username field");
			} catch (Exception e) {

				logger.error(e);
				logger.error("Submit button is not clicked successfulluy after invalid data is passed to the username field");

			}
			d.findElement(By.id("txtUser")).clear();


		}

		@Test(priority =3)
		public void wrongPW() {
			// Password field
			try {
				d.findElement(By.id("txtPassword")).sendKeys(pwd1);
				logger.info("Invalid password is entered through the password field");
			} catch (Exception e) {
				logger.error(e);
				logger.error("Invalid password is not entered through the password field");
			}
			try {
				d.findElement(By.name("btnlogin")).click();
				Thread.sleep(2000);

				Alert alert =d.switchTo().alert();
				alert.accept();
				logger.info("User unable to login with wrong PW");
			} catch (Exception e) {
				logger.error("User able to login with wrong PW ");
			}

			d.findElement(By.id("txtPassword")).clear();
		}

		@Test(priority =4)
		public void wrongUNPW() {
			logger.info("Checking the wrong UN and PW");
			try {
				d.findElement(By.id("txtUser")).sendKeys("annad");
				logger.info("Invalid Username is entered to the UN field");
			} catch (Exception e) {
				logger.error(e);
				logger.error("Invalid username is not entered to the UN field");

			}
			try {
				d.findElement(By.id("txtPassword")).sendKeys("annad");
				logger.info("Invalid password is entered to the PW field");
			}

			catch (Exception e) {
				logger.error(e);
				logger.error("Invalid Pw is not entered to the PW field");

			}
			try {
				d.findElement(By.name("btnlogin")).click();
				Thread.sleep(2000);

				Alert alert =d.switchTo().alert();
				alert.accept();
				logger.info("Submit is clicked after Wrong UN and PW");
				logger.info("Validation is raised and User unable to login with wrong UN & PW");

			} catch (Exception e) {
				logger.error(e);
				logger.error("User is able to login and with wrong UN and PW and need validation alert ");
			}

		}

		@Test(priority =5)
		public void OnlyCorrectUN() {

			d.findElement(By.id("txtUser")).clear();
			d.findElement(By.id("txtPassword")).clear();
			try {
				d.findElement(By.id("txtUser")).sendKeys("altius");
				logger.info("Valid User name is passed to the UN field");
			} catch (Exception e) {
				logger.error(e);
				logger.error("Valid user name is not passed to the UN field");
			}

			try {

				d.findElement(By.name("btnlogin")).click();
				Thread.sleep(2000);

				Alert alert =d.switchTo().alert();
				alert.accept();
				logger.info("Submit button is clicked after the valid UN is passed to the UN field");
				logger.info("User Unable to login with only correct UN");
			} catch (Exception e) {
				logger.error(e);
				logger.error("Submit button is not clicked after the valid UN is passed to the UN field");
				logger.error("User able to login with only correct UN");
			}
		}

		@Test(priority =6)
		public void OnlycorrectPW() throws InterruptedException {
			d.findElement(By.id("txtUser")).clear();
			try {
				d.findElement(By.id("txtPassword")).sendKeys("altius");
				logger.info("Only valid password data is passed to the password field ");
			}
			catch (Exception e) {

				logger.error(e);
				logger.error("Valid password data is not passed to the password field");
			}
			d.findElement(By.name("btnlogin")).click();
			Thread.sleep(2000);

			Alert alert =d.switchTo().alert();
			alert.accept();
		}
		@Test(priority =7)
		public void branchname()
		{
           try
           {
			Select branch =new Select(d.findElement(By.id("ddlBranch")));
			branch.selectByVisibleText("CentralOffice");
			logger.info("Central office option is selected successfully");
           }
           
           catch(Exception e )
			{
				logger.error("Central office option is not selected");
				
			}

		}
		@Test(priority =8)
		public void OnlyCorrectUNPW() {
			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
			WebElement un=d.findElement(By.id("txtUser"));
			WebElement pw=d.findElement(By.id("txtPassword"));
			un.clear();
			pw.clear();


			try {
		    un.sendKeys("admin@svcf.com");
			logger.info("Valid UN is passed to the UN field");
			}
			catch (Exception e) {
				logger.error(e);
				logger.error("Valid data is not passed to the UN field");

			}
			
			try {	
				
				pw.sendKeys("C*0/Svcf");
				logger.info("Valid password data is passed to the PW field");
			} 
			catch (Exception e) {

				logger.error("Valid password is not passed to the PW field");

			}
            WebElement click=d.findElement(By.name("btnlogin"));
             click.click();
             String URL ="http://182.72.104.66:8080/SVCF/Home.aspx";
             if(d.getCurrentUrl().equals(URL))
             {
    			logger.info("User able to login with Correct UN  &PW");
             }
             else
             {
            	 logger.error("User is not able to login with correct UN and PW");
            	 
             }

		}

		
	
	@AfterTest()
	public void aftertest()
	{

	d.quit();
		logger.info("Browser is closed successfully");
	}
	
	
}
