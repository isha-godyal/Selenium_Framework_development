package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	//Objects are defined at the top
	By email=By.cssSelector("[id='user_email']");
	By password=By.cssSelector("[type='password']");
	By login=By.cssSelector("[value='Log In']");
	
	//constructor
	public LoginPage(WebDriver driver) {

		this.driver=driver;  // the WebDriver driver obj which have a life is assigned to a driver obj of this 
								//public WebDriver driver; variable
	
	}

	//Methods are defined below
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	

	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
}
