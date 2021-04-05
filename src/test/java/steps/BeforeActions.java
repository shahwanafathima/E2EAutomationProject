package steps;

import java.io.IOException;

import io.cucumber.java.Before;
import utils.SeleniumDriver;

public class BeforeActions {

	@Before
	public void setup() throws IOException {
		SeleniumDriver.intializeDriver();
	}

}
