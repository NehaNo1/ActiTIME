package com.actitime.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.actitime.utility.AutoConstant;
import com.actitime.utility.BasePage;
import com.actitime.utility.ExcelLibrary;

public class ActitimeLoginPage extends BasePage implements AutoConstant
{
	public WebDriver driver;
	
	@FindBy(id = "username")
	private WebElement usernameTextfield;
	
	@FindBy(name = "pwd")
	private WebElement passwordTextfield;
	
	@FindBy(id = "loginButton")
	private WebElement loginButton;
	
	public ActitimeLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginMethod() throws InterruptedException, IOException
	{
		javascriptHighlightElement(driver, usernameTextfield);
		usernameTextfield.sendKeys(ExcelLibrary.getStringTypeCellData(sheetName, 1, 0));
		
		javascriptHighlightElement(driver, passwordTextfield);
		passwordTextfield.sendKeys(ExcelLibrary.getStringTypeCellData(sheetName, 1, 1));
		
		javascriptClick(driver, loginButton);
	}
}