/**
 * 
 */
package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.log4testng.Logger;

import com.pages.MobilePage;


public class BrowserFactory {

public  static EventFiringWebDriver e_driver;
public static WebEventListener eventListener;
public static WebDriver driver;
public static Properties prop;

public BrowserFactory()
{
	

		try {
			File src = new File("./src/com/utility/resources/Config.property");
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public static void getLogger()
{
	PropertyConfigurator.configure("./log4j.properties");
}


public static void initialization(String browserName) {
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Murshi\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.firefox.marionette", "E:\\Murshi\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver","C:\\Users\\Murshi\\Downloads\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
