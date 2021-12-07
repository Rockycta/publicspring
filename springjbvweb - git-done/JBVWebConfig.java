package com.sjv.config;

import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.sjv.controller", "com.sjv.validator", "com.sjv.service",
		"com.sjv.controller.advice" })
public class JBVWebConfig implements WebMvcConfigurer {

	@Bean
	public MessageSource messageSource() 
	{
		ResourceBundleMessageSource messageSource = null;

		messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("errors");

		return messageSource;
	}

	@Bean("simpleMappingExceptionResolver")
	public SimpleMappingExceptionResolver exceptionResolver() {
		SimpleMappingExceptionResolver exceptionResolver = null;
		Properties exceptionMappings = null;

		exceptionMappings = new Properties();
		exceptionMappings.put("ProductAlreadyExistsException", "producterror");

		exceptionResolver = new SimpleMappingExceptionResolver();
		exceptionResolver.setExceptionMappings(exceptionMappings);

		return exceptionResolver;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}

}
