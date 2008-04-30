package br.com.caelum.stella.boleto;

import java.net.URL;

public enum Bancos implements Banco {
	BANCO_DO_BRASIL(1), BRADESCO(237), ITAU(341), BANCO_REAL(356), 
	CAIXA_ECONOMICA(104), UNIBANCO(409), HSBC(399);

	private int numero;
	
	private Bancos(int numero) {
		this.numero = numero;
	}

	public String getCodigoBarras(Boleto boleto) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLinhaDigitavelPara(Boleto boleto) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNumero() {
		return this.numero;
	}
	
	public String getNumeroFormatado() {
		return String.format("%03d", this.numero);
	}

	public URL getImage() {
		return Bancos.class.getResource(String.format("/br/com/caelum/stella/boleto/img/%s.png", getNumeroFormatado()));
	}
}
