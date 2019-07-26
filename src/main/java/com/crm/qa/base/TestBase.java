package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public  static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;


    public TestBase() {

        try {

            prop = new Properties();
            FileInputStream ip = new FileInputStream("/home/cerber/IdeaProjects/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {

        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
            driver = new ChromeDriver();

//            String chromeDriverPath = "/usr/bin/chromedriver";
//            String chromeDriverPath = "/usr/local/bin/chromedriver";
//            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//            driver = new ChromeDriver();

        }
        else if(browserName.equals("FF")){
//            System.setProperty("webdriver.gecko.driver","/User/geckodriver");
            driver = new FirefoxDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        Dimension dimension = new Dimension(1920, 1080);
        driver.manage().window().setSize(dimension);

//т.к. существует баг для такогоразрешения экрана        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }

}
