package com.ebfs.testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebfs.pageObjects.BaseClass;
import com.ebfs.utilities.Constant;
import com.ebfs.utilities.ExcelUtils;
import com.ebfs.utilities.Log;
import com.ebfs.utilities.Utils;
import com.ebfs.appModules.HeaderModules;
import com.ebfs.appModules.Verify_Sell_Banner;


public class Home_Page_Scenarios {
	
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
  
  @BeforeMethod
  public void beforeMethod() throws Exception {
	    // Configuring Log4j logs
	  	DOMConfigurator.configure("log4j.xml");
	  	
	  	// Getting the Test Case name, as it will going to use in so many places
	  	// The main use is to get the TestCase row from the Test Data Excel sheet
	  	sTestCaseName = this.toString();
	  	// From above method we get long test case name including package and class name etc.
	  	// The below method will refine your test case name, exactly the name use have used
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
	  	// Start printing the logs and printing the Test Case name
		Log.startTestCase(sTestCaseName);
		
		// Setting up the Test Data Excel file using Constants variables
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		// Fetching the Test Case row number from the Test Data Sheet
		// This row number will be feed to so many functions, to get the relevant data from the Test Data sheet 
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		// Launching the browser, this will take the Browser Type from Test Data Sheet 
		driver = Utils.OpenBrowser(iTestCaseRow);
		
		// Initializing the Base Class for Selenium driver
		// Now we do need to provide the Selenium driver to any of the Page classes or Module Actions
		new BaseClass(driver);  
		
      }

  
  @Test
  public void Verif_Sell_Banner() throws Exception {
	  
	  try{
		  
		  Verify_Sell_Banner.Execute();
		  
		  
		  if(BaseClass.bResult==true){
				// If the value of boolean variable is True, then your test is complete pass and do this
				ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
			}else{
				// If the value of boolean variable is False, then your test is fail, and you like to report it accordingly
				// This is to throw exception in case of fail test, this exception will be caught by catch block below
				throw new Exception("Test Case Failed because of Verification");
			}
	  }catch(Exception e){
		  // If in case you got any exception during the test, it will mark your test as Fail in the test result sheet
		  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
		  // If the exception is in between the test, because of any element not found or anything, this will take a screen shot
		  Utils.takeScreenshot(driver, sTestCaseName);
		  // This will print the error log message
		  Log.error(e.getMessage());
		  // Again throwing the exception to fail the test completely in the TestNG results
		  throw (e);
	  }
	  
  }
  
  @Test
  public void Verify_Call_Us_Now_Span()throws Exception{
	  try {
		  	  HeaderModules.call_us_now();
		  
			  if(BaseClass.bResult == true) {
				  ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
			  }else {
				  throw new Exception("Test Case Failed because of Verification");
			  }
			  
	  }catch(Exception e){
		  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
		  Utils.takeScreenshot(driver, sTestCaseName);
		  Log.error(e.getMessage());
		  throw (e);
	  }
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }

}
