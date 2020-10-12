package Tests;

import Util.driverUtil.InitDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class basicAuthStepDef extends InitDriver {

    @Given("User is on herokuApp homepage")
    public void navigateToHomePage() {
        getDriver().get("http://admin:admin@the-internet.herokuapp.com/");
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
