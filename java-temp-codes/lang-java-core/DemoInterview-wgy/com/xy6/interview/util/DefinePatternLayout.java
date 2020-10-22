package com.xy6.interview.util;

import org.apache.log4j.PatternLayout;

/**
 * log4j发邮件辅助类
 *
 * @author daxiang
 * @since 2014-07-19
 */
public class DefinePatternLayout extends PatternLayout {

	/*
	 * 解决log4j发邮件，内容中文乱码
	 * 覆盖layout类中的getContentType方法
	 *
	 */
	@Override
	public String getContentType(){
		return "text/plain;charset=GBK";
	}
}
