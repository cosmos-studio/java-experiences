package ut.mock;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class MockTestMbean {

	@Test
	public void testMyBean() {
		MyBean mock1 = Mockito.mock(MyBean.class);
		MyBean mock2 = Mockito.mock(MyBean.class);

		Assert.assertFalse("Is not MyBean: ", mock1.getClass().equals(MyBean.class));
		Assert.assertTrue("Test MyBean mock1: ", mock1 instanceof MyBean);
		Assert.assertTrue("Test MyBean mock2: ", mock2 instanceof MyBean);
		Assert.assertFalse(mock1.equals(mock2));
	}

	@Test
	public void testMyBeanUser() {
		final int len = 10;
//		List<MyBean> list1 = new LinkedList<>();
//		for (int i = 0; i < 10; i++) {
//			MyBean bean = UseBean.createAMyBean();
//			list1.add(bean);
//		}
		List<MyBean> list2 = UseBean.createNBean(len);
//		System.out.println(list1);
//		System.out.println(list2);

		MyBean mb = list2.stream().filter(e -> e.getId() > 6).filter(e->e.getId()<8).findFirst().get();
		System.out.println(mb);
	}

}
