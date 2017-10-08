package com.maikeffi.deposit.interview.automate.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NewUser {

    WebDriver webDriver;

    @FindBy(id="name")
    public WebElement userName;

    @FindBy(id = "email")
    public WebElement userEmail;

    @FindBy(id = "password")
    public WebElement userPassword;

    @FindBy(id = "confirmationPassword")
    public WebElement userPasswordConfirmation;

    @FindBy(id = "user.email.error")
    public WebElement invalidUserEmailMsg;

    @FindBy(id = "user.confirmationPassword.error")
    public WebElement passwordConfirmationError;

    public NewUser(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void navigateNewUserUrl(String url){
        this.webDriver.get(url);
    }
}
