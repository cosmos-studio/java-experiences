package demo1;

public class BeanDao {
	
	public Bean fetch(int id) {
		Bean bean = new Bean();
		bean.setId(id);
		bean.setAge(id*10);
		bean.setName("<Name-"+id+">");
		bean.setHome("<Home-"+id+">");
		return bean;
	}
	
}
