package br.com.caelum.stella.validation;

import java.util.List;

import br.com.caelum.stella.ValidationMessage;

@SuppressWarnings("serial")
public class InvalidStateException extends RuntimeException {

	private final List<ValidationMessage> validationMessages;

	public InvalidStateException(List<ValidationMessage> validationMessages) {
		this.validationMessages = validationMessages;
	}

	public List<ValidationMessage> getInvalidMessages() {
		return validationMessages;
	}
	
	

}
