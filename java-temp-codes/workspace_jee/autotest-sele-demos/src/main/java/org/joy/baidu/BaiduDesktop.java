package org.joy.baidu;

import org.joy.fw.UIPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaiduDesktop extends UIPage {
	
	public BaiduDesktop() {
		super("http://www.baidu.com");
	}
	
	@FindBy(css="#kw")
//	@CacheLookup
	public WebElement searchTextbox;
	
	@FindBy(css="#su")
	public WebElement searchButton;
	
	public BaiduDetailPage searchText(String text) {
		searchTextbox.sendKeys(text);
		searchButton.click();
		return new BaiduDetailPage();
	}
	
}
