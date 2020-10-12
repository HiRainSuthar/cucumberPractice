package Tests;

import Util.driverUtil.InitDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void browserInit() {
        InitDriver.driverInit();
    }

    @After
    public void closeBrowser() {
        InitDriver.tearDown();
    }
}
