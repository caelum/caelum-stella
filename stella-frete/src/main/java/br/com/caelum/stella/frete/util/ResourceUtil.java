package br.com.caelum.stella.frete.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceUtil {

	
	private static final String BUNDLE_NAME = "encomenda";
	private static final ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
	
	
	public static String getValue(String key) {
		try{
        return bundle.getString(key);
		}catch(MissingResourceException e){
			return "";
		}
    }
	
	public static Double getValueAsDouble(String key){
		try{
		  return Double.valueOf(getValue(key));
		}catch(NumberFormatException e){
			return 0d;
		}
	}
}
