package br.com.caelum.stella.boleto;

import java.util.List;

public interface Boleto {
	String getValorBoleto();

	String getCaminho();

	String getTipoSaida();

	String getQtdMoeda();

	String getValorMoeda();

	double getAcrescimo();

	String getEspecieDocumento();
	
	String getNoDocumento();

	String getAceite();

	Datas getDatas();

	Banco getBanco();

	Sacado getSacado();

	Emissor getEmissor();
	
	List<String> getInstrucoes();

	List<String> getDescricoes();
	
	List<String> getLocaisDePagamento();
	
}
