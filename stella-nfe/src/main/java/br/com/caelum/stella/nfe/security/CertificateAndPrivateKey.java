package br.com.caelum.stella.nfe.security;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import br.com.caelum.stella.nfe.HSKeyManager;
import br.com.caelum.stella.nfe.config.NFEProperties;

public class CertificateAndPrivateKey {

	private final X509Certificate certificate;
	private final PrivateKey privateKey;
	private String defaultPassword = "changeit";

	public CertificateAndPrivateKey(X509Certificate certificate, PrivateKey privateKey) {
		this.certificate = certificate;
		this.privateKey = privateKey;
	}

	public void enableSSLForServer(InputStream serverCertificateFile, String password) {

		try {
			KeyStore trustStore = KeyStore.getInstance("JKS");
			trustStore.load(serverCertificateFile, password.toCharArray());

			String defaultAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
			TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(defaultAlgorithm);
			trustManagerFactory.init(trustStore);

			TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
			KeyManager[] keyManagers = { new HSKeyManager(certificate, privateKey) };

			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(keyManagers, trustManagers, null);
			HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public void enableSSLForServer(String arquivoCertificadoServidorNFE, String password) {
		this.enableSSLForServer(toFileInputStream(arquivoCertificadoServidorNFE), password);

	}

	public void enableSSLForServer(String arquivoCertificadoServidorNFE) {
		this.enableSSLForServer(toFileInputStream(arquivoCertificadoServidorNFE), defaultPassword);
	}
	
	private FileInputStream toFileInputStream(String arquivoCertificadoServidorNFE) {
		try {
			return new FileInputStream(arquivoCertificadoServidorNFE);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void enableSSLForServer() {
		String serverCertificateFile = new NFEProperties().getProperty("arquivo.certificado.servidor");
		InputStream is = this.getClass().getResourceAsStream(serverCertificateFile);
		enableSSLForServer(is,defaultPassword);
	}


}
