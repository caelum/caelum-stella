package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.exception.CriacaoBoletoException;

/**
 * Gera dados de um boleto relativos ao Banco do Brasil.
 * 
 * @see <a *
 *      href="http://stella.caelum.com.br/boleto-setup.html">http://stella.caelum
 *      * .com.br/boleto-setup.html< /a>
 * 
 * @author Cauê Guerra
 * @author Paulo Silveira
 * 
 */
public class BancoDoBrasil extends AbstractBanco implements Banco {

	private static final String NUMERO_BB = "001";
	private static final String DIGITO_NUMERO_BB = "9";

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		StringBuilder codigoDeBarras = new StringBuilder();
		codigoDeBarras.append(getNumeroFormatado());
		codigoDeBarras.append(String.valueOf(boleto.getCodigoEspecieMoeda()));
		// Digito Verificador sera inserido aqui.

		codigoDeBarras.append(boleto.getFatorVencimento());
		codigoDeBarras.append(boleto.getValorFormatado());

		Emissor emissor = boleto.getEmissor();
		// CAMPO LIVRE
		if (emissor.getNumeroConvenio() < 1000000) {
			if (emissor.getCarteira() == 16 || emissor.getCarteira() == 18) {
				codigoDeBarras.append(getNumeroConvenioDoEmissorFormatado(emissor));
				codigoDeBarras.append(getNossoNumeroDoEmissorFormatado(emissor));
				codigoDeBarras.append("21");
			} else {
				codigoDeBarras.append(getNossoNumeroDoEmissorFormatado(emissor));
				codigoDeBarras.append(emissor.getAgenciaFormatado());
				codigoDeBarras.append(emissor.getCedente());
				codigoDeBarras.append(boleto.getBanco().getCarteiraDoEmissorFormatado(emissor));
			}
		} else if (emissor.getCarteira() == 17 || emissor.getCarteira() == 18) {
			codigoDeBarras.append("000000");
			codigoDeBarras.append(getNumeroConvenioDoEmissorFormatado(emissor));
			codigoDeBarras.append(getNossoNumeroDoEmissorFormatado(emissor).substring(7));
			codigoDeBarras.append(boleto.getBanco().getCarteiraDoEmissorFormatado(emissor));
		} else {
			throw new CriacaoBoletoException(
					"Erro na geração do código de barras. Nenhuma regra se aplica. Verifique carteira e demais dados.");
		}

		codigoDeBarras.insert(4, this.geradorDeDigito.geraDigitoMod11(codigoDeBarras.toString()));

		String result = codigoDeBarras.toString();

		if (result.length() != 44) {
			throw new CriacaoBoletoException(
					"Erro na geração do código de barras. Número de digitos diferente de 44. Verifique todos os dados.");
		}

		return result;
	}

	@Override
	public String getNumeroFormatado() {
		return NUMERO_BB;
	}

	@Override
	public java.net.URL getImage() {
		return getClass().getResource(String.format("/br/com/caelum/stella/boleto/img/%s.png", getNumeroFormatado()));
	}

	@Deprecated
	public String getNumConvenioDoEmissorFormatado(Emissor emissor) {
		return getNumeroConvenioDoEmissorFormatado(emissor);
	}

	public String getNumeroConvenioDoEmissorFormatado(Emissor emissor) {
		if (emissor.getNumeroConvenio() < 1000000) {
			return String.format("%06d", emissor.getNumeroConvenio());
		} else {
			return String.format("%07d", emissor.getNumeroConvenio());
		}
	}

	@Override
	public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
		return String.format("%08d", emissor.getContaCorrente());
	}

	@Override
	public String getCarteiraDoEmissorFormatado(Emissor emissor) {
		return String.format("%02d", emissor.getCarteira());
	}

	@Override
	public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
		if (emissor.getCarteira() == 18) {
			return String.format("%017d", emissor.getNossoNumero());
		} else {
			return String.format("%011d", emissor.getNossoNumero());
		}
	}

	@Override
	public String getNumeroFormatadoComDigito() {
		return NUMERO_BB + "-" + DIGITO_NUMERO_BB;
	}

	@Override
	public String getNossoNumeroECodDocumento(Emissor emissor) {
		return getNossoNumeroDoEmissorFormatado(emissor);
	}

}
