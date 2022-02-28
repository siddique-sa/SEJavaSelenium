package ch03_auto.beyond;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.BaseTest2;
import common.SeleniumUtils;

class Ex03_NestedElements extends BaseTest2 {

	@Test
	void clickFirstCheckbox() {
		this.getDriver().findElement(By.linkText("Posts")).click();
		this.getDriver().findElement(By.linkText("Categories")).click();

		WebElement table = getDriver().findElement(By.className("wp-list-table"));
		WebElement firstCheckBox = table.findElement(By.name("delete_tags[]"));
		SeleniumUtils.printElementInfo("Category Checkbox", firstCheckBox);
		firstCheckBox.click();
		assertTrue(firstCheckBox.isSelected(), "Assert checkbox selection");
	}

}