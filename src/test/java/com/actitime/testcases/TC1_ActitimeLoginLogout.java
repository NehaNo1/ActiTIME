package com.actitime.testcases;

import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actitime.pages.ActitimeHomePage;
import com.actitime.pages.ActitimeLoginPage;
import com.actitime.utility.BaseTest;

@Listeners(com.actitime.utility.Screenshot.class)
public class TC1_ActitimeLoginLogout extends BaseTest
{
	@Test
	public void login() throws InterruptedException, IOException
	{
		ActitimeLoginPage loginPage=new ActitimeLoginPage(driver);
		loginPage.loginMethod();
	}
	
	@Test(dependsOnMethods = "login")
	public void logout() throws InterruptedException, IOException
	{
		ActitimeHomePage homePage=new ActitimeHomePage(driver);
		homePage.logoutMethod();
	}
}