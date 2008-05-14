package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.error.IEError;

public class InscricaoEstatudalDeMinasGeraisValidator extends
		AbstractValidator<String> {

	private static final int DVX_MOD = 10;

	private static final int DVY_MOD = 11;

	// TAMANHO = 13;
	private static final String MISSING_ZEROS = "0";

	private static final int DVX_POSITION = MISSING_ZEROS.length() + 12;

	private static final int DVY_POSITION = MISSING_ZEROS.length() + 13;

	private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P10;

	private static final Integer[] DVY_MULTIPLIERS = IEConstraints.P11;

	private static final RotinaDeDigitoVerificador[] DVX_ROTINAS = {
			IEConstraints.Rotina.A, IEConstraints.Rotina.E,
			IEConstraints.Rotina.POS_IE };

	private static final RotinaDeDigitoVerificador[] DVY_ROTINAS = {
			IEConstraints.Rotina.E, IEConstraints.Rotina.POS_IE };

	private static final DigitoVerificadorInfo DVX_INFO = new DigitoVerificadorInfo(
			0, DVX_ROTINAS, DVX_MOD, DVX_MULTIPLIERS, DVX_POSITION);

	private static final DigitoVerificadorInfo DVY_INFO = new DigitoVerificadorInfo(
			0, DVY_ROTINAS, DVY_MOD, DVY_MULTIPLIERS, DVY_POSITION);

	private static final ValidadorDeDV DVX_CHECKER = new ValidadorDeDV(DVX_INFO);

	private static final ValidadorDeDV DVY_CHECKER = new ValidadorDeDV(DVY_INFO);

	private final boolean isFormatted;

	public static final Pattern FORMATED = Pattern
			.compile("(\\d{3})[.](\\d{3})[.](\\d{3})[/](\\d{4})");
	public static final Pattern UNFORMATED = Pattern
			.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{4})");
	private static final String REPLACEMENT = MISSING_ZEROS + "$1$2$3$4";

	public InscricaoEstatudalDeMinasGeraisValidator(
			MessageProducer messageProducer, boolean isFormatted) {
		super(messageProducer);
		this.isFormatted = isFormatted;
	}

	@Override
	protected List<InvalidValue> getInvalidValues(String IE) {
		List<InvalidValue> errors = new ArrayList<InvalidValue>();
		errors.clear();
		if (IE != null) {
			String unformatedIE = checkForCorrectFormat(IE, errors);
			if (errors.isEmpty()) {
				if (!hasValidCheckDigits(unformatedIE)) {
					errors.add(IEError.INVALID_CHECK_DIGITS);
				}
			}
		}
		return errors;
	}

	private String checkForCorrectFormat(String ie, List<InvalidValue> errors) {
		String unformatedIE = null;
		if (isFormatted) {
			if (!(FORMATED.matcher(ie).matches())) {
				errors.add(IEError.INVALID_FORMAT);
			}
			unformatedIE = ie.replaceAll("\\D", "");
		} else {
			if (!UNFORMATED.matcher(ie).matches()) {
				errors.add(IEError.INVALID_DIGITS);
			}
			unformatedIE = ie;
		}
		return unformatedIE;
	}

	private boolean hasValidCheckDigits(String value) {
		String testedValue = null;
		Matcher matcher = UNFORMATED.matcher(value);
		if (matcher.matches()) {
			testedValue = matcher.replaceAll(REPLACEMENT);
		}
		boolean DVXisValid = DVX_CHECKER.DVisValid(testedValue);
		boolean DVYisValid = DVY_CHECKER.DVisValid(testedValue);
		return (DVXisValid) && (DVYisValid);
	}

}
