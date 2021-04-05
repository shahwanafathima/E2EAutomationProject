package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageDeclaration.CoinMarketCapHomePage;
import utils.SeleniumDriver;

public class ShowRowsSteps extends SeleniumDriver {

	CoinMarketCapHomePage homePage = new CoinMarketCapHomePage(driver);

	@Given("^I am on the CoinMarketCap home page \"([^\"]*)\" with page title \"([^\"]*)\"$")
	public void i_am_on_the_coinmarketcap_home_page_something_with_page_title_something(String strArg1, String strArg2)
			throws Throwable {
		homePage.getPage(strArg1);
		assertTrue((driver.getTitle().contains(strArg2)), "Validate Page Title");
	}

	@When("^Show rows drop down is clicked$")
	public void show_rows_drop_down_is_clicked() throws Throwable {
		homePage.clickShowRowDropDown();
	}

	@And("^Select (.+) value from the drop-down menu$")
	public void select_value_from_the_dropdown_menu(String rows) throws Throwable {
		homePage.selectFromShowRowDropDown(rows);
	}

	@Then("^I validate that (.+) rows are displayed$")
	public void i_validate_that_rows_are_displayed(String rows) throws Throwable {
		for (int i = 1; i < Integer.parseInt(rows); i++) {
			assertTrue(homePage.getResults(i).isDisplayed(), "Validate the number of rows dispplayed");
		}

	}

}