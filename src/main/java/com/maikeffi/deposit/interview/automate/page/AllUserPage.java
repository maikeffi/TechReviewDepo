package com.maikeffi.deposit.interview.automate.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllUserPage {

    WebDriver webDriver;

    @FindBy(id = "users")
    public WebElement usersTable;

    @FindBy(xpath = "//table[@id='users']/tbody/tr")
    public List<WebElement> userRows;

    @FindBy(xpath = "//table[@id='users']/tbody/tr/td")
    public WebElement noUserRow;


    public AllUserPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public int getNumberOfRowCounts(){
        return this.userRows.size();
    }
    public String getNoUserText(){
        return noUserRow.getText();
    }
}
