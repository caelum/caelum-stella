package br.com.caelum.stella.nfe.security;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;

public class TokenKeyStoreForWindows {

	private final String configFileName;
	private final TokenAlgorithm algorithm;
	private final String senhaDoCertificado;
	private KeyStore ks;

	public TokenKeyStoreForWindows(String configFileName, TokenAlgorithm algorithm, String senhaDoCertificado) {
		this.configFileName = configFileName;
		this.algorithm = algorithm;
		this.senhaDoCertificado = senhaDoCertificado;
		createKeyStore();

	}

	private void createKeyStore() {
		InputStream configFileStream = this.getClass().getResourceAsStream("/"+configFileName);
		Provider p = new sun.security.pkcs11.SunPKCS11(configFileStream);
		Security.addProvider(p);
		char[] pin = senhaDoCertificado.toCharArray();
		try {
			this.ks = KeyStore.getInstance(algorithm.toString(), p);
			this.ks.load(null, pin);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public CertificateAndPrivateKey getCertificateFor(String alias) {
		try {
			X509Certificate certificate = (X509Certificate) ks.getCertificate(alias);
			PrivateKey privateKey = (PrivateKey) ks.getKey(alias, senhaDoCertificado.toCharArray());			
			return new CertificateAndPrivateKey(certificate,privateKey);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
