package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import static Utilities.Utility.*;

public class CareerPage {

    public static By acceptCookies= By.cssSelector("a[id='wt-cli-accept-all-btn']");
    public static By moreTabElement= By.xpath("//*[text()='More']");
    public static By clickCareersElement= By.xpath("//h5[contains(text(),'Careers')]");
    public static By teamsElement= By.cssSelector("div[data-id='b6c45b2']");
    public static By locationElement= By.cssSelector("div[data-id='b1a909d']");
    public static By lifeAtInsiderElement= By.cssSelector("div[data-id='87842ec']");
    public static By allTeamsElement= By.xpath("//*[text()='See all teams']");
    public static By qualityElement=  By.xpath("//*[text()='Quality Assurance']");
    public static By allQaJobElement=  By.xpath("//*[text()='See all QA jobs']");

    public static void goToCareerPageControl(){

        clickElement(acceptCookies);
        clickElement(moreTabElement);
        clickElement(clickCareersElement);
        Assert.assertTrue(getCareerPageControl());
        Assert.assertTrue(isElementVisible(teamsElement));
        Assert.assertTrue(isElementVisible(locationElement));
        Assert.assertTrue(isElementVisible(lifeAtInsiderElement));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,2500)");

        waitBySeconds(2);
        clickElement(allTeamsElement);

        js.executeScript("window.scrollBy(0,1800)");
        waitBySeconds(2);
        clickElement(qualityElement);

        clickElement(allQaJobElement);

    }
}
