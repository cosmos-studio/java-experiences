package ut.mock;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class UseBean {

	public static MyBean createAMyBean() {
		Random random = new Random();
		return new MyBean("N" + random.nextInt(100), "A", "T");
	}

	public static List<MyBean> createNBean(int count) {
		List<MyBean> list = new LinkedList<>();
		for (int i = 0; i < count; i++) {
			list.add(createAMyBean());
		}
		return list;
	}

}
