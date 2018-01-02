package com.maikeffi.deposit.interview.automate.manager;

import com.maikeffi.deposit.interview.automate.utils.UserClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Manager {
    private static Manager manager;
    private WebDriver driver;
    private UserClient userClient;
    private Properties properties;

    public Manager() {
        properties = new Properties();
        loadProperties();
    }

    public static Manager getManager() {
        if (manager == null){
            manager = new Manager();
        }
        return manager;
    }

    public WebDriver getDriverForBrowser(String browser) {
        if (driver != null) {
            return driver;
        }
        switch (browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    private void loadProperties() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("elements.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Properties cannot be loaded.");
            e.printStackTrace();
        }
    }

    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public UserClient getUserClient() {
        if (userClient == null){
            userClient = createClient(UserClient.class, getManager().getProperty("baseUrl"));
        }
        return userClient;
    }

    private static  <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                //.logger(new Slf4jLogger(type))
                //.logLevel(Logger.Level.FULL)
                .target(type, uri);
    }
}
