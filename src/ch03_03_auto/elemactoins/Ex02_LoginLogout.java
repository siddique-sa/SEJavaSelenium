package ch03_03_auto.elemactoins;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.BaseTest1;
import common.Configuration;

class Ex02_LoginLogout extends BaseTest1 {

	@Test
	void test() throws Exception {
		WebElement userTextBox = getDriver().findElement(By.name("log"));
		userTextBox.sendKeys(Configuration.USER_NAME);
		// enter pass
		WebElement pwdTextBox = getDriver().findElement(By.name("pwd"));
		pwdTextBox.sendKeys(Configuration.PASSWORD);
		pwdTextBox.submit();

		boolean dBoardLoaded = getDriver().findElement(By.id("wpadminbar")).isDisplayed();
		assertTrue(dBoardLoaded, "Assert that dashboard is loaded");

		WebElement logOut = getDriver().findElement(By.xpath("//*[text()='Log Out']"));
		getDriver().get(logOut.getAttribute("href"));

		Thread.sleep(1000);

		WebElement logOutMsg = getDriver().findElement(By.xpath("//*[contains(text(), 'logged out')]"));
		assertTrue(logOutMsg.isDisplayed(), "Assert successful logout");

	}

}