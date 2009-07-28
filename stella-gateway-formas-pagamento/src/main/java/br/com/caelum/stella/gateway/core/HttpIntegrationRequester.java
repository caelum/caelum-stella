package br.com.caelum.stella.gateway.core;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;

/**
 * Classe responsável por fazer as requisições http para as integrações.
 * @author Alberto
 *
 */
public class HttpIntegrationRequester {

	private HttpMethod httpMethod;
	private HttpClient httpClient;
	public HttpIntegrationRequester(HttpMethod httpMethod) {
		// TODO Auto-generated constructor stub
		this(httpMethod,new HttpClient());
	}
	
	public HttpIntegrationRequester(HttpMethod httpMethod, HttpClient httpClient) {
		super();
		this.httpMethod = httpMethod;
		this.httpClient = httpClient;
	}
	
	
	public String makeRequest(){
		try {
			int status = httpClient.executeMethod(httpMethod);			
			if(status==HttpStatus.SC_OK){
				//retornando a tela gerada pela url configurada no .ini
				return httpMethod.getResponseBodyAsString();
			}
			else{
				throw new IntegrationFailedException("O status de retorno da comunicação com a url "+httpMethod.getPath()+" não foi o esperado(200). "+status);
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			throw new IntegrationFailedException("Problema para fazer a requisição para a url "+httpMethod.getPath(),e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IntegrationFailedException(e.getMessage(),e);
		}		
	}
	
	
	
	
	
	
}
