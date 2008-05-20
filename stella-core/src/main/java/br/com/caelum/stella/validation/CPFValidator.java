package br.com.caelum.stella.validation;

import static br.com.caelum.stella.validation.CPFConstraints.CPF_FORMATED;
import static br.com.caelum.stella.validation.CPFConstraints.CPF_UNFORMATED;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.validation.error.CPFError;

/**
 * Verifica se uma cadeia (String) é válida para o documento de CPF (Cadastro de
 * Pessoa Física).
 * 
 * @author Leonardo Bessa
 */
public class CPFValidator extends AbstractValidator<String> {
    private static final int MOD = 11;

    private final boolean isFormatted;

    private final boolean isIgnoringRepeatedDigits;

    private static class RotinaPosProdutoInterno implements
            RotinaDeDigitoVerificador {
        public Integer transform(RotinaParameters parameter) {
            Integer mod = parameter.getDigitoVerificadorInfo().getMod();
            Integer result = parameter.getResult() % mod;
            if (result < 2) {
                result = 0;
            } else {
                result = 11 - result;
            }
            return result;
        }
    }

    private static final Integer DV1_POSITION = 10;

    private static final Integer[] DV1_MULTIPLIERS = { 10, 9, 8, 7, 6, 5, 4, 3,
            2 };

    private static final Integer DV2_POSITION = 11;

    private static final Integer[] DV2_MULTIPLIERS = { 11, 10, 9, 8, 7, 6, 5,
            4, 3, 2 };

    private static final DigitoVerificadorInfo DV1_INFO = new DigitoVerificadorInfo(
            0,
            new RotinaDeDigitoVerificador[] { new RotinaPosProdutoInterno() },
            MOD, DV1_MULTIPLIERS, DV1_POSITION);

    private static final DigitoVerificadorInfo DV2_INFO = new DigitoVerificadorInfo(
            0,
            new RotinaDeDigitoVerificador[] { new RotinaPosProdutoInterno() },
            MOD, DV2_MULTIPLIERS, DV2_POSITION);

    private static final ValidadorDeDV DV1_CHECKER = new ValidadorDeDV(DV1_INFO);

    private static final ValidadorDeDV DV2_CHECKER = new ValidadorDeDV(DV2_INFO);

    public CPFValidator() {
        this(true);
    }

    public CPFValidator(boolean isFormatted) {
        super();
        this.isFormatted = isFormatted;
        this.isIgnoringRepeatedDigits = true;
    }

    /**
     * <p>
     * Construtor do Validador de CPF.
     * </p>
     * <p>
     * Por padrão o validador criado aceita cadeias de CPF com todos os dígitos
     * repetidos, quando todas as outras condições de validação são aceitas.
     * Para considerar estes documentos inválidos use o construtor
     * {@link #CPFValidator(MessageProducer, boolean, boolean)} com a váriavel
     * {@linkplain #isIgnoringRepeatedDigits} em <code>false</code>.
     * </p>
     * 
     * @param messageProducer
     *                produtor de mensagem de erro.
     * @param isFormatted
     *                considera cadeia no formato de CPF: "ddd.ddd.ddd-dd" onde
     *                "d" é um dígito decimal.
     */
    public CPFValidator(MessageProducer messageProducer, boolean isFormatted) {
        super(messageProducer);
        this.isFormatted = isFormatted;
        this.isIgnoringRepeatedDigits = true;
    }

    /**
     * @param messageProducer
     *                produtor de mensagem de erro.
     * @param isFormatted
     *                condição para considerar cadeia no formato de CPF:
     *                "ddd.ddd.ddd-dd" onde "d" é um dígito decimal.
     * @param isIgnoringRepeatedDigits
     *                condição para ignorar cadeias de CPF com todos os dígitos
     *                repetidos.
     */
    public CPFValidator(MessageProducer messageProducer, boolean isFormatted,
            boolean isIgnoringRepeatedDigits) {
        super(messageProducer);
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
    protected List<InvalidValue> getInvalidValues(String cpf) {
        List<InvalidValue> errors = new ArrayList<InvalidValue>();
        if (cpf != null) {
            String unformatedCPF = checkForCorrectFormat(cpf, errors);

            if (errors.isEmpty()) {
                if ((!isIgnoringRepeatedDigits)
                        && hasAllRepeatedDigits(unformatedCPF)) {
                    errors.add(CPFError.REPEATED_DIGITS);
                }
            }
            if (errors.isEmpty()) {
                if (!hasValidCheckDigits(unformatedCPF)) {
                    errors.add(CPFError.INVALID_CHECK_DIGITS);
                }
            }
        }
        return errors;
    }

    private String checkForCorrectFormat(String string,
            List<InvalidValue> errors) {
        String unformatedCPF = null;
        if (isFormatted) {
            if (!CPF_FORMATED.matcher(string).matches()) {
                errors.add(CPFError.INVALID_FORMAT);
            }
            unformatedCPF = (new CPFFormatter()).unformat(string);
        } else {
            if (!(CPF_UNFORMATED.matcher(string).matches())) {
                errors.add(CPFError.INVALID_DIGITS);
            }
            unformatedCPF = string;
        }
        return unformatedCPF;
    }

    private boolean hasValidCheckDigits(String value) {
        return (DV1_CHECKER.DVisValid(value)) && (DV2_CHECKER.DVisValid(value));
    }

    private boolean hasAllRepeatedDigits(String cpf) {
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                return false;
            }
        }
        return true;
    }

}
