package com.example.demo.controller;

public class JsonResult {

	private JsonStatus status = null;
	private Object result = null;

	public JsonResult result(JsonStatus status) {
		this.status = status;
		return this;
	}

	// getters and setters
	public JsonStatus getStatus() {
		return status;
	}

	public void setStatus(JsonStatus status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
