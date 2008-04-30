package br.com.caelum.stella.boleto;

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
	private Datas datas;

	private BoletoPadrao() {
	}

	public BoletoPadrao newBoleto() {
		BoletoPadrao boleto = new BoletoPadrao();
		return boleto;
	}

	public String getAceite() {
		return this.aceite;
	}

	public double getAcrescimo() {
		return this.acrescimo;
	}

	public BoletoPadrao comAcrescimo(double acrescimo) {
		this.acrescimo = acrescimo;
		return this;
	}

	public String getAgencia() {
		return this.agencia;
	}

	public BoletoPadrao comAgencia(String agencia) {
		this.agencia = agencia;
		return this;
	}

	public String getBairroSacado() {
		return this.bairroSacado;
	}

	public BoletoPadrao comBairroSacado(String bairroSacado) {
		this.bairroSacado = bairroSacado;
		return this;
	}

	public String getCaminho() {
		return this.caminho;
	}

	public BoletoPadrao comCaminho(String caminho) {
		this.caminho = caminho;
		return this;
	}

	public String getCarteira() {
		return this.carteira;
	}

	public BoletoPadrao comCarteira(String carteira) {
		this.carteira = carteira;
		return this;
	}

	public String getCedente() {
		return this.cedente;
	}

	public BoletoPadrao comCedente(String cedente) {
		this.cedente = cedente;
		return this;
	}

	public String getCepSacado() {
		return this.cepSacado;
	}

	public BoletoPadrao comCepSacado(String cepSacado) {
		this.cepSacado = cepSacado;
		return this;
	}

	public String getCidadeSacado() {
		return this.cidadeSacado;
	}

	public BoletoPadrao comCidadeSacado(String cidadeSacado) {
		this.cidadeSacado = cidadeSacado;
		return this;
	}

	public String getContaCorrente() {
		return this.contaCorrente;
	}

	public BoletoPadrao comContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
		return this;
	}

	public String getCpfSacado() {
		return this.cpfSacado;
	}

	public BoletoPadrao comCpfSacado(String cpfSacado) {
		this.cpfSacado = cpfSacado;
		return this;
	}

	public Datas getDatas() {
		return this.datas;
	}

	public BoletoPadrao comDatas(Datas datas) {
		this.datas = datas;
		return this;
	}

	public String getEnderecoSacado() {
		return this.enderecoSacado;
	}

	public BoletoPadrao comEnderecoSacado(String enderecoSacado) {
		this.enderecoSacado = enderecoSacado;
		return this;
	}

	public String getEspecieDocumento() {
		return this.especieDocumento;
	}

	public BoletoPadrao comEspecieDocumento(String especieDocumento) {
		this.especieDocumento = especieDocumento;
		return this;
	}

	public String getInstrucao() {
		return this.instrucao;
	}

	public BoletoPadrao comInstrucao(String instrucao) {
		this.instrucao = instrucao;
		return this;
	}

	public String getLocalPagamento() {
		return this.localPagamento;
	}

	public BoletoPadrao comLocalPagamento(String localPagamento) {
		this.localPagamento = localPagamento;
		return this;
	}

	public String getNomeSacado() {
		return this.nomeSacado;
	}

	public BoletoPadrao paraNomeSacado(String nomeSacado) {
		this.nomeSacado = nomeSacado;
		return this;
	}

	public String getNossoNumero() {
		return this.nossoNumero;
	}

	public BoletoPadrao comNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
		return this;
	}

	public String getNumConvenio() {
		return this.numConvenio;
	}

	public BoletoPadrao comNumConvenio(String numConvenio) {
		this.numConvenio = numConvenio;
		return this;
	}

	public String getQtdMoeda() {
		return this.qtdMoeda;
	}

	public BoletoPadrao comQtdMoeda(String qtdMoeda) {
		this.qtdMoeda = qtdMoeda;
		return this;
	}

	public String getTipoSaida() {
		return this.tipoSaida;
	}

	public BoletoPadrao comTipoSaida(String tipoSaida) {
		this.tipoSaida = tipoSaida;
		return this;
	}

	public String getUfSacado() {
		return this.ufSacado;
	}

	public BoletoPadrao comUfSacado(String ufSacado) {
		this.ufSacado = ufSacado;
		return this;
	}

	public String getValorBoleto() {
		return this.valorBoleto;
	}

	public BoletoPadrao comValorBoleto(String valorBoleto) {
		this.valorBoleto = valorBoleto;
		return this;
	}

	public String getValorMoeda() {
		return this.valorMoeda;
	}

	public BoletoPadrao comValorMoeda(String valorMoeda) {
		this.valorMoeda = valorMoeda;
		return this;
	}

	public Banco getBanco() {
		return this.banco;
	}

	public BoletoPadrao comBanco(Banco banco) {
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

}
