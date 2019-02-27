package com.altius.automation;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAutomation {
    WebDriver d;
    Logger logger =Logger.getLogger(TestAutomation.class);

	@BeforeTest()
   	public void browserlauching()
   	{
		PropertyConfigurator.configure("log4jproperties.txt");
		

	System.setProperty("webdriver.chrome.driver", "../SVCF/src/test/resources/chromedriver.exe");
	d = new ChromeDriver();
	
	d.get("http://182.72.104.66:8080/SVCF/Login.aspx");

	d.manage().window().maximize();

   	}

		@Test(priority =1)
		public void OnlyCorrectUNPW() throws InterruptedException
		{ 
			
			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(5000);
			// Clicking the login button 
			WebElement hover =d.findElement(By.xpath("/html/body/app-root/app-home/app-menu-search/mat-toolbar/div/div[2]/span/button[1]/span/mat-icon"));
			Actions action =new Actions(d);
			action.moveToElement(hover).build().perform();
			
			d.findElement(By.xpath("/html/body/app-root/app-home/app-menu-search/mat-toolbar/div/div[2]/span/div/div/div/h6")).click();
			
			Thread.sleep(2000);
		   
			WebElement un=d.findElement(By.name("username"));
			WebElement pw=d.findElement(By.name("password"));
		//	un.clear();
		//	pw.clear();

		try {

			un.click();
			un.sendKeys("anand.chinnasamy@adcltech.com");
			logger.info("Valid UN is passed to the UN field");
		} catch (Exception e)
		{
			logger.error(e);
			logger.error("Valid data is not passed to the UN field");

		}

		try {
			pw.click();
			pw.sendKeys("Anand@adcltech");
				logger.info("Valid password data is passed to the PW field");
			} 
			catch (Exception e) {

				logger.error("Valid password is not passed to the PW field");

			}
		Thread.sleep(2000);
            WebElement click=d.findElement(By.xpath("/html/body/app-root/app-home/app-menu-search/div/div/div/form/div[4]/button"));
             click.click();
    			logger.info("User able to login with Correct UN  &PW");

	}
		@Test(priority =2)
		public void itemcategory() throws InterruptedException
		{
			Thread.sleep(8000);
			try//*[@id="mat-tab-content-0-0"]/div/div/div[1]/ul[2]/div/li/a
			{
				WebElement itemcategory =d.findElement(By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/div/div[1]/ul[2]/div/li/a"));
				itemcategory.click();//*[@id="mat-tab-content-0-0"]/div/div/div[1]/ul[2]/div/li/a
				logger.info("Item category of 'Angle Grinders' is clicked successfully");
			}
	        catch(Exception e)
			{
	        	logger.error("Item category of 'Angle Grinders' is not clicked ");
	        	
			}
			
			
		}
		
		@Test(priority =3)
		public void Qty()
		{
			try
			{
				WebElement Qty1 = d.findElement(By.id("table-product-input-1"));
				Qty1.click();
				Qty1.clear();
				Qty1.sendKeys("5");
				logger.info("Qty of 5 is entered for the first Qty");
			}
            catch(Exception e)
			{
            	logger.error("Qty of 5 is not entered for the first Qty");
            	
			}

		/*	try
			{
				WebElement Qty2 = d.findElement(By.xpath("//input[starts-with(@id, 'mat-inp')]"));
				Qty2.sendKeys("5");
				logger.info("Qty of 5 is entered for the Second Qty");
			}
            catch(Exception e)
			{
            	logger.error("Qty of 5 is not entered for the Second Qty");
            	
			}*/
			
		}
		
		@Test(priority=4)
		public void itemadding() throws InterruptedException
		{
			try {
			Thread.sleep(2000); 
			WebElement checkbox=d.findElement(By.xpath("//*[@id=\"table-product-checkbox-1\"]/label/div"));
			checkbox.click();
			logger.info("Item is successfully selected");	
			}
			catch(Exception e)
			{
				logger.error("Item is not successfully selected");
			}
			
			try
			{
			d.findElement(By.xpath("/html/body/app-root/app-home/div/div/div[2]/div/div[2]/div[2]/button")).click();
			logger.info("Item is successfully added to the cart");
			
			}
			catch(Exception e)
			{
				logger.error("Item is not successfully added to the cart");
				
				
			}
			Thread.sleep(2000);

			// mouse hover
			try
			{
			Actions action =new Actions(d);
			WebElement items =d.findElement(By.xpath("/html/body/app-root/app-home/app-menu-search/mat-toolbar/div/div[2]/div/button/span/label/small[2]"));
			action.moveToElement(items).build().perform();
			
			}
			catch(Exception e ) 
			{
			logger.error("Mouse is not hovered successfully ");	
			}
				Thread.sleep(2000);
			
// checkout
				try
				{
			WebElement checkout =d.findElement(By.xpath("/html/body/app-root/app-home/app-menu-search/mat-toolbar/div/div[2]/div/div/div/div[3]/button"));
			checkout.click();
			logger.info("Item is successfully checked out");
				}
				
				catch(Exception e)
				{
					logger.error("Item is not successfully checked out");
					
					
				}
		}
	
	@AfterTest()
	public void aftertest()
	{

	d.quit();
		logger.info("Browser is closed successfully");
	}
	
	
}
