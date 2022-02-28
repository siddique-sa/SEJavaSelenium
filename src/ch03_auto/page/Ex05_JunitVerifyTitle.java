package ch03_auto.page;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import common.Configuration;

class Ex05_JunitVerityTitle {

	@Test
	void testSiteTitle() {
		WebDriver driver = Configuration.createChromeDriver();
		driver.get(Configuration.BLOG_URL);

		String expectedTitle = "dummy Blog";
		String actualTitle = driver.getTitle();

		assertEquals(expectedTitle, actualTitle);
		driver.quit();
	}

}