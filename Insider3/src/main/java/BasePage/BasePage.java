package BasePage;


import Utilities.ConfigReader;
import Utilities.Driver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.security.Provider;
import java.sql.DriverManager;

import static Utilities.Driver.driver;
import static Utilities.Utility.takeScreenShot;

public class BasePage {

    @Parameters({"browser"})
    @BeforeTest()
    public void initialize(@Optional String browser) {

        //PropertyConfigurator.configure("log4j.properties");
        ConfigReader.readProperties();
        Driver.setUpDriver(ConfigReader.browser);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus())
        {
            takeScreenShot(driver,result.getName());
        }

        Driver.quitDriver();
    }

}
