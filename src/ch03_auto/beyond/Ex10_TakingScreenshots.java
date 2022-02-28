package ch03_auto.beyond;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import common.BaseTest2;
import common.Configuration;

class Ex10_TakingScreenshots extends BaseTest2 {

	@Test
	void takeScreenshot() {
		TakesScreenshot camera = (TakesScreenshot) getDriver();
		File sFile = camera.getScreenshotAs(OutputType.FILE);

		String path = String.format("%s%s-%s.png", Configuration.SCREENSHOTS_DIR, "dashboard",
				System.currentTimeMillis());
		sFile.renameTo(new File(path));

	}

}