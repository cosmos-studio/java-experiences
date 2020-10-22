package demo1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import demo1.Bean;
import org.junit.Assert;

@RunWith(PowerMockRunner.class)
public class BeanTestCases {

	@Test
	@PrepareForTest({ Bean.class})
	public void testToString() {
		Bean bean = new Bean();
		bean.setId(1);
		bean.setAge(10);
		bean.setName("Jim");
		bean.setHome("MyHome");
		String expectStr = "Bean[id:1, name:Jim, age:10, home:MyHome]";
		String resultStr = bean.toString();
		Assert.assertEquals(expectStr, resultStr);
	}

	@Test
	@PrepareForTest({ Bean.class})
	public void testSayHello() {
		Bean beanMock = PowerMockito.mock(Bean.class);
		PowerMockito.when(beanMock.toString()).thenReturn("[TOSTR-MOTHOD]");
		beanMock.sayHello();
	}

}
