package ch01_01_auto.browser;

import org.openqa.selenium.WebDriver;

import common.Configuration;

public class Ex04_BrowserMethods {
	public static void main(String[] agrv) throws Exception {

		WebDriver driver = Configuration.createChromeDriver();
		Thread.sleep(3000);
		driver.quit();

	}

}