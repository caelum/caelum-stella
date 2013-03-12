package br.com.caelum.stella.boleto.bancos;

import java.net.URL;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.exception.CriacaoBoletoException;

public class Itau extends AbstractBanco implements Banco {

	private static final String NUMERO_ITAU = "341";
	private static final String DIGITO_ITAU = "7";

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		StringBuilder codigoDeBarras = new StringBuilder();
		codigoDeBarras.append(getNumeroFormatado());
		codigoDeBarras.append(String.valueOf(boleto.getCodigoEspecieMoeda()));
		// Digito Verificador sera inserido aqui.

		codigoDeBarras.append(boleto.getFatorVencimento());
		codigoDeBarras.append(boleto.getValorFormatado());

		Emissor emissor = boleto.getEmissor();

		codigoDeBarras.append(getCarteiraDoEmissorFormatado(emissor));
		codigoDeBarras.append(getNossoNumeroDoEmissorFormatado(emissor));
		// Digito Verificador sera inserido aqui.

		codigoDeBarras.append(emissor.getAgenciaFormatado());
		codigoDeBarras.append(getContaCorrenteDoEmissorFormatado(emissor));
		// Digito Verificador sera inserido aqui.

		codigoDeBarras.append("000");

		codigoDeBarras.insert(38, this.dvGenerator.geraDigitoMod10(codigoDeBarras.substring(30, 38)));

		codigoDeBarras.insert(
				29,
				this.dvGenerator.geraDigitoMod10(codigoDeBarras.substring(30, 38).concat(
						codigoDeBarras.substring(18, 28))));

		codigoDeBarras.insert(4, this.dvGenerator.geraDigitoMod11(codigoDeBarras.toString()));

		String result = codigoDeBarras.toString();

		if (result.length() != 44) {
			throw new CriacaoBoletoException(
					"Erro na geração do código de barras. Número de digitos diferente de 44. Verifique todos os dados.");
		}

		return result;
	}

	@Override
	public String getNumeroFormatadoComDigito() {
		return NUMERO_ITAU + "-" + DIGITO_ITAU;
	}

	@Override
	public String getCarteiraDoEmissorFormatado(Emissor emissor) {
		return String.format("%03d", emissor.getCarteira());
	}

	@Override
	public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
		return String.format("%05d", emissor.getContaCorrente());
	}

	@Override
	public URL getImage() {
		return getClass().getResource(String.format("/br/com/caelum/stella/boleto/img/%s.png", getNumeroFormatado()));
	}

	@Override
	public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
		return String.format("%08d", emissor.getNossoNumero());
	}

	@Override
	public String getNumeroFormatado() {
		return NUMERO_ITAU;
	}

}
