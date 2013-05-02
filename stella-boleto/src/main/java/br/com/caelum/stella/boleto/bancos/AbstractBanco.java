package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.bancos.gerador.GeradorDeDigito;
import br.com.caelum.stella.boleto.bancos.gerador.GeradorDeDigitoPadrao;

public abstract class AbstractBanco implements Banco {

	protected final GeradorDeDigito dvGenerator = new GeradorDeDigitoPadrao();

	@Override
	public GeradorDeDigito getGeradorDeDigito() {
		return dvGenerator;
	}

	@Override
	public String getNossoNumeroECodDocumento(Emissor emissor) {
		return emissor.getCarteira() + " / " + getNossoNumeroDoEmissorFormatado(emissor);
	}

	@Override
	public String getAgenciaECodigoCedente(Emissor emissor) {
		StringBuilder builder = new StringBuilder();
		builder.append(emissor.getAgenciaFormatado());
		builder.append("-").append(emissor.getDigitoAgencia());
		builder.append(getContaCorrenteDoEmissorFormatado(emissor));
		builder.append("-").append(emissor.getDigitoContaCorrente());
		return builder.toString();
	}

}
