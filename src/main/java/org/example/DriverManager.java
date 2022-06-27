package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class DriverManager extends Utils {
    LoadProp loadProp = new LoadProp();
    DesiredCapabilities caps = new DesiredCapabilities();

    public  final String AUTOMATE_USERNAME = loadProp.getProperty("bsUsername");
    public  final String AUTOMATE_ACCESS_KEY = loadProp.getProperty ("bsAccessKey");
    public  final String BrowserStackURL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

//    public final String AUTOMATE_USERNAME = loadProp.getProperty("bsUsername");
//    public final String AUTOMATE_ACCESS_KEY = loadProp.getProperty("bsAccessKey");
//    public final String BrowserStackURL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    // boolean cloud = false;
// if true this cloud will choose for browserstack
    //boolean cloud =true;
    boolean cloud = Boolean.parseBoolean(System.getProperty("cloud"));
    //open and close browser
    // String browserName =("chrome");
    String browserName = System.getProperty("browser");

    public void startOfBrowser() {

        if(cloud){
            System.out.println("Running in cloud");
            //applying conditional loop for web-browser selection
            if (browserName.equalsIgnoreCase("Chrome")){
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "11");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.0.0");

            } else if (browserName.equalsIgnoreCase("safari")) {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Edge");
                caps.setCapability("browser_version", "101.0");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.0.0");

            } else if (browserName.equalsIgnoreCase("firefox")) {
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.0.0");

            }else{
                System.out.println("Your Browser name is wrong");
            }
            try {
                driver = new RemoteWebDriver(new URL(BrowserStackURL),caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("Running Locally...");
        }

        if (browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
            driver = new ChromeDriver();//open chromebrowser
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            //WebDriverManager.firefoxdriver().setup();
            System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
            driver = new FirefoxDriver();// open firefoxbrowser
        }
        else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();// open Edgebrowser
        }
        else {
            System.out.println("Either your browser name is wrong or not provided " +browserName);
        }

        //Duration for waiting
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        // Type URL
        driver.get("https://demo.nopcommerce.com/");

    }

    //close browser
    public void closeTheBrowser() {
        driver.quit();
    }
}

//        //decide cloud or locaally
//        //making decision cloud true or false
//        //this will be run if cloud true (In cloud)
//        if(cloud){
//            System.out.println("Running in cloud");
//            //applying conditional loop for web-browser selection
//            if (browserName.equalsIgnoreCase("Chrome")) {
//                System.out.println("your test cases are running in Chrome");
//
//                caps.setCapability("os", "Windows");
//                caps.setCapability(" os_version", "11");
//                caps.setCapability("browser", "Chrome");
//                caps.setCapability("browser_version", "latest");
//                caps.setCapability("browserstack.local", "false");
//                caps.setCapability("browserstack.selenium_version", "4.1.0");
//
//            } else if (browserName.equalsIgnoreCase("Safari")) {
//                System.out.println("your test cases are running in Safari");
//
//                caps.setCapability("os", "OS X");
//                caps.setCapability("os_version", "Catalina");
//                caps.setCapability("browser", "Safari");
//                caps.setCapability("browser_version", "13.1");
//                caps.setCapability("browserstack.local", "false");
//                caps.setCapability("browserstack.selenium_version", "4.1.0");
//
//            } else if (browserName.equalsIgnoreCase("firefox")) {
//                System.out.println("your test cases are running in firefox");
//
//                caps.setCapability("os", "Windows");
//                caps.setCapability("os_version", "11");
//                caps.setCapability("browser", "Firefox");
//                caps.setCapability("browser_version", "latest-beta");
//                caps.setCapability("browserstack.local", "false");
//                caps.setCapability("browserstack.selenium_version", "4.1.0");
//
//
//            } else {
//                System.out.println("wrong browser name OR Connection wrong");
//            }
//            try {
//                driver = new RemoteWebDriver(new URL(BrowserStackURL), caps);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//
//        }else {
//            //this will be run if cloud false (locally)
//            System.out.println("test cases are running locally.....");
//
//            if (browserName.equalsIgnoreCase("Chrome")) {
//                //open chrome
//                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
//                //WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//
//            } else if (browserName.equalsIgnoreCase("Edge")) {
//                // System.setProperty("");
//                driver = new EdgeDriver();
//            } else if (browserName.equalsIgnoreCase("firefox")) {
//                System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
//                driver = new FirefoxDriver();
//            } else {
//                System.out.println("Wrong browser name");
//            }
//        }
//        //Duration for waiting
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        // Type URL
//        driver.get("https://demo.nopcommerce.com/");
//        }
//Chrome
//        if(browserName.equalsIgnoreCase("Chrome")) {
//            //Open Chrome
//            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
//            driver = new ChromeDriver();  // import chrome web-Driver dependency (In 'POM' file)
//
//        }else if(browserName.equalsIgnoreCase("Firefox")){
//
//            System.setProperty("webdriver.gecko.driver","src/test/java/drivers/geckodriver.exe");
//            driver= new FirefoxDriver();
//
//            //Edge
//        }else if(browserName.equalsIgnoreCase("Edge")){
//            //Edge
//            System.setProperty("webdriver.edge.driver","");
//            //instance of EdgeDriver
//            driver = new EdgeDriver();
//        }else{
//            System.out.println("You Entered un-valid Browser name :" + browserName);
//
// }else if (browserName.equalsIgnoreCase("Edge")) {
//                caps.setCapability("os", "Windows");  S
//                caps.setCapability("os_version", "11");
//                caps.setCapability("browser", "Edge");
//                caps.setCapability("browser_version", "latest");
//                caps.setCapability("browserstack.local", "false");
//                caps.setCapability("browserstack.selenium_version", "4.1.0");
////
//
// caps.setCapability("os", "Windows");
////                caps.setCapability("os_version", "11");
////                caps.setCapability("browser", "Edge");
////                caps.setCapability("browser_version", "latest");
////                caps.setCapability("browserstack.local", "false");
////                caps.setCapability("browserstack.selenium_version", "4.1.2");
////                System.out.println("your test cases are running in edge");







//=================================================================================================
//package org.example;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.time.Duration;
//import java.util.HashMap;
//
// public class DriverManager extends Utils {
//    static LoadProp loadProp = new LoadProp();
//    public static final String USERNAME = loadProp.getProperty("bsUsername");
//    public static final String AUTOMATE_KEY = loadProp.getProperty("bsAccessKey");
//    public static final String BrowserStackURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
//
//    boolean cloud = true;
//    String browserName = "Chrome";
//    DesiredCapabilities caps = new DesiredCapabilities();
//
//    public void startOfBrowser() {
//
//        if (browserName.equalsIgnoreCase("Chrome")) {
//
//
//            caps.setCapability("browserName", "Chrome");
//            caps.setCapability("browserVersion", "latest");
//            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//            browserstackOptions.put("os", "Windows");
//            browserstackOptions.put("osVersion", "10");
//            caps.setCapability("bStack:options", browserstackOptions);
//
//
//        } else {
//            System.out.println("your browser name is wrong there is connection issue ");
//
//        }
//        try {
//            driver = new RemoteWebDriver(new URL(BrowserStackURL), caps);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//
//
//        }
//        //Implicit wait method :
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        //Maximizing chrome window:
//        driver.manage().window().maximize();
//
//        //Driver to type URL :
//        driver.get("https://demo.nopcommerce.com/");
//    }
//
//    public void closeTheBrowser() {


