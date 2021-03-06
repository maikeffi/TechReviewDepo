package com.maikeffi.deposit.interview.automate.page;

import com.maikeffi.deposit.interview.automate.model.UserForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class NewUserPage extends AbstractPageObject {

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

    public NewUserPage(WebDriver webDriver) {
        super(webDriver, "newUserUrl");
    }

    public String getNewUserPageTitle(){
        return this.webDriver.getTitle();
    }

    public void setValuesOnPage(UserForm userForm){
        enterValuesInTextBox(userName,userForm.getName());
        enterValuesInTextBox(userEmail,userForm.getEmail());
        enterValuesInTextBox(userPassword,userForm.getPassword());
        enterValuesInTextBox(userPasswordConfirmation,userForm.getCnfPassword());
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

    public String getErrorMessageByType(String type){
        String errorMessage = "";
        if (type.equals("name")){
            errorMessage = getUserNameErrorMessage();
        } else if (type.equals("email")){
            errorMessage = getEmailErrorMessage();
        } else if (type.equals("password confirmation")){
            errorMessage = getPassworNotSameErrorMessage();
        }else if (type.equals("password")){
            errorMessage = getPasswordRequiredErrorMessage();
        }

        return errorMessage;
    }

    public void  setValuesOnFormExceptType(String one,String two,String type){

        if (type.equals("password")){
            setValuesOnExceptPassword(one,two);
        }else if (type.equals("name")){
            setValuesOnExceptName(one,two);
        }else if (type.equals("email")){
            setValuesOnExceptEmail(one,two);
        }

    }

    private void enterValuesInTextBox(WebElement element,String value){
        if(value!=null){
            element.clear();
            element.sendKeys(value);
        }


    }

    private void setValuesOnExceptPassword(String name,String email){
        enterValuesInTextBox(userName,name);
        enterValuesInTextBox(userEmail,email);
    }
    private void setValuesOnExceptName(String email,String pwd){
        enterValuesInTextBox(userEmail,email);
        enterValuesInTextBox(userPassword,pwd);
        enterValuesInTextBox(userPasswordConfirmation,pwd);
    }

    private void setValuesOnExceptEmail(String name,String pwd){
        enterValuesInTextBox(userName,name);
        enterValuesInTextBox(userPassword,pwd);
        enterValuesInTextBox(userPasswordConfirmation,pwd);
    }


}
