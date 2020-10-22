package com.example.demo.dao;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.example.demo.bean.User;

@Component
//@Mapper
public interface UserDaoMapper {
	@Insert("insert into users(user_id, first_name, last_name, phone_num) "
			+ "values(#{user_id}, #{first_name}, #{last_name}, #{phone_num})")
	int add(User user);

	@Update("update users set first_name=#{first_name},last_name=#{last_name},"
			+ "phone_num=#{phone_num} where user_id = #{user_id}")
	int update(User user);

	@DeleteProvider(type = UserSqlBuilder.class, method = "deleteByids")
	int deleteByIds(@Param("ids") String[] ids);

	@Select("select * from users where user_id = #{user_id}")
	@Results(id = "userMap", value = { @Result(column = "user_id", property = "user_id", javaType = String.class),
			@Result(property = "first_name", column = "first_name", javaType = String.class),
			@Result(property = "last_name", column = "last_name", javaType = String.class),
			@Result(property = "phone_num", column = "phone_num", javaType = String.class) })
	User queryById(@Param("user_id") String user_id);

	@SelectProvider(type = UserSqlBuilder.class, method = "queryAllByParams")
	List<User> queryAll();

	public class UserSqlBuilder {
		public String queryAllByParams() {
			StringBuffer sql = new StringBuffer();
			sql.append("select * from users where 1=1");
			return sql.toString();
		}

		public String deleteByids(@Param("ids") final String[] ids) {
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM Users WHERE user_id in(");
			for (int i = 0; i < ids.length; i++) {
				if (i == ids.length - 1) {
					sql.append("'").append(ids[i]).append("'");
				} else {
					sql.append("'").append(ids[i]).append("',");
				}
			}
			sql.append(")");
			System.out.println(sql);
			return sql.toString();
		}
	}
}
