package br.com.caelum.stella.validation.ie;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.constraint.IEConstraints;
import br.com.caelum.stella.validation.BaseValidator;
import br.com.caelum.stella.validation.DigitoVerificadorInfo;
import br.com.caelum.stella.validation.InvalidValue;
import br.com.caelum.stella.validation.RotinaDeDigitoVerificador;
import br.com.caelum.stella.validation.ValidadorDeDV;
import br.com.caelum.stella.validation.Validator;
import br.com.caelum.stella.validation.error.IEError;

/**
 * <p>
 * Documentação de referência:
 * </p>
 * <a href="http://www.pfe.fazenda.sp.gov.br/consist_ie.shtm">Secretaria da
 * Fazenda do Estado de São Paulo</a> <a
 * href="http://www.sintegra.gov.br/Cad_Estados/cad_BA.html">SINTEGRA - ROTEIRO
 * DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a>
 * 
 * @author Leonardo Bessa
 * 
 */
public class IEBahiaValidator implements Validator<String> {

    private static final RotinaDeDigitoVerificador[] rotinas = {
            IEConstraints.Rotina.E, IEConstraints.Rotina.POS_IE };

    private static final int DVX_POSITION = 6 + 8;

    private static final int DVY_POSITION = 6 + 7;

    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P2;

    private static final Integer[] DVY_MULTIPLIERS = IEConstraints.P3;

    private static final DigitoVerificadorInfo DVX_INFO_MOD11 = new DigitoVerificadorInfo(
            0, rotinas, 11, DVX_MULTIPLIERS, DVX_POSITION);

    private static final ValidadorDeDV DVX_CHECKER_MOD11 = new ValidadorDeDV(
            DVX_INFO_MOD11);

    private static final DigitoVerificadorInfo DVY_INFO_MOD11 = new DigitoVerificadorInfo(
            0, rotinas, 11, DVY_MULTIPLIERS, DVY_POSITION);

    private static final ValidadorDeDV DVY_CHECKER_MOD11 = new ValidadorDeDV(
            DVY_INFO_MOD11);

    private static final DigitoVerificadorInfo DVX_INFO_MOD10 = new DigitoVerificadorInfo(
            0, rotinas, 10, DVX_MULTIPLIERS, DVX_POSITION);

    private static final ValidadorDeDV DVX_CHECKER_MOD10 = new ValidadorDeDV(
            DVX_INFO_MOD10);

    private static final DigitoVerificadorInfo DVY_INFO_MOD10 = new DigitoVerificadorInfo(
            0, rotinas, 10, DVY_MULTIPLIERS, DVY_POSITION);

    private static final ValidadorDeDV DVY_CHECKER_MOD10 = new ValidadorDeDV(
            DVY_INFO_MOD10);

    private final boolean isFormatted;

    /*
     * 612345-57
     * 
     * 123456-63
     * 
     */
    public static final Pattern FORMATED = Pattern
            .compile("(\\d{6})[-](\\d{2})");

    public static final Pattern UNFORMATED = Pattern
            .compile("(\\d{6})(\\d{2})");

    /**
     * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public IEBahiaValidator() {
        this(true);
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens.
     * 
     * @param isFormatted
     *            considerar cadeia formatada quando <code>true</code>
     */
    public IEBahiaValidator(boolean isFormatted) {
        this.baseValidator = new BaseValidator();
        this.isFormatted = isFormatted;
    }

    public IEBahiaValidator(MessageProducer messageProducer, boolean isFormatted) {
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
        String testedValue = IEConstraints.PRE_VALIDATION_FORMATTER
                .format(value);
        boolean result = false;
        switch (value.charAt(0)) {
        case '6':
        case '7':
        case '9':
            result = DVX_CHECKER_MOD11.isDVValid(testedValue)
                    && DVY_CHECKER_MOD11.isDVValid(testedValue);
            break;
        default:
            result = DVX_CHECKER_MOD10.isDVValid(testedValue)
                    && DVY_CHECKER_MOD10.isDVValid(testedValue);
        }
        return result;
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

}
