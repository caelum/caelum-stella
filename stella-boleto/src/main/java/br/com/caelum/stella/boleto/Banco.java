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

	String geraCodigoDeBarrasPara(Boleto boleto);

	String geraLinhaDigitavelPara(Boleto boleto);

}
