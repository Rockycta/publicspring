package com.ffw.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ffw.form.EmailAddress;
import com.ffw.formatter.EmailAddressFormatter;
import com.ffw.formatter.factory.EmailAddressAnnotationFormatterFactory;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.ffw.controller", "com.ffw.validator" })
public class FFWWebConfig implements WebMvcConfigurer {
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = null;

		messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("errors");
		return messageSource;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		// registry.addFormatterForFieldType(EmailAddress.class, new
		// EmailAddressFormatter());
		registry.addFormatterForFieldAnnotation(new EmailAddressAnnotationFormatterFactory());
	}

}
