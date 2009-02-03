package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.validation.error.CNPJError;

/**
 * Representa um validador de CNPJ.
 * 
 * @author Leonardo Bessa
 */
public class CNPJValidator implements Validator<String> {

    private final BaseValidator baseValidator;

    private final boolean isFormatted;

    private static final int MOD = 11;

    private static final int DV1_POSITION = 13;

    private static final int DV2_POSITION = 14;

    private static final Integer[] DV1_MULTIPLIERS = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

    private static final Integer[] DV2_MULTIPLIERS = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

    public static final Pattern FORMATED = Pattern.compile("(\\d{2})[.](\\d{3})[.](\\d{3})/(\\d{4})-(\\d{2})");

    public static final Pattern UNFORMATED = Pattern.compile("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})");


    private static final DigitoVerificadorInfo DV1_INFO = new DigitoVerificadorInfo(0,
            new RotinaComumDeDigitoVerificador[] { new RotinaComumDeDigitoVerificador() }, MOD, DV1_MULTIPLIERS,
            DV1_POSITION);

    private static final DigitoVerificadorInfo DV2_INFO = new DigitoVerificadorInfo(0,
            new RotinaComumDeDigitoVerificador[] { new RotinaComumDeDigitoVerificador() }, MOD, DV2_MULTIPLIERS,
            DV2_POSITION);

    private static final ValidadorDeDV DV1_CHECKER = new ValidadorDeDV(DV1_INFO);

    private static final ValidadorDeDV DV2_CHECKER = new ValidadorDeDV(DV2_INFO);

    /**
     * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public CNPJValidator() {
        this(true);
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens.
     * 
     * @param isFormatted
     *            considera cadeia no formato de CNPJ: "dd.ddd.ddd/dddd-dd" onde
     *            "d" é um dígito decimal.
     */
    public CNPJValidator(boolean isFormatted) {
        this.baseValidator = new BaseValidator();
        this.isFormatted = isFormatted;
    }

    /**
     * <p>
     * Construtor do Validador de CNPJ.
     * </p>
     * <p>
     * 
     * @param messageProducer
     *            produtor de mensagem de erro.
     * @param isFormatted
     *            considera cadeia no formato de CNPJ: "dd.ddd.ddd/dddd-dd" onde
     *            "d" é um dígito decimal.
     */
    public CNPJValidator(MessageProducer messageProducer, boolean isFormatted) {
        this.baseValidator = new BaseValidator(messageProducer);
        this.isFormatted = isFormatted;
    }

    private List<InvalidValue> getInvalidValues(String cnpj) {
        List<InvalidValue> errors = new ArrayList<InvalidValue>();
        errors.clear();
        if (cnpj != null) {
            if (!isEligible(cnpj)) {
                if (isFormatted) {
                    errors.add(CNPJError.INVALID_FORMAT);
                } else {
                    errors.add(CNPJError.INVALID_DIGITS);
                }
            } else {
                String unformatedCNPJ;
                if (isFormatted) {
                    CNPJFormatter formatter = new CNPJFormatter();
                    unformatedCNPJ = formatter.unformat(cnpj);
                } else {
                    unformatedCNPJ = cnpj;
                }
                if (!hasValidCheckDigits(unformatedCNPJ)) {
                    errors.add(CNPJError.INVALID_CHECK_DIGITS);
                }
            }
        }
        return errors;
    }

    private boolean hasValidCheckDigits(String value) {
        return (DV1_CHECKER.isDVValid(value)) && (DV2_CHECKER.isDVValid(value));
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

    public void assertValid(String cnpj) {
        baseValidator.assertValid(getInvalidValues(cnpj));
    }

    public List<ValidationMessage> invalidMessagesFor(String cnpj) {
        return baseValidator.generateValidationMessages(getInvalidValues(cnpj));
    }

}
