package test.com.xy6.interview.util;

import java.math.BigDecimal;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xy6.interview.util.ProductConstants;

public class TestProductConstants extends TestCase {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testProductConstantsRateBasic(){
		assertEquals(new BigDecimal("0.10"),ProductConstants.RateBasic);
	}

	@Test
	public void testProductConstantsRateBasicNotEqual1(){
		boolean bResult = (null == ProductConstants.RateBasic);
		assertEquals(false,bResult);
	}

	@Test
	public void testProductConstantsRateBasicNotEqual2(){
		boolean bResult = (new BigDecimal("0.11") == ProductConstants.RateBasic);
		assertEquals(false,bResult);
	}

	@Test
	public void testProductConstantsRateBasicNotEqual3(){
		boolean bResult = (new BigDecimal("0.101") == ProductConstants.RateBasic);
		assertEquals(false,bResult);
	}

	@Test
	public void testProductConstantsRateImport(){
		assertEquals(new BigDecimal("0.05"),ProductConstants.RateImport);
	}

	@Test
	public void testProductConstantsRateImportNotEqual1(){
		boolean bResult = (null == ProductConstants.RateImport);
		assertEquals(false,bResult);
	}

	@Test
	public void testProductConstantsRateImportNotEqual2(){
		boolean bResult = (new BigDecimal("0.06") == ProductConstants.RateImport);
		assertEquals(false,bResult);
	}

	@Test
	public void testProductConstantsRateImportNotEqual3(){
		boolean bResult = (new BigDecimal("0.051") == ProductConstants.RateImport);
		assertEquals(false,bResult);
	}
}
