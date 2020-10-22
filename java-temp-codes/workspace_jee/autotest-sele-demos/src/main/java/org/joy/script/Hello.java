package org.joy.script;

import org.joy.baidu.BaiduDesktop;
import org.joy.baidu.BaiduDetailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hello {

	@Test
	public void test1() {
		BaiduDesktop baidu = new BaiduDesktop();
		BaiduDetailPage detailPage = baidu.searchText("Selenium java");
		Assert.assertTrue(detailPage.isBarExist());
		System.out.println(detailPage.getNumText());
		detailPage.close();
	}

}
