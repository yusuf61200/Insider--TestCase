import BasePage.BasePage;
import Utilities.Utility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.CareerPage.goToCareerPageControl;
import static Pages.HomePage.goToHomePage;
import static Pages.JobDetailsPage.goJobDetails;

public class InsiderTest extends BasePage {

    @BeforeMethod()
    public void openHomePage(){
        goToHomePage();
        Assert.assertTrue(Utility.getHomePageControl());

    }

    @Test()
    public void casesCareerPage(){
        goToCareerPageControl();
        goJobDetails();
    }
}
