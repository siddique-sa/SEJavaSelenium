package ch03_auto.page;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.BaseTest1;
import common.SeleniumUtils;

class Ex06_UsingXPath extends BaseTest1{

	/*
	 * Identify User Name with the Absolute XPath (Tag Name)
	 * Don't do this in professional Work
	 * Absolute XPath are evil ;->
	 */
	
	@Test
	void test00() {
		WebElement element = getDriver().findElement(By.xpath("/html/body/div[1]/form/p[1]/input"));
		SeleniumUtils.printElementInfo("User Name text field", element);
	}

	/*
	 * Now onwards we stick with relative XPath as Absolute XPath are brittle. 
	 * Identify User Name with XPath (Tag Name)
	 */
	@Test
	void test01() {
		WebElement element = getDriver().findElement(By.xpath("//input"));
		SeleniumUtils.printElementInfo("User Name text field", element);
	}
	/*
	 * Identify User Name with XPath (Tag Name with attribute name)
	 */
	@Test
	void test02() {
		WebElement element = getDriver().findElement(By.xpath("//input[@type]"));
		SeleniumUtils.printElementInfo("User Name text field", element);
	}
	
	/*
	 * Identify Password with XPath (Tag Name with attribute name and a given value)
	 */
	@Test
	void test03_01() {
		WebElement element = getDriver().findElement(By.xpath("//input[@type='password']"));
		SeleniumUtils.printElementInfo("Password", element);
	}
	/*
	 * Identify User Name with XPath - ID
	 * Variant of test03
	 */
	@Test
	void test03_02() {
		WebElement element = getDriver().findElement(By.xpath("//input[@id='user_login']"));
		SeleniumUtils.printElementInfo("User Name", element);
	}
	/*
	 * Identify User Name with XPath - Class
	 * Variant of test03
	 */
	@Test
	void test03_03() {
		WebElement element = getDriver().findElement(By.xpath("//input[@class='input']"));
		SeleniumUtils.printElementInfo("User Name", element);
	}
	/*
	 * Identify User Name with XPath - Name
	 * Variant of test03
	 */
	@Test
	void test03_04() {
		WebElement element = getDriver().findElement(By.xpath("//input[@name='log']"));
		SeleniumUtils.printElementInfo("User Name", element);
	}
	/*
	 * Identify User Name with XPath - any tag- *
	 * Variant of test03
	 */
	@Test
	void test03_05() {
		WebElement element = getDriver().findElement(By.xpath("//*[@name='log']"));
		SeleniumUtils.printElementInfo("User Name", element);
	}
	/*
	 * Identify Lost your password with XPath - Text
	 */
	@Test
	void test04() {
		WebElement element = getDriver().findElement(By.xpath("//*[text()='Lost your password?']"));
		SeleniumUtils.printElementInfo("Lost your password", element);
	}
	/*
	 * Identify User Name text field with XPath - Relationships - Child
	 */
	@Test
	void test05_01() {
		WebElement element = getDriver().findElement(By.xpath("//p/input"));
		SeleniumUtils.printElementInfo("User Name text field", element);
	}
	/*
	 * Identify User Name text field with XPath - Relationships - Following-sibling
	 */
	@Test
	void test05_02() {
		WebElement element = getDriver().findElement(By.xpath("//label/following-sibling::input"));
		SeleniumUtils.printElementInfo("User Name text field", element);
	}
	/*
	 * Identify User Name text field with XPath - Partial Matches - Contains
	 */
	@Test
	void test06_01() {
		WebElement element = getDriver().findElement(By.xpath("//input[contains(@id, 'er_l')]"));
		SeleniumUtils.printElementInfo("User Name text field", element);
	}
	/*
	 * Identify User Name text field with XPath - Partial Matches - Starts-with
	 */
	@Test
	void test06_02() {
		WebElement element = getDriver().findElement(By.xpath("//input[starts-with(@id, 'user_')]"));
		SeleniumUtils.printElementInfo("User Name text field", element);
	}
	/*
	 * Identify User Name text field with XPath - Partial Matches - ends-with
	 * Ends-with is not supported in current browsers
	 * As it requires XPath V2 - All the browsers use V1
	 */
	@Test
	void test06_03() {
		WebElement element = getDriver().findElement(By.xpath("//input[ends-with(@id, '_login')]"));
		SeleniumUtils.printElementInfo("User Name text field", element);
	}
	/*
	 * Identify Lost your password with XPath - Partial Matches - text - contains
	 */
	@Test
	void test07_01() {
		WebElement element = getDriver().findElement(By.xpath("//a[contains(text(), 'Lost')]"));
		SeleniumUtils.printElementInfo("Lost your password", element);
	}
	/*
	 * Identify Lost your password with XPath - Partial Matches - text - starts-with
	 */
	@Test
	void test07_02() {
		WebElement element = getDriver().findElement(By.xpath("//a[starts-with(text(), 'Lost')]"));
		SeleniumUtils.printElementInfo("Lost your password", element);
	}
	/*
	 * Identify Password text field with XPath - Logical or
	 */
	@Test
	void test08_01() {
		WebElement element = getDriver().findElement(By.xpath("//input[@id='user_pass' or @name='pwd']"));
		SeleniumUtils.printElementInfo("Password text field", element);
	}
	/*
	 * Identify Password text field with XPath - Logical and
	 */
	@Test
	void test08_02() {
		WebElement element = getDriver().findElement(By.xpath("//input[@id='user_pass' and @name='pwd']"));
		SeleniumUtils.printElementInfo("Password text field", element);
	}
	/*
	 * Identify Password text field with XPath - Logical and
	 */
	@Test
	void test08_03() {
		WebElement element = getDriver().findElement(By.xpath("//input[@type and not(@name='log')]"));
		SeleniumUtils.printElementInfo("Password text field", element);
	}
	/*
	 * Identify Form with XPath - Hierarchy (Axis)- Parent
	 */
	@Test
	void test09_01() {
		WebElement element = getDriver().findElement(By.xpath("//label/../.."));
		SeleniumUtils.printElementInfo("Form", element);
	}
	/*
	 * Identify Form with XPath - Hierarchy (Axis)- Descendant
	 * (// instead of / between form and input)
	 */
	@Test
	void test09_02() {
		WebElement element = getDriver().findElement(By.xpath("//form//input"));
		SeleniumUtils.printElementInfo("Form", element);
	}
	/*
	 * Identify Form with XPath - Hierarchy (Axis)- Ancestor
	 * (// instead of / between form and input)
	 */
	@Test
	void test09_03() {
		WebElement element = getDriver().findElement(By.xpath("//input/ancestor::form"));
		SeleniumUtils.printElementInfo("Form", element);
	}
	/*
	 * Identify Form with XPath - Hierarchy (Axis)- preceding-sibling
	 */
	@Test
	void test09_04() {
		WebElement element = getDriver().findElement(By.xpath("//p[@class='submit']/preceding-sibling::p//input"));
		SeleniumUtils.printElementInfo("Form", element);
	}
	/*
	 * Identify User name with XPath - Index (using human counting)
	 * this variant looks at children of the same parent
	 * that is the reason //input[2] does not point to the password field
	 * 
	 */
	@Test
	void test10_01() {
		WebElement element = getDriver().findElement(By.xpath("//input[1]"));
		SeleniumUtils.printElementInfo("User Name", element);
	}
	/*
	 * Identify User Name with XPath - index (using human counting)
	 * This variant looks at elements across the DOM
	 */
	@Test
	void test10_02() {
		WebElement element = getDriver().findElement(By.xpath("(//input)[1]"));
		SeleniumUtils.printElementInfo("User Name", element);
	}
	/*
	 * Identify User Name with XPath - multiple attribute name 
	 */
	@Test
	void test11_01() {
		WebElement element = getDriver().findElement(By.xpath("//input[@type and @name]"));
		SeleniumUtils.printElementInfo("User Name", element);
	}
	/*
	 * Identify Password with XPath - index (using human counting)
	 */
	@Test
	void test11_02() {
		WebElement element = getDriver().findElement(By.xpath("//input[@type ='password' and @name='pwd']"));
		SeleniumUtils.printElementInfo("Password", element);
	}
	

	
}