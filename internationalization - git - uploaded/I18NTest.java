package com.i18n.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18NTest {
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("tn_IN"));
		String message = bundle.getString("homewelcome");
		System.out.println(message);
	}
}
