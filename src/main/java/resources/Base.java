package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {

	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		//chrome Driver
		
		 prop = new Properties();   //create DataDriven Property file
		FileInputStream fis = new FileInputStream("C:\\Users\\isha.godyal\\workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");   //give File Path where exactly the data driven file located
		
		prop.load(fis); //load will take fis as a argument and pass fis obj have knowledge of this property
		String browserName=prop.getProperty("browser"); // goes to data properties file and pulls out the browser to base file
		System.out.println(browserName);
		
		if(browserName.equals("chrome"))
		{
			//execute in chrome driver
			System.setProperty("webdriver.chrome.driver","C:\\Users\\isha.godyal\\workspace\\E2EProject\\resources\\chromedriver.exe");
			
			//webdriver.chrome.driver->value of path
			 driver = new ChromeDriver();
		}
		else if (browserName.equals("IE"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\isha.godyal\\workspace\\E2EProject\\resources\\IEDriverServer.exe");
			
			//webdriver.chrome.driver->value of path
			 driver = new InternetExplorerDriver();
		}
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\isha.godyal\\workspace\\E2EProject\\resources\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();  
	        capabilities.setCapability("marionette",true);  
			//webdriver.chrome.driver->value of path
			 driver = new FirefoxDriver(capabilities);
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
