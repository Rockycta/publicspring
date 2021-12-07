package com.sjv.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.sjv.config.JBVWebConfig;

public class JBVDispatcherServerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { JBVWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "*.htm" };
	}

}
