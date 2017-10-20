package com.ebfs.utilities;

public class Constant {
	
	public static String workingDir = System.getProperty("user.dir");
	
	public static final String URL = "http://ebfs.bruteforcesolution.net/ebfs/index.php";
    public static final String Username = "testuser_1";
    public static final String Password ="Test@123";
	public static final String Path_TestData = workingDir + "//src//test//java//com//ebfs//testData//";
	public static final String File_TestData = "TestData.xlsx";
	
	
	//Test Data Sheet Columns
	public static final int Col_TestCaseName = 0;	
	public static final int Col_UserName =1 ;
	public static final int Col_Password = 2;
	public static final int Col_Browser = 3;
	public static final int Col_ProductType = 4;
	public static final int Col_ProductNumber = 5;
	public static final int Col_Result = 6;
	public static final String Path_ScreenShot = workingDir +"//src//test//java//com//ebfs//ScreenShots//";
			
}
