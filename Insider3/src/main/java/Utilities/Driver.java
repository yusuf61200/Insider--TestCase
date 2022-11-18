package Utilities;

import Utilities.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.time.Duration;

public class Driver {

    public static WebDriver driver = null;

    public static void setUpDriver(String browserType){
        switch (browserType){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.defaultTimeout));
    }

    public static void quitDriver(){
        if (driver != null){
            driver.close();
            driver.quit();
        }
    }
}
