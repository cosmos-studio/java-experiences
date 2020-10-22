package demo1;

public class BeanBiz {
	
	private BeanDao dao;
	
	{
		dao = new BeanDao();
	}
	
	public void doSth() {
		Bean bean = dao.fetch(1);
		bean.sayHello();
	}

}
