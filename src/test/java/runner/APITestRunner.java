package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/apiFeatures", glue = "apiSteps", plugin = "pretty")
public class APITestRunner  extends AbstractTestNGCucumberTests {

}
