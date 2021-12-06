package com.ffw.formatter.factory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import com.ffw.form.EmailAddress;
import com.ffw.formatter.Email;
import com.ffw.formatter.EmailAddressFormatter;

public class EmailAddressAnnotationFormatterFactory implements AnnotationFormatterFactory<Email> {

	@Override
	public Set<Class<?>> getFieldTypes() {
		return new HashSet<>(Arrays.asList(new Class<?>[] { EmailAddress.class }));
	}

	@Override
	public Printer<?> getPrinter(Email annotation, Class<?> fieldType) {
		return new EmailAddressFormatter();
	}

	@Override
	public Parser<?> getParser(Email annotation, Class<?> fieldType) {
		return new EmailAddressFormatter();
	}

}
