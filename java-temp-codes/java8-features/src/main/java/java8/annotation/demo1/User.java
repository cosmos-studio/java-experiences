package java8.annotation.demo1;

@AnnTable("uentity")
public class User {

	@AnnColumn("uid")
	private int id;

	@AnnColumn("uname")
	private String name;

	@AnnColumn("uage")
	private int age;

	@AnnColumn("uemail")
	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
