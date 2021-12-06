package com.ffw.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.ffw.form.EmailAddress;

public class EmailAddressFormatter implements Formatter<EmailAddress> {

	@Override
	public EmailAddress parse(String text, Locale locale) throws ParseException {
		EmailAddress emailAddress = null;
		String id = null;
		String domainName = null;

		if (text != null && text.trim().length() > 0) {
			try {
				System.out.println("parse()");

				id = text.substring(0, text.indexOf("@"));
				domainName = text.substring(text.indexOf("@") + 1, text.length());
				emailAddress = new EmailAddress(id, domainName);
			} catch (Throwable t) {
				throw new ParseException("email address is not valid", 1);
			}
		}
		return emailAddress;
	}

	@Override
	public String print(EmailAddress object, Locale locale) {
		System.out.println("print()");
		return object.getId() + "@" + object.getDomainName();
	}

}
