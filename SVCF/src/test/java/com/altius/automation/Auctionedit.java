package com.altius.automation;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Auctionedit {

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

			WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/ul/li[2]/a"));
			action.moveToElement(hover).build().perform();
			logger.info("Mouse is successfully hovered on screen ''");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Mouse is not successfully hovered on screen 'auction'");
		}
		Thread.sleep(2000);
		// Hovering view/edit screen
		try {

			WebElement hover = d.findElement(By.xpath("//*[@id=\"smoothmenu_h\"]/ul/li[3]/ul/li[2]/ul/li[3]/a"));
			action.moveToElement(hover).build().perform();
			hover.click();
			logger.info("Mouse is successfully clicked on screen auction Edit screen");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Mouse is successfully  not clicked on screen auction Edit screen");
		}
		Thread.sleep(2000);
		
		
	}
	@Test(priority =2)
	public void auctionsearch() throws InterruptedException
	{

		// editauction screen
		Actions action = new Actions(d);

			WebElement hover = d.findElement(By.name("ctl00$cphMainContent$gridBranch$DXFREditorcol8"));
			hover.sendKeys("sree");
			Thread.sleep(5000);
			String auction ="Sree Visalam Chit Fund Ltd";
			WebElement emp = d.findElement(By.xpath("//*[@id=\"cphMainContent_gridBranch_DXDataRow0\"]/td[5]"));
			if(auction.equals(emp.getText()))
			{
			logger.info("Auction is searched successfully");
			}
			else
			{
				logger.error("Auction is not searched successfully");
				
			}
	}
	@Test(priority =3)
	public void auctionupdate() throws InterruptedException
	{
		// Clicking the edit button
		try {
           Thread.sleep(2000);
			WebElement hover = d.findElement(By.xpath("//*[@id=\"cphMainContent_gridBranch_DXDataRow0\"]/td[1]/img"));
			hover.click();
			logger.info("Edit button is clicked successfully");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Edit button is not clicked successfully");
			
		}
		Actions action = new Actions(d);
       Thread.sleep(8000);
       
       // Next due amount 
		try {

			WebElement hover = d.findElement(By.id("cphMainContent_gridBranch_ef0_NextDueAmount_0_I"));
			hover.click();
			hover.clear();
			hover.sendKeys("7000");
			logger.info("Due amount is successfully entered");
		
		   }
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Due amount is not entered");
		}

		// Clicking the update button
				try {
		           Thread.sleep(2000);
					WebElement hover = d.findElement(By.xpath("//*[@id=\"cphMainContent_gridBranch_DXEFC\"]/div/img[1]"));
					hover.click();
					logger.info("Update button is clicked successfully");
				}
				catch (Exception e)
				{
					logger.error(e);
					logger.error("Update button is not clicked successfully");
					
				}
		
	// Cancel button
		Thread.sleep(5000);
		d.findElement(By.xpath("//*[@id=\"cphMainContent_gridBranch_DXEFC\"]/div/img[2]")).click();
	
		// clicking the edit buttto again
		Thread.sleep(5000);

		try {

			WebElement hover = d.findElement(By.xpath("//*[@id=\"cphMainContent_gridBranch_DXDataRow0\"]/td[1]/img[1]"));
			hover.click();
			logger.info("Edit button is successfully clicked");
		}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Edit button is not successfully clicked");
		}
		
		Thread.sleep(4000);

	// veryfying the due amount
		try {
			WebElement hover = d.findElement(By.id("cphMainContent_gridBranch_ef0_NextDueAmount_0_I"));
			String SR="7000.00";
			System.out.println("the text is :"+hover.getText());
			if(SR.equals(hover.getText()))
			{
			logger.info("Auction is successfully updated by changing the due amount");
			
			d.findElement(By.xpath("//*[@id=\"cphMainContent_gridBranch_DXEFC\"]/div/img[2]")).click();

		  }
			}
		catch (Exception e)
		{
			logger.error(e);
			logger.error("Auction is not updated ");
		}
	
	}
	
	

	@AfterTest()
	public void aftertest()
	{

	d.quit();
	}
}
