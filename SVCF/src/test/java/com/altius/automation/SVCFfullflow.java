package com.altius.automation;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.xpath.functions.FunctionDef1Arg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SVCFfullflow 
{ 
	 WebDriver d;
	 
	    Logger logger =Logger.getLogger(SVCFfullflow.class);
	    
	    @BeforeTest
	    public void methods() throws InterruptedException
	    {
	    
		
			
	    }
	    
	    @Test
	    public void test1() throws InterruptedException 
	    {

	    	   {
	   	    	CRR ga = new CRR();
	   	    	 
	   	    	 ga.methods();
	  	         ga.groupadditionhover1();
	   	    	 ga.groupaddition();
	   	    	 ga.fdrandpsdhover();
	   	    	 ga.addfdrandpsodetails();
	   	    	 ga.aggrementhover();
	   	   	 ga.agreementauctiondetails();
	   	    	 
	   	    	 ga.subscriberhover();
	   	    	 ga.Aadharaddition();
	   	    	 ga.editauctionhover1();
	   	    	 ga.suggestfornewgroup();
	   	    	 
	   	    	 ga.editauctionhover();
	   	    	 
	   	    	 ga.suggestforapproval();
		   	    	 
	   	    	 ga.newgroupallocationhover();
	   	    	 ga.newgroupallocation();
	   	    	 
	   	  	   ga.foremanpaymenthover();
	   	    	 ga.foremanpayment();
	   	    	 ga.auctionhover();
	   	    	 ga.auction();
	   	    	 ga.paymenthover();
	   	    	 ga.payment();
	   	    	 

	   	    	 
	   	    	ga.Transactionshover9();
	   	    	ga.CRRinsert1();

	   	    	ga.transactions1();
	   	    	ga.afterclass();
	   	    }
	    }
	    
	
    
	
}
	
	 
	
	