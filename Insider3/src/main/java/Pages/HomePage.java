package Pages;

import static Utilities.ConfigReader.homePage;
import static Utilities.Driver.driver;

public class HomePage {

    public static void goToHomePage(){

        driver.navigate().to(homePage);

    }
}
