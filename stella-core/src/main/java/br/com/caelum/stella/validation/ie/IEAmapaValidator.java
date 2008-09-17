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
 * href="http://www.sintegra.gov.br/Cad_Estados/cad_AP.html">SINTEGRA - ROTEIRO
 * DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a>
 * 
 * @author Leonardo Bessa
 * 
 */
public class IEAmapaValidator implements Validator<String> {

    private static final int MOD = 11;

    private static final int DVX_POSITION = 5 + 9;

    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P1;

    private static final RotinaDeDigitoVerificador[] ROTINAS_CASO1 = {
            IEConstraints.Rotina.C, IEConstraints.Rotina.E,
            IEConstraints.Rotina.POS_IE };

    private static final RotinaDeDigitoVerificador[] ROTINAS_CASO2 = ROTINAS_CASO1;

    private static final RotinaDeDigitoVerificador[] ROTINAS_CASO3 = {
            IEConstraints.Rotina.E, IEConstraints.Rotina.POS_IE };

    private static final DigitoVerificadorInfo DVX_INFO_CASO1 = new DigitoVerificadorInfo(
            0, ROTINAS_CASO1, MOD, DVX_MULTIPLIERS, DVX_POSITION);

    private static final DigitoVerificadorInfo DVX_INFO_CASO2 = new DigitoVerificadorInfo(
            1, ROTINAS_CASO2, MOD, DVX_MULTIPLIERS, DVX_POSITION);

    private static final DigitoVerificadorInfo DVX_INFO_CASO3 = new DigitoVerificadorInfo(
            0, ROTINAS_CASO3, MOD, DVX_MULTIPLIERS, DVX_POSITION);

    private static final ValidadorDeDV DVX_CHECKER_CASO1 = new ValidadorDeDV(
            DVX_INFO_CASO1);

    private static final ValidadorDeDV DVX_CHECKER_CASO2 = new ValidadorDeDV(
            DVX_INFO_CASO2);

    private static final ValidadorDeDV DVX_CHECKER_CASO3 = new ValidadorDeDV(
            DVX_INFO_CASO3);

    private final boolean isFormatted;

    public static final Pattern FORMATED = Pattern
            .compile("(03)[.](\\d{3})[.](\\d{3})[-](\\d{1})");

    public static final Pattern UNFORMATED = Pattern
            .compile("(03)(\\d{3})(\\d{3})(\\d{1})");

    /**
     * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public IEAmapaValidator() {
        this(true);
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens.
     * 
     * @param isFormatted
     *            considerar cadeia formatada quando <code>true</code>
     */
    public IEAmapaValidator(boolean isFormatted) {
        this.baseValidator = new BaseValidator();
        this.isFormatted = isFormatted;
    }

    public IEAmapaValidator(MessageProducer messageProducer, boolean isFormatted) {
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
        int ie = Integer.parseInt(value) / 10;
        boolean result;
        /*
         * http://www.sintegra.gov.br/Cad_Estados/cad_AP.html
         * 
         * De 03000001X a 03017000X => CASO 1
         * 
         * De 03017001X a 03019022X => CASO 2
         * 
         * De 03019023X em diante => CASO 3
         */
        String testedValue = IEConstraints.PRE_VALIDATION_FORMATTER
                .format(value);
        ValidadorDeDV validadorDeDV = null;
        if ((3000001 <= ie) && (ie <= 3017000)) {
            validadorDeDV = DVX_CHECKER_CASO1;
        } else if ((3017001 <= ie) && (ie <= 3019022)) {
            validadorDeDV = DVX_CHECKER_CASO2;
        } else if (3019023 <= ie) {
            validadorDeDV = DVX_CHECKER_CASO3;
        }
        result = validadorDeDV.isDVValid(testedValue);

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
