package br.com.caelum.stella.validation;

import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ValidationMessage;

public class InscricaoEstatudalDeSaoPauloValidator implements Validator<String> {
	
	private final InscricaoEstatudalDeSaoPauloParaComercioIndustriaValidator comercioIndustriaValidator;
	private final InscricaoEstatudalDeSaoPauloParaProdutorRuralValidator produtorRuralValidator;
	private final AbstractValidator<String> abstractValidator;
	
	public InscricaoEstatudalDeSaoPauloValidator(MessageProducer messageProducer,
			boolean isFormatted) {
		comercioIndustriaValidator = new InscricaoEstatudalDeSaoPauloParaComercioIndustriaValidator(null,isFormatted);
		produtorRuralValidator = new InscricaoEstatudalDeSaoPauloParaProdutorRuralValidator(null,isFormatted);
		this.abstractValidator = new AbstractValidator<String>(messageProducer){

			@Override
			protected List<InvalidValue> getInvalidValues(String value) {
				List<InvalidValue> result = null;
				if (value.startsWith("P")){
					result = produtorRuralValidator.getInvalidValues(value);
				} else {
					result = comercioIndustriaValidator.getInvalidValues(value);
				}
				return result;
			}
			
		};
	}

	public void assertValid(String value) {
		abstractValidator.assertValid(value);
	}

	public List<ValidationMessage> invalidMessagesFor(String value) {
		return abstractValidator.invalidMessagesFor(value);
	}
	


}
