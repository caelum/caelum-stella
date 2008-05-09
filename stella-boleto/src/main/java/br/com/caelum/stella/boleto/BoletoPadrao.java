package br.com.caelum.stella.boleto;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class BoletoPadrao implements Boleto {
	
	private String valorBoleto;
	private String caminho;
	private String tipoSaida;

	private String qtdMoeda;
	private String valorMoeda;
	private String especieMoeda;
	private int codEspecieMoeda;
	private double acrescimo;

	private String especieDocumento;
	private String noDocumento;
	private String aceite;
	
	private Banco banco;
	private Datas datas;
	private Sacado sacado;
	private Emissor emissor;
	private List<String> instrucoes;
	private List<String> descricoes;
	private List<String> locaisDePagamento;

	private BoletoPadrao() {
	}

	public static BoletoPadrao newBoleto() {
		return new BoletoPadrao().comEspecieMoeda("R$").comCodEspecieMoeda(9);
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

	public String getCaminho() {
		return this.caminho;
	}

	public BoletoPadrao comCaminho(String caminho) {
		this.caminho = caminho;
		return this;
	}

	public Datas getDatas() {
		return this.datas;
	}

	public BoletoPadrao comDatas(Datas datas) {
		this.datas = datas;
		return this;
	}

	public String getEspecieDocumento() {
		return this.especieDocumento;
	}

	public BoletoPadrao comEspecieDocumento(String especieDocumento) {
		this.especieDocumento = especieDocumento;
		return this;
	}
	
	public String getNoDocumento() {
		return this.noDocumento;
	}
	
	public BoletoPadrao comNoDocumento(String noDocumento) {
		this.noDocumento = noDocumento;
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

	public String getValorBoleto() {
		return this.valorBoleto;
	}

	public BoletoPadrao comValorBoleto(String valorBoleto) {
		this.valorBoleto = valorBoleto;
		return this;
	}
	
	public String getEspecieMoeda() {
		return this.especieMoeda;
	}
	
	private BoletoPadrao comEspecieMoeda(String especieMoeda) {
		this.especieMoeda = especieMoeda;
		return this;
	}
	
	public int getCodEspecieMoeda() {
		return this.codEspecieMoeda;
	}
	
	private BoletoPadrao comCodEspecieMoeda(int codEspecieMoeda) {
		this.codEspecieMoeda = codEspecieMoeda;
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
	
	public Sacado getSacado() {
		return this.sacado;
	}
	
	public BoletoPadrao comSacado(Sacado sacado) {
		this.sacado = sacado;
		return this;
	}
	
	public Emissor getEmissor() {
		return this.emissor;
	}
	
	public BoletoPadrao comEmissor(Emissor emissor) {
		this.emissor = emissor;
		return this;
	}

	public List<String> getInstrucoes() {
		return instrucoes;
	}

	public BoletoPadrao comInstrucoes(String ... instrucoes) {
		if(instrucoes.length > 5) {
			throw new IllegalArgumentException("maximo de 5 instrucoes permitidas");
		}
		this.instrucoes = Arrays.asList(instrucoes);
		return this;
	}

	public List<String> getDescricoes() {
		return descricoes;
	}

	public BoletoPadrao comDescricoes(String ... descricoes) {
		// TODO: verificar se 5 eh max mesmo
		if(descricoes.length > 5) {
			throw new IllegalArgumentException("maximo de 5 descricoes permitidas");
		}
		this.descricoes = Arrays.asList(descricoes);
		return this;
	}
	
	public List<String> getLocaisDePagamento() {
		return locaisDePagamento;
	}
	
	public BoletoPadrao comLocaisDePagamento(String ... locaisDePagamento) {
		if(locaisDePagamento.length > 2) {
			throw new IllegalArgumentException("maximo de 2 locais de pagamento permitidos");
		}
		this.locaisDePagamento = Arrays.asList(locaisDePagamento);
		return this;
	}

	public int getFatorVencimento() {
		Calendar dataBase = Calendar.getInstance();
		dataBase.set(Calendar.DAY_OF_MONTH, 7);
		dataBase.set(Calendar.MONTH, 10 - 1);
		dataBase.set(Calendar.YEAR, 1997);
		
		long diferencasEmMiliSegundos = this.datas.getVencimento().getTimeInMillis() - dataBase.getTimeInMillis();
		long diferencasEmDias = diferencasEmMiliSegundos / (1000 * 60 * 60 * 24);
		
		return (int) diferencasEmDias;
	}
	
	// TODO: formatar mais bonito: algo como %010d nao funciona
	public String getValorFormatado() {
		String formatado = this.valorBoleto.replaceAll("[^0-9]", "");
		return "0" + String.format("%09d", Integer.parseInt(formatado));
	}
}
