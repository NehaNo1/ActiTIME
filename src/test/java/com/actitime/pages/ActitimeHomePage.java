package com.actitime.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utility.BasePage;

public class ActitimeHomePage extends BasePage
{
	public WebDriver driver;
	
	@FindBy(id = "logoutLink")
	private WebElement logoutLink;
	
	public ActitimeHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logoutMethod() throws InterruptedException, IOException
	{
		javascriptHighlightElement(driver, logoutLink);
		javascriptClick(driver, logoutLink);
	}
}