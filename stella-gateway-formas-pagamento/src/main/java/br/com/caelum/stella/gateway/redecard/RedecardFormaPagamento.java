package br.com.caelum.stella.gateway.redecard;

import br.com.caelum.stella.gateway.core.InvalidCheckoutException;

public class RedecardFormaPagamento {

	private RedecardTipoTransacao tipoTransacao;
	private int numeroDeParcelas;

	/**
	 * 
	 * @param tipoTransacao
	 * @param numeroDeParcelas
	 * @throws InvalidCheckoutException
	 *             caso a combinação tipoTransacao e numeroDeParcelas esteja
	 *             errada.
	 */
	public RedecardFormaPagamento(RedecardTipoTransacao tipoTransacao,
			int numeroDeParcelas) {
		if (numeroDeParcelas < 0) {
			throw new InvalidCheckoutException(
					"O número de parcelas não pode ser igual ou menor que 0");
		} else {
			if (tipoTransacao.equals(RedecardTipoTransacao.A_VISTA)) {
				if (numeroDeParcelas > 0) {
					throw new InvalidCheckoutException(
							"Para transação a vista o número de parcelas deve ser igual a 0");
				}

			} else {
				if (numeroDeParcelas == 0) {
					throw new InvalidCheckoutException("Para transações com "
							+ numeroDeParcelas
							+ " parcela(s), use o tipo de transação a vista");
				}
			}
			this.tipoTransacao = tipoTransacao;
			this.numeroDeParcelas = numeroDeParcelas;
		}
	}

	/**
	 * 
	 * @return Parcelamento já configurado para transacao a vista.
	 */
	public static RedecardFormaPagamento newPagamentoAVista() {
		return new RedecardFormaPagamento(RedecardTipoTransacao.A_VISTA, 0);
	}

	public static RedecardFormaPagamento newPagamentoParceladoJurosLojista(
			int numeroDeParcelas) {
		return new RedecardFormaPagamento(
				RedecardTipoTransacao.PARCELADO_JUROS_LOJISTA, numeroDeParcelas);
	}

	public static RedecardFormaPagamento newPagamentoParceladoJurosEmissor(
			int numeroDeParcelas) {
		return new RedecardFormaPagamento(
				RedecardTipoTransacao.PARCELADO_JUROS_EMISSOR, numeroDeParcelas);
	}

	public RedecardTipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public int getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public String getNumeroDeParcelasComNoMinimoDoisDigitos() {
		return String.format("%02d", numeroDeParcelas);
	}

}
