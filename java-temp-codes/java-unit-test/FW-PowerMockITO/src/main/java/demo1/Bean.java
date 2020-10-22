package demo1;

public class Bean {
	private int id;
	private String name;
	private int age;
	private String home;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	@Override
	public String toString() {
		return "Bean[id:" + this.id + ", name:" + this.name + ", age:" + this.age + ", home:" + this.home + "]";
	}

	public void sayHello() {
		System.out.println("Hello I'm " + this);
	}

}
