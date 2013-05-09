package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.exception.CriacaoBoletoException;

/**
 * Gera dados de um boleto relativos ao Banco do Brasil.
 * 
 * @author Cauê Guerra
 * @author Paulo Silveira
 */
public class BancoDoBrasil extends AbstractBanco implements Banco {

	private static final String NUMERO_BB = "001";
	private static final String DIGITO_NUMERO_BB = "9";

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		StringBuilder campoLivre = new StringBuilder();
		Emissor emissor = boleto.getEmissor();
		if (emissor.getNumeroConvenio() < 1000000) {
			if (emissor.getCarteira() == 16 || emissor.getCarteira() == 18) {
				campoLivre.append(getNumeroConvenioDoEmissorFormatado(emissor));
				campoLivre.append(getNossoNumeroDoEmissorFormatado(emissor));
				campoLivre.append("21");
			} else {
				campoLivre.append(getNossoNumeroDoEmissorFormatado(emissor));
				campoLivre.append(emissor.getAgenciaFormatado());
				campoLivre.append(emissor.getCedente());
				campoLivre.append(boleto.getBanco().getCarteiraDoEmissorFormatado(emissor));
			}
		} else if (emissor.getCarteira() == 17 || emissor.getCarteira() == 18) {
			campoLivre.append("000000");
			campoLivre.append(getNumeroConvenioDoEmissorFormatado(emissor));
			campoLivre.append(getNossoNumeroDoEmissorFormatado(emissor).substring(7));
			campoLivre.append(boleto.getBanco().getCarteiraDoEmissorFormatado(emissor));
		} else {
			throw new CriacaoBoletoException(
					"Erro na geração do código de barras. Nenhuma regra se aplica. " +
					"Verifique carteira e demais dados.");
		}
		return new CodigoDeBarrasBuilder(boleto).comCampoLivre(campoLivre);
	}

	@Override
	public String getNumeroFormatado() {
		return NUMERO_BB;
	}

	@Override
	public java.net.URL getImage() {
		String arquivo = "/br/com/caelum/stella/boleto/img/%s.png";
		String imagem = String.format(arquivo, getNumeroFormatado());
		return getClass().getResource(imagem);
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
