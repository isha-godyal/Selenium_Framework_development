package Academy;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.LandingPage;
import resources.Base;

public class HomePage extends Base {

	@Test
	public void basePageNavigation() throws IOException {
		
		driver = initializeDriver(); // invoke a method to initialize driver
		
		driver.get("https://qaclickacademy.com");

		// for Model
		WebElement popupcloseEl = driver.findElement(By.xpath(
				"//div[contains(@class, 'sumome-react-wysiwyg-close-button')]//div[@class='sumome-react-wysiwyg-move-handle']"));

		WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(popupcloseEl));
		element.click();

		//one is inheritance
		//creating obj to that class and invoke methods of it
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();  //similar to driver.findElement(By.css())
	}

}
