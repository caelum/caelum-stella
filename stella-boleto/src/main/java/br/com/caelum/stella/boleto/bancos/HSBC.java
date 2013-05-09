package br.com.caelum.stella.boleto.bancos;

import java.net.URL;
import java.util.Calendar;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Emissor;

public class HSBC extends AbstractBanco implements Banco {

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
		return String.format("%016d", emissor.getNossoNumero()).substring(0, 13);
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
	public String getNossoNumeroECodDocumento(Emissor emissor) {
		return String.format("%016d", emissor.getNossoNumero());
	}
	
}
