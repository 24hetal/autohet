package org.example;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager extends Utils {

    String browserName ="chrome";

    public void startOfBrowser(){

        //Chrome
        if(browserName.equalsIgnoreCase("Chrome")) {
            //Open Chrome
            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
            driver = new ChromeDriver();  // import chrome web-Driver dependency (In 'POM' file)

        }else if(browserName.equalsIgnoreCase("Firefox")){

            System.setProperty("webdriver.gecko.driver","src/test/java/drivers/geckodriver.exe");
            driver= new FirefoxDriver();

            //Edge
        }else if(browserName.equalsIgnoreCase("Edge")){
            //Edge
            System.setProperty("webdriver.edge.driver","");
            //instance of EdgeDriver
            driver = new EdgeDriver();
        }else{
            System.out.println("You Entered un-valid Browser name :" + browserName);

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





