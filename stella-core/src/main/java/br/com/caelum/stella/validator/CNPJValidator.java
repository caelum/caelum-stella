package br.com.caelum.stella.validator;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.Validator;

/**
 * @Author Leonardo Bessa
 */
public class CNPJValidator implements Validator<String> {
	private final MessageProducer<CNPJError> messageProducer;
	private final List<CNPJError> errors = new ArrayList<CNPJError>();
	private static final int MOD = 11;
	private static final int CNPJ_DIGITS_SIZE = 14;
	// Décimo terceiro digito é o primeiro digito verificador
	private static final int dv1_position = 12;
	// Décimo quarto primeiro digito é o segundo digito verificador
	private static final int dv2_position = 13;
	private static final int[] dv1Multipliers = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4,
			3, 2 };
	private static final int[] dv2Multipliers = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5,
			4, 3, 2 };

	public CNPJValidator(MessageProducer<CNPJError> messageProducer) {
		super();
		this.messageProducer = messageProducer;
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
		if (cnpj == null) {
			return true;
		}
		errors.clear();
		
		if (!cnpj.matches("\\d{" + CNPJ_DIGITS_SIZE + "}")) {
			errors.add(CNPJError.DIGITS_MISSMATCH);
		}
		if (hasAllRepeatedDigits(cnpj)) {
			errors.add(CNPJError.ALL_REPEATED_DIGITS_FAUL);
		}
		if (errors.isEmpty() && !hasValidCheckDigits(cnpj)) {
			errors.add(CNPJError.CHECK_DIGITS_MISSMATCH);
		}

		return errors.isEmpty();
	}
	private boolean hasAllRepeatedDigits(String cnpj) {
		for (int i = 1; i < cnpj.length(); i++) {
			if (cnpj.charAt(i) != cnpj.charAt(0)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean hasValidCheckDigits(String cnpj) {
		int[] cnpjDigits = new int[CNPJ_DIGITS_SIZE];
		for (int i = 0; i < CNPJ_DIGITS_SIZE; i++) {
			cnpjDigits[i] = Integer.parseInt("" + cnpj.charAt(i));
		}
		Integer dv1 = cnpjDigits[dv1_position];
		Integer dv2 = cnpjDigits[dv2_position];
		Integer determinedDV1 = determineCheckDigit(cnpjDigits, dv1_position);
		Integer determinedDV2 = determineCheckDigit(cnpjDigits, dv2_position);
		return dv1.equals(determinedDV1) && dv2.equals(determinedDV2);
	}
	
	private Integer determineCheckDigit(int[] cnpjDigits, int checkDigitPosition) {
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
		int resto = innerProduct(multipliers, cnpjDigits) % MOD;
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

}
