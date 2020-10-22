package org.joy.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class UIPage {

	public UIPage(String url) {
		DRIVER.get(url);
		PageFactory.initElements(DRIVER, this);
	}
	
	public UIPage() {
		PageFactory.initElements(DRIVER, this);
	}

	public void close() {
		DRIVER.quit();
	}

	private static WebDriver DRIVER;
	private static String FIREFOX_PATH = "C:/softwares/Mozilla Firefox/firefox.exe";

	static {
		System.setProperty("webdriver.firefox.bin", FIREFOX_PATH);
		DRIVER = new FirefoxDriver();

	}

}
