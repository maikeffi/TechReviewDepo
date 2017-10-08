package com.maikeffi.deposit.interview.automate.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CHDriver {
    WebDriver chDriver = new ChromeDriver();

    public void dismiss(){
        chDriver.quit();
    }

    public WebDriver getDriver() {
        System.out.println("Initiating Chrome Webdriver");
        return  chDriver;
    }
}
