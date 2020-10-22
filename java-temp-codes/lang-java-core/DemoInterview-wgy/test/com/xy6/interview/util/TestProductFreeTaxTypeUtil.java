package test.com.xy6.interview.util;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xy6.interview.util.ProductFreeTaxTypeUtil;

public class TestProductFreeTaxTypeUtil extends TestCase {

	public ArrayList<String> listFreeTaxProType;

	@Before
	public void setUp() throws Exception {
		listFreeTaxProType = ProductFreeTaxTypeUtil.listFreeTaxProType;
	}

	@After
	public void tearDown() throws Exception {
		ProductFreeTaxTypeUtil.init();
		listFreeTaxProType = new ArrayList<String>();
	}

	@Test
	public void testInitFreeTaxProTypeListTestNull() {
		boolean bBookFreeTax = listFreeTaxProType.contains(null);
		assertEquals(false,bBookFreeTax);
	}

	@Test
	public void testInitFreeTaxProTypeListTestEmpty() {
		boolean bBookFreeTax = listFreeTaxProType.contains("");
		assertEquals(false,bBookFreeTax);
	}

	@Test
	public void testInitFreeTaxProTypeListTestNormal1() {
		boolean bBookFreeTax = listFreeTaxProType.contains("book");
		assertEquals(true,bBookFreeTax);
	}

	@Test
	public void testInitFreeTaxProTypeListTestNormal2() {
		boolean bBookFreeTax = listFreeTaxProType.contains("medical");
		assertEquals(true,bBookFreeTax);
	}

	@Test
	public void testInitFreeTaxProTypeListTestNormal3() {
		boolean bBookFreeTax = listFreeTaxProType.contains("food");
		assertEquals(true,bBookFreeTax);
	}

	@Test
	public void testInitFreeTaxProTypeListTestNormal4() {
		boolean bBookFreeTax = listFreeTaxProType.contains("dvd");
		assertEquals(false,bBookFreeTax);
	}

	@Test
	public void testInitFreeTaxProTypeListTestNormal5() {
		boolean bBookFreeTax = listFreeTaxProType.contains("Book");
		assertEquals(false,bBookFreeTax);
	}

}
