package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Utility extends Driver{

    public static void takeScreenShot(WebDriver driver, String screenshotName){
        try {
            TakesScreenshot screenshot = ((TakesScreenshot)driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("./screenshots/" + screenshotName + ".png"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static boolean getHomePageControl(){
        return driver.getCurrentUrl()
                .equals(ConfigReader.homePage);
    }

    public static boolean getCareerPageControl(){
        return driver.getCurrentUrl()
                .contains(ConfigReader.careerUrl);
    }

    public static boolean getLeverUrlControl(){
        return driver.getCurrentUrl()
                .contains(ConfigReader.jobsLeverUrl);
    }

    public static void switchToNewTab(){
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static WebElement waitElementVisible(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return webElement;
    }

    public static boolean clickElement(By element){
        boolean isClick = false;
        try
        {
            waitElementVisible(element).click();
            isClick = true;
        }
        catch (Exception e)
        {

            isClick = false;
        }
        return isClick;
    }

    public static boolean isElementVisible(By element){
        boolean isVisible = false;
        try
        {
            isVisible = waitElementVisible(element).isDisplayed();
        }
        catch (Exception e)
        {

            isVisible = false;
        }
        return isVisible;
    }
    public static String getText(By element){
        try
        {
            isElementVisible(element);
            String text = driver.findElement(element).getText();
            return text;
        }
        catch (Exception e)
        {

            return null;
        }
    }

    public static void waitBySeconds ( int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
