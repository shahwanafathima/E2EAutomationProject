package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDriver {

	// Initialize WebDriver
	public static WebDriver driver;
	static String browserName;

	public static WebDriver intializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("src\\test\\resources\\data.properties");
		prop.load(file);
		browserName = prop.getProperty("browser");

		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\seleniumDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\seleniumDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void tearDown() {
		if (browserName.equals("Firefox")) {
			driver.close();
		} else {
			driver.close();
			driver.quit();
		}
	}

	public int[] formatInputNumber(String ip) {
		int[] num = { Integer.parseInt(ip.split("-")[0].trim().replaceAll("[^0-9]", "")),
				Integer.parseInt(ip.split("-")[1].trim().replaceAll("[^0-9]", "")) };
		return num;
	}

	public BigDecimal formatInputNumberMarketCap(String ip) {
		BigDecimal num = new BigDecimal(0);
		if (ip.contains("B")) {
			num = new BigDecimal(Double.parseDouble(ip.trim().replaceAll("[^0-9]", "")) * 1000000000);
		} else if (ip.contains("M")) {
			num = new BigDecimal(Double.parseDouble(ip.trim().replaceAll("[^0-9]", "")) * 1000000);
		}
		return num;
	}

	public BigDecimal formatActualResults(String ip) {
		BigDecimal num = new BigDecimal(Double.parseDouble(ip.trim().replaceAll("[^0-9]", "")));
		return num;
	}

}
