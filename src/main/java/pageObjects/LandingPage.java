package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	//Objects are defined at the top
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector(".text-centre>h2");
	By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	//constructor
	public LandingPage(WebDriver driver) {

		this.driver=driver;  // the WebDriver driver obj which have a life is assigned to a driver obj of this 
								//public WebDriver driver; variable
	
	}

	//Methods are defined below
	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(NavBar);
	}
}
