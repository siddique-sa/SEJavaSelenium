package ch03_auto.page;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.BaseTest1;
import common.SeleniumUtils;

class Ex04_IdentifyingLinks extends BaseTest1{

	/*
	 * Identify Lost your password link using link text
	 */
	@Test
	void test01() {
		WebElement element = getDriver().findElement(By.linkText("Lost your password?"));
		SeleniumUtils.printElementInfo("Lost your password link", element);	
	}
	/*
	 * Identify Back to link using link text
	 * contains <-
	 * and the name of the blog changes. 
	 */
	@Test
	void test02() {
		WebElement element = getDriver().findElement(By.partialLinkText("Go to"));
		SeleniumUtils.printElementInfo("Back to Link", element);	
	}

}