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

public class Allocationforremoval {
	WebDriver d;
    Logger logger =Logger.getLogger(Auctionedit.class);
    
    @BeforeTest
    public void beforetest() throws InterruptedException
    {
    	PropertyConfigurator.configure("log4jproperties.txt");

    	System.setProperty("webdriver.chrome.driver", "../SVCF/src/test/resources/chromedriver.exe");
    	d = new ChromeDriver();
	    d.get("http://182.72.104.66:8080/SVCF/Login.aspx#");
	    Thread.sleep(2000);
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

		}        WebElement click=d.findElement(By.name("btnlogin"));
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
public void trnsferallocation() throws InterruptedException
{

	// editauction screen
	Actions action = new Actions(d);

	try {

		WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/a"));
		action.moveToElement(hover).build().perform();
		logger.info("Mouse is successfully hovered on module 'Group and confidential report'");
	}
	catch (Exception e)
	{
		logger.error(e);
		logger.error("Mouse is not successfully hovered on module 'Group and confidential report'");
	}
	  //  Hover on auction
	Thread.sleep(2000);

	try {

		WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/ul/li[5]/a"));
		action.moveToElement(hover).build().perform();
		logger.info("Mouse is successfully hovered on for removal screen");
	}
	catch (Exception e)
	{
		logger.error(e);
		logger.error("Mouse is not successfully hovered on  removal screen");
	}
	Thread.sleep(2000);
	
	// Hovering view/edit screen
	try {

		WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/ul/li[5]/ul/li[3]/a"));
		action.moveToElement(hover).build().perform();
		hover.click();
		logger.info("Mouse is successfully clicked on removal allocation screen");
	    }
	catch (Exception e)
	{
		logger.error(e);
		logger.error("Mouse is successfully  not clicked on removal allocation screen");
	}
	Thread.sleep(2000);
	
	
	}
@Test(priority=2)
public void transferforallocation() throws InterruptedException
{
	try
	{

		WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlGrpID_chzn\"]/a"));
		Thread.sleep(1000);
		
		designation.click();
		WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlGrpID_chzn\"]/div/div/input"));
		Thread.sleep(1000);

		manager.sendKeys("Chitgroup");
		Thread.sleep(1000);

		manager.sendKeys(Keys.TAB);
		
		
	//	designation.selectByIndex(2);
		logger.info("Chit group is successfully selected");
		
	}
	
	catch(Exception e)
	{
		logger.error("Chit group is not successfully selected");
	}
	Thread.sleep(2000);
	// Token
	try
	{

		WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlGrpMemberID_chzn\"]/a"));
		Thread.sleep(1000);
		
		designation.click();
		WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlGrpMemberID_chzn\"]/div/div/input"));
		Thread.sleep(1000);

		manager.sendKeys("Chitgroup");
		Thread.sleep(1000);

		manager.sendKeys(Keys.TAB);
		
		
	//	designation.selectByIndex(2);
		logger.info("Token is successfully selected");
		
	}
	
	catch(Exception e)
	{
		logger.error("Token is not successfully selected");
	}
	
	
	
	// Member name
	Thread.sleep(2000);
	try
	{

		WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlMemberName_chzn\"]/a"));
		Thread.sleep(1000);
		
		designation.click();
		WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlMemberName_chzn\"]/div/div/input"));
		Thread.sleep(1000);

		manager.sendKeys("pushpam");
		Thread.sleep(1000);

		manager.sendKeys(Keys.TAB);
		
		
	//	designation.selectByIndex(2);
		logger.info("Member name is successfully selected");
		
	}
	
	catch(Exception e)
	{
		logger.error("Member name is not successfully selected");
	}
	
	
	
	// card
		Thread.sleep(2000);
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlNoCard_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlNoCard_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("yes");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			
		//	designation.selectByIndex(2);
			logger.info("Card is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Card is not successfully selected");
		}
		
		//Sunstited date
		
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$txtSubstitutionDate"));
			hover.sendKeys("14032019");
			logger.info("Substituted date is successfully entered");
		    }
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Sunstituted date is not entered");
		}
		
	//Subscriber date
		
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$txtIntimationDate"));
			hover.sendKeys("14032019");
			logger.info("Intimation date date is successfully entered");
		    }
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Intimation date date is not entered");
		}
		Thread.sleep(2000);
		// Nominee details
		try {

			 d.findElement(By.id("cphMainContent_GridGuardians_chkNominee_0")).click();
		
			logger.info("Nominne details is successfully entered");
		    }
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Nominne details is not entered");
		}
		
		// Assign button
		
		try {

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$AddChit"));
			hover.click();
			logger.info("Assign button is clicked successfully");
		    }
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Assign button is not get clicked");
		}
Thread.sleep(3000);

//final status
	String status ="Approval Finished Successfullly!!!";
	
	WebElement sts =d.findElement(By.id("cphMainContent_lblMsgInfoContent"));
	
	if(status.equals(sts.getText()))
	{
		
		d.findElement(By.name("ctl00$cphMainContent$btnInfo_yes")).click();
		
		logger.info("Assigned successfully");
	}
	else
	{
		
		logger.error("Not assigned");
	}
}


	@AfterTest()
	public void aftertest() 
	{

		d.quit();
	}
}

