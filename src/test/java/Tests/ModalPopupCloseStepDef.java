package Tests;

import Util.driverUtil.InitDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ModalPopupCloseStepDef extends InitDriver {

    @Given("User is on herokuApp landingpage")
    public void navigateToHomePage() {
        getDriver().get("http://the-internet.herokuapp.com/");
    }

    @When("User click on Entry ad link")
    public void clickToGetModalPopup() throws InterruptedException {
        getDriver().findElement(By.cssSelector("#content > ul > li > a[href = '/entry_ad']")).click();
    }

    @Then("close the modal popup appeared")
    public void closeModalPopup() throws InterruptedException {
        Thread.sleep(5000);
        boolean modalPopUpDisplayed = getDriver().findElement(By.cssSelector("#modal > div.modal > div.modal-footer > p")).isDisplayed();
        Assert.assertTrue(modalPopUpDisplayed);
        getDriver().findElement(By.cssSelector("#modal > div.modal > div.modal-footer > p")).click();
    }
}
