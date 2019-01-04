package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {


    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    private WebElement contactsLabel;

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "surname")
    private WebElement lastName;

    @FindBy(name = "client_lookup")
    private WebElement company;

    @FindBy(xpath = "//input[@type=\"submit\" and @value=\"Save\" and @class=\"button\"]")
    private WebElement saveBtn;

    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }


    public boolean verifyContactsLabel() {
        return contactsLabel.isDisplayed();
    }


    public void selectContactsByName(String name) {
        driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']/" +
                "/preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
    }

    public void createNewContact(String title, String firstName, String lastName, String companyName) throws InterruptedException {
        Thread.sleep(3000);
        Select select = new Select(driver.findElement(By.name("title")));
        select.selectByVisibleText(title);

        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        company.sendKeys(companyName);

        saveBtn.click();

    }
}
