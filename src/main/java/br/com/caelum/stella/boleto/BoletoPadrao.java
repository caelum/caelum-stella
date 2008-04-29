package br.com.caelum.stella.boleto;

import java.util.Calendar;


public class BoletoPadrao implements Boleto {
	String agencia;
	String contaCorrente;
	String carteira;
	String numConvenio;
	String nossoNumero;
	Calendar dataVencimento;
	Calendar dataDocumento;
	Calendar dataProcessamento;
	String valorBoleto;
	String caminho;
	String tipoSaida;

	String localPagamento;
	String cedente;
	String qtdMoeda;
	String valorMoeda;
	double acrescimo;

	String instrucao;

	String nomeSacado;
	String cpfSacado;
	String enderecoSacado;
	String cepSacado;
	String bairroSacado;
	String cidadeSacado;
	String ufSacado;
	String especieDocumento;
	String aceite;
	
	private BoletoPadrao() {
	}
	
	public Boleto newBoleto() {
		Boleto boleto = new BoletoPadrao();
		return boleto;
	}

	public String getAceite() {
		return this.aceite;
	}

	public double getAcrescimo() {
		return this.acrescimo;
	}
	
	public Boleto comAcrescimo(double acrescimo) {
		this.acrescimo = acrescimo;
		return this;
	}

	public String getAgencia() {
		return this.agencia;
	}
	
	public Boleto comAgencia(String agencia) {
		this.agencia = agencia;
		return this;
	}

	public String getBairroSacado() {
		return this.bairroSacado;
	}
	
	public Boleto comBairroSacado(String bairroSacado) {
		this.bairroSacado = bairroSacado;
		return this;
	}

	public String getCaminho() {
		return this.caminho;
	}
	
	public Boleto comCaminho(String caminho) {
		this.caminho = caminho;
		return this;
	}

	public String getCarteira() {
		return this.carteira;
	}
	
	public Boleto comCarteira(String carteira) {
		this.carteira = carteira;
		return this;
	}

	public String getCedente() {
		return this.cedente;
	}
	
	public Boleto comCedente(String cedente) {
		this.cedente = cedente;
		return this;
	}

	public String getCepSacado() {
		return this.cepSacado;
	}
	
	public Boleto comCepSacado(String cepSacado) {
		this.cepSacado = cepSacado;
		return this;
	}

	public String getCidadeSacado() {
		return this.cidadeSacado;
	}
	
	public Boleto comCidadeSacado(String cidadeSacado) {
		this.cidadeSacado = cidadeSacado;
		return this;
	}

	public String getContaCorrente() {
		return this.contaCorrente;
	}
	
	public Boleto comContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
		return this;
	}

	public String getCpfSacado() {
		return this.cpfSacado;
	}
	
	public Boleto comCpfSacado(String cpfSacado) {
		this.cpfSacado = cpfSacado;
		return this;
	}

	public Calendar getDataDocumento() {
		return this.dataDocumento;
	}
	
	public Boleto comDataDocumento(Calendar dataDocumento) {
		this.dataDocumento = dataDocumento;
		return this;
	}

	public Calendar getDataProcessamento() {
		return this.dataProcessamento;
	}
	
	public Boleto comDataProcessamento(Calendar dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
		return this;
	}

	public Calendar getDataVencimento() {
		return this.dataVencimento;
	}
	
	public Boleto comDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
		return this;
	}

	public String getEnderecoSacado() {
		return this.enderecoSacado;
	}
	
	public Boleto comEnderecoSacado(String enderecoSacado) {
		this.enderecoSacado = enderecoSacado;
		return this;
	}

	public String getEspecieDocumento() {
		return this.especieDocumento;
	}
	
	public Boleto comEspecieDocumento(String especieDocumento) {
		this.especieDocumento = especieDocumento;
		return this;
	}

	public String getInstrucao() {
		return this.instrucao;
	}
	
	public Boleto comInstrucao(String instrucao) {
		this.instrucao = instrucao;
		return this;
	}

	public String getLocalPagamento() {
		return this.localPagamento;
	}
	
	public Boleto comLocalPagamento(String localPagamento) {
		this.localPagamento = localPagamento;
		return this;
	}

	public String getNomeSacado() {
		return this.nomeSacado;
	}
	
	public Boleto paraNomeSacado(String nomeSacado) {
		this.nomeSacado = nomeSacado;
		return this;
	}

	public String getNossoNumero() {
		return this.nossoNumero;
	}
	
	public Boleto comNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
		return this;
	}

	public String getNumConvenio() {
		return this.numConvenio;
	}
	
	public Boleto comNumConvenio(String numConvenio) {
		this.numConvenio = numConvenio;
		return this;
	}

	public String getQtdMoeda() {
		return this.qtdMoeda;
	}
	
	public Boleto comQtdMoeda(String qtdMoeda) {
		this.qtdMoeda = qtdMoeda;
		return this;
	}

	public String getTipoSaida() {
		return this.tipoSaida;
	}
	
	public Boleto comTipoSaida(String tipoSaida) {
		this.tipoSaida = tipoSaida;
		return this;
	}

	public String getUfSacado() {
		return this.ufSacado;
	}
	
	public Boleto comUfSacado(String ufSacado) {
		this.ufSacado = ufSacado;
		return this;
	}

	public String getValorBoleto() {
		return this.valorBoleto;
	}
	
	public Boleto comValorBoleto(String valorBoleto) {
		this.valorBoleto = valorBoleto;
		return this;
	}

	public String getValorMoeda() {
		return this.valorMoeda;
	}
	
	public Boleto comValorMoeda(String valorMoeda) {
		this.valorMoeda = valorMoeda;
		return this;
	}
	
	public String getLinhaDigitavel() {
		// TODO Auto-generated method stub
		return null;
	}
}
