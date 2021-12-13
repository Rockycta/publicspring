package com.sfm.in.beans;

import java.net.URI;
import java.net.URL;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {

	public static void main(String[] args) {
		
			XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("application-context.xml"));
			Task task = xmlBeanFactory.getBean("task",Task.class);
			System.out.println(task);			
	}
	
	
}
