package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.validation.error.CPFError;

/**
 * Verifica se uma cadeia (String) é válida para o documento de CPF (Cadastro de
 * Pessoa Física).
 * 
 * @author Leonardo Bessa
 */
public class CPFValidator implements Validator<String> {
    private final BaseValidator baseValidator;

    private static final int MOD = 11;

    private final boolean isFormatted;

    private final boolean isIgnoringRepeatedDigits;

    public static final Pattern FORMATED = Pattern.compile("(\\d{3})[.](\\d{3})[.](\\d{3})-(\\d{2})");

    public static final Pattern UNFORMATED = Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})");

    private static final Integer DV1_POSITION = 10;

    private static final Integer[] DV1_MULTIPLIERS = { 10, 9, 8, 7, 6, 5, 4, 3, 2 };

    private static final Integer DV2_POSITION = 11;

    private static final Integer[] DV2_MULTIPLIERS = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

    private static final DigitoVerificadorInfo DV1_INFO = new DigitoVerificadorInfo(0,
            new RotinaDeDigitoVerificador[] { new RotinaComumDeDigitoVerificador() }, MOD, DV1_MULTIPLIERS,
            DV1_POSITION);

    private static final DigitoVerificadorInfo DV2_INFO = new DigitoVerificadorInfo(0,
            new RotinaDeDigitoVerificador[] { new RotinaComumDeDigitoVerificador() }, MOD, DV2_MULTIPLIERS,
            DV2_POSITION);

    private static final ValidadorDeDV DV1_CHECKER = new ValidadorDeDV(DV1_INFO);

    private static final ValidadorDeDV DV2_CHECKER = new ValidadorDeDV(DV2_INFO);

    /**
     * Construtor padrão de validador de CPF. Este considera, por padrão, que as
     * cadeias estão formatadas e utiliza um {@linkplain SimpleMessageProducer}
     * para geração de mensagens.
     */
    public CPFValidator() {
        this(true);
    }

    /**
     * Construtor de validador de CPF. O validador utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public CPFValidator(boolean isFormatted) {
        this.baseValidator = new BaseValidator();
        this.isFormatted = isFormatted;
        this.isIgnoringRepeatedDigits = false;
    }
    
    /**
     * Construtor de validador de CPF. O validador utiliza um
     * @param isFormatted indica se o CPF está formatado.
     *  @param isIgnoringRepeatedDigits
     *            condição para ignorar cadeias de CPF com todos os dígitos
     *            repetidos.
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public CPFValidator(boolean isFormatted, boolean isIgnoringRepeatedDigits) {
        this.baseValidator = new BaseValidator();
        this.isFormatted = isFormatted;
        this.isIgnoringRepeatedDigits = isIgnoringRepeatedDigits;
    }

    /**
     * <p>
     * Construtor do Validador de CPF.
     * </p>
     * <p>
     * Por padrão o validador criado não aceita cadeias de CPF com todos os dígitos
     * repetidos, quando todas as outras condições de validação são aceitas.
     * Para considerar estes documentos válidos use o construtor
     * {@link #CPFValidator(MessageProducer, boolean, boolean)} com a váriavel
     * {@linkplain #isIgnoringRepeatedDigits} em <code>true</code>.
     * </p>
     * 
     * @param messageProducer
     *            produtor de mensagem de erro.
     * @param isFormatted
     *            considera cadeia no formato de CPF: "ddd.ddd.ddd-dd" onde "d"
     *            é um dígito decimal.
     */
    public CPFValidator(MessageProducer messageProducer, boolean isFormatted) {
        this(messageProducer, isFormatted, false);
    }

    /**
     * @param messageProducer
     *            produtor de mensagem de erro.
     * @param isFormatted
     *            condição para considerar cadeia no formato de CPF:
     *            "ddd.ddd.ddd-dd" onde "d" é um dígito decimal.
     * @param isIgnoringRepeatedDigits
     *            condição para ignorar cadeias de CPF com todos os dígitos
     *            repetidos.
     */
    public CPFValidator(MessageProducer messageProducer, boolean isFormatted, boolean isIgnoringRepeatedDigits) {
        this.baseValidator = new BaseValidator(messageProducer);
        this.isFormatted = isFormatted;
        this.isIgnoringRepeatedDigits = isIgnoringRepeatedDigits;
    }

    /**
     * Valida se a cadeia está de acordo com as regras de um CPF.
     * 
     * @see br.com.caelum.stella.validation.Validator#assertValid(java.lang.Object)
     * @return <code>true</code> se a cadeia é válida ou é nula;
     *         <code>false</code> caso contrario.
     */
    private List<InvalidValue> getInvalidValues(String cpf) {
        List<InvalidValue> errors = new ArrayList<InvalidValue>();
        if (cpf != null) {

            if (!isEligible(cpf)) {
                if (isFormatted) {
                    errors.add(CPFError.INVALID_FORMAT);
                } else {
                    errors.add(CPFError.INVALID_DIGITS);
                }
            } else {
                String unformatedCPF;
                if (isFormatted) {
                    CPFFormatter formatter = new CPFFormatter();
                    unformatedCPF = formatter.unformat(cpf);
                } else {
                    unformatedCPF = cpf;
                }
                if (errors.isEmpty()) {
                    if ((!isIgnoringRepeatedDigits) && hasAllRepeatedDigits(unformatedCPF)) {
                        errors.add(CPFError.REPEATED_DIGITS);
                    }
                }
                if (errors.isEmpty()) {
                    if (!hasValidCheckDigits(unformatedCPF)) {
                        errors.add(CPFError.INVALID_CHECK_DIGITS);
                    }
                }
            }
        }
        return errors;
    }

    private boolean hasValidCheckDigits(String value) {
        return (DV1_CHECKER.isDVValid(value)) && (DV2_CHECKER.isDVValid(value));
    }

    private boolean hasAllRepeatedDigits(String cpf) {
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                return false;
            }
        }
        return true;
    }

    @Override
	public boolean isEligible(String value) {
        boolean result;
        if (isFormatted) {
            result = FORMATED.matcher(value).matches();
        } else {
            result = UNFORMATED.matcher(value).matches();
        }
        return result;
    }

    @Override
	public void assertValid(String cpf) {
        baseValidator.assertValid(getInvalidValues(cpf));
    }

    @Override
	public List<ValidationMessage> invalidMessagesFor(String cpf) {
        return baseValidator.generateValidationMessages(getInvalidValues(cpf));
    }

}
