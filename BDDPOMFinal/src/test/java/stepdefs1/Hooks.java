package stepdefs1;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base1.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;

public class Hooks {

    // This method will run once before any scenario
    @BeforeAll
    public static void setupDriver() {
        TestBase.initDriver();  // Initialize WebDriver
    }

    // This method will run after each scenario
    @After
    public void tearDown(Scenario scenario) {
        TakesScreenshot screen = (TakesScreenshot) TestBase.getDriver();
        byte[] img = screen.getScreenshotAs(OutputType.BYTES);
        
        // Attach the screenshot to the report
        scenario.attach(img, "image/png", scenario.getName() + " - Screenshot");
    }

    // This method will run once after all scenarios have completed
    @AfterAll
    public static void quitDriver() {
        // Quit the driver after all tests have finished
        if (TestBase.getDriver() != null) {
            TestBase.getDriver().quit();
        }
    }
}
