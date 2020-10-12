package Util.driverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class InitDriver {

    private static String browser;

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    protected static void setDriver(RemoteWebDriver driver) {
        InitDriver.driver.set(driver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void driverInit(){
        PropertyUtil propUtil = new PropertyUtil();
        try {
            browser =  propUtil.getGlobalProperty("browser");
        } catch (Exception e) {
            System.out.println("Could not get global property "+ e.getCause());
        }
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            setDriver(new ChromeDriver());
        }
        else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            setDriver(new FirefoxDriver());
        }
        else if (browser.equalsIgnoreCase("ie")){
            WebDriverManager.iedriver().setup();
            setDriver(new InternetExplorerDriver());
        }
        else {
            System.out.println("Please provide valid browser");
        }
    }

    public static void tearDown(){
        getDriver().close();
    }
}
