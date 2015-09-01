package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.stella.DigitoGenerator;
import br.com.caelum.stella.DigitoPara;
import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.format.RenavamFormatter;
import br.com.caelum.stella.validation.error.RenavamError;

/**
 * <p>
 * Verifica se uma cadeia (String) representa um Renavam válido.
 * </p>
 * 
 * <p>
 * O Renavam, ou Registro nacional de veículos automotores, é o número único de
 * cada veículo e é composto de 10 (dez) dígitos, mais um digito verificador.
 * </p>
 * 
 * Formato do Renavam: "dddd.dddddd-d" onde "d" é um digito decimal.
 * 
 * @author Rafael Carvalho
 */
public class RenavamValidator implements Validator<String> {

	public static final Pattern FORMATED = Pattern.compile("(\\d{4})[.](\\d{6})-(\\d{1})");
	public static final Pattern UNFORMATED = Pattern.compile("(\\d{4})(\\d{6})(\\d{1})");

    private boolean isFormatted = false;
    private MessageProducer messageProducer;

    /**
     * Construtor padrão de validador do Renavam. Este considera, por padrão,
     * que as cadeias estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public RenavamValidator() {
    	this.messageProducer = new SimpleMessageProducer();
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
        this.messageProducer = new SimpleMessageProducer();
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
        this.messageProducer = messageProducer;
    }

    public void assertValid(String renavam) {
        List<ValidationMessage> errors = getInvalidValues(renavam);
        if (!errors.isEmpty()) {
			throw new InvalidStateException(errors);
		}
    }

    public List<ValidationMessage> invalidMessagesFor(String renavam) {
        return getInvalidValues(renavam);
    }

    /**
     * Valida se a cadeia está de acordo com as regras de validação do Renavam.
     * 
     * @see br.com.caelum.stella.validation.Validator#assertValid(java.lang.Object)
     * 
     * @param renavam
     *            Cadeia de caracteres representando o Renavam a ser validado
     * @return Uma lista de {@linkplain ValidationMessage} com os erros encontrados
     *         ou uma lista vazia, caso não haja nenhum erro.
     */
    private List<ValidationMessage> getInvalidValues(String renavam) {
        List<ValidationMessage> errors = new ArrayList<ValidationMessage>();
		if (renavam != null) {

			renavam = formataPadraoNovo(renavam);
			
			if (isFormatted && !FORMATED.matcher(renavam).matches()) {
				errors.add(messageProducer.getMessage(RenavamError.INVALID_FORMAT));
			}

			String unformatedRenavam = null;
			try {
				unformatedRenavam = new RenavamFormatter().unformat(renavam);
			} catch (IllegalArgumentException e) {
				errors.add(messageProducer.getMessage(RenavamError.INVALID_DIGITS));
				return errors;
			}
			
			if (unformatedRenavam.length() != 11 || !unformatedRenavam.matches("[0-9]*")) {
				errors.add(messageProducer.getMessage(RenavamError.INVALID_DIGITS));
			}

			String renavamSemDigito = unformatedRenavam.substring(0, unformatedRenavam.length() - 1);
			String digito = unformatedRenavam.substring(unformatedRenavam.length() - 1);

			String digitoCalculado = calculaDigito(renavamSemDigito);

			if (!digito.equals(digitoCalculado)) {
				errors.add(messageProducer.getMessage(RenavamError.INVALID_CHECK_DIGIT));
			}
		}
		return errors;
    }

	private String formataPadraoNovo(String renavam) {
		if ((isFormatted && renavam.length() == 11) || (!isFormatted && renavam.length() == 9)) {
			return "00" + renavam;
		}
		return renavam;
	}

	private String calculaDigito(String renavamSemDigito) {
    	return new DigitoPara(renavamSemDigito).complementarAoModulo().trocandoPorSeEncontrar("0",10,11).mod(11).calcula();
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

    @Override
	public String generateRandomValid() {
		final String renavamSemDigito = new DigitoGenerator().generate(10);
		final String renavamComDigito = renavamSemDigito + calculaDigito(renavamSemDigito);
		if (isFormatted) {
			return new RenavamFormatter().format(renavamComDigito);
		}
		return renavamComDigito;
	}
}
