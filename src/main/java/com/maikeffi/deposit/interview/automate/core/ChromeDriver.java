package com.maikeffi.deposit.interview.automate.core;

import org.openqa.selenium.WebDriver;

public class ChromeDriver {

    WebDriver chDriver = new org.openqa.selenium.chrome.ChromeDriver();

    public void dismiss(){
        chDriver.quit();
    }

    public WebDriver getDriver() {
        System.out.println("Initiating Chrome Webdriver");
        //System.setProperty("webdriver.chrome.driver",manager.getProItem().getItemFromProp("chromePath"));

        return  chDriver;
    }
}
