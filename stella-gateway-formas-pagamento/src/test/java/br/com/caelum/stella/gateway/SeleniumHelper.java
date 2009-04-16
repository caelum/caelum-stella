package br.com.caelum.stella.gateway;

import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleniumLogLevels;

public class SeleniumHelper {

	private Selenium selenium;
	private SeleniumServer seleniumServer;
	
	public SeleniumHelper iniciarSelenium() throws Exception{
		seleniumServer = new SeleniumServer(4444);
		seleniumServer.start();
		return this;
	}
	
	public SeleniumHelper configurarContextoDoTeste(String urlBaseDesejada,String nomeDoContextoDeTeste){
		selenium = new DefaultSelenium("localhost",4444,"*firefox",urlBaseDesejada);
		selenium.start();
		selenium.setContext(nomeDoContextoDeTeste);		
		selenium.setBrowserLogLevel(SeleniumLogLevels.DEBUG);
		return this;
	}
	
	public void finalizar(){
		selenium.stop();
		seleniumServer.stop();
	}

	public Selenium getSelenium() {
		return selenium;
	}
		
}
