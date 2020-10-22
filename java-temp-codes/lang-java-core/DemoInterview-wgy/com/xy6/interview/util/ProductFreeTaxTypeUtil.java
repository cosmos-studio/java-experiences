package com.xy6.interview.util;

import java.util.ArrayList;

import com.xy6.interview.IProductService;
import com.xy6.interview.ProductService;

/**
 * 免税商品类别工具类
 *
 * @author daxiang
 * @since 2014-07-17
 */
public class ProductFreeTaxTypeUtil {

	public static ArrayList<String> listFreeTaxProType = new ArrayList<String>();

	/**
	 * 初始化免税商品类型集合
	 */
	public static void init(){
		IProductService productService = new ProductService();
		String strFilePath = "G://PROGRAM//j2ee//workspace//DemoInterview2//com//xy6//interview//data//freetaxtype.xml";
		listFreeTaxProType = productService.readFreeTypeList(strFilePath);
	}
}
