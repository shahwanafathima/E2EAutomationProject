package steps;

import static org.testng.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageDeclaration.CoinMarketCapHomePage;
import utils.SeleniumDriver;

public class FilterSteps extends SeleniumDriver {

	CoinMarketCapHomePage homePage = new CoinMarketCapHomePage(driver);
	WebDriverWait wait = new WebDriverWait(driver, 30);

	@When("^Filters is clicked$")
	public void filters_is_clicked() throws Throwable {
		homePage.clickFiltersButton();
	}

	@And("^Add Filter is clicked$")
	public void add_filter_is_clicked() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(homePage.AddFilterLink));
		homePage.clickAddFilterButton();
	}

	@And("^expand Market Cap option$")
	public void expand_market_cap_option() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(homePage.MarketCapExpandLink));
		homePage.expandMarketCapButton();
	}

	@And("^click (.+) Market Cap option$")
	public void click_market_cap_option(String marketcap) throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage.clickMarketCapRange(marketcap);
	}

	@And("^click Apply Filter button under Market Cap Range$")
	public void click_apply_filter_button_under_market_cap_range() throws Throwable {
		homePage.clickApplyFilterButton();
	}

	@And("^expand Price option$")
	public void expand_price_option() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(homePage.PriceRangeExpandButton));
		homePage.expandPriceRangeButton();
	}

	@And("^click (.+) Price option$")
	public void click_price_option(String price) throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage.clickPriceRange(price);
	}

	@And("^click Apply Filter button under Price Range$")
	public void click_apply_filter_button_under_price_range() throws Throwable {
		homePage.clickApplyFilterButtonPriceRange();
	}

	@And("^click Show results button$")
	public void click_show_results_button() throws Throwable {
		homePage.clickShowResultsButton();
	}

	@Then("^validate that the results are within (.+) Price range$")
	public void validate_that_the_results_are_within_price_range(String price) throws Throwable {
		Thread.sleep(3000);
		String rowNum = homePage.getfilteredRowNumText().split("of")[1].trim();
		for (int i = 1; i <= Integer.parseInt(rowNum); i++) {
			Double actualPrice = Double.parseDouble(homePage.getPriceFilterResults(i).replace("[^a-zA-Z0-9_-]", ""));
			assertTrue(((actualPrice < formatInputNumber(price)[1]) && (actualPrice > formatInputNumber(price)[0])),
					"Validate that the results are within the price range");
		}
	}

	@And("^validate that the results are within (.+) Market Cap range$")
	public void validate_that_the_results_are_within_market_cap_range(String marketcap) throws Throwable {
		String rowNum = homePage.getfilteredRowNumText().split("of")[1].trim();
		for (int i = 1; i <= Integer.parseInt(rowNum); i++) {
			BigDecimal lowerRange = formatInputNumberMarketCap(marketcap.split("-")[0]);
			BigDecimal upperRange = formatInputNumberMarketCap(marketcap.split("-")[1]);
			BigDecimal result = formatActualResults(homePage.getMarketCapResults(i));
			assertTrue(((result.compareTo(lowerRange) == 1) && (result.compareTo(upperRange) == -1)),
					"Validate Market Cap Results");
		}
	}

}
