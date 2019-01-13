package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebDriverListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebDriverEventListener eventListener;

    public TestBase() {

        try {
              prop = new Properties();
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")
                    + "/src/main/java/com/crm/qa/config/config.properties");
            prop.load(fileInputStream);
        }
        catch(FileNotFoundException fNException) {
            fNException.printStackTrace();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    public static void initialization() {
        String browser = prop.getProperty("browser");
        if(browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebDriverListener();
        e_driver.register(eventListener);
        driver = e_driver;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }
}
