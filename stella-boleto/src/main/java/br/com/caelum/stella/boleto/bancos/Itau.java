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
		
		Emissor emissor = boleto.getEmissor();
		StringBuilder codigoDeBarras = new StringBuilder();
		codigoDeBarras.append(getNumeroFormatado());
		codigoDeBarras.append(String.valueOf(boleto.getCodigoEspecieMoeda()));
		codigoDeBarras.append(boleto.getFatorVencimento());
		codigoDeBarras.append(boleto.getValorFormatado());
		codigoDeBarras.append(getCarteiraDoEmissorFormatado(emissor));
		codigoDeBarras.append(getNossoNumeroDoEmissorFormatado(emissor));
		codigoDeBarras.append(emissor.getAgenciaFormatado());
		codigoDeBarras.append(getContaCorrenteDoEmissorFormatado(emissor)).append("000");

		codigoDeBarras.insert(38, this.geradorDeDigito
				.geraDigitoMod10(codigoDeBarras.substring(30, 38)));

		codigoDeBarras.insert(29, this.geradorDeDigito
				.geraDigitoMod10(codigoDeBarras.substring(30, 38)
						.concat(codigoDeBarras.substring(18, 29))));

		codigoDeBarras.insert(4, this.geradorDeDigito
				.geraDigitoMod11(codigoDeBarras.toString()));

		String codigoDeBarrasGerado = codigoDeBarras.toString();

		if (codigoDeBarrasGerado.length() != 44) {
			throw new CriacaoBoletoException("Erro na geração do código de barras. " +
					"Número de digitos diferente de 44. Verifique todos os dados.");
		}
		return codigoDeBarrasGerado;
	}

	@Override
	public String getNumeroFormatadoComDigito() {
		StringBuilder builder = new StringBuilder();
		builder.append(getNumeroFormatado()).append("-");
		return builder.append(DIGITO_ITAU).toString();
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
		String arquivo = "/br/com/caelum/stella/boleto/img/%s.png";
		String imagem = String.format(arquivo, getNumeroFormatado());
		return getClass().getResource(imagem);
	}

	@Override
	public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
		return String.format("%08d", emissor.getNossoNumero());
	}
	
	@Override
	public String getNossoNumeroECodDocumento(Emissor emissor) {
		String valor = super.getNossoNumeroECodDocumento(emissor);
		return valor.concat("-").concat(emissor.getDigitoNossoNumero());
	}

	@Override
	public String getNumeroFormatado() {
		return NUMERO_ITAU;
	}
	
	@Override
	public String getAgenciaECodigoCedente(Emissor emissor) {
		StringBuilder builder = new StringBuilder();
		builder.append(emissor.getAgenciaFormatado()).append("/");
		builder.append(getContaCorrenteDoEmissorFormatado(emissor));
		builder.append("-").append(emissor.getDigitoContaCorrente());
		return builder.toString();
	}
}
