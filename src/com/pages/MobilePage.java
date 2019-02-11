/**
 * 
 */
package com.pages;


import org.openqa.selenium.By;
import org.testng.log4testng.Logger;
import com.utility.BrowserFactory;
import com.utility.ConfigReader;
import com.utility.Log;

/**
 * @author prosenjit.majumder
 *
 */
public class MobilePage extends BrowserFactory {
	
	ConfigReader conf = new ConfigReader();
	Logger log = Logger.getLogger(MobilePage.class);
	
	
	public String readXperiaCost() {
		try {
			
			Log.info("Getting the text of the sonyXperiaPrice");
			return driver.findElement(By.xpath(conf.sonyXperiaPrice())).getText();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error(e.getMessage());
			return e.getMessage();
		}
	}
	
	public void clickOnExperia() {
		try {
			Log.info("Clicking on sonyXperiaLink");
			driver.findElement(By.id(conf.sonyXperiaLink())).click();
			Log.info("sonyXperia Link is clicked");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.error(e.getMessage());
		}
	}
	
	public String readXperiaCostDetailsScreen() {
		try {
			Log.info("Getting the text of the sonyXperiaPrice");
			return driver.findElement(By.xpath(conf.xperiaPriceDetails())).getText();
		} catch (Exception e) {
			Log.error(e.getMessage());
			// TODO Auto-generated catch block
			return e.getMessage();
			
		}
	}
	
	public void addToCart() {
		try {
			Log.info("Clicking on xperiaAddToCart button");
			driver.findElement(By.xpath(conf.xperiaAddToCart())).click();
			log.info("xperiaAddToCart button is clicked successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Log.error(e.getMessage());
		}
		
	}
	
	public void provideQty() {
		try { 
			Log.info("Clearing the text of Qty on Mobile details page");
			driver.findElement(By.xpath(conf.qty())).clear();
			Log.info("Qty text field is successfully cleared");
			log.debug("Entering the text on the Qty text field of Mobile details page");
			driver.findElement(By.xpath(conf.qty())).sendKeys(conf.qtyAmnt());
			Log.info("Text is succesfully entered in the Qty field");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Log.error(e.getMessage());
		}
	}
	
	public void clickOnUpdate() {
		try {
			driver.findElement(By.xpath(conf.update())).click();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Log.error(e.getMessage());
		}
	}
	
	public String actualErrMsg() {
		try {
			return driver.findElement(By.xpath(conf.actErrorMsg())).getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error(e.getMessage());
			return e.getMessage();
		}
	}
	
	public String expctdErrMsg() {
		return conf.expctdErrorMsg();
	}
	
	public void clickOnEmptyCart() {
		try {
			driver.findElement(By.id(conf.emptyCartBtn())).click();
		} catch (Exception e) {
			// TODO: handle exception
			Log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	public String actualEmptyCartMsg() {
		try {
			return driver.findElement(By.xpath(conf.actEmptyCartMsg())).getText();
		} catch (Exception e) {
			// TODO: handle exception
			Log.error(e.getMessage());
			return e.getMessage();
		}
		
	}
	
	public String expctdEmptyCartMsg() {
		return conf.expctdEmptyCartMsg();
	}
	
	public void iphoneAddToCompare() {
		try {
			driver.findElement(By.xpath(conf.iphoneAddToCompare())).click();
		} catch (Exception e) {
			// TODO: handle exception
			Log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void xperiaAddToCompare() {
		try {
			driver.findElement(By.xpath(conf.xperiaAddToCompare())).click();
		} catch (Exception e) {
			// TODO: handle exception
			Log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String iphoneTitle() {
		try {
			return driver.findElement(By.xpath(conf.iphoneTitle())).getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error(e.getMessage());
			return e.getMessage();
		}
	}
	
	public String xperiaTitle() {
		try {
			return driver.findElement(By.xpath(conf.xperiaTitle())).getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error(e.getMessage());
			return e.getMessage();
		}	
	}
	public void compareButton() {
		try {
			driver.findElement(By.xpath(conf.compareBtn())).click();
		} catch (Exception e) {
			// TODO: handle exception
			Log.error(e.getMessage());
			e.printStackTrace();
		}
	}	

}
