package test.com.xy6.interview;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xy6.interview.ProductDAO;
import com.xy6.interview.ProductForm;

public class TestProductDAO extends TestCase {

	public static ProductDAO productDAO = new ProductDAO();
	public static TestProductFormHelper helper = new TestProductFormHelper();

	@Before
	public void setUp() throws Exception {
		helper.bCalced = false;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadFreeTypeListNull() {
		ArrayList<String> listFreeTypeList = productDAO.readFreeTypeList(null);
		ArrayList<String> list = new ArrayList<String>();
		assertEquals(list,listFreeTypeList);
	}

	@Test
	public void testReadFreeTypeListEmpty1() {
		ArrayList<String> listFreeTypeList = productDAO.readFreeTypeList("");
		ArrayList<String> list = new ArrayList<String>();
		assertEquals(list,listFreeTypeList);
	}

	@Test
	public void testReadFreeTypeListEmpty2() {
		ArrayList<String> listFreeTypeList = productDAO.readFreeTypeList("  ");
		ArrayList<String> list = new ArrayList<String>();
		assertEquals(list,listFreeTypeList);
	}

	@Test
	public void testReadFreeTypeListInvalidFile() {
		ArrayList<String> listFreeTypeList = productDAO.readFreeTypeList("aaa");
		ArrayList<String> list = new ArrayList<String>();
		assertEquals(list,listFreeTypeList);
	}

	@Test
	public void testReadFreeTypeListNormal1() {
		String strXmlFilePath = "G://PROGRAM//j2ee//workspace//DemoInterview2//com//xy6//interview//data//freetaxtype.xml";
		ArrayList<String> listFreeTypeList = productDAO.readFreeTypeList(strXmlFilePath);
		ArrayList<String> list = new ArrayList<String>();
		list.add("book");
		list.add("medical");
		list.add("food");
		assertEquals(list,listFreeTypeList);
	}

	@Test
	public void testReadProductListNull() {
		ArrayList<ProductForm> listForm = new ArrayList<ProductForm>();
		assertEquals(listForm,productDAO.readProductList(null));
	}

	@Test
	public void testReadProductListEmpty1() {
		String strXmlFilePath = "";
		strXmlFilePath = "";
		ArrayList<ProductForm> listForm = new ArrayList<ProductForm>();
		assertEquals(listForm,productDAO.readProductList(strXmlFilePath));
	}

	@Test
	public void testReadProductListEmpty2() {
		String strXmlFilePath = "";
		strXmlFilePath = "   ";
		ArrayList<ProductForm> listForm = new ArrayList<ProductForm>();
		assertEquals(listForm,productDAO.readProductList(strXmlFilePath));
	}

	@Test
	public void testReadProductListCase1(){
		String strXmlFilePath = "";
		strXmlFilePath = "G://PROGRAM//j2ee//workspace//DemoInterview//com//xy6//interview//data//case1.xml";
		ArrayList<ProductForm> listForm = productDAO.readProductList(strXmlFilePath);
		assertEquals(3,listForm.size());
		assertEquals(helper.getCase1ListForm().toString(),listForm.toString());
	}

	@Test
	public void testReadProductListCase2(){
		String strXmlFilePath = "";
		strXmlFilePath = "G://PROGRAM//j2ee//workspace//DemoInterview//com//xy6//interview//data//case2.xml";
		ArrayList<ProductForm> listForm = productDAO.readProductList(strXmlFilePath);
		assertEquals(2,listForm.size());
		assertEquals(helper.getCase2ListForm().toString(),listForm.toString());
	}

	@Test
	public void testReadProductListCase3(){
		String strXmlFilePath = "";
		strXmlFilePath = "G://PROGRAM//j2ee//workspace//DemoInterview//com//xy6//interview//data//case3.xml";
		ArrayList<ProductForm> listForm = productDAO.readProductList(strXmlFilePath);
		assertEquals(4,listForm.size());
		assertEquals(helper.getCase3ListForm().toString(),listForm.toString());
	}

	@Test
	public void testReadProductListInvalidFile() {
		String strXmlFilePath = "";
		strXmlFilePath = "aaa";
		ArrayList<ProductForm> listForm = new ArrayList<ProductForm>();
		assertEquals(listForm,productDAO.readProductList(strXmlFilePath));
	}

}
