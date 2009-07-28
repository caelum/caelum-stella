package br.com.caelum.stella.gateway.visa;

import java.util.Calendar;

import br.com.caelum.stella.gateway.core.InvalidCheckoutException;

/**
 * Classe responsável por gerar o TID, tá isolado para facilitar os testes e
 * para que possa ser usada em outro contexto.
 * 
 * @author Alberto Pc
 * 
 */
public class TIDGenerator {


	/**
	 * identificador unico gerado para cada compra.
	 * 
	 * @param data
	 *            data que serve de referencia para o calculo do tid
	 * @param numeroDeAfiliacao
	 *            numeroDeAfiliacao que serve de base para o calculo.
	 * @return
	 * @throws InvalidCheckoutException
	 *             caso o parcelamento não tenha sido definido
	 */
	public String getTid(VISAFormaPagamento parcelamento, Calendar data,
			long numeroDeFiliacao) {
		String dataNoFormatoJuliano = obterDataNoFormatoJuliano(data);
		String numeroDeFiliacaoString = String.valueOf(numeroDeFiliacao);
		String numeroDeAfiliacaoDoVisaFormatado = String.valueOf(numeroDeFiliacaoString).substring(4,
				numeroDeFiliacaoString.length() - 1);
		String horaFormatadaComOMilesimoDoSegundo = String.format(
				"%1$tH%1$tM%1$tS"
						+ String.valueOf(data.get(Calendar.MILLISECOND))
								.substring(0, 1), data);
		String ultimoDigitoDoAno = getUltimoDigitoDoAno(data);
		String tid = numeroDeAfiliacaoDoVisaFormatado + ultimoDigitoDoAno
				+ dataNoFormatoJuliano + horaFormatadaComOMilesimoDoSegundo
				+ parcelamento.getCodigoDePagamento();
		return tid;

	}

	private String getUltimoDigitoDoAno(Calendar data) {
		String ano = String.valueOf(data.get(Calendar.YEAR));
		return ano.substring(ano.length() - 1);
	}

	private String obterDataNoFormatoJuliano(Calendar data) {
		int diaDoAno = data.get(Calendar.DAY_OF_YEAR);
		String result = String.format("%03d", diaDoAno);
		return result;
	}

}
