package com.example.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "url", locations="classpath:mybeans.properties")
public class Url {

	private int url_id;
	private String url_key;
	private String url_value;

	@Override
	public String toString() {
		return "Url [url_id=" + url_id + ", url_key=" + url_key + ", url_value=" + url_value + "]";
	}

	public int getUrl_id() {
		return url_id;
	}

	public void setUrl_id(int url_id) {
		this.url_id = url_id;
	}

	public String getUrl_key() {
		return url_key;
	}

	public void setUrl_key(String url_key) {
		this.url_key = url_key;
	}

	public String getUrl_value() {
		return url_value;
	}

	public void setUrl_value(String url_value) {
		this.url_value = url_value;
	}

}
