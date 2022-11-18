package Pages;

import Utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static Utilities.Driver.driver;
import static Utilities.Utility.*;

public class JobDetailsPage {

    public static By locationFilterElement=  By.id("select2-filter-by-location-container");
    public static By totalResultValue= By.cssSelector("span[class='totalResult']");
    public static By jobTitleElement= By.cssSelector("span[class='position-department text-large font-weight-600 text-primary']");
    public static By jobLocationElement= By.cssSelector("div[class='position-location text-large']");
    public static By control=  By.xpath("(//div[@class='position-list-item col-12 col-lg-4 qualityassurance istanbul-turkey full-timeremote'])[2]");
    public static By applyNowElement= By.xpath("(//*[text()='Apply Now'])[2]");

    public static void goJobDetails(){

        clickElement(locationFilterElement);
        Select select = new Select(driver.findElement(By.name("filter-by-location")));
        select.selectByVisibleText(ConfigReader.jobLocation);


        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,600)");
        clickElement(control);

        String textElement = getText(totalResultValue);
        Integer count = Integer.valueOf(textElement);


        for (int i=0; i<count; i++)
        {
            Assert.assertEquals(getText(jobTitleElement), ConfigReader.jobTitle);
            Assert.assertEquals(getText(jobLocationElement),ConfigReader.jobLocation);
        }

        if (count != 0) {
            clickElement(applyNowElement);

            switchToNewTab();

            Assert.assertTrue(getLeverUrlControl());
        }
    }
}
