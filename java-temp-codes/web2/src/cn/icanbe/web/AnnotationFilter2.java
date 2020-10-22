package cn.icanbe.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="f2", urlPatterns = { "/*" })
public class AnnotationFilter2 implements Filter {

	public AnnotationFilter2() {
    	System.out.println("--> filter 2 constructor().");
    }

	public void destroy() {
		System.out.println("--> filter 2 destroy().");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("--> filter 2 dofilter before..");
		chain.doFilter(request, response);
		System.out.println("--> filter 2 dofilter after..");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("--> filter 2 initialed.");
	}

}
