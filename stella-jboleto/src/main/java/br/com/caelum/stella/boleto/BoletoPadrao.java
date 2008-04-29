package br.com.caelum.stella.boleto;

import java.util.Calendar;


public class BoletoPadrao implements Boleto {
	private String agencia;
	private String contaCorrente;
	private String carteira;
	private String numConvenio;
	private String nossoNumero;
	private String valorBoleto;
	private String caminho;
	private String tipoSaida;

	private String localPagamento;
	private String cedente;
	private String qtdMoeda;
	private String valorMoeda;
	private double acrescimo;

	private String instrucao;

	private String nomeSacado;
	private String cpfSacado;
	private String enderecoSacado;
	private String cepSacado;
	private String bairroSacado;
	private String cidadeSacado;
	private String ufSacado;
	private String especieDocumento;
	private String aceite;
	private Banco banco;
	private DatasPadrao datas;
	
	private BoletoPadrao() {
	}
	
	public Datas newBoleto() {
		Datas boleto = new BoletoPadrao();
		return boleto;
	}

	public String getAceite() {
		return this.aceite;
	}

	public double getAcrescimo() {
		return this.acrescimo;
	}
	
	public Datas comAcrescimo(double acrescimo) {
		this.acrescimo = acrescimo;
		return this;
	}

	public String getAgencia() {
		return this.agencia;
	}
	
	public Datas comAgencia(String agencia) {
		this.agencia = agencia;
		return this;
	}

	public String getBairroSacado() {
		return this.bairroSacado;
	}
	
	public Datas comBairroSacado(String bairroSacado) {
		this.bairroSacado = bairroSacado;
		return this;
	}

	public String getCaminho() {
		return this.caminho;
	}
	
	public Datas comCaminho(String caminho) {
		this.caminho = caminho;
		return this;
	}

	public String getCarteira() {
		return this.carteira;
	}
	
	public Datas comCarteira(String carteira) {
		this.carteira = carteira;
		return this;
	}

	public String getCedente() {
		return this.cedente;
	}
	
	public Datas comCedente(String cedente) {
		this.cedente = cedente;
		return this;
	}

	public String getCepSacado() {
		return this.cepSacado;
	}
	
	public Datas comCepSacado(String cepSacado) {
		this.cepSacado = cepSacado;
		return this;
	}

	public String getCidadeSacado() {
		return this.cidadeSacado;
	}
	
	public Datas comCidadeSacado(String cidadeSacado) {
		this.cidadeSacado = cidadeSacado;
		return this;
	}

	public String getContaCorrente() {
		return this.contaCorrente;
	}
	
	public Datas comContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
		return this;
	}

	public String getCpfSacado() {
		return this.cpfSacado;
	}
	
	public Datas comCpfSacado(String cpfSacado) {
		this.cpfSacado = cpfSacado;
		return this;
	}

	public Calendar getDataDocumento() {
		return this.dataDocumento;
	}
	
	public Datas comDataDocumento(Calendar dataDocumento) {
		this.dataDocumento = dataDocumento;
		return this;
	}

	public Calendar getDataProcessamento() {
		return this.dataProcessamento;
	}
	
	public Datas comDataProcessamento(Calendar dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
		return this;
	}

	public Calendar getDataVencimento() {
		return this.dataVencimento;
	}
	
	public Datas comDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
		return this;
	}

	public String getEnderecoSacado() {
		return this.enderecoSacado;
	}
	
	public Datas comEnderecoSacado(String enderecoSacado) {
		this.enderecoSacado = enderecoSacado;
		return this;
	}

	public String getEspecieDocumento() {
		return this.especieDocumento;
	}
	
	public Datas comEspecieDocumento(String especieDocumento) {
		this.especieDocumento = especieDocumento;
		return this;
	}

	public String getInstrucao() {
		return this.instrucao;
	}
	
	public Datas comInstrucao(String instrucao) {
		this.instrucao = instrucao;
		return this;
	}

	public String getLocalPagamento() {
		return this.localPagamento;
	}
	
	public Datas comLocalPagamento(String localPagamento) {
		this.localPagamento = localPagamento;
		return this;
	}

	public String getNomeSacado() {
		return this.nomeSacado;
	}
	
	public Datas paraNomeSacado(String nomeSacado) {
		this.nomeSacado = nomeSacado;
		return this;
	}

	public String getNossoNumero() {
		return this.nossoNumero;
	}
	
	public Datas comNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
		return this;
	}

	public String getNumConvenio() {
		return this.numConvenio;
	}
	
	public Datas comNumConvenio(String numConvenio) {
		this.numConvenio = numConvenio;
		return this;
	}

	public String getQtdMoeda() {
		return this.qtdMoeda;
	}
	
	public Datas comQtdMoeda(String qtdMoeda) {
		this.qtdMoeda = qtdMoeda;
		return this;
	}

	public String getTipoSaida() {
		return this.tipoSaida;
	}
	
	public Datas comTipoSaida(String tipoSaida) {
		this.tipoSaida = tipoSaida;
		return this;
	}

	public String getUfSacado() {
		return this.ufSacado;
	}
	
	public Datas comUfSacado(String ufSacado) {
		this.ufSacado = ufSacado;
		return this;
	}

	public String getValorBoleto() {
		return this.valorBoleto;
	}
	
	public Datas comValorBoleto(String valorBoleto) {
		this.valorBoleto = valorBoleto;
		return this;
	}

	public String getValorMoeda() {
		return this.valorMoeda;
	}
	
	public Datas comValorMoeda(String valorMoeda) {
		this.valorMoeda = valorMoeda;
		return this;
	}
	
	public Banco getBanco() {
		return this.banco;
	}
	
	public Datas comBanco(Banco banco) {
		this.banco = banco;
		return this;
	}
	
	
	
	public void gerar() {
		BoletoFactory boletoFactory = new BoletoFactory();
		boletoFactory.generateBoleto(this);
	}
	
	public String getLinhaDigitavel() {
		// TODO Auto-generated method stub
		return null;
	}

	public Datas getDatas() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
