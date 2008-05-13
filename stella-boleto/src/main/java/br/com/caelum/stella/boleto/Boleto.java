package br.com.caelum.stella.boleto;

import java.util.List;

public interface Boleto {

	String getValorBoleto();
	
	String getEspecieMoeda();
	
	int getCodEspecieMoeda();

	String getQtdMoeda();

	String getValorMoeda();

	double getAcrescimo();

	String getEspecieDocumento();
	
	String getNoDocumento();

	/**
	 * Devolve o aceite do boleto
	 * Valor padrão: 'N'
	 * 
	 * @return
	 */
	String getAceite();

	Datas getDatas();
	
	/**
	 * Devolve o fator de vencimento do boleto. Utilizado para geração do código de barras e 
	 * da linha digitável
	 * 
	 * @return
	 */
	int getFatorVencimento();

	Banco getBanco();

	Sacado getSacado();

	Emissor getEmissor();
	
	String getValorFormatado();
	
	List<String> getInstrucoes();

	/**
	 * Devolve as descrições do boleto. Note que esse campo não aparece no boleto gerado em PNG
	 * 
	 * @return
	 */
	List<String> getDescricoes();
	
	List<String> getLocaisDePagamento();
}
