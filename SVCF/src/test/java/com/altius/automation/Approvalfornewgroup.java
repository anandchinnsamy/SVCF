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

public class Approvalfornewgroup {
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

			WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/ul/li[3]/ul/li[2]/a"));
			action.moveToElement(hover).build().perform();
			hover.click();
			logger.info("Mouse is successfully clicked on new group approval screen");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Mouse is successfully  not clicked on new group approval screen");
		}
		Thread.sleep(2000);
		
		
	}
	
	@Test(priority=2)
	public void suggestforapproval() throws InterruptedException
	{
		try
		{

			WebElement designation =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlChitGroup_chzn\"]/a"));
			Thread.sleep(1000);
			
			designation.click();
			WebElement manager =d.findElement(By.xpath("//*[@id=\"cphMainContent_ddlChitGroup_chzn\"]/div/div/input"));
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
		
		// Load memebers
		
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$btnLoad"));
				pw.click();
				
			logger.info("load members is clicked successfully");
		} 
		catch (Exception e) 
		{

			logger.error("load members is not clicked");

		}
		
		// Approval button
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$GridView1$ctl02$btnReject"));
				pw.click();
				
			logger.info("Approve button is clicked sucessfully");
		} 
		catch (Exception e) 
		{

			logger.error("Approve button is not clicked");

		}
		
		// clicking yes button
		try {
			 WebElement pw =d.findElement(By.name("ctl00$cphMainContent$btnInfo_yesnot"));
				pw.click();
				
			logger.info("Yes button is clicked sucessfully");
		} 
		catch (Exception e) 
		{

			logger.error("Yes button is not clicked");

		}
		
		
		// final status
		String status ="Approval Finished Successfullly!!!";
		
		WebElement sts =d.findElement(By.id("cphMainContent_lblMsgInfoContent"));
		
		if(status.equals(sts.getText()))
		{
			
			d.findElement(By.name("ctl00$cphMainContent$btnInfo_yes")).click();
			
			logger.info("New group is approved successfully");
		}
		else
		{
			
			logger.error("New group is not approved");
		}
		
		
		
		
		
		
		
}
	@AfterTest()
	public void aftertest()
	{

	d.quit();
	}
}

