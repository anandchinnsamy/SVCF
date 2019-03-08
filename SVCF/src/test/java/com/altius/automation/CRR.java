package com.altius.automation;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
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

public class CRR {

	 WebDriver d;
	    Logger logger =Logger.getLogger(CRR.class);
	    String amount ="1250";
	    
	@BeforeTest()
	public void beforetest()
	{
/*
		Logincredentials lc= new Logincredentials();
		lc.browserlauching();
		*/

		PropertyConfigurator.configure("log4jproperties.txt");

	System.setProperty("webdriver.chrome.driver", "../SVCF/src/test/resources/chromedriver.exe");
	d = new ChromeDriver();
	
	d.get("http://182.72.104.66:8080/SVCF/Login.aspx#");
	
	
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
	
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
		WebElement un=d.findElement(By.id("txtUser"));
		WebElement pw=d.findElement(By.id("txtPassword"));
		un.clear();
		pw.clear();


		try {
	    un.sendKeys("admin@svcf.com");
		logger.info("Valid UN is passed to the UN field");
		}
		catch (Exception e)
		{
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
	 	
	

	@Test(priority =1)
	public void Transactionshover() throws InterruptedException
	{
	Thread.sleep(5000);

	
    try
    {  
    	// Transaction hover
    	Actions action =new Actions(d);

		WebElement branch =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/a"));
		action.moveToElement(branch).build().perform();
		
		logger.info("Hovered on 'Transaction' module successfully" );
    }
    
    catch(Exception e )
		{
			logger.error("Not Hovered on 'Transaction' module ");
			
			
		}
	
    // Receipt details
    try
    {
    	// Receipt details hover
    	Actions action =new Actions(d);
    	Thread.sleep(1000);

		WebElement branch =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[1]/a"));
		action.moveToElement(branch).build().perform();
		
		logger.info("Hovered on 'Receipt details' screen successfully" );
    }
    
    catch(Exception e )
		{
			logger.error("Not Hovered on 'receipt details' screen ");
			
		
		}
// CRR
    try
    {
    	// CRR hover
    	Actions action =new Actions(d);
    	Thread.sleep(1000);

		WebElement branch =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[1]/ul/li[1]/a"));
		action.moveToElement(branch).build().perform();
		
		logger.info("Hovered on 'CRR' screen successfully" );
    }
    
    catch(Exception e )
		{
			logger.error("Not Hovered on 'CRR' screen ");
			
			
		}
	// Cash receipt current branch
    try
    {
    	// Receipt details hover
    	Actions action =new Actions(d);
    	Thread.sleep(1000);

		WebElement branch =d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[2]/ul/li[1]/ul/li[1]/ul/li[1]/a"));
		action.moveToElement(branch).build().perform();
		branch.click();
		
		logger.info("Hovered on 'CRR current branch' screen successfully" );
    }
    
    catch(Exception e )
		{
			logger.error("Not Hovered on 'Current branch details' screen ");
			
			
		}
    
	}
	@Test(priority =2)
	public void CRRinsert() throws InterruptedException
	{
	Thread.sleep(5000);

	
	try
	{

		WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlColloctorName_chzn\"]/a"));
		Thread.sleep(1000);
		
		designation.click();
		WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlColloctorName_chzn\"]/div/div/input"));
		Thread.sleep(1000);

		manager.sendKeys("kennady");
		Thread.sleep(1000);

		manager.sendKeys(Keys.TAB);
	//	designation.selectByIndex(2);
		logger.info("Collector name is successfully selected");
		
	}
	
	catch(Exception e)
	{
		logger.error("Collector name is not successfully selected");
	}
	
	// Received by
	  try
	    {
	    	Thread.sleep(1000);

			Select branch =new Select(d.findElement(By.id("cphMainContent_ddlEmployee")));

			branch.selectByIndex(2);
			logger.info("Received is successfully selected" );
	    }
	    
	    catch(Exception e )
			{
				logger.error("Received is not successfully selected");
				
			
			}
	 // Total amount
	  try
	    {
	    	Thread.sleep(1000);

			WebElement branch =d.findElement(By.name("ctl00$cphMainContent$txtTotalAmount"));

			branch.sendKeys(amount);
			logger.info("Amount is successfully entered" );
	    }
	    
	    catch(Exception e )
			{
				logger.error("Amount is not entered");
				
			
			}
	
	// Receipt date
	  try
	    {
	    	Thread.sleep(1000);

			WebElement branch =d.findElement(By.name("ctl00$cphMainContent$txtReceivedDate"));

			branch.sendKeys("10102018");
			logger.info("Receipt date is successfully entered" );
	    }
	    
	    catch(Exception e )
			{
				logger.error("Receipt is not entered");
				
			
			}
	}
	
	  @Test(priority =3)
	  public void generatebutton() throws InterruptedException {
	  
	  // Generate button
	  try
	    {
	    	Thread.sleep(1000);

			WebElement branch =d.findElement(By.name("ctl00$cphMainContent$btnGenerate"));

			branch.click();
			
			Alert alert =d.switchTo().alert();
			String alert1 ="Enter the transaction fields";
			if (alert1.equals(alert.getText()))
					{
			
			logger.info("Form is validated" );
	    }
	    }
	    catch(Exception e )
			{
				logger.error("Form is not validated");
				Transactionshover();
				CRRinsert();
			}
	}
	
	  @Test(priority =4)
	  public void trnsactions(String a) throws InterruptedException {
	  
	  // Generate button

			try
			{

				WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlTokennew_chzn\"]/a"));
				Thread.sleep(1000);
				
				designation.click();
				WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlTokennew_chzn\"]/div/div/input"));
				Thread.sleep(1000);

				manager.sendKeys("MLM-04/1");
				Thread.sleep(1000);

				manager.sendKeys(Keys.TAB);
			//	designation.selectByIndex(2);
				logger.info("Collector name is successfully selected");
				
			}
			
			catch(Exception e)
			{
				logger.error("Collector name is not successfully selected");
			}
	 // Amount field
			
			    	Thread.sleep(1000);

					WebElement branch =d.findElement(By.name("ctl00$cphMainContent$txtReceivedDate"));

					String amount1 =amount+1;
					String b =a;
					branch.sendKeys(amount1);
					branch.sendKeys(b);

				// Add button	
					WebElement add =d.findElement(By.name("ctl00$cphMainContent$ButtonAdd"));
					add.click();
			    }
	  
			 @Test(priority =5)
			 public void amountvalidation() throws InterruptedException
			 {
			    	Thread.sleep(1000);

					Alert alert =d.switchTo().alert();
					String alert1 ="Amount is mismatching";
					if (alert1.equals(alert.getText()))
							{
					logger.info("Amount fields are validated" );
							}
					else
					{
						logger.error("Amount fields are not validated");
					}

			// Deleting 
					 try
					    {
					    	Thread.sleep(1000);

							WebElement branch =d.findElement(By.id("cphMainContent_GView_Selected_img1_0"));

							branch.click();
							trnsactions("1250");
							logger.info("Data is deleted successfully" );
					    }
					    
					    catch(Exception e )
							{
								logger.error("Data is not deleted");
								
							
							}
					
	  }
	  
	@AfterTest()
	public void aftertest()
	{

	d.quit();	
	}
}
