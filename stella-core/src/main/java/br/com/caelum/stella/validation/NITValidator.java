package br.com.caelum.stella.validation;

import static br.com.caelum.stella.constraint.NITConstraints.NIT_FORMATED;
import static br.com.caelum.stella.constraint.NITConstraints.NIT_UNFORMATED;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.formatter.NITFormatter;

/**
 * <p>
 * Validador do Número de Identificação do Trabalhador. Este documento contém 11
 * (onze) caracteres numéricos, no formato ddd.ddddd.dd-d.
 * </p>
 * <p>
 * O NIT corresponde ao número do <b>PIS/PASEP/CI</b> sendo que, no caso de
 * Contribuinte Individual (CI), pode ser utilizado o número de inscrição no
 * Sistema Único de Saúde (SUS) ou na Previdência Social.
 * </p>
 * 
 * @author Leonardo Bessa
 */
public class NITValidator extends AbstractValidator<String> {

	private static final int MOD = 11;
	private final boolean isFormatted;

	@SuppressWarnings("serial")
	private static final DigitChecker digitChecker = new DigitChecker(
			new HashMap<Integer, List<Integer>>() {
				{
					final Integer dv1Position = 11;
					final Integer[] dv1Multipliers = { 3, 2, 9, 8, 7, 6, 5, 4,
							3, 2 };
					this.put(dv1Position, Arrays.asList(dv1Multipliers));
				}
			}, MOD) {
		@Override
		protected int rotinaPosProdutoInterno(int resto) {
			return (resto < 2) ? 0 : 11 - resto;
		}
	};

	/**
	 * <p>
	 * Construtor do Validador de NIT.
	 * </p>
	 * 
	 * @param messageProducer
	 *            produtor de mensagem de erro.
	 * @param isFormatted
	 *            considera cadeia no formato de NIT: "ddd.ddddd.dd-d" onde "d"
	 *            é um dígito decimal.
	 */
	public NITValidator(MessageProducer messageProducer, boolean isFormatted) {
		super(messageProducer);
		this.isFormatted = isFormatted;
	}

	protected List<InvalidValue> getInvalidValues(String nit) {
		List<InvalidValue> errors = new ArrayList<InvalidValue>();
		errors.clear();
		if (nit != null) {
			if (isFormatted) {
				if (!NIT_FORMATED.matcher(nit).matches()) {
					errors.add(NITError.INVALID_FORMAT);
				}
				nit = (new NITFormatter()).unformat(nit);
			} else if (!NIT_UNFORMATED.matcher(nit).matches()) {
				errors.add(NITError.INVALID_DIGITS);
			}
			if (errors.isEmpty() && !digitChecker.hasValidCheckDigits(nit)) {
				errors.add(NITError.INVALID_CHECK_DIGITS);
			}
		}
		return errors;
	}

}
