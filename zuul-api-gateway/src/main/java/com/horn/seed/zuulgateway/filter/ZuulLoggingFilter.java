package com.horn.seed.zuulgateway.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


public class ZuulLoggingFilter extends ZuulFilter {

	@Override
	public Object run() throws ZuulException {
		// Log details of request
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		// Add logger later
		System.out.println(String.format("request -> {} request uri -> {}", request,request.getRequestURI()));
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// should this filter be executed
		return true;
	}

	@Override
	public int filterOrder() {
		// set priority order below
		return 0;
	}

	@Override
	public String filterType() {
		// When should filtering happen
		//"error"
		return "pre";
	}

}
