package test.com.xy6.interview;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.apache.log4j.PropertyConfigurator;

import test.com.xy6.interview.util.TestProductConstants;
import test.com.xy6.interview.util.TestProductFreeTaxTypeUtil;
import test.com.xy6.interview.util.TestProductUtil;

public class TestRunning extends TestCase {

	static {
		// 不能在main中进行初始化
		String strLog4jFile = "G:/PROGRAM/j2ee/workspace/DemoInterview2/com/xy6/interview/config/log4j.properties";
		PropertyConfigurator.configure(strLog4jFile);
	}

	public static void main(String[] args){
		TestRunner.run(suite());
	}

	public static Test suite(){
		TestSuite suite = new TestSuite();

		suite.addTestSuite(TestProductDAO.class);
		suite.addTestSuite(TestProductService.class);

		suite.addTestSuite(TestProductConstants.class);
		suite.addTestSuite(TestProductFreeTaxTypeUtil.class);
		suite.addTestSuite(TestProductUtil.class);
		return suite;
	}
}
