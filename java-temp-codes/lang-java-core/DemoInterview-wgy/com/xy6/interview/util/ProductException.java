package com.xy6.interview.util;

/**
 * 异常类
 *
 * @author daxiang
 * @since 2014-07-17
 */
public class ProductException extends Exception {

	public ProductException(Throwable ex){
		super(ex.getMessage());
	}

	public ProductException(String strMsg){
		super(strMsg);
	}

	public ProductException(String strMsg,Throwable ex){
		super(strMsg);
	}
}
