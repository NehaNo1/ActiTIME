package com.actitime.utility;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Screenshot implements ITestListener
{
	public void onTestFailure(ITestResult result) 
	{
		TakesScreenshot ts=(TakesScreenshot)BaseTest.driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		
		//returns the status of the test method
		if(result.getStatus()==1)
			System.out.println(" Test case is SUCCESS");
		else if(result.getStatus()==2)
				System.out.println("Test case is FAILURE");
		else if(result.getStatus()==3)
			System.out.println("Test case is SKIPPED");
		
		//returns the method that got failed
		String name = result.getName();
		
		//fetch the date and time of failure
		Date date = Calendar.getInstance().getTime();
		String today=date.toString().replaceAll(":", "-");
		
		File destFile = new File("./failedscreenshot/" +name+today+ ".png");
		try 
		{
			FileHandler.copy(srcFile, destFile);
		}
		catch (IOException e) 
		{
			
		}
	}
}