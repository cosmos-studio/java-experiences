package com.xy6.interview;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.xy6.interview.util.ProductFreeTaxTypeUtil;

/**
 * 主程序
 *
 * @author daxiang
 * @since 2014-07-17
 */
public class Program {

	private static Logger logger = Logger.getLogger(Program.class);

	/**
	 * 程序入口
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String strLog4jFile = "G:/PROGRAM/j2ee/workspace/DemoInterview2/com/xy6/interview/config/log4j.properties";
		PropertyConfigurator.configure(strLog4jFile);
		ProductFreeTaxTypeUtil.init();
		calculateResult();
	}

	/**
	 * 展示各购物车的总税额和总价
	 */
	public static void calculateResult(){
		IProductService productService = new ProductService();
		String strFilePath;
		ProductResultForm resultForm;

		strFilePath = "G:/PROGRAM/j2ee/workspace/DemoInterview2/com/xy6/interview/data/";
		String[] strXmlFile = new String[]{"case1.xml","case2.xml","case3.xml"};
		for(String strXmlFilePath : strXmlFile){
			resultForm = new ProductResultForm();
			resultForm = productService.calcProductPrice(strFilePath + strXmlFilePath);
			logger.info(strXmlFilePath + ":");
			logger.info("total:" + resultForm.getBdTotalPrice().toString());
			logger.info("taxes:" + resultForm.getBdTotalTax().toString());
			logger.info("");
		}
	}
}
