package com.crm.qa.tests;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    //This Constructor calls TestBase Class Constructor
    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String pageTitle = loginPage.validateLoginPageTitle();
        Assert.assertEquals(pageTitle,"#1 Free CRM software in the cloud for sales and service");
    }

    @Test(priority = 2)
    public void crmLogoImageTest() {
        boolean validateCRMImage = loginPage.validateCRMImage();
        Assert.assertTrue(validateCRMImage);
    }

    @Test(priority = 3)
    public void loginTest() throws InterruptedException {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
