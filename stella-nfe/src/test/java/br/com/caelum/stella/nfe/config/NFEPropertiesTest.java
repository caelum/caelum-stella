package br.com.caelum.stella.nfe.config;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.stella.nfe.config.NFEProperties;

public class NFEPropertiesTest {

	@Test
	public void deveLerOArquivoDeConfiguracaoDefault() {

		NFEProperties nfeProperties = new NFEProperties();

		assertNotNull(nfeProperties.getProperty("arquivo.config.token"));
		assertNotNull(nfeProperties.getProperty("certificado.senha"));
	}

}
