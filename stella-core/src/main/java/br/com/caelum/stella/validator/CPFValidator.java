package br.com.caelum.stella.validator;

import java.util.ArrayList;
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
	private static final int dv1_position = 9;
	// Décimo primeiro digito é o segundo digito verificador
	private static final int dv2_position = 10;
	private static final int[] dv1Multipliers = { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
	private static final int[] dv2Multipliers = { 11, 10, 9, 8, 7, 6, 5, 4, 3,
			2 };
	private final List<CPFError> errors = new ArrayList<CPFError>();;

	public CPFValidator(MessageProducer<CPFError> messageProducer) {
		this.messageProducer = messageProducer;
	}

	public boolean validate(String cpf) {
		if (cpf == null) {
			return true;
		}
		errors.clear();
		
		if (!cpf.matches("\\d{" + CPF_DIGITS_SIZE + "}")) {
			errors.add(CPFError.DIGITS_MISSMATCH);
		}
		if (hasAllRepeatedDigits(cpf)) {
			errors.add(CPFError.ALL_REPEATED_DIGITS_FAUL);
		}
		if (errors.isEmpty() && !hasValidCheckDigits(cpf)) {
			errors.add(CPFError.CHECK_DIGITS_MISSMATCH);
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

	private boolean hasValidCheckDigits(String cpf) {
		int[] cpfDigits = new int[CPF_DIGITS_SIZE];
		for (int i = 0; i < CPF_DIGITS_SIZE; i++) {
			cpfDigits[i] = Integer.parseInt("" + cpf.charAt(i));
		}
		Integer dv1 = cpfDigits[dv1_position];
		Integer dv2 = cpfDigits[dv2_position];
		Integer determinedDV1 = determineCheckDigit(cpfDigits, dv1_position);
		Integer determinedDV2 = determineCheckDigit(cpfDigits, dv2_position);
		return dv1.equals(determinedDV1) && dv2.equals(determinedDV2);
	}

	private Integer determineCheckDigit(int[] cpfDigits, int checkDigitPosition) {
		int resultado;
		int[] multipliers;
		switch (checkDigitPosition) {
		case dv1_position:
			multipliers = dv1Multipliers;
			break;

		case dv2_position:
			multipliers = dv2Multipliers;
			break;

		default:
			throw new IllegalArgumentException("Not a check digit position.");
		}
		int resto = innerProduct(multipliers, cpfDigits) % MOD;
		resultado = (resto < 2) ? 0 : 11 - resto;
		return resultado;
	}

	private Integer innerProduct(int[] a, int[] b) {
		Integer result = 0;
		for (int i = 0; i < a.length; i++) {
			result += a[i] * b[i];
		}
		return result;
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
