package cn.icanbe.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="f1", urlPatterns={"/*"})
public class AnnotationFilter implements Filter {

    public AnnotationFilter() {
    	System.out.println("--> filter 1 constructor().");
    }

	public void destroy() {
		System.out.println("--> filter 1 destroy().");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("--> filter 1 dofilter before..");
		chain.doFilter(request, response);
		System.out.println("--> filter 1 dofilter after..");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("--> filter 1 initialed.");
	}

}
