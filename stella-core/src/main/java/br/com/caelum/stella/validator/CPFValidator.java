package br.com.caelum.stella.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.Validator;

/**
 * @Author Leonardo Bessa
 */
public class CPFValidator implements Validator<String> {
	private final MessageProducer<CPFError> messageProducer;
	private static final int MOD = 11;
	private static final int CPF_DIGITS_SIZE = 11;
	// Décimo digito é o primeiro digito verificador
	private static final Integer dv1Position = 10;
	// Décimo primeiro digito é o segundo digito verificador
	private static final Integer dv2Position = 11;
	private static final Integer[] dv1Multipliers = { 10, 9, 8, 7, 6, 5, 4, 3,
			2 };
	private static final Integer[] dv2Multipliers = { 11, 10, 9, 8, 7, 6, 5, 4,
			3, 2 };
	private final List<CPFError> errors = new ArrayList<CPFError>();

	private static DigitChecker digitChecker;

	{
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		map.put(dv1Position, Arrays.asList(dv1Multipliers));
		map.put(dv2Position, Arrays.asList(dv2Multipliers));
		digitChecker = new DigitChecker(map, MOD);
	}

	public CPFValidator(MessageProducer<CPFError> messageProducer) {
		this.messageProducer = messageProducer;
	}

	public boolean validate(String cpf) {
		if (cpf == null) {
			return true;
		}
		errors.clear();

		if (!cpf.matches("\\d{" + CPF_DIGITS_SIZE + "}")) {
			errors.add(CPFError.INVALID_DIGITS_PATTERN);
		}
		if (hasAllRepeatedDigits(cpf)) {
			errors.add(CPFError.ALL_REPEATED_DIGITS_FAUL);
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

}
