package br.com.caelum.stella.jboleto;

import br.com.caelum.stella.Boleto;
import br.com.caelum.stella.BoletoInfo;

public class BoletoPadrao implements Boleto {
	
	private BoletoInfo info;

	public BoletoPadrao(BoletoInfo info) {
		super();
		this.info = info;
	}

	public String getLinhaDigitavel(){
		return "";
	}
}
