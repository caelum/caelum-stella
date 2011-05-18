package br.com.caelum.stella.validation.ie;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.BaseValidator;
import br.com.caelum.stella.validation.InvalidValue;
import br.com.caelum.stella.validation.ValidadorDeDV;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.error.IEError;

public enum IEValidators {

	ACRE(Pattern.compile("(01)[.](\\d{3})[.](\\d{3})[/](\\d{3})[-](\\d{2})"), 
			Pattern.compile("(01)(\\d{3})(\\d{3})(\\d{3})(\\d{2})"),
			IEConstraints.Acre.DVX_CHECKER, 
			IEConstraints.Acre.DVY_CHECKER);

	private final Pattern formatted;
	private final Pattern unformatted;
	private final ValidadorDeDV validadorX;
	private final ValidadorDeDV validadorY;

	IEValidators(Pattern formatted, Pattern unformatted, ValidadorDeDV validadorX, ValidadorDeDV validadorY) {
		this.formatted = formatted;
		this.unformatted = unformatted;
		this.validadorX = validadorX;
		this.validadorY = validadorY;
	}
	
	public Validator<String> build() {
		return new IEValidator();
	}

	public Validator<String> build(boolean formatted) {
		return new IEValidator(formatted);
	}

	public Validator<String> build(MessageProducer producer, boolean formatted) {
		return new IEValidator(producer, formatted);
	}

	class IEValidator implements Validator<String> {

	    private boolean isFormatted;
		private BaseValidator baseValidator;

		public IEValidator() {
	        this(true);
	    }

	    public IEValidator(boolean isFormatted) {
	        this.isFormatted = isFormatted;
	        this.baseValidator = new BaseValidator();
	    }

	    public IEValidator(MessageProducer messageProducer, boolean isFormatted) {
	        this.baseValidator = new BaseValidator(messageProducer);
	        this.isFormatted = isFormatted;
	    }
	    
	    private List<InvalidValue> getInvalidValues(String IE) {
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
	            if (!formatted.matcher(ie).matches()) {
	                errors.add(IEError.INVALID_FORMAT);
	            }
	            unformatedIE = ie.replaceAll("\\D", "");
	        } else {
	            if (!unformatted.matcher(ie).matches()) {
	                errors.add(IEError.INVALID_DIGITS);
	            }
	            unformatedIE = ie;
	        }
	        return unformatedIE;
	    }

	    private boolean hasValidCheckDigits(String value) {
	        String testedValue = IEConstraints.PRE_VALIDATION_FORMATTER.format(value);
	        return validadorX.isDVValid(testedValue) && validadorY.isDVValid(testedValue);
	    }

	    public boolean isEligible(String value) {
	        boolean result;
	        if (isFormatted) {
	            result = formatted.matcher(value).matches();
	        } else {
	            result = unformatted.matcher(value).matches();
	        }
	        return result;
	    }

	    public void assertValid(String ie) {
	        baseValidator.assertValid(getInvalidValues(ie));
	    }

	    public List<ValidationMessage> invalidMessagesFor(String IE) {
	        return baseValidator.generateValidationMessages(getInvalidValues(IE));
	    }

		
	}
}
