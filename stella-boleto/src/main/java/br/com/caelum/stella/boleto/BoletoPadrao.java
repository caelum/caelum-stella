package br.com.caelum.stella.boleto;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
		Calendar dataBase = new GregorianCalendar(1997, 10, 07);
		
		long diferencasEmMiliSegundos = this.datas.getVencimento().getTimeInMillis() - dataBase.getTimeInMillis();
		long diferencasEmDias = diferencasEmMiliSegundos / (1000 * 60 * 60 * 24);
		
		return (int) diferencasEmDias;
	}
	
	// TODO: formatar mais bonito: algo como %010d nao funciona
	public String getValorFormatado() {
		String formatado = this.valorBoleto.replaceAll("[^0-9]", "");
		return "0" + String.format("%09d", Integer.parseInt(formatado));
	}
	
	public String geraCodigoDeBarras() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getBanco().getNumeroFormatado());
		builder.append(String.valueOf(this.getCodEspecieMoeda()));
		builder.append("D"); // digito verificador, calculado depois
		builder.append(String.valueOf(this.getFatorVencimento()));
		builder.append(this.getValorFormatado());
		builder.append(this.getEmissor().getAgencia());
		builder.append(this.getEmissor().getCarteira());
		builder.append(this.getEmissor().getNossoNumero());
		builder.append(this.getEmissor().getContaCorrente());
		builder.append("0"); // zero fixo
		
		String codigoDeBarras = builder.toString();
		builder.replace(4, 5, String.valueOf(geraDVCodigoDeBarras(codigoDeBarras)));

		return builder.toString();
	}

	int geraDVCodigoDeBarras(String codigoDeBarras) {
		int soma = 0;
		for (int i = 0, multiplicador = 2; i < codigoDeBarras.length(); i++, multiplicador++) {
			if (i == 4) // pula posição 5
				i++;
			if (multiplicador == 10) // volta pro 2
				multiplicador = 2;
			soma += Integer.parseInt(String.valueOf(codigoDeBarras.charAt(i)))
					* multiplicador;
		}

		int resto = soma % 11;
		return 11 - resto;
	}

	public String geraLinhaDigitavel() {
		String codigoDeBarras = this.geraCodigoDeBarras();
		
		StringBuilder builder = new StringBuilder();
		builder.append(this.getBanco().getNumeroFormatado());
		builder.append(String.valueOf(this.getCodEspecieMoeda()));
		builder.append(codigoDeBarras.substring(19, 24));
		builder.append("D"); // digito verificador, calculado depois
		builder.append(codigoDeBarras.substring(24, 34));
		builder.append("D"); // digito verificador, calculado depois
		builder.append(codigoDeBarras.substring(34, 44));
		builder.append("D"); // digito verificador, calculado depois
		builder.append(codigoDeBarras.charAt(4));
		builder.append(String.valueOf(this.getFatorVencimento()));
		builder.append(this.getValorFormatado());
		
		String linhaDigitavel = builder.toString();
		builder.replace(9, 10, String.valueOf(geraDVLinhaDigitavel(linhaDigitavel.substring(0, 9))));
		builder.replace(20, 21, String.valueOf(geraDVLinhaDigitavel(linhaDigitavel.substring(10, 20))));
		builder.replace(31, 32, String.valueOf(geraDVLinhaDigitavel(linhaDigitavel.substring(21, 31))));
		
		builder.insert(5, '.');
		builder.insert(11, "  ");
		builder.insert(18, '.');
		builder.insert(25, "  ");
		builder.insert(32, '.');
		builder.insert(39, "  ");
		builder.insert(42, "  ");
		
		return builder.toString();
	}
	
	int geraDVLinhaDigitavel(String campo) {
		int soma = 0;
		for (int i = campo.length() - 1; i >= 0; i--) {
			int multiplicador = (campo.length() - i) % 2 + 1;
			int algarismoMultiplicado = Integer.parseInt(String.valueOf(campo.charAt(i))) * multiplicador;
			soma += (algarismoMultiplicado / 10) + (algarismoMultiplicado % 10);
		}
		
		int resto = soma % 10;
		return 10 - resto;
	}
}
