package br.com.caelum.stella.gateway.redecard;

import br.com.caelum.stella.gateway.core.InvalidCheckoutException;

public class FormaPagamento {

	private final TipoTransacao tipoTransacao;
	private final int numeroDeParcelas;

	/**
	 * 
	 * @param tipoTransacao
	 * @param numeroDeParcelas
	 * @throws InvalidCheckoutException
	 *             caso a combinação tipoTransacao e numeroDeParcelas esteja
	 *             errada.
	 */
	public FormaPagamento(final TipoTransacao tipoTransacao,
			final int numeroDeParcelas) {
		if (numeroDeParcelas < 0) {
			throw new InvalidCheckoutException(
					"O número de parcelas não pode ser igual ou menor que 0");
		} else {
			if (tipoTransacao.equals(TipoTransacao.A_VISTA)) {
				if (numeroDeParcelas > 0) {
					throw new InvalidCheckoutException(
							"Para transação a vista o número de parcelas deve ser igual a 0");
				}

			} else {
				if (numeroDeParcelas <= 0) {
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
	public static FormaPagamento newPagamentoAVista() {
		return new FormaPagamento(TipoTransacao.A_VISTA, 0);
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public int getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public String getNumeroDeParcelasComNoMinimoDoisDigitos() {
		return String.format("%02d", numeroDeParcelas);
	}

}
