package com.crm.qa.tests;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitleTest() {
        String title = homePage.verifyHomePageTitle();
        Assert.assertEquals(title, "CRMPRO" , "Home Page Title does not match");
    }

    @Test(priority = 2)
    public void verifyUserNameTest() {
        testUtil.switchToFrame();
        Assert.assertTrue(homePage.verifyCorrectUserName(),"UserName not matched");
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest() {
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
