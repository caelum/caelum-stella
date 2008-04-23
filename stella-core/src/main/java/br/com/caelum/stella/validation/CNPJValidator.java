package br.com.caelum.stella.validation;

import static br.com.caelum.stella.constraint.CNPJConstraints.CNPJ_FORMATED;
import static br.com.caelum.stella.constraint.CNPJConstraints.CNPJ_UNFORMATED;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.Validator;
import br.com.caelum.stella.formatter.CNPJFormatter;

/**
 * @author Leonardo Bessa
 */
public class CNPJValidator implements Validator<String> {
	private final boolean isFormatted;
	private final MessageProducer<CNPJError> messageProducer;
	private final List<CNPJError> errors = new ArrayList<CNPJError>();
	private static final int MOD = 11;
	private static final int dv1Position = 13;
	private static final int dv2Position = 14;
	private static final Integer[] dv1Multipliers = { 5, 4, 3, 2, 9, 8, 7, 6,
			5, 4, 3, 2 };
	private static final Integer[] dv2Multipliers = { 6, 5, 4, 3, 2, 9, 8, 7,
			6, 5, 4, 3, 2 };

	@SuppressWarnings("serial")
	private static final DigitChecker digitChecker = new DigitChecker(
			new HashMap<Integer, List<Integer>>() {
				{
					this.put(dv1Position, Arrays.asList(dv1Multipliers));
					this.put(dv2Position, Arrays.asList(dv2Multipliers));
				}
			}, MOD) {
		@Override
		protected int rotinaPosProdutoInterno(int resto) {
			return (resto < 2) ? 0 : 11 - resto;
		}
	};

	public CNPJValidator(MessageProducer<CNPJError> messageProducer,
			boolean isFormatted) {
		super();
		this.messageProducer = messageProducer;
		this.isFormatted = isFormatted;
	}

	public List<ValidationMessage> getLastValidationMessages() {
		List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
		for (CNPJError error : errors) {
			ValidationMessage message = messageProducer.getMessage(error);
			messages.add(message);
		}
		return messages;
	}

	public boolean validate(String cnpj) {
		errors.clear();
		if (cnpj == null) {
			return true;
		}
		if (isFormatted) {
			if (!(CNPJ_FORMATED.matcher(cnpj).matches())) {
				errors.add(CNPJError.INVALID_FORMAT);
			}
			cnpj = (new CNPJFormatter()).unformat(cnpj);
		} else if (!CNPJ_UNFORMATED.matcher(cnpj).matches()) {
			errors.add(CNPJError.INVALID_DIGITS);
		}
		if (errors.isEmpty() && !digitChecker.hasValidCheckDigits(cnpj)) {
			errors.add(CNPJError.INVALID_CHECK_DIGITS);
		}

		return errors.isEmpty();
	}

}
