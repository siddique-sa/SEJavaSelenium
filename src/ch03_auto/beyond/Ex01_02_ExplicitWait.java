package ch03_auto.beyond;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Configuration;

class Ex01_02_ExplicitWait {

	@Test
	void test() {
		WebDriver driver = Configuration.createChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		driver.get(Configuration.ADMIN_URL);
		
		WebElement userTextBox = 
				wait.until(ExpectedConditions.presenceOfElementLocated(By.name("log")));
		userTextBox.sendKeys(Configuration.USER_NAME);
		assertEquals(Configuration.USER_NAME, 
				userTextBox.getAttribute("value"), "Assert the user name text");
		
		WebElement pwdTextBox = driver.findElement(By.name("pwd"));
		pwdTextBox.sendKeys(Configuration.PASSWORD);
		assertEquals(Configuration.PASSWORD, 
				pwdTextBox.getAttribute("value"), "Assert the password text");
		
		WebElement sumbitButton = driver.findElement(By.id("wp-submit"));
		sumbitButton.click();

		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[text()='WordPress Events and News']")));
		
		WebElement logOut = driver.findElement(By.xpath("//*[text()='Log Out']"));
		driver.get(logOut.getAttribute("href"));
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'logged out')]")));
		
		driver.quit();

	}

}