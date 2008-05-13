package br.com.caelum.stella.boleto;

import java.net.URL;

/**
 * Define a implementação dos Bancos no modo geral.
 * 
 * Documentação que pode ser consultada:
 * 
 * http://www.macoratti.net/boleto.htm
 * http://pt.wikipedia.org/wiki/Boleto_bancário
 * 
 * Para testes rapidos: http://evandro.net/codigo_barras.html
 * 
 * Apesar de possuirmos diversos unit tests, sempre é bom ter precaução com
 * valores e testar alguns boletos, em especial se valores serão altos.
 * 
 * @author Paulo Silveira
 * @author Cauê Guerra
 * 
 */
public interface Banco {

	int getNumero();

	String getNumeroFormatado();

	URL getImage();

	String geraCodigoDeBarrasPara(Boleto boleto);

	String geraLinhaDigitavelPara(Boleto boleto);

}
