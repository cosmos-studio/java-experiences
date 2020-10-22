package cn.usmile365.jsonpath;

import java.io.InputStream;
import java.util.List;

import org.testng.annotations.Test;

import com.jayway.restassured.path.json.JsonPath;

//import com.jayway.jsonpath.JsonPath;
//
//public class TestJson {
//
//	@Test
//	public void testJson1() throws Exception {
//		InputStream json = System.class.getResourceAsStream("/cn/usmile365/jsonpath/json4.json");
//		List<Object> authors = JsonPath.read(json, "$.store.book[?(@.tattr==false)]");
//		System.out.println(authors.size());
//	}
//
//}

public class TestJson {
	@Test
	public void testJson2() throws Exception {
		Object obj;
		InputStream json;
		json = System.class.getResourceAsStream("/cn/usmile365/jsonpath/json3.json");
		obj= JsonPath.with(json).get("category.findAll()");
		System.out.println((List<String>)obj);
		
		json = System.class.getResourceAsStream("/cn/usmile365/jsonpath/json3.json");
		obj= JsonPath.with(json).get("tattr.findAll{ tattr-> tattr!=true }");
		System.out.println((List<Boolean>)obj);
		
		json = System.class.getResourceAsStream("/cn/usmile365/jsonpath/json3.json");
		obj= JsonPath.with(json).get("every {it-> it.tattr != false}");
		System.out.println(obj);
		
		json = System.class.getResourceAsStream("/cn/usmile365/jsonpath/json3.json");
		obj= JsonPath.with(json).get("any {it-> it.tattr != false}");
		System.out.println(obj);
		
		json = System.class.getResourceAsStream("/cn/usmile365/jsonpath/json3.json");
		obj= JsonPath.with(json).get("tattr.findAll{ tattr-> tattr!=true || tattr!=false }.unique()");
		System.out.println(obj);
		
		json = System.class.getResourceAsStream("/cn/usmile365/jsonpath/json3.json");
		obj= JsonPath.with(json).get("last()");
		System.out.println(obj);
		
		json = System.class.getResourceAsStream("/cn/usmile365/jsonpath/json3.json");
		obj= JsonPath.with(json).get("findAll()");
		System.out.println(obj);
	}

}