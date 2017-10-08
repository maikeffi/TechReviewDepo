package com.maikeffi.deposit.interview.automate.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FFDriver {

    WebDriver ffDriver = new FirefoxDriver();

    public void dismiss(){
        ffDriver.quit();
    }

    public WebDriver getDriver(){
        System.out.println("Initiating FireFox Webdriver");
        return ffDriver;
    }
}
