package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {

	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException {
		
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
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys("abc@qw.com");
		lp.getPassword().sendKeys("123456");
		System.out.println(text);
		lp.getLogin().click();
	}

	@DataProvider
	public Object[][] getData()
	{
		//Rows stands for how many different data types test shud run
		//column stands for how many values per each test
		//0th row
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
		
		//1st row
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456788";
		data[1][2] = "Non restricted user";
		
		return data;
	}
}
