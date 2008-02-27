package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.Validator;

/**
 * @Author Leonardo Bessa
 */
public class RGValidatorForSaoPaulo implements Validator<String> {

	private static final int DIVISOR = 11;
	private final MessageProducer<RGError> messageProducer;
	private final List<RGError> errors = new ArrayList<RGError>();
	private static final int MOD = 11;
	private static final int RG_DIGITS_SIZE = 9;
	private static final int[] multipliers = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	public RGValidatorForSaoPaulo(MessageProducer<RGError> messageProducer) {
		super();
		this.messageProducer = messageProducer;
	}

	public List<ValidationMessage> getLastValidationMessages() {
		List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
		for (RGError error : errors) {
			ValidationMessage message = messageProducer.getMessage(error);
			messages.add(message);
		}
		return messages;
	}

	public boolean validate(String rg) {
		if (rg == null) {
			return true;
		}
		errors.clear();

		if (!rg.matches("\\d{" + RG_DIGITS_SIZE + "}")) {
			errors.add(RGError.INVALID_DIGITS_PATTERN);
		}
		if (errors.isEmpty() && checkDigit(rg)){
			errors.add(RGError.INVALID_CHECK_DIGITS);
		}
		return errors.isEmpty();
	}

	private boolean checkDigit(String rg) {
		int result = 0;
		int position = 0;
		for (int multiplier : multipliers) {
			char charDigit = rg.charAt(position++);
			int intDigit = Integer.parseInt("" + charDigit);
			result += intDigit*multiplier;
		}

		result /= DIVISOR;
		result %= MOD;

		return (result == 0);
	}

}
