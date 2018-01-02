package com.maikeffi.deposit.interview.automate.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllUserPage extends AbstractPageObject {
    public AllUserPage(WebDriver webDriver) {
        super(webDriver, "getAllUsersUrl");
    }
}
