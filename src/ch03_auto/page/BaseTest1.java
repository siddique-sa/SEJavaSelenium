package ch03_auto.page;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import common.Configuration;

public class BaseTest1 {
	private WebDriver driver = null;

	@BeforeEach
	void launchBrowser() throws Exception {

		setDriver(Configuration.createChromeDriver());
		getDriver().get(Configuration.ADMIN_URL);
		Thread.sleep(3000);

	}

	@AfterEach
	void closeBrowser() throws Exception {
		driver.quit();

	}

	private void setDriver(WebDriver driver) {
		this.driver = driver;

	}

	protected WebDriver getDriver() {
		return driver;
	}

}