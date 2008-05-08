package br.com.caelum.stella.boleto;

import java.io.IOException;
import java.net.URL;

public interface Banco {

	/**
	 * Pega o codigo do banco
	 */
	int getNumero();

	/**
	 * Devolve numero do banco como uma String com três digitos.
	 * 
	 * @return
	 */
	String getNumeroFormatado();

	/**
	 * Devolve a imagem referente a esse banco
	 * 
	 * @return
	 * @throws IOException
	 */
	URL getImage();

	public String geraCodigoDeBarrasPara(Boleto boleto);
	
	public int geraDVCodigoDeBarras(String codigoDeBarras);

	public String geraLinhaDigitavelPara(Boleto boleto);
	
	public int geraDVLinhaDigitavel(String campo);
}
