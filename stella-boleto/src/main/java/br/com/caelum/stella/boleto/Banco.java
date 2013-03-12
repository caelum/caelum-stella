package br.com.caelum.stella.boleto;

import java.net.URL;

import br.com.caelum.stella.boleto.bancos.gerador.GeradorDeDigito;

/**
 * Interface que define métodos específicos ao funcionamento de cada banco para
 * gerar o código de barras e a linha digitável.<br/>
 * <br/>
 * 
 * Infelizmente cada banco funciona de uma maneira diferente para gerar esses
 * valores, e as vezes até mudam de funcionamento.
 * 
 * Documentação que pode ser consultada:<br/>
 * <br/>
 * 
 * http://www.macoratti.net/boleto.htm<br/>
 * http://pt.wikipedia.org/wiki/Boleto_bancário<br/>
 * <br/>
 * 
 * Para testes rapidos: http://evandro.net/codigo_barras.html<br/>
 * <br/>
 * 
 * Apesar de possuirmos diversos unit tests, sempre é bom ter precaução com
 * valores e testar alguns boletos, em especial se valores serão altos.
 * 
 * @author Paulo Silveira
 * @author Cauê Guerra
 * 
 */
public interface Banco {

	/**
	 * Retorna o número desse banco, formatado com 3 dígitos
	 * 
	 * @return
	 */
	String getNumeroFormatado();

	/**
	 * Pega a URL com a imagem de um banco
	 * 
	 * @return
	 */
	URL getImage();

	/**
	 * Gera o código de barras para determinado boleto
	 */
	String geraCodigoDeBarrasPara(Boleto boleto);

	String getContaCorrenteDoEmissorFormatado(Emissor emissor);

	String getCarteiraDoEmissorFormatado(Emissor emissor);

	String getNossoNumeroDoEmissorFormatado(Emissor emissor);

	String getAgenciaECodigoCedente(Emissor emissor);

	String getNumeroFormatadoComDigito();

	GeradorDeDigito getGeradorDeDigito();

	String getNossoNumeroECodDocumento(Emissor emissor);

}
