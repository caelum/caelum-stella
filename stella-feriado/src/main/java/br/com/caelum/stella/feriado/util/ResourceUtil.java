package br.com.caelum.stella.feriado.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceUtil {

	
	private static final String BUNDLE_NAME = "feriado";
	private static final ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
	
	
	public static String getValue(String key) {
		if(key == null || key.trim().isEmpty()){
			return "";
		}
		try{
        return bundle.getString(key);
		}catch(MissingResourceException e){
			return key;
		}
    }
}
