package com.rays.resourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestResourceBundle {

	public static void main(String[] args) throws Exception{
		
//		ResourceBundle rb = ResourceBundle.getBundle("com.rays.resourceBundle.app"); 
//		String t = rb.getString("user");
//		System.out.println(t);
		
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.resourceBundle.app",new Locale("hi"));
		
		System.out.println(rb.getString("greeting"));
		
		

	}
}
