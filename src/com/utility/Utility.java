/**
 * 
 */
package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Prosenjit
 * 
 */
public class Utility extends BrowserFactory {

	/*public static String captureScrenshot(WebDriver driver, String screenshotName) {

		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String dest = "D:\\eclipse_workspace\\RealTimeProject\\Screenshots\\" + screenshotName + ".png";

			// Copy the screenshot to desired location using copyFile method
			FileUtils.copyFile(src, new File(dest));
			// System.out.println("Screenshot taken!");
			return dest;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// System.out.println("Exception while taking the screenshot: "+e.getMessage());
			return e.getMessage();
		}
	}*/
	
	
	public static String ExtenthtmlReportPath()
	{
	String Path = "./Test_Report.html";
	return Path;
	}
	public static String getTimeStamp() {
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	    return timestamp;
	}
		
		public static void takeScreenshotAtEndOfTest(WebDriver driver,String testMethodName) throws IOException {
			try {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			String currentDir = System.getProperty("user.dir");
			//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" +getTimeStamp() + ".png"));
			
			FileUtils.copyFile(scrFile,new File(currentDir + "/Screenshots/"+testMethodName+getTimeStamp()+"_"+".jpg"));
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println("Exception while taking the screenshot: "+e.getMessage());
				System.out.println(e.getMessage());

	}
		}
			public static void switchToWindow() {
				try {
					for (String handle : driver.getWindowHandles()) {
						driver.switchTo().window(handle);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	


	
}
