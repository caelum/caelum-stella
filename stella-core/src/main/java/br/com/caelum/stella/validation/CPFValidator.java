package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.Validator;

/**
 * @author Leonardo Bessa
 */
public class CPFValidator implements Validator<String> {
	private static final int CPF_DIGITS_SIZE = 11;
	private static final Pattern CPF_FORMATED = Pattern.compile("\\d{3}[.]\\d{3}[.]\\d{3}-\\d{2}");
	private static final Pattern CPF_UNFORMATED = Pattern.compile("\\d{"+CPF_DIGITS_SIZE+"}");
	private final boolean isFormatted;
	private final MessageProducer<CPFError> messageProducer;
	private static final int MOD = 11;
	// Décimo digito é o primeiro digito verificador
	private static final Integer dv1Position = 10;
	// Décimo primeiro digito é o segundo digito verificador
	private static final Integer dv2Position = 11;
	private static final Integer[] dv1Multipliers = { 10, 9, 8, 7, 6, 5, 4, 3,
			2 };
	private static final Integer[] dv2Multipliers = { 11, 10, 9, 8, 7, 6, 5, 4,
			3, 2 };
	private final List<CPFError> errors = new ArrayList<CPFError>();

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

	public CPFValidator(MessageProducer<CPFError> messageProducer, boolean isFormatted) {
		this.messageProducer = messageProducer;
		this.isFormatted = isFormatted;
	}

	public boolean validate(String cpf) {
		errors.clear();
		if (cpf == null) {
			return true;
		}

		if (isFormatted){
			if (!CPF_FORMATED.matcher(cpf).matches()){
				errors.add(CPFError.INVALID_FORMAT);
			}
			cpf = cpf.replaceAll("[^0-9]", "");
		}
		else
		if (!(CPF_UNFORMATED.matcher(cpf).matches())) {
			errors.add(CPFError.INVALID_DIGITS);
		}
		if (errors.isEmpty() && hasAllRepeatedDigits(cpf)) {
			errors.add(CPFError.REPEATED_DIGITS);
		}
		if (errors.isEmpty() && !digitChecker.hasValidCheckDigits(cpf)) {
			errors.add(CPFError.INVALID_CHECK_DIGITS);
		}

		return errors.isEmpty();
	}

	private boolean hasAllRepeatedDigits(String cpf) {
		for (int i = 1; i < cpf.length(); i++) {
			if (cpf.charAt(i) != cpf.charAt(0)) {
				return false;
			}
		}
		return true;
	}

	public List<ValidationMessage> getLastValidationMessages() {
		List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
		for (CPFError error : errors) {
			ValidationMessage message = messageProducer.getMessage(error);
			messages.add(message);
		}
		return messages;
	}

	public List<CPFError> getErrors() {
		return errors;
	}
}
