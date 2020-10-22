package java8.annotation.demo1;

public class __Main__ {

	public static void main(String[] args) {
		User user1 = new User();
		user1.setId(0001);// 查询ID为0001的用户
		user1.setName("繁华");// 查询昵称为繁华的用户

		User user2 = new User();
		user2.setName("Jack");// 查询用户名为Jack的用户
		user2.setAge(18);// 查询年龄为18的用户

		User user3 = new User();
		user3.setEmail("lian@sina.com, jiang@qq.com");// 查询邮箱为其中任意一个的用户

		System.out.println(SqlParser.getQuerySql(user1));
		System.out.println(SqlParser.getQuerySql(user2));
		System.out.println(SqlParser.getQuerySql(user3));
	}

}
