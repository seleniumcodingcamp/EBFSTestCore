package com.ebfs.appModules;

import org.testng.Reporter;

import com.ebfs.pageObjects.BaseClass;
import com.ebfs.pageObjects.Home_Page;

public class Verify_Sell_Banner {
	public static void Execute() throws Exception{
		
		if(Home_Page.lnk_Sale() != null){
			
			BaseClass.bResult=true;
			Reporter.log("Verification Passed for Sale Banner on Home page.");
			
		}else{
			BaseClass.bResult=false;
			Reporter.log("Verification Failed for Sale Banner on Home page.");
     		
		}
		
	}
}
