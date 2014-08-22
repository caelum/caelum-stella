package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
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
		Beneficiario beneficiario = boleto.getBeneficiario();
		
		if (convenioAntigo(beneficiario.getNumeroConvenio())) {
			if (beneficiario.getCarteira().equals(CARTEIRA_16) || beneficiario.getCarteira().equals(CARTEIRA_18)) {
				campoLivre.append(getNumeroConvenioFormatado(beneficiario));
				campoLivre.append(getNossoNumeroFormatado(beneficiario));
				campoLivre.append(TIPO_MODALIDADE_COBRANCA_CARTEIRA_SEM_REGISTRO);
			} else {
				campoLivre.append(getNossoNumeroFormatado(beneficiario));
				campoLivre.append(beneficiario.getAgenciaFormatada());
				campoLivre.append(beneficiario.getCodigoBeneficiario());
				campoLivre.append(boleto.getBanco().getCarteiraFormatado(beneficiario));
			}
		} else if (beneficiario.getCarteira().equals(CARTEIRA_17) || beneficiario.getCarteira().equals(CARTEIRA_18)) {
			campoLivre.append(ZEROS_CONVENIOS_NOVOS);
			campoLivre.append(getNumeroConvenioFormatado(beneficiario));
			campoLivre.append(getNossoNumeroParaCarteiras17e18(beneficiario));
			campoLivre.append(boleto.getBanco().getCarteiraFormatado(beneficiario));
		} else {
			throw new CriacaoBoletoException(
					"Erro na geração do código de barras. Nenhuma regra se aplica. " +
					"Verifique carteira e demais dados.");
		}
		return new CodigoDeBarrasBuilder(boleto).comCampoLivre(campoLivre);
	}

	private String getNossoNumeroParaCarteiras17e18(Beneficiario beneficiario) {
		int indice = beneficiario.getCarteira().equals(CARTEIRA_17) ? 1 : 7;
		return  getNossoNumeroFormatado(beneficiario).substring(indice);
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

	public String getNumeroConvenioFormatado(Beneficiario beneficiario) {
		if (convenioAntigo(beneficiario.getNumeroConvenio())) {
			return leftPadWithZeros(beneficiario.getNumeroConvenio(), 6);
		} else {
			return leftPadWithZeros(beneficiario.getNumeroConvenio(), 7);
		}
	}

	@Override
	public String getCodigoBeneficiarioFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getCodigoBeneficiario(), 8);
	}

	@Override
	public String getCarteiraFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getCarteira(),2);
	}

	@Override
	public String getNossoNumeroFormatado(Beneficiario beneficiario) {
		if (beneficiario.getCarteira().equals(CARTEIRA_18) || beneficiario.getCarteira().equals(CARTEIRA_16)) {
			return leftPadWithZeros(beneficiario.getNossoNumero(), 17);
		} else {
			return leftPadWithZeros(beneficiario.getNossoNumero(), 11);
		}
	}

	@Override
	public String getNumeroFormatadoComDigito() {
		return NUMERO_BB + "-" + DIGITO_NUMERO_BB;
	}

	@Override
	public String getNossoNumeroECodigoDocumento(Boleto boleto) {
		return getNossoNumeroFormatado(boleto.getBeneficiario());
	}

}
