package test.com.xy6.interview;

import java.math.BigDecimal;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xy6.interview.ProductForm;
import com.xy6.interview.ProductResultForm;
import com.xy6.interview.ProductService;
import com.xy6.interview.util.ProductFreeTaxTypeUtil;

public class TestProductService extends TestCase {

	public static ProductService productService = new ProductService();
	public static TestProductFormHelper helper = new TestProductFormHelper();

	@Before
	public void setUp() throws Exception {
		ProductFreeTaxTypeUtil.init();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadFreeTypeListNull() {
		ArrayList<String> listFreeTypeList = productService.readFreeTypeList(null);
		ArrayList<String> list = new ArrayList<String>();
		assertEquals(list,listFreeTypeList);
	}

	@Test
	public void testReadFreeTypeListEmpty1() {
		ArrayList<String> listFreeTypeList = productService.readFreeTypeList("");
		ArrayList<String> list = new ArrayList<String>();
		assertEquals(list,listFreeTypeList);
	}

	@Test
	public void testReadFreeTypeListEmpty2() {
		ArrayList<String> listFreeTypeList = productService.readFreeTypeList("  ");
		ArrayList<String> list = new ArrayList<String>();
		assertEquals(list,listFreeTypeList);
	}

	@Test
	public void testReadFreeTypeListInvalidFile() {
		ArrayList<String> listFreeTypeList = productService.readFreeTypeList("aaa");
		ArrayList<String> list = new ArrayList<String>();
		assertEquals(list,listFreeTypeList);
	}

	@Test
	public void testReadFreeTypeListNormal1() {
		String strXmlFilePath = "G://PROGRAM//j2ee//workspace//DemoInterview2//com//xy6//interview//data//freetaxtype.xml";
		ArrayList<String> listFreeTypeList = productService.readFreeTypeList(strXmlFilePath);
		ArrayList<String> list = new ArrayList<String>();
		list.add("book");
		list.add("medical");
		list.add("food");
		assertEquals(list,listFreeTypeList);
	}

	@Test
	public void testReadProductListNull() {
		ArrayList<ProductForm> listForm = new ArrayList<ProductForm>();
		assertEquals(listForm,productService.readProductList(null));
	}

	@Test
	public void testReadProductListEmpty1() {
		String strXmlFilePath = "";
		strXmlFilePath = "";
		ArrayList<ProductForm> listForm = new ArrayList<ProductForm>();
		assertEquals(listForm,productService.readProductList(strXmlFilePath));
	}

	@Test
	public void testReadProductListEmpty2() {
		String strXmlFilePath = "";
		strXmlFilePath = "   ";
		ArrayList<ProductForm> listForm = new ArrayList<ProductForm>();
		assertEquals(listForm,productService.readProductList(strXmlFilePath));
	}

	@Test
	public void testReadProductListCase1(){
		String strXmlFilePath = "";
		strXmlFilePath = "G://PROGRAM//j2ee//workspace//DemoInterview2//com//xy6//interview//data//case1.xml";
		ArrayList<ProductForm> listForm = productService.readProductList(strXmlFilePath);
		assertEquals(3,listForm.size());
		assertEquals(helper.getCase1ListForm().toString(),listForm.toString());
	}

	@Test
	public void testReadProductListCase2(){
		String strXmlFilePath = "";
		strXmlFilePath = "G://PROGRAM//j2ee//workspace//DemoInterview2//com//xy6//interview//data//case2.xml";
		ArrayList<ProductForm> listForm = productService.readProductList(strXmlFilePath);
		assertEquals(2,listForm.size());
		assertEquals(helper.getCase2ListForm().toString(),listForm.toString());
	}

	@Test
	public void testReadProductListCase3(){
		String strXmlFilePath = "";
		strXmlFilePath = "G://PROGRAM//j2ee//workspace//DemoInterview2//com//xy6//interview//data//case3.xml";
		ArrayList<ProductForm> listForm = productService.readProductList(strXmlFilePath);
		assertEquals(4,listForm.size());
		assertEquals(helper.getCase3ListForm().toString(),listForm.toString());
	}

	@Test
	public void testReadProductListInvalidFile() {
		String strXmlFilePath = "";
		strXmlFilePath = "aaa";
		ArrayList<ProductForm> listForm = new ArrayList<ProductForm>();
		assertEquals(listForm,productService.readProductList(strXmlFilePath));
	}

	@Test
	public void testCalcProductPriceNull() {
		ProductResultForm resultForm = new ProductResultForm();
		assertEquals(resultForm.toString(),productService.calcProductPrice(null).toString());
	}

	@Test
	public void testCalcProductPriceEmpty1() {
		ProductResultForm resultForm = new ProductResultForm();
		assertEquals(resultForm.toString(),productService.calcProductPrice("").toString());
	}

	@Test
	public void testCalcProductPriceEmpty2() {
		ProductResultForm resultForm = new ProductResultForm();
		assertEquals(resultForm.toString(),productService.calcProductPrice("   ").toString());
	}

	@Test
	public void testCalcProductPriceInvalidFile() {
		ProductResultForm resultForm = new ProductResultForm();
		assertEquals(resultForm.toString(),productService.calcProductPrice("aaa").toString());
	}

	@Test
	public void testCalcProductPriceCase1() {
		String strXmlFilePath = "";
		strXmlFilePath = "G://PROGRAM//j2ee//workspace//DemoInterview2//com//xy6//interview//data//case1.xml";
		ProductResultForm resultForm = new ProductResultForm();
		resultForm.setBdTotalTax(new BigDecimal("1.50"));
		resultForm.setBdTotalPrice(new BigDecimal("29.83"));
		assertEquals(resultForm.toString(),productService.calcProductPrice(strXmlFilePath).toString());
	}

	@Test
	public void testCalcProductPriceCase2() {
		String strXmlFilePath = "";
		strXmlFilePath = "G://PROGRAM//j2ee//workspace//DemoInterview2//com//xy6//interview//data//case2.xml";
		ProductResultForm resultForm = new ProductResultForm();
		resultForm.setBdTotalTax(new BigDecimal("7.65"));
		resultForm.setBdTotalPrice(new BigDecimal("65.15"));
		assertEquals(resultForm.toString(),productService.calcProductPrice(strXmlFilePath).toString());
	}

	@Test
	public void testCalcProductPriceCase3() {
		String strXmlFilePath = "";
		strXmlFilePath = "G://PROGRAM//j2ee//workspace//DemoInterview2//com//xy6//interview//data//case3.xml";
		ProductResultForm resultForm = new ProductResultForm();
		resultForm.setBdTotalTax(new BigDecimal("6.70"));
		resultForm.setBdTotalPrice(new BigDecimal("74.68"));
		assertEquals(resultForm.toString(),productService.calcProductPrice(strXmlFilePath).toString());
	}

	@Test
	public void testCalcEachPriceAndTaxNull() {
		assertEquals(null,productService.calcEachPriceAndTax(null));
	}

	@Test
	public void testCalcEachPriceAndTaxEmpty() {
		ArrayList<ProductForm> listProductForm = new ArrayList<ProductForm>();
		assertEquals(listProductForm,productService.calcEachPriceAndTax(listProductForm));
	}

	@Test
	public void testCalcEachPriceAndTaxCase1() {
		helper.bCalced = false;
		ArrayList<ProductForm> listProductForm = helper.getCase1ListForm();
		helper.bCalced = true;
		ArrayList<ProductForm> listProductForm2 = helper.getCase1ListForm();
		assertEquals(listProductForm2.toString(),productService.calcEachPriceAndTax(listProductForm).toString());
	}

	@Test
	public void testCalcEachPriceAndTaxCase2() {
		helper.bCalced = false;
		ArrayList<ProductForm> listProductForm = helper.getCase2ListForm();
		helper.bCalced = true;
		ArrayList<ProductForm> listProductForm2 = helper.getCase2ListForm();
		assertEquals(listProductForm2.toString(),productService.calcEachPriceAndTax(listProductForm).toString());
	}

	@Test
	public void testCalcEachPriceAndTaxCase3() {
		helper.bCalced = false;
		ArrayList<ProductForm> listProductForm = helper.getCase3ListForm();
		helper.bCalced = true;
		ArrayList<ProductForm> listProductForm2 = helper.getCase3ListForm();
		assertEquals(listProductForm2.toString(),productService.calcEachPriceAndTax(listProductForm).toString());
	}

	@Test
	public void testCalcTotalPriceAndTaxNull() {
		ProductResultForm resultForm = new ProductResultForm();
		assertEquals(resultForm.toString(),productService.calcTotalPriceAndTax(null).toString());
	}

	@Test
	public void testCalcTotalPriceAndTaxEmpty() {
		ArrayList<ProductForm> listProductForm = new ArrayList<ProductForm>();
		ProductResultForm resultForm = new ProductResultForm();
		assertEquals(resultForm.toString(),productService.calcTotalPriceAndTax(listProductForm).toString());
	}

	@Test
	public void testCalcTotalPriceAndTaxCase1() {
		helper.bCalced = true;
		ArrayList<ProductForm> listProductForm = helper.getCase1ListForm();
		ProductResultForm resultForm = new ProductResultForm();
		resultForm.setBdTotalTax(new BigDecimal("1.50"));
		resultForm.setBdTotalPrice(new BigDecimal("29.83"));
		assertEquals(resultForm.toString(),productService.calcTotalPriceAndTax(listProductForm).toString());
	}

	@Test
	public void testCalcTotalPriceAndTaxCase2() {
		helper.bCalced = true;
		ArrayList<ProductForm> listProductForm = helper.getCase2ListForm();
		ProductResultForm resultForm = new ProductResultForm();
		resultForm.setBdTotalTax(new BigDecimal("7.65"));
		resultForm.setBdTotalPrice(new BigDecimal("65.15"));
		assertEquals(resultForm.toString(),productService.calcTotalPriceAndTax(listProductForm).toString());
	}

	@Test
	public void testCalcTotalPriceAndTaxCase3() {
		helper.bCalced = true;
		ArrayList<ProductForm> listProductForm = helper.getCase3ListForm();
		ProductResultForm resultForm = new ProductResultForm();
		resultForm.setBdTotalTax(new BigDecimal("6.70"));
		resultForm.setBdTotalPrice(new BigDecimal("74.68"));
		assertEquals(resultForm.toString(),productService.calcTotalPriceAndTax(listProductForm).toString());
	}

}
