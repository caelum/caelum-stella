package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.Validator;

/**
 * Verifica se uma cadeia (String) é válida para o documento de CPF (Cadastro de
 * Pessoa Física).
 * 
 * @author Leonardo Bessa
 */
public class CPFValidator implements Validator<String> {
	private static final int CPF_DIGITS_SIZE = 11;
	private static final Pattern CPF_FORMATED = Pattern
			.compile("\\d{3}[.]\\d{3}[.]\\d{3}-\\d{2}");
	private static final Pattern CPF_UNFORMATED = Pattern.compile("\\d{"
			+ CPF_DIGITS_SIZE + "}");
	private static final int MOD = 11;
	private final boolean isFormatted;
	private final boolean isIgnoringRepeatedDigits;
	private final MessageProducer<CPFError> messageProducer;
	private final List<CPFError> errors = new ArrayList<CPFError>();

	@SuppressWarnings("serial")
	private static final DigitChecker digitChecker = new DigitChecker(
			new HashMap<Integer, List<Integer>>() {
				{
					Integer dv1Position = 10;
					Integer[] dv1Multipliers = { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
					Integer dv2Position = 11;
					Integer[] dv2Multipliers = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
					this.put(dv1Position, Arrays.asList(dv1Multipliers));
					this.put(dv2Position, Arrays.asList(dv2Multipliers));
				}
			}, MOD) {
		@Override
		protected int rotinaPosProdutoInterno(int resto) {
			return (resto < 2) ? 0 : 11 - resto;
		}
	};

	/**
	 * <p>
	 * Construtor do Validador de CPF.
	 * </p>
	 * <p>
	 * Por padrão o validador criado aceita cadeias de CPF com todos os dígitos
	 * repetidos, quando todas as outras condições de validação são aceitas.
	 * Para considerar estes documentos inválidos use o construtor
	 * {@link #CPFValidator(MessageProducer, boolean, boolean)} com a
	 * váriavel {@linkplain #isIgnoringRepeatedDigits} em <code>false</code>.
	 * </p>
	 * 
	 * @param messageProducer
	 *            produtor de mensagem de erro.
	 * @param isFormatted
	 *            considera cadeia no formato de CPF: "ddd.ddd.ddd-dd" onde "d"
	 *            é um dígito decimal.
	 */
	public CPFValidator(MessageProducer<CPFError> messageProducer,
			boolean isFormatted) {
		this.messageProducer = messageProducer;
		this.isFormatted = isFormatted;
		this.isIgnoringRepeatedDigits = true;
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
	public CPFValidator(MessageProducer<CPFError> messageProducer,
			boolean isFormatted, boolean isIgnoringRepeatedDigits) {
		this.messageProducer = messageProducer;
		this.isFormatted = isFormatted;
		this.isIgnoringRepeatedDigits = isIgnoringRepeatedDigits;
	}

	/**
	 * Valida se a cadeia está de acordo com as regras de um CPF.
	 * 
	 * @see br.com.caelum.stella.Validator#validate(java.lang.Object)
	 * @return <code>true</code> se a cadeia é válida ou é nula;
	 *         <code>false</code> caso contrario.
	 */
	public boolean validate(String cpf) {
		errors.clear();
		if (cpf == null) {
			return true;
		}

		if (isFormatted) {
			if (!CPF_FORMATED.matcher(cpf).matches()) {
				errors.add(CPFError.INVALID_FORMAT);
			}
			cpf = cpf.replaceAll("[^0-9]", "");
		} else if (!(CPF_UNFORMATED.matcher(cpf).matches())) {
			errors.add(CPFError.INVALID_DIGITS);
		}
		if (errors.isEmpty() && (!isIgnoringRepeatedDigits)
				&& hasAllRepeatedDigits(cpf)) {
			errors.add(CPFError.REPEATED_DIGITS);
		}
		if (errors.isEmpty() && !digitChecker.hasValidCheckDigits(cpf)) {
			errors.add(CPFError.INVALID_CHECK_DIGITS);
		}

		return errors.isEmpty();
	}

	private boolean hasAllRepeatedDigits(String cpf) {
		for (int i = 1; i < cpf.length(); i++) {
			if (cpf.charAt(i) != cpf.charAt(0)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @see br.com.caelum.stella.Validator#getLastValidationMessages()
	 */
	public List<ValidationMessage> getLastValidationMessages() {
		List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
		for (CPFError error : errors) {
			ValidationMessage message = messageProducer.getMessage(error);
			messages.add(message);
		}
		return messages;
	}

	/**
	 * @return lista de enum de erros gerados pela última chamada de {@link #validate(String)}
	 */
	public List<CPFError> getErrors() {
		return errors;
	}
}
