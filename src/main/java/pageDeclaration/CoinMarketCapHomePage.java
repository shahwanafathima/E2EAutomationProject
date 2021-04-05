package pageDeclaration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoinMarketCapHomePage {

	public WebDriver driver;

	// WebElements for Show-Rows feature
	public By ShowRowsDropDown = By.xpath("/html/body/div/div/div[2]/div/div/div[1]/div[2]/div[3]/div[1]/div");
	public By ShowRows100 = By.xpath("/html/body/div[2]/div/div[1]/div/div/button[1]");
	public By ShowRows50 = By.xpath("/html/body/div[2]/div/div[1]/div/div/button[2]");
	public By ShowRows20 = By.xpath("/html/body/div[2]/div/div[1]/div/div/button[3]");

	// WebElements for Filter feature
	public By FiltersLink = By.xpath("/html/body/div/div/div[2]/div/div/div[1]/div[2]/div[3]/div[2]/button[1]");
	public By AddFilterLink = By.xpath("/html/body/div/div/div[2]/div/div/ul/li[5]/button");
	public By MarketCapExpandLink = By
			.xpath("/html/body/div[1]/div/div[2]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/button");

	public By MarketCapRange1Bto10BButton = By.xpath(
			"/html/body/div/div/div[2]/div/div/div[3]/div/div/div[2]/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/button[2]");
	public By MarketCapRange10BButton = By.xpath(
			"/html/body/div[1]/div/div[2]/div/div/div[3]/div/div/div[2]/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/button[1]");
	public By MarketCapRange100Mto1BButton = By.xpath(
			"/html/body/div[1]/div/div[2]/div/div/div[3]/div/div/div[2]/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/button[3]");
	public By MarketCapRange10Mto100MButton = By.xpath(
			"/html/body/div[1]/div/div[2]/div/div/div[3]/div/div/div[2]/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/button[4]");
	public By MarketCapRange1Mto10MButton = By.xpath(
			"/html/body/div[1]/div/div[2]/div/div/div[3]/div/div/div[2]/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/button[5]");
	public By MarketCapRange1MButton = By.xpath(
			"/html/body/div[1]/div/div[2]/div/div/div[3]/div/div/div[2]/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/button[6]");

	public By ApplyFilterButton = By.xpath(
			"/html/body/div[1]/div/div[2]/div/div/div[3]/div/div/div[2]/div[1]/div[4]/div/div/div[2]/div/div[2]/div/button[1]");
	public By ApplyFilterButtonPriceRange = By.xpath(
			"/html/body/div[1]/div/div[2]/div/div/div[3]/div/div/div[2]/div[1]/div[5]/div/div/div[2]/div/div[2]/div/button[1]");
	public By PriceRangeExpandButton = By
			.xpath("/html/body/div[1]/div/div[2]/div/div/div[3]/div/div/div[2]/div[1]/div[3]/button");

	public By PriceRange101To1000Button = By.xpath(
			"/html/body/div/div/div[2]/div/div/div[3]/div/div/div[2]/div[1]/div[5]/div/div/div[2]/div/div[1]/div[2]/button[3]");
	public By PriceRange0To1Button = By.xpath(
			"/html/body/div[1]/div/div[2]/div/div/div[3]/div/div/div[2]/div[1]/div[5]/div/div/div[2]/div/div[1]/div[2]/button[1]");
	public By PriceRange1To100Button = By.xpath(
			"/html/body/div[1]/div/div[2]/div/div/div[3]/div/div/div[2]/div[1]/div[5]/div/div/div[2]/div/div[1]/div[2]/button[2]");
	public By PriceRangeMoreThan1000Button = By.xpath(
			"/html/body/div[1]/div/div[2]/div/div/div[3]/div/div/div[2]/div[1]/div[5]/div/div/div[2]/div/div[1]/div[2]/button[4]");

	public By ShowResultsButton = By.xpath("/html/body/div/div/div[2]/div/div/div[3]/div/div/div[2]/div[2]/button[1]");

	public By filteredRowNumText = By.xpath("/html/body/div/div/div[2]/div/div/div[4]/p");

	public String getfilteredRowNumText() {
		return driver.findElement(filteredRowNumText).getText();
	}

	public CoinMarketCapHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void getPage(String url) {
		driver.get(url);
	}

	public WebElement getShowRowsDropDown() {
		return driver.findElement(ShowRowsDropDown);
	}

	public WebElement getFiltersLink() {
		return driver.findElement(FiltersLink);
	}

	public WebElement getShowRows100() {
		return driver.findElement(ShowRows100);
	}

	public WebElement getShowRows50() {
		return driver.findElement(ShowRows50);
	}

	public WebElement getShowRows20() {
		return driver.findElement(ShowRows20);
	}

	public WebElement getAddFilterLink() {
		return driver.findElement(AddFilterLink);
	}

	public WebElement getMarketCapExpandLink() {
		return driver.findElement(MarketCapExpandLink);
	}

	public WebElement getMarketCapRange1Bto10BButton() {
		return driver.findElement(MarketCapRange1Bto10BButton);
	}

	public WebElement getMarketCapRange10BButton() {
		return driver.findElement(MarketCapRange10BButton);
	}

	public WebElement getMarketCapRange100Mto1BButton() {
		return driver.findElement(MarketCapRange100Mto1BButton);
	}

	public WebElement getMarketCapRange10Mto100MButton() {
		return driver.findElement(MarketCapRange10Mto100MButton);
	}

	public WebElement getMarketCapRange1Mto10MButton() {
		return driver.findElement(MarketCapRange1Mto10MButton);
	}

	public WebElement getMarketCapRange1MButton() {
		return driver.findElement(MarketCapRange1MButton);
	}

	public WebElement getApplyFilterButtonPriceRange() {
		return driver.findElement(ApplyFilterButtonPriceRange);
	}

	public WebElement getApplyFilter() {
		return driver.findElement(ApplyFilterButton);
	}

	public WebElement getPriceRangeExpandButton() {
		return driver.findElement(PriceRangeExpandButton);
	}

	public WebElement getPriceRange101To1000Button() {
		return driver.findElement(PriceRange101To1000Button);
	}

	public WebElement getPriceRange0To1Button() {
		return driver.findElement(PriceRange0To1Button);
	}

	public WebElement getPriceRange1To100Button() {
		return driver.findElement(PriceRange1To100Button);
	}

	public WebElement getPriceRangeMoreThan1000Button() {
		return driver.findElement(PriceRangeMoreThan1000Button);
	}

	public WebElement getShowResultsButton() {
		return driver.findElement(ShowResultsButton);
	}

	public void clickShowRowDropDown() {
		getShowRowsDropDown().click();
	}

	public void selectFromShowRowDropDown(String num) {
		if (Integer.parseInt(num) == 100) {
			getShowRows100().click();
		} else if (Integer.parseInt(num) == 50) {
			getShowRows50().click();
		} else if (Integer.parseInt(num) == 20) {
			getShowRows20().click();
		}
	}

	public WebElement getResults(int i) {
		return driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/table/tbody/tr[" + i + "]"));
	}

	public void clickFiltersButton() {
		getFiltersLink().click();
	}

	public void clickAddFilterButton() {
		getAddFilterLink().click();
	}

	public void expandMarketCapButton() {
		getMarketCapExpandLink().click();
	}

	public void clickMarketCapRange(String value) {
		if (value.equals("$1B - $10B")) {
			getMarketCapRange1Bto10BButton().click();
		} else if (value.equals("> $10B")) {
			getMarketCapRange10BButton().click();
		} else if (value.equals("$100M - $1B")) {
			getMarketCapRange100Mto1BButton().click();
		} else if (value.equals("$10M - $100M")) {
			getMarketCapRange10Mto100MButton().click();
		} else if (value.equals("$1M - $10M")) {
			getMarketCapRange1Mto10MButton().click();
		} else if (value.equals("< $1M")) {
			getMarketCapRange1MButton().click();
		}
	}

	public void clickApplyFilterButtonPriceRange() {
		getApplyFilterButtonPriceRange().click();
	}

	public void clickApplyFilterButton() {
		getApplyFilter().click();
	}

	public void expandPriceRangeButton() {
		getPriceRangeExpandButton().click();
	}

	public void clickPriceRange(String value) {
		if (value.equals("$101 - $1,000")) {
			getPriceRange101To1000Button().click();
		} else if (value.equals("$0 - $1")) {
			getPriceRange0To1Button().click();
		} else if (value.equals("$1 - $100")) {
			getPriceRange1To100Button().click();
		} else if (value.equals("$1,000 +")) {
			getPriceRangeMoreThan1000Button().click();
		}
	}

	public void clickShowResultsButton() {
		getShowResultsButton().click();
	}

	public String getPriceFilterResults(int i) {
		return driver
				.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/table/tbody/tr[" + i + "]/td[4]/div/a"))
				.getText().replace("$", "");
	}

	public String getMarketCapResults(int i) {
		return driver
				.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/table/tbody/tr[" + i + "]/td[7]"))
				.getText().replace("$", "");
	}

}
