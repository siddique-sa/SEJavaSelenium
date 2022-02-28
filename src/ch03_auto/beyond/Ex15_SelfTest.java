package ch03_auto.beyond;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.BaseTest2;

class Ex15_SelfTest extends BaseTest2{

	@Test
	void settings() {
		WebElement settingMenu = getDriver().findElement(By.xpath("//li[@id='menu-settings']/a/div[3]"));
		settingMenu.click();
		
		
		
				
			
	}
	@Test
	void titlechange() {
		
		WebElement titleChange = getDriver().findElement(By.id("blogname]"));
		
		titleChange.clear();
		
		//Selenium Blog
		//
		
		
				
			
	}

}
