package org.example;
;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

    public class BaseTest extends Utils {

DriverManager driverManager = new DriverManager();
        @BeforeMethod
        public void setUp()
        {
            driverManager.startOfBrowser();
        }
        @AfterMethod
        public void tearDown(ITestResult result) throws Exception {
            if(!result.isSuccess())
            {
                takeSnapShot(result.getName());
            }
            driverManager.closeTheBrowser();
        }

    }



