package com.ebfs.appModules;

import org.testng.Reporter;

import com.ebfs.pageObjects.BaseClass;
import com.ebfs.pageObjects.Home_Page;

public class HeaderModules {

	
	public static void call_us_now()throws Exception {
		
		if(Home_Page.span_call_us_now() !=null) {
			BaseClass.bResult=true;
			Reporter.log("Verification Passed for Span Call us Now on Home page.");
			
		}else{
			BaseClass.bResult=false;
			Reporter.log("Verification Failed for Span Call us Now on Home page.");
     		
		}
		
	}
}
