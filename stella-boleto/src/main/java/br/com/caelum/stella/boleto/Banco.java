package br.com.caelum.stella.boleto;

import java.io.IOException;
import java.net.URL;

/**
 * Interface com métodos específicos para cada banco
 * 
 * @author caue
 *
 */
public interface Banco {

	/**
	 * Devolve o codigo do banco
	 * 
	 * @return
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

	/**
	 * Devolve a String que representa o código de barras do boleto para esse banco. 
	 * Cada banco tem uma regra diferente para a geração de código de barras
	 * 
	 * @param boleto
	 * @return
	 */
	String geraCodigoDeBarrasPara(Boleto boleto);

	/**
	 * Devolve a linha digitavel do código do boleto para esse banco. A linha digitável
	 * é o código numérico de 44 posições.
	 * Cada banco tem uma regra diferente para a geração da linha digitável
	 * 
	 * @param boleto
	 * @return
	 */
	String geraLinhaDigitavelPara(Boleto boleto);

}
