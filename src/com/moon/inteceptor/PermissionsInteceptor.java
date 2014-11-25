package com.moon.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PermissionsInteceptor implements HandlerInterceptor {

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public boolean preHandle(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj)
			throws Exception {
		logger.info("===> PermissionsInteceptor preHandle");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj,
			ModelAndView modelandview) throws Exception {
		logger.info("===> PermissionsInteceptor postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse, Object obj,
			Exception exception) throws Exception {
		logger.info("===> PermissionsInteceptor afterCompletion");
	}
}