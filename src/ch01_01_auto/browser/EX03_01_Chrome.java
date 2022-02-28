package ch01_01_auto.browser;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EX03_01_Chrome {

	public static void main(String[] args) throws Exception {

		String driverPath = System.getProperty("user.dir") + File.separator + "drivers" + File.separator
				+ "chromedriver.exe";// add .exe for windows

		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();
		Thread.sleep(5000);
		driver.quit();

	}

}