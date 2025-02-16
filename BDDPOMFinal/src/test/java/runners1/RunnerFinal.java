package runners1;

import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src//test//resources//features1//",
    glue = {"stepdefs1"},
    monochrome = true,
    dryRun = false,
    plugin = {
        "pretty",
        "html:target/reports/HTMLReport.html",
        //"rerun:target/failedScenarios.txt",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
)

public class RunnerFinal extends AbstractTestNGCucumberTests {
   
}
