package br.com.caelum.stella.boleto.bancos;

import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;

import java.net.URL;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.bancos.gerador.GeradorDeDigitoSantander;

public class Santander extends AbstractBanco {

	private static final long serialVersionUID = 1L;

	private final static String NUMERO_SANTANDER = "033";
	private final static String DIGITO_SANTANDER = "7";
	private GeradorDeDigitoSantander gdivSantander = new GeradorDeDigitoSantander();

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		Beneficiario beneficiario = boleto.getBeneficiario();
		StringBuilder campoLivre = new StringBuilder("9");
		campoLivre.append(getNumeroConvenioFormatado(beneficiario));
		campoLivre.append(getNossoNumeroFormatado(beneficiario));
		campoLivre.append("0").append(beneficiario.getCarteira());
		return new CodigoDeBarrasBuilder(boleto).comCampoLivre(campoLivre);
	}
	
	@Override
	public URL getImage() {
		String pathDoArquivo = "/br/com/caelum/stella/boleto/img/%s.png";
		String imagem = String.format(pathDoArquivo, NUMERO_SANTANDER);
		return getClass().getResource(imagem);
	}

	@Override
	public String getNumeroFormatado() {
		return NUMERO_SANTANDER;
	}

	@Override
	public String getCarteiraFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getCarteira(), 3);
	}

	@Override
	public String getCodigoBeneficiarioFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getCodigoBeneficiario(), 7);
	}

	@Override
	public String getNossoNumeroFormatado(Beneficiario beneficiario) {
		String nossoNumero = beneficiario.getNossoNumero();
		if (beneficiario.getDigitoNossoNumero() != null) {
			return leftPadWithZeros(nossoNumero+beneficiario.getDigitoNossoNumero(), 13);
		} 
		return leftPadWithZeros(nossoNumero+getGeradorDeDigito().calculaDVNossoNumero(nossoNumero), 13);
	}

	@Override
	public String getNumeroFormatadoComDigito() {
		StringBuilder builder = new StringBuilder();
		builder.append(NUMERO_SANTANDER).append("-");
		return builder.append(DIGITO_SANTANDER).toString();
	}

	@Override
	public String getAgenciaECodigoBeneficiario(Beneficiario beneficiario) {
		StringBuilder builder = new StringBuilder();
		builder.append(leftPadWithZeros(beneficiario.getAgencia(), 5));
		builder.append("/").append(getNumeroConvenioFormatado(beneficiario));
		return builder.toString();
	}

	@Override
	public String getNossoNumeroECodigoDocumento(Boleto boleto) {
		Beneficiario beneficiario = boleto.getBeneficiario();
		
		String nossoNumero = getNossoNumeroFormatado(beneficiario);
		StringBuilder builder = new StringBuilder();
		builder.append(nossoNumero.substring(0, 12));
		builder.append("-").append(nossoNumero.substring(12));
		return  builder.toString();
	}
 
	@Override
	public GeradorDeDigitoSantander getGeradorDeDigito() {
		return gdivSantander;
	}
	
	public String getNumeroConvenioFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getNumeroConvenio(), 7);
	}
}