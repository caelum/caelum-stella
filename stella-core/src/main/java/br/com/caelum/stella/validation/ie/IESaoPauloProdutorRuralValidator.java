package br.com.caelum.stella.validation.ie;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.text.MaskFormatter;

import br.com.caelum.stella.DigitoGenerator;
import br.com.caelum.stella.DigitoPara;
import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.BaseValidator;
import br.com.caelum.stella.validation.InvalidValue;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.error.IEError;

class IESaoPauloProdutorRuralValidator implements Validator<String> {

    private final boolean isFormatted;

    public static final Pattern FORMATED = Pattern.compile("P-\\d{8}\\.\\d{1}/\\d{3}");

    public static final Pattern UNFORMATED = Pattern.compile("P\\d{12}");

    public IESaoPauloProdutorRuralValidator(MessageProducer messageProducer, boolean isFormatted) {
        this.baseValidator = new BaseValidator(messageProducer);
        this.isFormatted = isFormatted;
    }

    private List<InvalidValue> getInvalidValues(String ie) {
        List<InvalidValue> errors = new ArrayList<InvalidValue>();
        errors.clear();
        if (ie != null) {
            String unformatedIE = checkForCorrectFormat(ie, errors);
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
            unformatedIE = ie.replaceAll("\\D", "");
        }
        return unformatedIE;
    }

    protected boolean hasValidCheckDigits(String unformattedIE) {
		String iESemDigito = unformattedIE.substring(0, unformattedIE.length() - 4);
		String digito = unformattedIE.substring(unformattedIE.length() - 4, unformattedIE.length() - 3);

		String digitoCalculado = calculaDigito(iESemDigito);

		return digito.equals(digitoCalculado);
    }

	private String calculaDigito(String iESemDigito) {
		return new DigitoPara(iESemDigito).comMultiplicadores(10,8,7,6,5,4,3,1)
						.trocandoPorSeEncontrar("0", 10).trocandoPorSeEncontrar("1", 11).calcula();
	}

    public boolean isEligible(String value) {
        boolean result;
        if (isFormatted) {
            result = FORMATED.matcher(value).matches();
        } else {
            result = UNFORMATED.matcher(value).matches();
        }
        return result;
    }

    private final BaseValidator baseValidator;

    public void assertValid(String cpf) {
        baseValidator.assertValid(getInvalidValues(cpf));
    }

    public List<ValidationMessage> invalidMessagesFor(String cpf) {
        return baseValidator.generateValidationMessages(getInvalidValues(cpf));
    }

    private String formata(String valor) {
		try {
			final MaskFormatter formatador = new MaskFormatter("U-########.#/###");
			formatador.setValidCharacters("P1234567890");
			formatador.setValueContainsLiteralCharacters(false);
			return formatador.valueToString(valor);
		} catch (ParseException e) {
			throw new RuntimeException("Valor gerado não bate com o padrão: " + valor, e);
		}
	}
    
	@Override
	public String generateRandomValid() {
		final DigitoGenerator digitoGenerator = new DigitoGenerator();
		final String ieSemDigitoParte1 = digitoGenerator.generate(8);
		final String ieSemDigitoParte2 = digitoGenerator.generate(3);
		final String ieComDigito = "P" + ieSemDigitoParte1 + calculaDigito(ieSemDigitoParte1)
		        + ieSemDigitoParte2;
		if (isFormatted) {
			return formata(ieComDigito);
		}
		return ieComDigito;
	}
}
