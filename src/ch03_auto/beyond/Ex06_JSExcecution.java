package ch03_auto.beyond;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import common.BaseTest2;

class Ex06_JSExcecution extends BaseTest2 {

	@Test
	void js() {

		JavascriptExecutor jsExec = (JavascriptExecutor) getDriver();
		// find in JS and click in JS

		jsExec.executeScript("document.getElementsByClassName('welcome-view-site')[0].click();");
		getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Site Admin")));
		getDriver().navigate().back();

		// find in WD and click in JS
		WebElement viewSiteLink = getDriver().findElement(By.className("welcome-view-site"));
		jsExec.executeScript("arguments[0].click();", viewSiteLink);
		getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Site Admin")));
		getDriver().navigate().back();

		// Find in JS (and return web element) and click in WD
		WebElement siteLink = (WebElement) jsExec
				.executeScript("return document.getElementsByClassName('welcome-view-site')[0]");
		siteLink.click();
		getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.linkText("Site Admin")));

	}

}