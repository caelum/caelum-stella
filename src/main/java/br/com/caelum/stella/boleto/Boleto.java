package br.com.caelum.stella.boleto;


public interface Boleto {
	public String getAgencia();
	public String getContaCorrente();
	public String getCarteira();
	public String getNumConvenio();
	public String getNossoNumero();
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
	public Datas getDatas();
	public Banco getBanco();
}
