package com.leetcode.a001;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.icanbe.util.Utils;

public class TestSolution {

	@Test(dataProvider = "data")
	public void test1(List<DataEntry> dataEntryList) {
		Solution solution = new Solution();
		for (DataEntry entry : dataEntryList) {
			int[] expected = entry.getExpected();
			int[] nums = entry.getNums();
			int target = entry.getTarget();
			int[] result = solution.twoSum1(nums, target);
			Assert.assertEquals(result, expected);
		}
	}

	@Test(dataProvider = "data")
	public void test2(List<DataEntry> dataEntryList) {
		Solution solution = new Solution();
		for (DataEntry entry : dataEntryList) {
			int[] expected = entry.getExpected();
			int[] nums = entry.getNums();
			int target = entry.getTarget();
			int[] result = solution.twoSum2(nums, target);
			Assert.assertEquals(result, expected);
		}
	}

	@DataProvider(name = "data")
	public Object[][] dataProvider() {
		List<DataEntry> dataEntryList = Utils.parseJSON2List("data.json", DataEntry.class);;
		return new Object[][] { { dataEntryList } };
	}

}
