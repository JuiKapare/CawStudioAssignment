package test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicTableTest extends TestData 
{

	WebDriver driver;

	// Test data stored in an object to avoid duplication
	TestData testData = new TestData();

	@BeforeTest
	public void setup() 
	{
		// System.setProperty("webdriver.chrome.driver","path\\to\\chromedriver.exe");
		// //no need for latest version of selenium
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testDynamicTable() 
	{

		// Open app url
		driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

		// Verify page title
		String expectedTitle = "Table HTML Tag - JavaScript Created";
		String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.contains(expectedTitle), "Correct page title not displayed");

		// Click Table Data button
		driver.findElement(By.xpath("//summary[text()=\"Table Data\"]")).click();

		// Verify input text box displayed
		WebElement inputBox = driver.findElement(By.id("jsondata"));
		Assert.assertTrue(inputBox.isDisplayed(), "Input box not displayed");

		// clear previous data
		inputBox.clear();

		// Insert test data in input box
		inputBox.sendKeys(testData.jsonData);

		// Click Refresh Table button
		driver.findElement(By.id("refreshtable")).click();

		// Get rows from table
		List<WebElement> rows = driver.findElements(By.cssSelector("#tablehere tr"));

		// Assert table data matches input data
		for (int i = 1; i < rows.size(); i++) 
		{
			WebElement row = rows.get(i);
			List<WebElement> cols = row.findElements(By.tagName("td"));

			Assert.assertEquals(cols.get(0).getText(), testData.records[i - 1].name);
			Assert.assertEquals(cols.get(1).getText(), testData.records[i - 1].age);
			Assert.assertEquals(cols.get(2).getText(), testData.records[i - 1].gender);
		}
	}

	@AfterTest
	public void tearDown() 
	{
		driver.quit();
	}

}
