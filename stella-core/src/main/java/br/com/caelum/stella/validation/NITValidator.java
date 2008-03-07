package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.Validator;

/**
 * @author Leonardo Bessa
 * 
 * Número de Identificação do Trabalhador com 11 (onze) caracteres numéricos, no
 * formato XXX.XXXXX.XX-X.
 * <p>
 * O NIT corresponde ao número do PIS/PASEP/CI sendo que, no caso de
 * Contribuinte Individual (CI), pode ser utilizado o número de inscrição no
 * Sistema Único de Saúde (SUS) ou na Previdência Social.
 * </p>
 */
public class NITValidator implements Validator<String> {
	private final String NIT_FORMAT = "\\d{3}[.]\\d{5}[.]\\d{2}-\\d{1}";
	private final boolean isFormatted;
	private final MessageProducer<NITError> messageProducer;
	private static final int MOD = 11;
	private static final int NIT_DIGITS_SIZE = 11;
	private static final Integer dv1Position = 11;
	private static final Integer[] dv1Multipliers = { 3, 2, 9, 8, 7, 6, 5, 4,
			3, 2 };

	private final List<NITError> errors = new ArrayList<NITError>();

	@SuppressWarnings("serial")
	private static final DigitChecker digitChecker = new DigitChecker(
			new HashMap<Integer, List<Integer>>() {
				{
					this.put(dv1Position, Arrays.asList(dv1Multipliers));
				}
			}, MOD) {
		@Override
		protected int rotinaPosProdutoInterno(int resto) {
			return (resto < 2) ? 0 : 11 - resto;
		}
	};

	public NITValidator(MessageProducer<NITError> messageProducer,
			boolean isFormatted) {
		super();
		this.isFormatted = isFormatted;
		this.messageProducer = messageProducer;
	}

	public List<ValidationMessage> getLastValidationMessages() {
		List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
		for (NITError error : errors) {
			ValidationMessage message = messageProducer.getMessage(error);
			messages.add(message);
		}
		return messages;
	}

	public boolean validate(String NIT) {
		if (NIT == null) {
			return true;
		}
		errors.clear();

		if (isFormatted) {
			if (!NIT.matches(NIT_FORMAT)) {
				errors.add(NITError.INVALID_FORMAT);
			}
			NIT = NIT.replaceAll("[^0-9]", "");
		} else if (!NIT.matches("\\d{" + NIT_DIGITS_SIZE + "}")) {
			errors.add(NITError.INVALID_DIGITS);
		}
		if (errors.isEmpty() && hasAllRepeatedDigits(NIT)) {
			errors.add(NITError.REPEATED_DIGITS);
		}
		if (errors.isEmpty() && !digitChecker.hasValidCheckDigits(NIT)) {
			errors.add(NITError.INVALID_CHECK_DIGITS);
		}

		return errors.isEmpty();

	}

	private boolean hasAllRepeatedDigits(String s) {
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(0)) {
				return false;
			}
		}
		return true;
	}

}
