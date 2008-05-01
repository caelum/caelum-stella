package br.com.caelum.stella.boleto;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

public interface Banco {

	/**
     * Pega o codigo do banco
     */
	int getNumero();
	
	/**
	 * Pga codigo de barras para determinado boleto
	 */
	String getCodigoBarras(Boleto boleto);
	
    /**
     * Recupera a numeracao para a geracao da linha digitavel do boleto
     */
	String getLinhaDigitavelPara(Boleto boleto);
	
	/**
	 * Devolve numero do banco como uma String com três digitos.
	 * 
	 * @return
	 */
	String getNumeroFormatado();
	
	/**
	 * Devolve a imagem referente a esse banco
	 * @return
	 * @throws IOException 
	 */
	URL getImage();
}
