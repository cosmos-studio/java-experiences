package org.joy.baidu;

import org.joy.fw.UIPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BaiduDetailPage extends UIPage{
	
	public BaiduDetailPage() {
	}

	@FindBy(css = "#s_tab")
	private WebElement bar;
	
	@FindBy(how = How.XPATH, xpath = "//*[@id='container']/div[2]/div/div[2]")
	private WebElement numText;
	
	
	public boolean isBarExist() {
		boolean flag = false;
		flag = bar.isDisplayed();
		return flag;
	}
	
	public String getNumText() {
		return numText.getText();
	}
	
}
