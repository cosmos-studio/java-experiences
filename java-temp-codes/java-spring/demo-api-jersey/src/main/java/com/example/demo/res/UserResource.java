package com.example.demo.res;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	@Autowired
	private UserService userService;

	@POST
	public JsonResult addUser(User user) throws Exception {
		JsonResult jr = new JsonResult();
		if (user == null) {
			jr.result(JsonStatus.FAILURE).setResult(null);
			return jr;
		}
		String newUserId = user.getUser_id();
		User newUser = userService.queryById(newUserId);
		if (newUser != null) {
			jr.result(JsonStatus.FAILURE).setResult(null);
			return jr;
		} else {
			newUserId = UUID.randomUUID().toString().replaceAll("-", "");
			user.setUser_id(newUserId);
		}
		userService.add(user);
		jr.result(JsonStatus.SUCCESS).setResult(user);
		return jr;
	}

	@GET
	public JsonResult findAll() {
		JsonResult jr = new JsonResult();
		List<User> userList = userService.queryAll();
		jr.result(JsonStatus.SUCCESS).setResult(userList);
		return jr;
	}

	@GET
	@Path("{user_id}")
	public JsonResult findById(@PathParam("user_id") String user_id) {
		JsonResult jr = new JsonResult();
		if (user_id == null) {
			jr.result(JsonStatus.FAILURE).setResult(null);
			return jr;
		}
		User user = userService.queryById(user_id);
		jr.result(JsonStatus.SUCCESS).setResult(user);
		return jr;
	}

	@DELETE
	@Path("{user_id}")
	public JsonResult deleteById(@PathParam("user_id") String user_id) {
		JsonResult jr = new JsonResult();
		if (user_id == null) {
			jr.result(JsonStatus.FAILURE).setResult(null);
			return jr;
		}
		User delUser = userService.queryById(user_id);
		if (delUser == null) {
			jr.result(JsonStatus.FAILURE).setResult(null);
			return jr;
		}
		userService.deleteByIds(new String[] { user_id });
		jr.result(JsonStatus.SUCCESS).setResult(delUser);
		return jr;
	}

	@PUT
	public JsonResult update(User user) {
		JsonResult jr = new JsonResult();
		if (user == null) {
			jr.result(JsonStatus.FAILURE).setResult(null);
			return jr;
		}
		String newUserId = user.getUser_id();
		User updateUser = userService.queryById(newUserId);
		if (updateUser == null) {
			jr.result(JsonStatus.FAILURE).setResult(null);
			return jr;
		}
		userService.update(user);
		User user2 = userService.queryById(user.getUser_id());
		jr.result(JsonStatus.SUCCESS).setResult(user2);
		return jr;
	}

}
