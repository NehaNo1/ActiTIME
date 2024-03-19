package com.actitime.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest implements AutoConstant
{
	public static WebDriver driver;
	public Properties prop;
	
	@Parameters("browser")
	
	@BeforeClass
	public void setup(String browser) throws IOException
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			FileInputStream fis=new FileInputStream(propertiesPath);
			prop=new Properties();
			prop.load(fis);
			driver.get(prop.getProperty("url"));
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			FileInputStream fis=new FileInputStream(propertiesPath);
			prop=new Properties();
			prop.load(fis);
			driver.get(prop.getProperty("url"));
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			FileInputStream fis=new FileInputStream(propertiesPath);
			prop=new Properties();
			prop.load(fis);
			driver.get(prop.getProperty("url"));
		}
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}