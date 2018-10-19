package br.com.caelum.stella.boleto.bancos;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;
import br.com.caelum.stella.DigitoPara;
import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;

public class HSBC extends AbstractBanco implements Banco {

	private static final long serialVersionUID = 1L;

	private static final String NUMERO_HSBC = "399";
	private static final String DIGITO_HSBC = "9";
	private static final String CODIGO_APLICATIVO = "2";
	private static final String CARTEIRA_NAO_REGISTRADA = "CNR";

	@Override
	public String getNumeroFormatadoComDigito() {
		return NUMERO_HSBC + "-" + DIGITO_HSBC;
	}

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		StringBuilder campoLivre = new StringBuilder();
		String codigoAgencia = boleto.getBeneficiario().getCodigoBeneficiario();
		campoLivre.append(leftPadWithZeros(codigoAgencia, 7));
		campoLivre.append(getNossoNumeroFormatado(boleto.getBeneficiario()));
		campoLivre.append(getDataFormatoJuliano(boleto.getDatas().getVencimento(), 4));
		campoLivre.append(HSBC.CODIGO_APLICATIVO);
		return new CodigoDeBarrasBuilder(boleto).comCampoLivre(campoLivre);
	}

	public String getDataFormatoJuliano(Calendar vencimento, int tipo) {
		String result;
		Calendar dataLimite = Calendar.getInstance();
		dataLimite.set(Calendar.DAY_OF_MONTH, 1);
		dataLimite.set(Calendar.MONTH, 7 - 1);
		dataLimite.set(Calendar.YEAR, 1997);
		if (vencimento.before(dataLimite)) {
			result = "0000";
		} else {
			int diaDoAno = vencimento.get(Calendar.DAY_OF_YEAR);
			int digitoDoAno = vencimento.get(Calendar.YEAR) % 10;
			result = String.format("%03d%d", diaDoAno, digitoDoAno);
		}
		return result;
	}

	@Override
	public String getCarteiraFormatado(Beneficiario beneficiario) {
		return CARTEIRA_NAO_REGISTRADA;
	}

	@Override
	public String getCodigoBeneficiarioFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getCodigoBeneficiario(), 7);
	}

	@Override
	public URL getImage() {
		String arquivo = "/br/com/caelum/stella/boleto/img/%s.png";
		String imagem = String.format(arquivo, getNumeroFormatado());
		return getClass().getResource(imagem);
	}

	@Override
	public String getNossoNumeroFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getNossoNumero(), 13);
	}

	@Override
	public String getNumeroFormatado() {
		return HSBC.NUMERO_HSBC;
	}

	@Override
	public String getAgenciaECodigoBeneficiario(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getCodigoBeneficiario(), 7);
	}
	
	@Override
	public String getNossoNumeroECodigoDocumento(Boleto boleto) {
		
		Beneficiario beneficiario = boleto.getBeneficiario();
		
		String nossoNumero = getNossoNumeroFormatado(beneficiario);
		String codigoBeneficiario = beneficiario.getCodigoBeneficiario();
		String dataVcto = new SimpleDateFormat("ddMMyy").format(boleto.getDatas().getVencimento().getTime());;
		
		DigitoPara calculadorMod = getModuloNossoNumero(nossoNumero);
		String primeiroDigito = calculadorMod.calcula();
		
		String nossoNumeroComDigitos = nossoNumero + primeiroDigito + 4; // 4 é fixo
	
		long nossoNum = Long.parseLong(nossoNumeroComDigitos);
		long vcto = Long.parseLong(dataVcto);
		long benef = Long.parseLong(codigoBeneficiario);
		
		String somatorio = String.valueOf(nossoNum + benef + vcto);
		
		DigitoPara calculadorMod2 = getModuloNossoNumero(somatorio);
		String segundoDigito = calculadorMod2.calcula();
		return nossoNumeroComDigitos + segundoDigito;
	}

	private DigitoPara getModuloNossoNumero(String nossoNumero) {
		return new DigitoPara(nossoNumero)
						.trocandoPorSeEncontrar("0",10,11)
						.comMultiplicadores(9,8,7,6,5,4,3,2)
						.mod(11);
	}
	
}