package br.com.caelum.stella.validation;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.MessageProducer;

@SuppressWarnings("unchecked")
public class LogicOrComposedValidatorTest {
	private MessageProducer messageProducer;

	@Before
	public void setUp() {
		messageProducer = mock(MessageProducer.class);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionIfNoValidatorsArePassedOnConstruction()
	        throws Exception {
		new LogicOrComposedValidator<String>(messageProducer, true);
	}

	@Test
	public void shouldGenerateValidDocumentAccordingToTheFirstValidatorPassedAsArgument()
	        throws Exception {
		LogicOrComposedValidator<String> validatorCpfPrimeiro = new LogicOrComposedValidator<String>(
		        messageProducer, true, CPFValidator.class, CNPJValidator.class);
		new CPFValidator(true).assertValid(validatorCpfPrimeiro.generateRandomValid());

		LogicOrComposedValidator<String> validatorCnpjPrimeiro = new LogicOrComposedValidator<String>(
		        messageProducer, true, CNPJValidator.class, CPFValidator.class);
		new CNPJValidator(true).assertValid(validatorCnpjPrimeiro.generateRandomValid());
	}

    @Test
	public void shouldGenerateValidDocumentFormattedAccordingToParameterSpecifiedInConstructor()
	        throws Exception {
		LogicOrComposedValidator<String> validatorFormatado = new LogicOrComposedValidator<String>(
		        messageProducer, true, CPFValidator.class, CNPJValidator.class);
		new CPFValidator(true).assertValid(validatorFormatado.generateRandomValid());

		LogicOrComposedValidator<String> validatorNaoFormatado = new LogicOrComposedValidator<String>(
		        messageProducer, false, CPFValidator.class, CNPJValidator.class);
		new CPFValidator(false).assertValid(validatorNaoFormatado.generateRandomValid());
	}
}
