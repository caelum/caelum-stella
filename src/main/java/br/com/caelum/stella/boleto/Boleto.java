package br.com.caelum.stella.boleto;

import java.util.Calendar;

public interface Boleto {
	public String getAgencia();
	public String getContaCorrente();
	public String getCarteira();
	public String getNumConvenio();
	public String getNossoNumero();
	public Calendar getDataVencimento();
	public Calendar getDataDocumento();
	public Calendar getDataProcessamento();
	public String getValorBoleto();
	public String getCaminho();
	public String getTipoSaida();
	public String getLocalPagamento();
	public String getCedente();
	public String getQtdMoeda();
	public String getValorMoeda();
	public double getAcrescimo();
	public String getInstrucao();
	public String getNomeSacado();
	public String getCpfSacado();
	public String getEnderecoSacado();
	public String getCepSacado();
	public String getBairroSacado();
	public String getCidadeSacado();
	public String getUfSacado();
	public String getEspecieDocumento();
	public String getAceite();
}
