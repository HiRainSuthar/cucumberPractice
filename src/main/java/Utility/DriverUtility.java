package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtility {

    private static void highLightElement(WebDriver driver, WebElement ele, String colour) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].setAttribute('style', 'border: 2px solid " + colour + ";');", ele);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //Logger to be implemented by later stage
        }
    }

    public static void executeScript(WebDriver driver, String script) {
        try {
            ((JavascriptExecutor) driver).executeScript(script);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //Logger to be implemented by later stage
        }
    }

    public static boolean isElementPresent(WebDriver driver, By by, int waitTime) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDisplayed(WebDriver driver, WebElement ele) {
        try {
            if (ele.isDisplayed()) {
                highLightElement(driver, ele, "blue");
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitUntilVisibilityOf(WebDriver driver, WebElement locator, int waitTime) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.visibilityOf(locator));
            highLightElement(driver, locator, "blue");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //Logger to be implemented by later stage
        }
    }

    public static void waitUntilClickable(WebDriver driver, WebElement locator, int waitTime) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            System.out.println("There was an error " + e.getMessage());
        }
    }

    public static void deleteCookies(WebDriver driver) {
        try {
            driver.manage().deleteAllCookies();
        } catch (Exception ex) {
            System.out.println("Error in deleteCookies" + ex);
        }
    }

    public static void waitUntilPresenceOf(WebDriver driver, By locator, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Error in deleteCookies" + e);
        }
    }

    public static void timeout(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception ex) {
            System.out.println("Error in waiting" + ex);
        }
    }

    public static void selectFrommDropDown(WebDriver driver, WebElement dropDown, String value, String selectionType) {
        Select objDropDown = null;
        try {
            objDropDown = new Select(dropDown);
            if (selectionType.equalsIgnoreCase("text")) {
                objDropDown.selectByVisibleText(value);
            } else if (selectionType.equalsIgnoreCase("index")) {
                objDropDown.selectByIndex(Integer.parseInt(value));
            } else if (selectionType.equalsIgnoreCase("value")) {
                objDropDown.selectByValue(value);
            } else {
                objDropDown.selectByIndex(1);
            }
        } catch (Exception ex) {
            System.out.println("Error in selectFrommDropDown >> " + ex);
        }
    }

    public static void setZoom(WebDriver driver, int zoomPercentage) {
        try {
            final JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("document.body.style.zoom = '" + zoomPercentage + "%'");
        } catch (Exception ex) {
            System.out.println("Error in hover element : " + ex.getMessage());
        }
    }

    public static void moveToElement(WebDriver driver, WebElement element) {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(element).build().perform();
        } catch (Exception ex) {
            System.out.println("Error in hover element : " + ex.getMessage());
        }
    }
}
