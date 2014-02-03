package br.com.caelum.stella.boleto.bancos;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sun.xml.internal.ws.util.StringUtils;

import br.com.caelum.stella.DigitoPara;
import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Emissor;

public class HSBC extends AbstractBanco implements Banco {

	private static final long serialVersionUID = 1L;

	private static final String NUMERO_HSBC = "399";
	private static final String DIGITO_HSBC = "9";
	private static final String CODIGO_APLICATIVO = "2";

	@Override
	public String getNumeroFormatadoComDigito() {
		return NUMERO_HSBC + "-" + DIGITO_HSBC;
	}

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		StringBuilder campoLivre = new StringBuilder();
		int codigoAgencia = boleto.getEmissor().getCodigoFornecidoPelaAgencia();
		campoLivre.append(String.format("%07d", codigoAgencia));
		campoLivre.append(getNossoNumeroDoEmissorFormatado(boleto.getEmissor()));
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
	public String getCarteiraDoEmissorFormatado(Emissor emissor) {
		return "CNR";
	}

	@Override
	public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
		return String.format("%07d", emissor.getContaCorrente());
	}

	@Override
	public URL getImage() {
		String arquivo = "/br/com/caelum/stella/boleto/img/%s.png";
		String imagem = String.format(arquivo, getNumeroFormatado());
		return getClass().getResource(imagem);
	}

	@Override
	public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
		return String.format("%013d", emissor.getNossoNumero());
	}

	@Override
	public String getNumeroFormatado() {
		return HSBC.NUMERO_HSBC;
	}

	@Override
	public String getAgenciaECodigoCedente(Emissor emissor) {
		return String.format("%07d", emissor.getCodigoFornecidoPelaAgencia());
	}

	
	@Override
	public String getNossoNumeroECodDocumento(Boleto boleto) {
		
		Emissor emissor = boleto.getEmissor();
		
		String nossoNumero = getNossoNumeroDoEmissorFormatado(emissor);
		int beneficiario = emissor.getCodigoFornecidoPelaAgencia();
		String dataVcto = new SimpleDateFormat("ddMMyy").format(boleto.getDatas().getVencimento().getTime());;
		
		DigitoPara calculadorMod = getModuloNossoNumero(nossoNumero);
		String primeiroDigito = calculadorMod.calcula();
		
		String nossoNumeroComDigitos = nossoNumero + primeiroDigito + 4; // 4 é fixo
	
		long nossoNum = Long.parseLong(nossoNumeroComDigitos);
		long vcto = Long.parseLong(dataVcto);
		
		String somatorio = String.valueOf(nossoNum + beneficiario + vcto);
		
		String segundoDigito = getModuloNossoNumero(somatorio).calcula();
		return nossoNumeroComDigitos + segundoDigito;
	}

	private DigitoPara getModuloNossoNumero(String nossoNumero) {
		return new DigitoPara(nossoNumero).comMultiplicadores(9,8,7,6,5,4,3,2).mod(11);
	}
	
}
