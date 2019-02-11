/**
 * 
 */
package com.pages;

import org.testng.log4testng.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.test.TestCase1;
import com.utility.BrowserFactory;
import com.utility.ConfigReader;
import com.utility.Log;

/**
 * @author prosenjit.majumder
 *
 */
public class HomePage extends BrowserFactory{
	
	
	ConfigReader conf = new ConfigReader();
	Logger log = Logger.getLogger(HomePage.class);
	
	public void homePageTitleVerification() {
		try {
		
			Log.info("Asserting the Hompagetitle");
			Assert.assertEquals(driver.getTitle(), conf.homePageTitle());
			Log.info("HomePagetitle is displayed as expected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.error(e.getMessage());
		}
	}
	
	public void clickOnMobile() {
		try {
			
			Log.info("Clicking on Mobilelink on HomePage");
			driver.findElement(By.xpath(conf.mobileElement())).click();
			Log.info("Clicked on Mobilelink");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.error(e.getMessage());
		}
		
	}
	
	public void mobilePageTitle() {
		try {
			
			Log.info("Asserting the MobilePagetitle");
			Assert.assertEquals(driver.getTitle(), conf.mobilePageTitle());
			Log.info("MobilePagetitle is displayed as expected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.error(e.getMessage());
		}
		
	}
	
	public void sortByOption() {
		try {
			
			Select select = new Select(driver.findElement(By.xpath(conf.sortbyElement())));
			select.selectByVisibleText(conf.sortedVisibleElement());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
