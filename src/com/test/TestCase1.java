/**
 * 
 */
package com.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.pages.HomePage;
import com.pages.MobilePage;
import com.pages.ProductComparePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.BrowserFactory;
import com.utility.ConfigReader;
import com.utility.Log;
import com.utility.SendFileEmail;
import com.utility.Utility;
import com.utility.WindowHandle;


/**
 * @author prosenjit.majumder
 *
 */
public class TestCase1 extends BrowserFactory {

	ExtentReports report;
	ExtentTest logger;
	String toAddress = null;
	String reportPath = null;
	HomePage hp=new HomePage();
	MobilePage mp=new MobilePage();
	ConfigReader conf = new ConfigReader();
	ProductComparePage pc=new ProductComparePage();
	Logger log = Logger.getLogger(TestCase1.class);

	public TestCase1() {
		super();
	}

	@BeforeClass
	@Parameters("Browser")
	public void setup(@Optional("chrome") String browserName) {
		Log.info("Opening the Browser and URL");
		BrowserFactory.initialization(browserName);
		/*logger.log(LogStatus.INFO, "URL Opens");
		logger.log(LogStatus.PASS, "");
*/
		
	}

	@BeforeTest
	public void reportInitiation() {
		report = new ExtentReports("./Test_Report.html", true);

		report.loadConfig(TestCase1.class, "resources", "extent-config.xml");
		reportPath = Utility.ExtenthtmlReportPath();
	}

	

	@Test(priority=1, testName = "Verify the Home Page Title")
	public void verifyTitle() {
		logger = report.startTest("verifyTitle", "Verify the Home Page Title").assignCategory("Functional");

		hp.homePageTitleVerification();
		logger.log(LogStatus.PASS, "Home Page Title verified");
	}

	@Test(dependsOnMethods = "verifyTitle", testName = "Click operation on Mobile menu")
	public void clickOnMobileMenu() {
		logger = report.startTest("clickOnMobileMenu", "Click operation on Mobile menu").assignCategory("Functional");

		hp.clickOnMobile();
		logger.log(LogStatus.PASS, "Succefully clicked on Mobile");
	}

	@Test(dependsOnMethods = "clickOnMobileMenu", testName = "Verify the Mobile page title")
	public void mobilePageTitle() {
		logger = report.startTest("mobilePageTitle", "Verify the Mobile page title").assignCategory("Functional");

		hp.mobilePageTitle();
		logger.log(LogStatus.PASS, "Mobile page title verified");
	}

	@Test(dependsOnMethods = "mobilePageTitle", testName = "Verify the products while sorted by name in the list of all mobiles")
	public void productsSortByName() {
		logger = report
				.startTest("productsSortByName", "Verify the products while sorted by name in the list of all mobiles")
				.assignCategory("Functional");

		hp.sortByOption();
		logger.log(LogStatus.PASS, "Products are sorted by name");
	}

	@Test(dependsOnMethods = "productsSortByName", testName = "Compare the xperia price in Mobile page and details page")
	public void verifyXperiaPrice() {
		logger = report.startTest("verifyXperiaPrice", "Compare the xperia price in Mobile page and details page")
				.assignCategory("Functional");

		String xperiacost = mp.readXperiaCost();
		logger.log(LogStatus.INFO, "Stored the Sony Experia price from Mobile page");
		mp.clickOnExperia();
		logger.log(LogStatus.INFO, "Clicked on Sony Experia on Mobile page");
		logger.log(LogStatus.INFO, "Navigated to Sony Experia details page");
		String xperiacostDetails = mp.readXperiaCostDetailsScreen();
		logger.log(LogStatus.INFO, "Stored the Sony Experia price from Sony Experia details page");
		Assert.assertEquals(xperiacost, xperiacostDetails);
		logger.log(LogStatus.PASS, "Price matches !");
	}

	@Test(dependsOnMethods = "verifyXperiaPrice", testName = "Verify the error message while quantity is updated to 1000")
	public void verifyQtyUpdateErrMsg() {
		logger = report.startTest("verifyQtyUpdate", "Verify the error message while quantity is updated to 1000")
				.assignCategory("Functional");

		hp.clickOnMobile();
		logger.log(LogStatus.INFO, "Clicked on Mobile menu");
		mp.addToCart();
		logger.log(LogStatus.INFO, "Clicked on ADD TO CART corresponding to Sony Experia");
		mp.provideQty();
		logger.log(LogStatus.INFO, "required quantity providede");
		mp.clickOnUpdate();
		logger.log(LogStatus.INFO, "Clicked on UPDATE");
		Assert.assertEquals(mp.actualErrMsg(), mp.expctdErrMsg());
		logger.log(LogStatus.PASS, "Message verified");
	}

	@Test(dependsOnMethods = "verifyQtyUpdateErrMsg", testName = "Verify the message after clicking on Empty Cart")
	public void verifyEmptyCartMsg() {
		logger = report.startTest("verifyEmptyCartMsg", "Verify the message after clicking on Empty Cart")
				.assignCategory("Functional");

		mp.clickOnEmptyCart();
		logger.log(LogStatus.INFO, "Clicked on Empty Cart link");
		Assert.assertEquals(mp.actualEmptyCartMsg(), mp.expctdEmptyCartMsg());
		logger.log(LogStatus.PASS, "Message verified");
	}

	@Test(dependsOnMethods = {
			"verifyEmptyCartMsg" }, testName = "Verify the pop-up window with the desired products reflected on it on clickin on COMPARE button")
	public void compareMobiles() {
		logger = report.startTest("compareMobiles",
				"Verify the pop-up window with the desired products reflected on it on clickin on COMPARE button")
				.assignCategory("Functional");

		hp.clickOnMobile();
		logger.log(LogStatus.INFO, "Clicked on Mobile menu");
		mp.xperiaAddToCompare();
		logger.log(LogStatus.PASS, "Succesfully clicked on Add To Compare button corresponding to Sony Experia");
		mp.iphoneAddToCompare();
		logger.log(LogStatus.PASS, "Succesfully clicked on Add To Compare button corresponding to IPhone");
		mp.compareButton();
		logger.log(LogStatus.PASS, "Successfully clicked on COMAPRE button");
		logger.log(LogStatus.INFO, "Popup window opens up");
		logger.log(LogStatus.INFO, "Switching to the new pop-up window...");
		Utility.switchToWindow();
		logger.log(LogStatus.PASS, "Switched to new popup window");
		pc.windowHeadingComparison();
		logger.log(LogStatus.PASS, "Popup window heading comparison completed");
		logger.log(LogStatus.INFO, "Verify the screenshots for product verification");
		logger.log(LogStatus.PASS, "Closing the popup window");
		pc.closeWindowBtn();
		logger.log(LogStatus.INFO, "Switching to main window..");
		Utility.switchToWindow();

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			try {
				Utility.takeScreenshotAtEndOfTest(driver, result.getMethod().getMethodName());
				SendFileEmail sendMail = new SendFileEmail();
				sendMail.sendMailWithAttachmentNew(reportPath, "murshitha.farveen@gmail.com");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			logger.log(LogStatus.ERROR, "Dependant test caese(s) will be skipped if any..! ");
			logger.log(LogStatus.FAIL, result.getThrowable());
			// Utility.takeScreenshotAtEndOfTest(driver,result.getMethod().getMethodName()+"_failed");
			try {
				Utility.takeScreenshotAtEndOfTest(driver, result.getMethod().getMethodName() + "_failed");
				SendFileEmail sendMail = new SendFileEmail();
				sendMail.sendMailWithAttachmentNew(reportPath, "murshitha.farveen@gmail.com");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		report.endTest(logger);
		report.flush();
	}

	/*@AfterTest()
	public void endReport(ITestResult result1) {
		if (result1.getStatus() == ITestResult.SUCCESS) {
			SendFileEmail sendMail = new SendFileEmail();
			sendMail.sendMailWithAttachmentNew(reportPath, "murshitha.farveen@gmail.com");
		} else {
			SendFileEmail sendMail = new SendFileEmail();
			sendMail.sendMailWithAttachmentNew(reportPath, "murshitha.farveen@gmail.com");
		}

		driver.quit();
	}
*/
	
	  @AfterClass public void closeBrowser() {
		  driver.quit(); report.close(); 
		  }
	 
}
