package br.com.caelum.stella.frete.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Strings {
	
	public static double stringToDuble(String value){
		NumberFormat  formatter = NumberFormat.getInstance(new Locale("pt","BR"));
		
		try {
			return formatter.parse(value).doubleValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static String doubleToString(double value){
		NumberFormat  formatter = NumberFormat.getInstance(new Locale("pt","BR"));
		formatter.setMinimumFractionDigits(2);
		formatter.setMaximumIntegerDigits(6);
		return formatter.format(value).replace(",", ".");
	}
	
	public static String onlyNumbers(String str) {
		return str!=null?  str.replaceAll("[^0123456789]", "") : "";
	}
}
