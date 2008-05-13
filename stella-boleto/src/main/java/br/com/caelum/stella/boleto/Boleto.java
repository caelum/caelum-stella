package br.com.caelum.stella.boleto;

import java.util.List;

/**
 * @author caue
 *
 */
public interface Boleto {
	/**
	 * Devolve uma String com o valor do boleto
	 * 
	 * @return
	 */
	String getValorBoleto();
	
	/**
	 * Devolve a espécie da moeda.
	 * 
	 * @return
	 */
	String getEspecieMoeda();
	
	/**
	 * Devolve o código da espécie da moeda
	 * 
	 * @return
	 */
	int getCodEspecieMoeda();

	/**
	 * Devolve a quantidade de moeda.
	 * 
	 * @return
	 */
	String getQtdMoeda();

	/**
	 * Devolve o valor da moeda
	 * 
	 * @return
	 */
	String getValorMoeda();

	/**
	 * Devolve o acréscimo do boleto
	 * 
	 * @return
	 */
	double getAcrescimo();

	/**
	 * Devolve a espécie do documento
	 * 
	 * @return
	 */
	String getEspecieDocumento();
	
	/**
	 * Devolve o número do documento
	 * 
	 * @return
	 */
	String getNoDocumento();

	/**
	 * Devolve o aceite do boleto
	 * Valor padrão: 'N'
	 * 
	 * @return
	 */
	String getAceite();

	/**
	 * Devolve as datas do boleto
	 * 
	 * @return
	 */
	Datas getDatas();
	
	/**
	 * Devolve o fator de vencimento do boleto. Utilizado para geração do código de barras e 
	 * da linha digitável
	 * 
	 * @return
	 */
	int getFatorVencimento();

	/**
	 * Devolve o banco do boleto
	 * 
	 * @return
	 */
	Banco getBanco();

	/**
	 * Devolve o sacado do boleto
	 * 
	 * @return
	 */
	Sacado getSacado();

	/**
	 * Devolve o emissor do boleto
	 * 
	 * @return
	 */
	Emissor getEmissor();
	
	/**
	 * Devolve o valor formatado do boleto (sem pontos, com 10 digitos)
	 * 
	 * @return
	 */
	String getValorFormatado();
	
	/**
	 * Devolve as instruções do boleto
	 * 
	 * @return
	 */
	List<String> getInstrucoes();

	/**
	 * Devolve as descrições do boleto. Note que esse campo não aparece no boleto gerado em PNG
	 * 
	 * @return
	 */
	List<String> getDescricoes();
	
	/**
	 * Devolve os locais de pagamento do boleto.
	 * 
	 * @return
	 */
	List<String> getLocaisDePagamento();
}
