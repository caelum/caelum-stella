package br.com.caelum.stella.nfe.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 
public class NFEProperties {

	Properties prop = new Properties();

	public NFEProperties() {

		try {
			InputStream defaultIS = this.getClass().getResourceAsStream("/nfe.default.properties");
			if (defaultIS != null)
				prop.load(defaultIS);

			InputStream propFile = this.getClass().getResourceAsStream("/nfe.properties");

			if (propFile != null) {
				prop.load(propFile);
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String getProperty(String key) {
		return this.prop.getProperty(key);
	}

}
