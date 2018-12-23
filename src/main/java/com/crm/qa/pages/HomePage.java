package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'Gaurav')]")
    private WebElement usernameLabel;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    private WebElement contactsLink;

    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    private WebElement dealsLink;

    @FindBy(xpath = "//a[contains(text(),'Tasks)]")
    private WebElement tasksLink;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
}
