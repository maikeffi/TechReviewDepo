package com.maikeffi.deposit.interview.automate.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


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

    @FindBy(id = "user.name.error")
    public WebElement invalidUserNameMsg;

    @FindBy(id = "user.email.error")
    public WebElement invalidUserEmailMsg;

    @FindBy(id = "user.password.error")
    public WebElement passwordRequiredError;

    @FindBy(id = "user.confirmationPassword.error")
    public WebElement passwordConfirmationError;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(id = "users")
    public WebElement usersTable;

    @FindBy(xpath = "//table[@id='users']/tbody/tr")
    public List<WebElement>  userRows;

    public NewUser(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void navigateNewUserUrl(String url){
        this.webDriver.get(url);
    }

    public String getNewUserPageTitle(){
        return this.webDriver.getTitle();
    }

    public void setValuesOnPage(String name, String email, String pwd , String cnfPwd){
        userName.clear();
        userName.sendKeys(name);
        userEmail.clear();
        userEmail.sendKeys(email);
        userPassword.clear();
        userPassword.sendKeys(pwd);
        userPasswordConfirmation.clear();
        userPasswordConfirmation.sendKeys(cnfPwd);

    }

    public void setValuesOnPage(String name,String email){
        userName.clear();
        userName.sendKeys(name);
        userEmail.clear();
        userEmail.sendKeys(email);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getUserNameErrorMessage(){
        return this.invalidUserNameMsg.getText();

    }

    public String getEmailErrorMessage(){
        return this.invalidUserEmailMsg.getText();
    }

    public String getPassworNotSameErrorMessage(){
        return this.passwordConfirmationError.getText();
    }

    public String getPasswordRequiredErrorMessage(){
        return this.passwordRequiredError.getText();
    }

    public int getNumberOfRowCounts(){
        return this.userRows.size();
    }
}
