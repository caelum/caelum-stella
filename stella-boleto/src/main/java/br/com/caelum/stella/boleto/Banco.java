package br.com.caelum.stella.boleto;

import java.io.Serializable;
import java.net.URL;

import br.com.caelum.stella.boleto.bancos.gerador.GeradorDeDigito;

/**
 * <p>Interface que define métodos específicos ao funcionamento de cada banco para
 * gerar o código de barras e a linha digitável.</p>
 * 
 * 
 * <p>Infelizmente cada banco funciona de uma maneira diferente para gerar esses
 * valores, e as vezes até mudam de funcionamento.</p>
 * 
 * <p>Documentação que pode ser consultada:</p>
 * 
 * <ul>
 *   <li>http://www.macoratti.net/boleto.htm</li>
 *   <li>http://pt.wikipedia.org/wiki/Boleto_bancário</li>
 * </ul>
 * 
 * <p>Para testes rapidos: http://evandro.net/codigo_barras.html</p>
 * 
 * <p>Apesar de possuirmos diversos unit tests, sempre é bom ter precaução com
 * valores e testar alguns boletos, em especial se valores serão altos.</p>
 * 
 * @author Paulo Silveira
 * @author Cauê Guerra
 * 
 */
public interface Banco extends Serializable {

	/**
	 * Retorna o número desse banco, formatado com 3 dígitos
	 * 
	 * @return numero formatado
	 */
	String getNumeroFormatado();

	/**
	 * Pega a URL com a imagem de um banco
	 * 
	 * @return logo do banco
	 */
	URL getImage();

	/**
	 * Gera o código de barras para determinado boleto
	 * @param boleto boleto
	 * @return código de barras (texto)
	 */
	String geraCodigoDeBarrasPara(Boleto boleto);

	String getCodigoBeneficiarioFormatado(Beneficiario beneficiario);

	String getCarteiraFormatado(Beneficiario beneficiario);

	String getNossoNumeroFormatado(Beneficiario beneficiario);

	String getAgenciaECodigoBeneficiario(Beneficiario beneficiario);

	String getNumeroFormatadoComDigito();

	GeradorDeDigito getGeradorDeDigito();

	String getNossoNumeroECodigoDocumento(Boleto boleto);

}
