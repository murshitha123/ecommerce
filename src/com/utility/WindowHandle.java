/**
 * 
 */
package com.utility;

import org.openqa.selenium.WebDriver;

/**
 * @author prosenjit.majumder
 * 
 */
public class WindowHandle {

	WebDriver driver;

	public WindowHandle(WebDriver ldriver) {
		this.driver = ldriver;
	}

	public void switchToWindow() {
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
