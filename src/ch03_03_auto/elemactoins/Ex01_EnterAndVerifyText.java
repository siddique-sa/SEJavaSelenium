package ch03_03_auto.elemactoins;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.BaseTest1;
import common.Configuration;

class Ex01_EnterAndVerifyText extends BaseTest1 {

	@Test
	void enterUserName() {
		String expectedUserName = Configuration.USER_NAME;
		WebElement userNameTextField = getDriver().findElement(By.name("log"));
		assertTrue(userNameTextField.isEnabled(), "Assert that user name text field is enabled");
		userNameTextField.sendKeys(expectedUserName);

		String actualUserName = userNameTextField.getAttribute("value");
		assertEquals(expectedUserName, actualUserName, "Assert that user name is entered correctly");

	}

}