package br.com.caelum.stella.boleto.bancos;

import java.net.URL;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;

/**
 * Gera dados de um boleto relativos ao Banco Safra.
 * <p>
 * <a href="http://www.boletophp.com.br/documentacao/Documentacao_Safra.zip">Documentação Safra</a>
 * </p>
 * @author Bluesoft
 * 
 */
public class Safra extends AbstractBanco implements Banco {

	private static final long serialVersionUID = 1L;

	private static final String NUMERO_SAFRA = "422";
	private static final String DIGITO_NUMERO_SAFRA = "7";
	private static final String COBRANCA_DIRETA_ELETRONICA = "7";
	private static final String TIPO_COBRANCA_EMITIDO_AO_CLIENTE = "2";
	
	@Override
	public String getNumeroFormatado() {
		return NUMERO_SAFRA;
	}

	@Override
	public URL getImage() {
		String arquivo = "/br/com/caelum/stella/boleto/img/%s.png";
		String imagem = String.format(arquivo, getNumeroFormatado());
		return getClass().getResource(imagem);
	}

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		Beneficiario beneficiario = boleto.getBeneficiario();
		StringBuilder campoLivre = new StringBuilder().append(COBRANCA_DIRETA_ELETRONICA);
		campoLivre.append(getAgencia(beneficiario));
		campoLivre.append(getCodigoBeneficiarioFormatado(beneficiario));
		campoLivre.append(getNossoNumeroFormatado(beneficiario));
		campoLivre.append(TIPO_COBRANCA_EMITIDO_AO_CLIENTE);
		return new CodigoDeBarrasBuilder(boleto).comCampoLivre(campoLivre);
	}
	
	@Override
	public String getCodigoBeneficiarioFormatado(Beneficiario beneficiario) {
		StringBuilder builder = new StringBuilder();
		builder.append(leftPadWithZeros(beneficiario.getCodigoBeneficiario(), 8));
		builder.append(beneficiario.getDigitoCodigoBeneficiario());
		return builder.toString();
	}

	@Override
	public String getCarteiraFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getCarteira(), 2);
	}

	@Override
	public String getNossoNumeroFormatado(Beneficiario beneficiario) {
		StringBuilder builder = new StringBuilder();
		builder.append(leftPadWithZeros(beneficiario.getNossoNumero(),9));
		return builder.toString();
	}
	
	@Override
	public String getNumeroFormatadoComDigito() {
		StringBuilder builder = new StringBuilder();
		builder.append(getNumeroFormatado()).append("-");
		return builder.append(DIGITO_NUMERO_SAFRA).toString();
	}
	
	private String getAgencia(Beneficiario beneficiario){
		StringBuilder builder =new StringBuilder();
		//O Banco Safra espera uma Agencia com 5 posicoes
		builder.append("0");
		return builder.append(beneficiario.getAgenciaFormatada()).toString();
	}

}
