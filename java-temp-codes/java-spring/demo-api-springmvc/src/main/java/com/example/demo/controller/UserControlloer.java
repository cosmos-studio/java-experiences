package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/api2")
public class UserControlloer {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseEntity<JsonResult> add(@RequestHeader(value = "param") JSONObject json) throws JSONException {
		String firstName = (String) json.get("first_name");
		String lastName = (String) json.get("last_name");
		String user_id = UUID.randomUUID().toString().replaceAll("-", "");
		User user = new User(user_id, firstName, lastName);
		int cnt = userService.add(user);
		JsonResult jr = new JsonResult();
		jr.result(JsonStatus.SUCCESS).setResult(cnt);
		return ResponseEntity.ok(jr);
	}

	@RequestMapping(value = "add", method = RequestMethod.PUT)
	public ResponseEntity<JsonResult> update(@RequestHeader(value = "param") JSONObject json) throws JSONException {
		String firstName = (String) json.get("first_name");
		String lastName = (String) json.get("last_name");
		String user_id = (String) json.get("user_id");
		User user = new User(user_id, firstName, lastName);
		String phone_num = (String) json.get("phone_num");
		user.setPhone_num(phone_num);
		int cnt = userService.update(user);
		JsonResult jr = new JsonResult();
		jr.result(JsonStatus.SUCCESS).setResult(cnt);
		return ResponseEntity.ok(jr);
	}

	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public ResponseEntity<JsonResult> delete(@RequestHeader(value = "param") JSONObject json) throws JSONException {
		String userIdListStr = (String) json.get("idList");
		String[] userIds = userIdListStr.split(",");
		int cnt = userService.deleteByIds(userIds);
		JsonResult jr = new JsonResult();
		jr.result(JsonStatus.SUCCESS).setResult(cnt);
		return ResponseEntity.ok(jr);
	}

	@RequestMapping(value = "users", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> findAll() {
		JsonResult jr = new JsonResult();
		List<User> userList = userService.queryAll();
		jr.result(JsonStatus.SUCCESS).setResult(userList);
		return ResponseEntity.ok(jr);
	}


	@RequestMapping(value = "user", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> findById(@RequestParam(value = "user_id") String user_id) throws JSONException {
		JsonResult jr = new JsonResult();
		User user = userService.queryById(user_id);
		jr.result(JsonStatus.SUCCESS).setResult(user);
		return ResponseEntity.ok(jr);
	}
}
