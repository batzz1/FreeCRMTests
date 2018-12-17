package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory or OObject Repo of Login Page
    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginBtn;

    @FindBy(xpath = "//font[contains(text(),'Sign Up')]")
    private WebElement signUpBtn;

    @FindBy(xpath = "//img[contains(@alt,'free crm logo')]")
    private WebElement crmLogo;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateCRMImage() {
        return crmLogo.isDisplayed();
    }

    public HomePage login(String username, String passworrd) {
         this.username.sendKeys(username);
         this.password.sendKeys(passworrd);
         loginBtn.click();
         return new HomePage();
    }
}
