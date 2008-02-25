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
public class CNPJValidator implements Validator<String> {
	private final String CNPJ_FORMAT = "\\d{2}[.]\\d{3}[.]\\d{3}/\\d{4}-\\d{2}";
	private final boolean isFormatted;
	private final MessageProducer<CNPJError> messageProducer;
	private final List<CNPJError> errors = new ArrayList<CNPJError>();
	private static final int MOD = 11;
	private static final int CNPJ_DIGITS_SIZE = 14;
	// Décimo terceiro digito é o primeiro digito verificador
	private static final int dv1Position = 13;
	// Décimo quarto digito é o segundo digito verificador
	private static final int dv2Position = 14;
	private static final Integer[] dv1Multipliers = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4,
			3, 2 };
	private static final Integer[] dv2Multipliers = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5,
			4, 3, 2 };

	private static DigitChecker digitChecker;

	{
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		map.put(dv1Position, Arrays.asList(dv1Multipliers));
		map.put(dv2Position, Arrays.asList(dv2Multipliers));
		digitChecker = new DigitChecker(map, MOD);
	}

	public CNPJValidator(MessageProducer<CNPJError> messageProducer, boolean isFormatted) {
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
		if (cnpj == null) {
			return true;
		}
		errors.clear();
		if (isFormatted){
			if(!cnpj.matches(CNPJ_FORMAT)){
				errors.add(CNPJError.INVALID_FORMAT);
			}
			cnpj = cnpj.replaceAll("[^0-9]", "");
		}
		else if (!cnpj.matches("\\d{" + CNPJ_DIGITS_SIZE + "}")) {
			errors.add(CNPJError.INVALID_DIGITS_PATTERN);
		}
		if (errors.isEmpty() && hasAllRepeatedDigits(cnpj)) {
			errors.add(CNPJError.ALL_REPEATED_DIGITS_FAUL);
		}
		if (errors.isEmpty() && !digitChecker.hasValidCheckDigits(cnpj)) {
			errors.add(CNPJError.INVALID_CHECK_DIGITS);
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

}
