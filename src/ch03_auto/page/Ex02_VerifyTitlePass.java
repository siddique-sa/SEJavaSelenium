package ch03_auto.page;

import org.openqa.selenium.WebDriver;

import common.Configuration;

public class Ex02_VerifyTitlePass {

	public static void main(String[] args) throws Exception {
		WebDriver driver = Configuration.createChromeDriver();
		driver.get(Configuration.BLOG_URL);

		String expectedTitle = "CSE Blog";
		String actualTitle = driver.getTitle();

		if (!expectedTitle.equals(actualTitle)) {
			throw new Exception(String.format("Failure: Title does not match. Expected:<%s> Actual <%s>", expectedTitle,
					actualTitle));

		}
		driver.quit();
	}

}