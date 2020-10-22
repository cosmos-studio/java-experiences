package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.example.demo.domain.ResLink;
import com.example.demo.domain.properties.ProcessState;

@Mapper
public interface ResLinkDao {
	
	@Select("SELECT * FROM res_links where link_id = #{link_id}")
	@Results({
		@Result(property="linkId", column="link_id"),
		@Result(property="linkUrl", column="link_url"),
		@Result(property="linkTitle",column="link_title"),
		@Result(property="processState",column="process_state", javaType=ProcessState.class, jdbcType=JdbcType.VARCHAR),
		@Result(property="updateDate",column="update_dt", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
	})
	public ResLink queryRawUrlById(@Param("link_id") Integer link_id);
	
	@Select("SELECT count(1)+100 as c from res_links")
	@Results({
		@Result(column="c")
	})
	public Integer queryCount();

	/*
SELECT * from res_links limit 0, 10;
SELECT * from res_links limit 10, 10;
SELECT * from res_links limit 20, 10;
	 */
	@Select("SELECT * FROM res_links limit #{pageIndex}, #{pageSize}")
	@Results({
		@Result(property="linkId", column="link_id"),
		@Result(property="linkUrl", column="link_url"),
		@Result(property="linkTitle",column="link_title"),
		@Result(property="processState",column="process_state", javaType=ProcessState.class, jdbcType=JdbcType.VARCHAR),
		@Result(property="updateDate",column="update_dt", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
	})
	public List<ResLink> queryRawURLByPage(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

	@Insert("INSERT INTO res_links(link_title, link_url, process_state) values(#{linkTitle}, #{linkUrl}, #{processState})")
	public void add(ResLink resLink);
}
