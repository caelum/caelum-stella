package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.stella.DigitoGenerator;
import br.com.caelum.stella.DigitoPara;
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

	public static final Pattern FORMATED = Pattern.compile("(\\d{3})[.](\\d{3})[.](\\d{3})-(\\d{2})");
	public static final Pattern UNFORMATED = Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})");

	private final boolean isFormatted;
	private final boolean isIgnoringRepeatedDigits;
	private final MessageProducer messageProducer;

	/**
	 * Construtor padrão de validador de CPF. Este considera, por padrão, que as
	 * cadeias não estão formatadas e utiliza um {@linkplain SimpleMessageProducer}
	 * para geração de mensagens.
	 */
	public CPFValidator() {
		this(new SimpleMessageProducer(), false, false);
	}

	/**
	 * Construtor de validador de CPF. O validador utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens. Leva em
	 * conta se o valor está ou não formatado.
	 * 
	 * @param isFormatted
	 *            considera cadeia no formato de CPF:"ddd.ddd.ddd-dd" onde "d" é
	 *            um dígito decimal.
	 */
	public CPFValidator(boolean isFormatted) {
		this(new SimpleMessageProducer(), isFormatted, false);
	}

	/**
	 * Construtor de validador de CPF. O validador utiliza um
	 * 
	 * @param isFormatted
	 *            indica se o CPF está formatado.
	 * @param isIgnoringRepeatedDigits
	 *            condição para ignorar cadeias de CPF com todos os dígitos
	 *            repetidos. {@linkplain SimpleMessageProducer} para geração de
	 *            mensagens.
	 */
	public CPFValidator(boolean isFormatted, boolean isIgnoringRepeatedDigits) {
		this(new SimpleMessageProducer(), isFormatted, isIgnoringRepeatedDigits);
	}

	/**
	 * <p>
	 * Construtor do Validador de CPF. Leva em consideração se o valor está
	 * formatado.
	 * </p>
	 * <p>
	 * Por padrão o validador criado não aceita cadeias de CPF com todos os
	 * dígitos repetidos, quando todas as outras condições de validação são
	 * aceitas. Para considerar estes documentos válidos use o construtor
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
		this.messageProducer = messageProducer;
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
	private List<ValidationMessage> getInvalidValues(String cpf) {

		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();

		if (cpf != null) {
			if (isFormatted != FORMATED.matcher(cpf).matches()) {
				errors.add(messageProducer.getMessage(CPFError.INVALID_FORMAT));
			}

			String unformatedCPF = null;
			try {
				unformatedCPF = new CPFFormatter().unformat(cpf);
			} catch (IllegalArgumentException e) {
				errors.add(messageProducer.getMessage(CPFError.INVALID_DIGITS));
				return errors;
			}

			if (unformatedCPF.length() != 11 || !unformatedCPF.matches("[0-9]*")) {
				errors.add(messageProducer.getMessage(CPFError.INVALID_DIGITS));
			}

			if ((!isIgnoringRepeatedDigits) && hasAllRepeatedDigits(unformatedCPF)) {
				errors.add(messageProducer.getMessage(CPFError.REPEATED_DIGITS));
			}

			String cpfSemDigito = unformatedCPF.substring(0, unformatedCPF.length() - 2);
			String digitos = unformatedCPF.substring(unformatedCPF.length() - 2);

			String digitosCalculados = calculaDigitos(cpfSemDigito);

			if (!digitos.equals(digitosCalculados)) {
				errors.add(messageProducer.getMessage(CPFError.INVALID_CHECK_DIGITS));
			}
		}
		return errors;
	}

	/**
	 * Faz o cálculo dos digitos usando a lógica de CPF
	 * 
	 * @return String os dois dígitos calculados.
	 */
	private String calculaDigitos(String cpfSemDigito) {
		DigitoPara digitoPara = new DigitoPara(cpfSemDigito);
    	digitoPara.comMultiplicadoresDeAte(2, 11).complementarAoModulo().trocandoPorSeEncontrar("0",10,11).mod(11);

		String digito1 = digitoPara.calcula();
		digitoPara.addDigito(digito1);
		String digito2 = digitoPara.calcula();
		
		return digito1 + digito2;
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
		if (value == null) {
			return false;
		}
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
		List<ValidationMessage> errors = getInvalidValues(cpf);
		if (!errors.isEmpty()) {
			throw new InvalidStateException(errors);
		}
	}

	@Override
	public List<ValidationMessage> invalidMessagesFor(String cpf) {
		return getInvalidValues(cpf);
	}

	@Override
	public String generateRandomValid() {
		final String cpfSemDigitos = new DigitoGenerator().generate(9);
		final String cpfComDigitos = cpfSemDigitos + calculaDigitos(cpfSemDigitos);
		if (isFormatted) {
			return new CPFFormatter().format(cpfComDigitos);
		}
		return cpfComDigitos;
	}
}
