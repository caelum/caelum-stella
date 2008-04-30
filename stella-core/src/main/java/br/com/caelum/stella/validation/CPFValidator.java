package br.com.caelum.stella.validation;

import static br.com.caelum.stella.constraint.CPFConstraints.CPF_FORMATED;
import static br.com.caelum.stella.constraint.CPFConstraints.CPF_UNFORMATED;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.formatter.CPFFormatter;

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
	 * {@link #CPFValidator(MessageProducer, boolean, boolean)} com a váriavel
	 * {@linkplain #isIgnoringRepeatedDigits} em <code>false</code>.
	 * </p>
	 * 
	 * @param messageProducer
	 *            produtor de mensagem de erro.
	 * @param isFormatted
	 *            considera cadeia no formato de CPF: "ddd.ddd.ddd-dd" onde "d"
	 *            é um dígito decimal.
	 */
	public CPFValidator(MessageProducer messageProducer, boolean isFormatted) {
		super(messageProducer);
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
	public CPFValidator(MessageProducer messageProducer, boolean isFormatted,
			boolean isIgnoringRepeatedDigits) {
		super(messageProducer);
		this.isFormatted = isFormatted;
		this.isIgnoringRepeatedDigits = isIgnoringRepeatedDigits;
	}

	/**
	 * Valida se a cadeia está de acordo com as regras de um CPF.
	 * 
	 * @see br.com.caelum.stella.Validator#assertValid(java.lang.Object)
	 * @return <code>true</code> se a cadeia é válida ou é nula;
	 *         <code>false</code> caso contrario.
	 */
	protected List<InvalidValue> getInvalidValues(String cpf) {
		List<InvalidValue> errors = new ArrayList<InvalidValue>();
		errors.clear();
		if (cpf != null) {
			if (isFormatted) {
				if (!CPF_FORMATED.matcher(cpf).matches()) {
					errors.add(CPFError.INVALID_FORMAT);
				}
				cpf = (new CPFFormatter()).unformat(cpf);
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
		}
		return errors;
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
