package com.maikeffi.deposit.interview.test.runner;

import com.maikeffi.deposit.interview.automate.manager.Manager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.commons.lang3.SystemUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/"},
        format = {"pretty", "html:target/reports/cucumber/html", "json:target/reports/cucumber/all_tests.json", "junit:target/reports/junit/all_tests.xml"},
        glue = {"com.maikeffi.deposit.interview.test.steps"},
        tags = {"@NewUser"})

public class PortalTest {

    public static Manager manager = new Manager();

    @BeforeClass
    public static void setUp(){
        String browser = manager.getProItem().getItemFromProp("webBrowser");
        manager.getUserClient().deleteAll();
        if (browser.equals("chrome") && SystemUtils.IS_OS_WINDOWS){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+manager.getProItem().getItemFromProp("chromeDriverPathWindows"));
        }else if (browser.equals("chrome") && SystemUtils.IS_OS_LINUX) {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+manager.getProItem().getItemFromProp("chromeDriverPathLinux"));
        }else if (browser.equals("chrome") && SystemUtils.IS_OS_MAC_OSX){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+manager.getProItem().getItemFromProp("chromeDriverPathMac"));
        }
    }

    @AfterClass
    public static void tearDown(){
        manager.kill();
    }


}
