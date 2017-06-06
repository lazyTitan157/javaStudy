package com.tacademy.sam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AFilter
 */
@WebFilter("/AFilter")
public class AFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// pass the request along the filter chain
		//사전작업 : 자원에 들어가기전에 호출하는 작업
		System.out.println("AFilter start");
		request.setCharacterEncoding("utf-8");
		
		MyWrapperRequest mRequest = new MyWrapperRequest((HttpServletRequest)request);
		
		chain.doFilter(request, response); //실제 호출하는 자원
		System.out.println("AFilter terminate");
		//사후 작업
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
