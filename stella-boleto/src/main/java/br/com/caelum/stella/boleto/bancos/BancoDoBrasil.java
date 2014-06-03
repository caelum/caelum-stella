package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.exception.CriacaoBoletoException;
import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;

/**
 * Gera dados de um boleto relativos ao Banco do Brasil.
 * 
 * @author Cauê Guerra
 * @author Paulo Silveira
 */
public class BancoDoBrasil extends AbstractBanco implements Banco {

	private static final long serialVersionUID = 1L;

	private static final String NUMERO_BB = "001";
	private static final String DIGITO_NUMERO_BB = "9";
	private static final String CARTEIRA_16 = "16";
	private static final String CARTEIRA_17 = "17";
	private static final String CARTEIRA_18 = "18";
	private static final String ZEROS_CONVENIOS_NOVOS = "000000";
	private static final String TIPO_MODALIDADE_COBRANCA_CARTEIRA_SEM_REGISTRO = "21";


	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		StringBuilder campoLivre = new StringBuilder();
		Emissor emissor = boleto.getEmissor();
		
		if (convenioAntigo(emissor.getNumeroConvenio())) {
			if (emissor.getCarteira().equals(CARTEIRA_16) || emissor.getCarteira().equals(CARTEIRA_18)) {
				campoLivre.append(getNumeroConvenioDoEmissorFormatado(emissor));
				campoLivre.append(getNossoNumeroDoEmissorFormatado(emissor));
				campoLivre.append(TIPO_MODALIDADE_COBRANCA_CARTEIRA_SEM_REGISTRO);
			} else {
				campoLivre.append(getNossoNumeroDoEmissorFormatado(emissor));
				campoLivre.append(emissor.getAgenciaFormatado());
				campoLivre.append(emissor.getContaCorrente());
				campoLivre.append(boleto.getBanco().getCarteiraDoEmissorFormatado(emissor));
			}
		} else if (emissor.getCarteira().equals(CARTEIRA_17) || emissor.getCarteira().equals(CARTEIRA_18)) {
			campoLivre.append(ZEROS_CONVENIOS_NOVOS);
			campoLivre.append(getNumeroConvenioDoEmissorFormatado(emissor));
			campoLivre.append(getNossoNumeroParaCarteiras17e18(emissor));
			campoLivre.append(boleto.getBanco().getCarteiraDoEmissorFormatado(emissor));
		} else {
			throw new CriacaoBoletoException(
					"Erro na geração do código de barras. Nenhuma regra se aplica. " +
					"Verifique carteira e demais dados.");
		}
		return new CodigoDeBarrasBuilder(boleto).comCampoLivre(campoLivre);
	}

	private String getNossoNumeroParaCarteiras17e18(Emissor emissor) {
		int indice = emissor.getCarteira().equals(CARTEIRA_17) ? 1 : 7;
		return  getNossoNumeroDoEmissorFormatado(emissor).substring(indice);
	}

	private boolean convenioAntigo(String convenio) {
		long numeroConvenio = Long.parseLong(convenio);
		return numeroConvenio < 1000000;
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
		if (convenioAntigo(emissor.getNumeroConvenio())) {
			return leftPadWithZeros(emissor.getNumeroConvenio(), 6);
		} else {
			return leftPadWithZeros(emissor.getNumeroConvenio(), 7);
		}
	}

	@Override
	public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
		return leftPadWithZeros(emissor.getContaCorrente(), 8);
	}

	@Override
	public String getCarteiraDoEmissorFormatado(Emissor emissor) {
		return leftPadWithZeros(emissor.getCarteira(),2);
	}

	@Override
	public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
		if (emissor.getCarteira().equals(CARTEIRA_18)) {
			return leftPadWithZeros(emissor.getNossoNumero(), 17);
		} else {
			return leftPadWithZeros(emissor.getNossoNumero(), 11);
		}
	}

	@Override
	public String getNumeroFormatadoComDigito() {
		return NUMERO_BB + "-" + DIGITO_NUMERO_BB;
	}

	@Override
	public String getNossoNumeroECodDocumento(Boleto boleto) {
		return getNossoNumeroDoEmissorFormatado(boleto.getEmissor());
	}

}
