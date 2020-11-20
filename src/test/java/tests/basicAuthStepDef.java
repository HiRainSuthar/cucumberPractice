package tests;

import Utility.InitDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class basicAuthStepDef extends InitDriver {

    @Before
    public void browserInit() {
        driverInit();
    }

    @After
    public void closeBrowser() {
        tearDown();
    }

    @Given("User is on herokuApp homepage")
    public void navigateToHomePage() throws InterruptedException {
        getDriver().get("http://admin:admin@the-internet.herokuapp.com/");
        Thread.sleep(10000);
    }

    @When("User click on basic Auth link")
    public void clickOnBasicAuth() {
        getDriver().findElement(By.cssSelector("#content > ul > li > a[href = '/basic_auth'] ")).click();
    }

    @Then("login popup should not appear")
    public void validationOnBasicAuthPage() {
        String text = getDriver().findElement(By.cssSelector("#content > div > p")).getText();
        boolean value = text.contains("Congratulations");
        Assert.assertTrue(value);
    }
}
