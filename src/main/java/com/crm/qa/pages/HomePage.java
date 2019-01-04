package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath = "//a[contains(text(),'New Contact')]")

    private WebElement newContactLink;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public boolean verifyCorrectUserName() {
        return usernameLabel.isDisplayed();

    }

    public ContactsPage clickOnContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink(){
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksLink(){
        tasksLink.click();
        return new TasksPage();
    }

    public void clickOnNewContactLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(contactsLink).build().perform();
        newContactLink.click();

    }
}
