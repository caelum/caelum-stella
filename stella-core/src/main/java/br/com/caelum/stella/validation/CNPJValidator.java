package br.com.caelum.stella.validation;

import static br.com.caelum.stella.constraint.CNPJConstraints.CNPJ_FORMATED;
import static br.com.caelum.stella.constraint.CNPJConstraints.CNPJ_UNFORMATED;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.constraint.CNPJConstraints.Rotina;
import br.com.caelum.stella.formatter.CNPJFormatter;

/**
 * @author Leonardo Bessa
 */
public class CNPJValidator extends AbstractValidator<String> {
	private final boolean isFormatted;

	private static final int MOD = 11;

	private static final int DV1_POSITION = 13;

	private static final int DV2_POSITION = 14;

	private static final Integer[] DV1_MULTIPLIERS = { 5, 4, 3, 2, 9, 8, 7, 6,
			5, 4, 3, 2 };

	private static final Integer[] DV2_MULTIPLIERS = { 6, 5, 4, 3, 2, 9, 8, 7,
			6, 5, 4, 3, 2 };

	private static final DigitoVerificadorInfo DV1_INFO = new DigitoVerificadorInfo(
			0, new Rotina[] { Rotina.POS_PRODUTO_INTERNO }, MOD,
			DV1_MULTIPLIERS, DV1_POSITION);

	private static final DigitoVerificadorInfo DV2_INFO = new DigitoVerificadorInfo(
			0, new Rotina[] { Rotina.POS_PRODUTO_INTERNO }, MOD,
			DV2_MULTIPLIERS, DV2_POSITION);

	private static final ValidadorDeDV DV1_CHECKER = new ValidadorDeDV(DV1_INFO);

	private static final ValidadorDeDV DV2_CHECKER = new ValidadorDeDV(DV2_INFO);

	public CNPJValidator(MessageProducer messageProducer, boolean isFormatted) {
		super(messageProducer);
		this.isFormatted = isFormatted;
	}

	protected List<InvalidValue> getInvalidValues(String cnpj) {
		List<InvalidValue> errors = new ArrayList<InvalidValue>();
		errors.clear();
		if (cnpj != null) {
			String unformatedCNPJ = checkForCorrectFormat(cnpj, errors);
			if (errors.isEmpty()) {
				if (!hasValidCheckDigits(unformatedCNPJ)) {
					errors.add(CNPJError.INVALID_CHECK_DIGITS);
				}
			}
		}
		return errors;
	}

	private String checkForCorrectFormat(String cnpj, List<InvalidValue> errors) {
		String unformatedCNPJ = null;
		if (isFormatted) {
			if (!(CNPJ_FORMATED.matcher(cnpj).matches())) {
				errors.add(CNPJError.INVALID_FORMAT);
			}
			unformatedCNPJ = (new CNPJFormatter()).unformat(cnpj);
		} else {
			if (!CNPJ_UNFORMATED.matcher(cnpj).matches()) {
				errors.add(CNPJError.INVALID_DIGITS);
			}
			unformatedCNPJ = cnpj;
		}
		return unformatedCNPJ;
	}

	private boolean hasValidCheckDigits(String value) {
		return (DV1_CHECKER.DVisValid(value)) && (DV2_CHECKER.DVisValid(value));
	}

}
