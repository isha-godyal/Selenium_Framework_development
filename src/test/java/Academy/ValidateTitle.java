package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateTitle extends Base {

	public WebDriver driver;
	
	@Test
	public void basePageNavigation() throws IOException {
		
		driver = initializeDriver(); // invoke a method to initialize driver
		
		driver.get(prop.getProperty("url"));
		
		WebElement popupcloseEl = driver.findElement(By.xpath(
				"//div[contains(@class, 'sumome-react-wysiwyg-close-button')]//div[@class='sumome-react-wysiwyg-move-handle']"));

		WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(popupcloseEl));
		element.click();

		//one is inheritance
		//creating obj to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		String titleText = l.getTitle().getText();
		System.out.println(titleText);
		//compare the text with browser from actual value text
		Assert.assertEquals(titleText, "FEATURED COURSES");
		
		
	}
	

	@AfterTest
	public void teardown()
	{
		driver.close();
	}

	}

