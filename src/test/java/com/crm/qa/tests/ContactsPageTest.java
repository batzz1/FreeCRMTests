package com.crm.qa.tests;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    String sheetName = "Contacts";

    public ContactsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        testUtil = new TestUtil();
        contactsPage = new ContactsPage();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }


    @Test(priority = 1)
    public void verifyContactsPageLabel() {
        Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contact Label is missing on the Page");
    }


    @Test(priority = 2)
    public void selectContactTest() {
        contactsPage.selectContactsByName("John Doe");
        contactsPage.selectContactsByName("Test Mahajan");
    }

    @DataProvider
    public Object[][] getCRMTestData() {
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 3, dataProvider = "getCRMTestData")
    public void validateCreateNewContact() throws InterruptedException {
        homePage.clickOnNewContactLink();
        contactsPage.createNewContact("Mr.", "Pankul", "Gupta", "TCS");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
