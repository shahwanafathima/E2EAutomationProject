package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/uiFeatures", glue = "steps", plugin = "pretty")
public class UITestRunner extends AbstractTestNGCucumberTests {

}
