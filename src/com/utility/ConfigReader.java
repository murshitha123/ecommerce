/**
 * 
 */
package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author prosenjit.majumder
 * 
 */
public class ConfigReader extends BrowserFactory {

	//Properties prop;

	
	public String getDriverPath() {
		String path = prop.getProperty("driver_path");
		return path;

	}

	public String getDriverValue() {
		String value = prop.getProperty("driver_value");
		return value;
	}

	public String getURL() {
		return prop.getProperty("url");
	}

	public String homePageTitle() {
		return prop.getProperty("homePageTitle");
	}

	public String mobileElement() {
		return prop.getProperty("mobile_element_xpath");
	}

	public String mobilePageTitle() {
		return prop.getProperty("mobile_page_title");
	}

	public String sortbyElement() {
		return prop.getProperty("sortby_element_xpath");
	}

	public String sortedVisibleElement() {
		return prop.getProperty("visible_element_on_sorting");
	}

	public String sonyXperiaPrice() {
		return prop.getProperty("sony_xperia_price_xpath");

	}

	public String sonyXperiaLink() {
		return prop.getProperty("sony_xperia_link_id");
	}

	public String xperiaPriceDetails() {
		return prop.getProperty("sony_xperia_price_detailsscreen_xpath");
	}

	public String xperiaAddToCart() {
		return prop.getProperty("xperia_addToCart_xpath");
	}

	public String qty() {
		return prop.getProperty("qty_xpath");
	}

	public String qtyAmnt() {
		return prop.getProperty("qty");
	}

	public String update() {
		return prop.getProperty("update_xpath");

	}

	public String actErrorMsg() {
		return prop.getProperty("errorMsg_xpath");
	}

	public String expctdErrorMsg() {
		return prop.getProperty("expctedErrorMsg");
	}

	public String emptyCartBtn() {
		return prop.getProperty("emptyCartBttn_id");
	}

	public String actEmptyCartMsg() {
		return prop.getProperty("emptyCartMsg");
	}

	public String expctdEmptyCartMsg() {
		return prop.getProperty("expctedemptyCartMsg");

	}

	public String iphoneAddToCompare() {
		return prop.getProperty("Iphone_AddToCompare_xpath");
	}

	public String xperiaAddToCompare() {
		return prop.getProperty("Xperia_AddToCompare_xpath");
	}

	public String iphoneTitle() {
		return prop.getProperty("Iphone_Title_xpath");
	}

	public String xperiaTitle() {
		return prop.getProperty("Xperia_Title_xpath");
	}

	public String compareBtn() {
		return prop.getProperty("Compare_xpath");
	}

	public String expctdPopupHeading() {
		return prop.getProperty("pop_up_xpected_heading");
	}

	public String actualPopupHeading() {
		return prop.getProperty("pop_up_actual_heading_xpath");
	}

	public String closeWindow() {
		return prop.getProperty("close_popup_window_xpath");
	}

}