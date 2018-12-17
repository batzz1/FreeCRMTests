package com.crm.qa.tests;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    //This Constructor calls TestBase Class Constructor
    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
         loginPage = new LoginPage();
    }

    @Test
    public void loginPageTitleTest() {
        String pageTitle = loginPage.validateLoginPageTitle();
        Assert.assertEquals(pageTitle,"");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
