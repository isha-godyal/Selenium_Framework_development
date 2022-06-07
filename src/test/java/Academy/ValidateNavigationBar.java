package Academy;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateNavigationBar extends Base {

	@Test
	public void basePageNavigation() throws IOException {
		
		driver = initializeDriver(); // invoke a method to initialize driver
		
		
		driver.get(prop.getProperty("url"));
		
//		//one is inheritance
//		//creating obj to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
//		//compare the text with browser from actual value text
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		
	}

	}

