package cn.icanbe.web;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AnnotationListener implements ServletRequestListener {

    public AnnotationListener() {
    	System.out.println("+++> Listener constructor().");
    }

    public void requestDestroyed(ServletRequestEvent paramServletRequestEvent)  {
    	System.out.println("+++> Listener destroyed.");
    }

    public void requestInitialized(ServletRequestEvent paramServletRequestEvent)  {
    	System.out.println("+++> Listener initialized.");
    }
	
}
