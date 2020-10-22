package test.com.xy6.interview.util;

import java.math.BigDecimal;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xy6.interview.util.ProductUtil;

public class TestProductUtil extends TestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRoundTax1() {
		BigDecimal bd = BigDecimal.ZERO;
		bd = ProductUtil.roundTax(new BigDecimal(0));
		assertEquals(bd.toString(),"0.00");
	}

	@Test
	public void testRoundTax2() {
		BigDecimal bd = BigDecimal.ZERO;
		bd = ProductUtil.roundTax(null);
		assertEquals(bd.toString(),"0.00");
	}

	@Test
	public void testRoundTax3() {
		BigDecimal bd = BigDecimal.ZERO;
		bd = ProductUtil.roundTax(new BigDecimal("7.125"));
		assertEquals(bd.toString(),"7.15");
	}

	@Test
	public void testRoundTax4() {
		BigDecimal bd = BigDecimal.ZERO;
		bd = ProductUtil.roundTax(new BigDecimal("-100"));
		assertEquals(bd.toString(),"0.00");
	}

	@Test
	public void testRoundTax5() {
		BigDecimal bd = BigDecimal.ZERO;
		bd = ProductUtil.roundTax(new BigDecimal("-10.5"));
		assertEquals(bd.toString(),"0.00");
	}

	@Test
	public void testRoundTax6() {
		BigDecimal bd = BigDecimal.ZERO;
		bd = ProductUtil.roundTax(new BigDecimal("10.5"));
		assertEquals(bd.toString(),"10.50");
	}

	@Test
	public void testRoundTax7() {
		BigDecimal bd = BigDecimal.ZERO;
		bd = ProductUtil.roundTax(new BigDecimal("10.1"));
		assertEquals(bd.toString(),"10.10");
	}

	@Test
	public void testRoundTax8() {
		BigDecimal bd = BigDecimal.ZERO;
		bd = ProductUtil.roundTax(new BigDecimal("10.157"));
		assertEquals(bd.toString(),"10.20");
	}

	@Test
	public void testRoundTax9() {
		BigDecimal bd = BigDecimal.ZERO;
		bd = ProductUtil.roundTax(new BigDecimal("10.147"));
		assertEquals(bd.toString(),"10.15");
	}

	@Test
	public void testRoundTax10() {
		BigDecimal bd = BigDecimal.ZERO;
		bd = ProductUtil.roundTax(new BigDecimal("10.123"));
		assertEquals(bd.toString(),"10.15");
	}

	@Test
	public void testRoundTax11() {
		BigDecimal bd = BigDecimal.ZERO;
		bd = ProductUtil.roundTax(new BigDecimal("10.16"));
		assertEquals(bd.toString(),"10.20");
	}

	@Test
	public void testRoundTax12() {
		BigDecimal bd = BigDecimal.ZERO;
		bd = ProductUtil.roundTax(new BigDecimal("10.15"));
		assertEquals(bd.toString(),"10.15");
	}

}
