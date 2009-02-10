package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.format.RenavamFormatter;
import br.com.caelum.stella.validation.error.RenavamError;

/**
 * <p>
 * Verifica se uma cadeia (String) representa um Renavam válido.
 * </p>
 * 
 * <p>
 * O Renavam, ou Registro nacional de veículos automotores, é o número único de
 * cada veículo e é composto de 8 (oito) dígitos, mais um digito verificador.
 * </p>
 * 
 * Formato do Renavam: "dd.dddddd-d" onde "d" é um digito decimal.
 * 
 * @author Rafael Carvalho
 */
public class RenavamValidator implements Validator<String> {

    private final BaseValidator baseValidator;
    private static final Integer fator = 0;
    private static final Integer mod = 11;
    private static final Integer[] pesos = { 9, 8, 7, 6, 5, 4, 3, 2 };
    private static final Integer posicaoDoDigitoVerificador = 9;
    private static final RotinaDeDigitoVerificador[] rotinas = { new RotinaComumDeDigitoVerificador() };
    private static final DigitoVerificadorInfo digitoVerificadorInfo = new DigitoVerificadorInfo(fator, rotinas, mod,
            pesos,
            posicaoDoDigitoVerificador);
    private static final ValidadorDeDV validatorDeDigitoVerificador = new ValidadorDeDV(digitoVerificadorInfo);
    private final boolean isFormatted;

    /**
     * Construtor padrão de validador do Renavam. Este considera, por padrão,
     * que as cadeias estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public RenavamValidator() {
        this(true);
    }

    /**
     * Construtor de validador de Renavam. O validador utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     * 
     * @param isFormatted
     *            Informa se a cadeia de caracteres a ser validada está ou não
     *            formatada
     */
    public RenavamValidator(boolean isFormatted) {
        this.isFormatted = isFormatted;
        this.baseValidator = new BaseValidator();
    }

    /**
     * <p>
     * Construtor do validador de Renavam
     * </p>
     * 
     * @param messageProducer
     *            produtor de mensagem de erro.
     * @param isFormatted
     *            Informa se a cadeia de caracteres a ser validada está ou não
     *            formatada
     */
    public RenavamValidator(MessageProducer messageProducer, boolean isFormatted) {
        this.isFormatted = isFormatted;
        this.baseValidator = new BaseValidator(messageProducer);
    }

    public void assertValid(String renavam) {
        baseValidator.assertValid(getInvalidValues(renavam));
    }

    private boolean isCheckDigitValid(String renavam) {
        return validatorDeDigitoVerificador.isDVValid(unformat(renavam));
    }

    public List<ValidationMessage> invalidMessagesFor(String renavam) {
        return baseValidator.generateValidationMessages(getInvalidValues(renavam));
    }

    /**
     * Valida se a cadeia está de acordo com as regras de validação do Renavam.
     * 
     * @see br.com.caelum.stella.validation.Validator#assertValid(java.lang.Object)
     * 
     * @param renavam
     *            Cadeia de caracteres representando o Renavam a ser validado
     * @return Uma lista de {@linkplain InvalidValue} com os erros encontrados
     *         ou uma lista vazia, caso não haja nenhum erro.
     */
    private List<InvalidValue> getInvalidValues(String renavam) {
        List<InvalidValue> errors = new ArrayList<InvalidValue>();
        if (!isEligible(renavam)) {
            errors.add(RenavamError.INVALID_DIGITS);
        } else if (!isCheckDigitValid(renavam)) {
            errors.add(RenavamError.INVALID_CHECK_DIGIT);
        }
        return errors;
    }

    public boolean isEligible(String renavam) {
        boolean isEligible;
        if (isFormatted) {
            isEligible = RenavamFormatter.FORMATTED.matcher(renavam).matches();
        } else {
            isEligible = RenavamFormatter.UNFORMATTED.matcher(renavam).matches();
        }
        return isEligible;
    }

    /**
     * Remove a formatação da cadeia
     * 
     * @param renavam
     *            Cadeia de caracteres representando o Renavam
     * @return O renvam informado, sem formatação.
     */
    private String unformat(String renavam) {
        String result = renavam;
        if (isFormatted) {
            result = new RenavamFormatter().unformat(renavam);
        }
        return result;
    }
}
