package br.com.caelum.stella.boleto;

import java.util.List;

public interface Boleto {
	String getValorBoleto();

	String getCaminho();

	String getTipoSaida();
	
	String getEspecieMoeda();
	
	int getCodEspecieMoeda();

	String getQtdMoeda();

	String getValorMoeda();

	double getAcrescimo();

	String getEspecieDocumento();
	
	String getNoDocumento();

	String getAceite();

	Datas getDatas();
	
	int getFatorVencimento();

	Banco getBanco();

	Sacado getSacado();

	Emissor getEmissor();
	
	String getValorFormatado();
	
	List<String> getInstrucoes();

	List<String> getDescricoes();
	
	List<String> getLocaisDePagamento();
	
}
