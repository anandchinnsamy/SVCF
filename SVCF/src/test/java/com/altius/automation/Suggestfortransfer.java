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

public class Suggestfortransfer {
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
	public void editauctionhover() throws InterruptedException
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

			WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/ul/li[4]/a"));
			action.moveToElement(hover).build().perform();
			logger.info("Mouse is successfully hovered on for transfer");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Mouse is not successfully hovered on for transfer screen");
		}
		Thread.sleep(2000);
		
		// Hovering view/edit screen
		try {

			WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/ul/li[4]/ul/li[1]/a"));
			action.moveToElement(hover).build().perform();
			hover.click();
			logger.info("Mouse is successfully clicked on approval screen");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Mouse is successfully  not clicked on approval screen");
		}
		Thread.sleep(2000);
		
		
	}
	

	@Test(priority=2)
	public void suggestfortransfer() throws InterruptedException
	{
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlChitGroupNo_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlChitGroupNo_chzn\"]/div/div/input"));
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
		
		// Branch name
		try
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
		}
	
	 Thread.sleep(25000);
	 
	 // Old Membere name
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlOldMember_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlOldMember_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("Visalam");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			
		//	designation.selectByIndex(2);
			logger.info("Old Member name is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Old Member name is not successfully selected");
		}
		 // New Membere name
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlNewMember_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlNewMember_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("0");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			
		//	designation.selectByIndex(2);
			logger.info("New  Member name is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("New Member name is not successfully selected");
		}
	
	//kasar amount
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtKasar"));
				pw.sendKeys("34");
				
			logger.info("Kasar amount is  successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Kasar amount is not successfully entered");

		}
		
		//Transfer amount
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtTransfer"));
				pw.sendKeys("10000");
				
			logger.info("Transfer amount is  successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Transfer amount is not successfully entered");

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
		// Commission
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtCommision"));
				pw.sendKeys("2000");
				
			logger.info("Commission  is  successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Commision is not successfully entered");

		}
		// Estimated call number
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtEstimated_DrawNo_for_Auction"));
				pw.sendKeys("2");
				
			logger.info("Estimated call number  is  successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Estimated call number is not successfully entered");

		}
		// Transfer date
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtSuggestionDate"));
				pw.sendKeys("14032019");
				
			logger.info("Transfer date  is  successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Transfer date is not successfully entered");

		}
		// Reason for transfer
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtReason"));
				pw.sendKeys("Member left the Job");
				
			logger.info("Reason for trnsfer  is  successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Reason for transfer is not successfully entered");

		}
		// Surety details
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtEstimated_Surety_Details"));
				pw.sendKeys("Having a property value of 500000");
				
			logger.info("Surety details is entered successfully");
		} 
		catch (Exception e) 
		{

			logger.error("Surety detaisl is not entered");

		}
		// Money collector
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlMonyCollector_Name_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlMonyCollector_Name_chzn\"]/div/div/input"));
			Thread.sleep(1000);

			manager.sendKeys("a");
			Thread.sleep(1000);

			manager.sendKeys(Keys.TAB);
			
			
		//	designation.selectByIndex(2);
			logger.info("Money collector is successfully selected");
			
		}
		
		catch(Exception e)
		{
			logger.error("Money collector is not  selected");
		}
	
			// profession bussiness
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$txtProfession"));
				pw.sendKeys("Staff at CRI Pvt.Ltd");
				
			logger.info("Profession bussiness is successfully entered");
		} 
		catch (Exception e) 
		{

			logger.error("Profession bussiness is not entered");

		}
		// Transfer button
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$btnTransfer"));
				pw.click();
				
			logger.info("Tansfer button is successfully clicked");
		} 
		catch (Exception e) 
		{

			logger.error("Tansfer is not clicked");

		}
		// Ok button
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$btnok"));
				pw.click();				
			logger.info("Ok button is clicked successfully");
		} 
		catch (Exception e) 
		{

			logger.error("Ok button is not clicked");

		}
		Thread.sleep(2000);
		// Final yes button
		try {
			
			String suggestion ="103 is Suggested instead of 1 Successfully for the Token MLM-04/50";
			
			
			 WebElement pw =d.findElement(By.id("cphMainContent_lblContent"));
			 
			 if(suggestion.equals(pw.getText()))
			 {
				 
			logger.info("Memeber is successfully trnsfered");
			 WebElement pw1 =d.findElement(By.name("ctl00$cphMainContent$btnok"));
			 pw1.click();
			 }
			 else
			 {
				 
				 logger.info("Member is not transfered");
			 }
		    } 
		catch (Exception e) 
		{

			logger.error("Member is not transfered");

		}
		
		
		Thread.sleep(4000);

	}
	
	
	
	@AfterTest()
	public void aftertest()
	{

	d.quit();
	}
}


