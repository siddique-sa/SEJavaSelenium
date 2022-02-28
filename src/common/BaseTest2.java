package common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest2 {
	private WebDriver driver = null;
	private WebDriverWait wait = null;

	@BeforeEach
	void login() throws Exception {

		setDriver(Configuration.createChromeDriver());
		wait = new WebDriverWait(getDriver(), 60);

		getDriver().manage().window().maximize();

		getDriver().get(Configuration.ADMIN_URL);

		WebElement userTextBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("log")));
		userTextBox.sendKeys(Configuration.USER_NAME);
		assertEquals(Configuration.USER_NAME, userTextBox.getAttribute("value"), "Assert the user name text");

		WebElement pwdTextBox = driver.findElement(By.name("pwd"));
		pwdTextBox.sendKeys(Configuration.PASSWORD);
		assertEquals(Configuration.PASSWORD, pwdTextBox.getAttribute("value"), "Assert the password text");

		WebElement sumbitButton = driver.findElement(By.id("wp-submit"));
		sumbitButton.click();

		getWaiter().until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='WordPress News']")));

	}

	@AfterEach
	void logOut() throws Exception {
		WebElement logOut = driver.findElement(By.xpath("//*[text()='Log Out']"));
		getDriver().get(logOut.getAttribute("href"));

		getWaiter()
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'logged out')]")));
		getDriver().quit();

	}

	private void setDriver(WebDriver driver) {
		this.driver = driver;

	}

	protected WebDriver getDriver() {
		return driver;
	}

	protected WebDriverWait getWaiter() {
		return this.wait;
	}

}