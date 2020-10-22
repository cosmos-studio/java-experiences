package cn.icanbe.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

public class Utils {

	public static <T> T parseJSON2Object(String dataFileName, Class<T> clazz) {
		// argument validation
		if (StringUtils.isBlank(dataFileName) && null == clazz) {
			throw new IllegalArgumentException("argument is empty");
		}

		// base class is the class you use this method
		StackTraceElement stackTraceElement = new Exception().getStackTrace()[1];
		Class<?> baseCls;
		try {
			baseCls = Class.forName(stackTraceElement.getClassName());
		} catch (ClassNotFoundException e1) {
			throw new RuntimeException("");
		}

		// read JSON file content to string
		File dateFile = new File(baseCls.getResource(dataFileName).getFile());
		String jsonString = null;
		try {
			jsonString = FileUtils.readFileToString(dateFile, Charset.defaultCharset());
		} catch (IOException e) {
			throw new RuntimeException("");
		}

		// parse to java object
		return JSON.parseObject(jsonString, clazz);
	}

	public static <T> List<T> parseJSON2List(String dataFileName, Class<T> clazz) {
		// argument validation
		if (StringUtils.isBlank(dataFileName) && null == clazz) {
			throw new IllegalArgumentException("argument is empty");
		}

		// base class is the class you use this method
		StackTraceElement stackTraceElement = new Exception().getStackTrace()[1];
		Class<?> baseCls;
		try {
			baseCls = Class.forName(stackTraceElement.getClassName());
		} catch (ClassNotFoundException e1) {
			throw new RuntimeException("");
		}

		// read JSON file content to string
		File dateFile = new File(baseCls.getResource(dataFileName).getFile());
		String jsonString = null;
		try {
			jsonString = FileUtils.readFileToString(dateFile, Charset.defaultCharset());
		} catch (IOException e) {
			throw new RuntimeException("");
		}

		// parse to java object
		return JSON.parseArray(jsonString, clazz);
	}

}
