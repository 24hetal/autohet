package org.example;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager extends Utils {

    String browserName ="Chrome";
    public void startOfBrowser(){

        if (browserName.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webDriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webDriver.gecko.driver","src/test/java/drivers/geckodriver.exe" );
            driver= new FirefoxDriver();
        }

        //open chrome browser
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
    //close browser
    public void closeTheBrowser(){
        driver.quit();
    }

}





