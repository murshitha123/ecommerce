/**
 * 
 */
package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.utility.ConfigReader;

/**
 * @author prosenjit.majumder
 *
 */
public class SampleClass {
	
	ConfigReader conf = new ConfigReader();
	
	@Test
	public void testName() {
		System.setProperty("webdriver.chrome.driver", conf.getDriverPath());
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(conf.getURL());
		driver.quit();
	}

}
