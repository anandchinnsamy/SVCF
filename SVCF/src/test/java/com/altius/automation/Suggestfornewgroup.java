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

public class Suggestfornewgroup extends Subscriberaddition
{
	// WebDriver d;
	    Logger logger =Logger.getLogger(Auctionedit.class);
	    
	    @BeforeTest
	    public void beforetest5() throws InterruptedException
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
	public void editauctionhover1() throws InterruptedException
	{
        Thread.sleep(15000);
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

			WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/ul/li[3]/a"));
			action.moveToElement(hover).build().perform();
			logger.info("Mouse is successfully hovered on screen for new group");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Mouse is not successfully hovered on screen for new group");
		}
		Thread.sleep(2000);
		
		// Hovering view/edit screen
		try {

			WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/ul/li[3]/ul/li[1]/a"));
			action.moveToElement(hover).build().perform();
			hover.click();
			logger.info("Mouse is successfully clicked on screen suggest screen");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Mouse is successfully  not clicked on screen suggest screen");
		}
		Thread.sleep(2000);
		
		
	}
	

	@Test(priority=2)
	public void suggestfornewgroup() throws InterruptedException
	{
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlChitGroup_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlChitGroup_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys(a);
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			
		//	designation.selectByIndex(2);
			logger.info("Chit group is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Chit group is not successfully selected");
		}
		
		// Branch name
		/*try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlBranchName_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlBranchName_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("Coimbatore");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			
		//	designation.selectByIndex(2);
			logger.info("Branch name is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Branch is not successfully selected");
		}*/
	
	 Thread.sleep(5000);
	 
	 // Membere name
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlMembName_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlMembName_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys(name);
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			
		//	designation.selectByIndex(2);
			logger.info("Member name is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Member name is not successfully selected");
		}
	
	
	// No of tolens
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtNoofTokens"));
				pw.sendKeys("1");
				
			logger.info("No of tokens is  successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("No of tokens is not successfully entered");

		}
		
		// Income(mobthly)
		
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtIncome"));
				pw.sendKeys("2000");
				
			logger.info("Income  is  successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Income is not successfully entered");

		}
		// Money collector
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlMoneyCollector_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlMoneyCollector_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("office");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			
		//	designation.selectByIndex(2);
			logger.info("Money collector is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Money collector is not  selected");
		}
	
		// Est.call.no.auction
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtEstCallNoofAuction"));
				pw.sendKeys("2");
				
			logger.info("Call no of auction  is  successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Call no of auction is not entered");

		}
		// Ect.surety document
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtEstSuretyDocument"));
				pw.sendKeys("Having 4 ground property");
				
			logger.info("Call no of auction is successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Call no of auction is not entered");

		}
		// Suggest button
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtMcDesc"));
				pw.sendKeys("Suggesting member to chit");
				
			logger.info("Description is successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Description is not entered");

		}
		// DEscription
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$btnSuggest"));
				pw.click();				
			logger.info("Suggest button is clicked successfully");
		} 
		catch (Exception e) 
		{

			logger.error("Suggest button is not clicked");

		}
		Thread.sleep(2000);
		// Final yes button
		/*try {
			
			String suggestion ="You Have successFully Suggested Mr/Ms./Mrs :K. Ramasamy|288, 9th Block, C.M.C Colony, V.H. Road, Coimbatore-641001";
			
			
			 WebElement pw =d.findElement(By.id("cphMainContent_lblContent"));
			 
			 if(suggestion.equals(pw.getText()))
			 {
			logger.info("Memeber is successfully suggested");
			 WebElement pw1 =d.findElement(By.name("ctl00$cphMainContent$Button1"));
			 pw1.click();
			 }
			 else
			 {
				 
				 logger.info("Member is not suggested");
			 }
		    } 
		catch (Exception e) 
		{

			logger.error("Member is not suggested");

		}
		
		*/

		 WebElement pw1 =d.findElement(By.name("ctl00$cphMainContent$Button1"));
		 pw1.click();
		logger.info("Memeber is successfully suggested");
		
	}
	
	
	
	@AfterTest()
	public void aftertest()
	{

	d.quit();
	}
}

