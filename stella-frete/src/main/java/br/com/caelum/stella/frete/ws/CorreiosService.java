package br.com.caelum.stella.frete.ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

public class CorreiosService {


	public static String sendRequest(Properties parametros){
		String urlString = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx";
  
		@SuppressWarnings("rawtypes")
		Iterator i = parametros.keySet().iterator();  
		int counter = 0;  

		while (i.hasNext()) {  
			String name = (String) i.next();  
			String value = parametros.getProperty(name);  
			urlString += (++counter == 1 ? "?" : "&") + name + "=" + value;  
		}  

		try {  
			URL url = new URL(urlString);  
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();  
			connection.setRequestProperty("Request-Method", "GET");  
			connection.setDoInput(true);  
			connection.setDoOutput(false);  
			connection.connect();  
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));  

			StringBuffer newData = new StringBuffer();  
			String s = "";  
			while (null != ((s = br.readLine()))) {
				newData.append(s);  
			}  
			br.close();
			return newData.toString();
		} catch(Exception e ){
			e.printStackTrace();
			return null;
		}
	}
}
