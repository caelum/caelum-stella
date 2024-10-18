package br.com.caelum.stella.validation;

import br.com.caelum.stella.DigitoGenerator;
import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.error.AgenciaBancariaError;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Representa um validador de agencia bancária.
 * 
 * @author Thiago Nascimento
 */
public class AgenciaBancariaValidator implements Validator<String> {

	public static final Pattern COM_DV = Pattern.compile("(\\d+)\\-([\\dX])");
    public static final Pattern SEM_DV = Pattern.compile("\\d+");
	
    private boolean isComDigito = true;
    private MessageProducer messageProducer;
    
    public AgenciaBancariaValidator() {
    	this.messageProducer = new SimpleMessageProducer();
	}
    
	public AgenciaBancariaValidator(boolean isComDigito) {
		this();
		this.isComDigito = isComDigito;
	}

	@Override
	public void assertValid(String agencia) {
		
		List<ValidationMessage> errors = this.invalidMessagesFor(agencia);
		
		if (!errors.isEmpty()) {
			throw new InvalidStateException(errors);
	    }
	}

	@Override
	public List<ValidationMessage> invalidMessagesFor(String agencia) {
		
		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();
		
		if (this.isEligible(agencia)) {
			
			if (this.isComDigito) {
				
				Matcher matcher = COM_DV.matcher(agencia);
				
				if (!matcher.find()) {
					throw new InvalidStateException(this.messageProducer.getMessage(AgenciaBancariaError.INVALID_FORMAT));
				}
				
				String dvInformado = matcher.group(2);
				String dvComputado = this.computarDigitoVerificador(matcher.group(1));
				
				if (!dvInformado.equals(dvComputado)) {
					errors.add(this.messageProducer.getMessage(AgenciaBancariaError.INVALID_CHECK_DIGIT));	
				}
				
			} else {
				errors.add(this.messageProducer.getMessage(AgenciaBancariaError.CHECK_DIGIT_NOT_FOUND));
			}
			
		} else {
			errors.add(this.messageProducer.getMessage(AgenciaBancariaError.INVALID_FORMAT));
		}
		
		return errors;
	}

	@Override
	public boolean isEligible(String value) {
		
		if (value == null || value.trim().isEmpty()) {
			return false;
		}
		
		return this.isComDigito ? 
				COM_DV.matcher(value).matches() : SEM_DV.matcher(value).matches();
	}

	@Override
	public String generateRandomValid() {
		final String agenciaSemDigitos = new DigitoGenerator().generate(4);
		return String.format("%s-%s", agenciaSemDigitos, this.computarDigitoVerificador(agenciaSemDigitos));
	}
	
	public String computarDigitoVerificador(String agenciaSemDV) {
		
		String[] algarisms = agenciaSemDV.split(""); 
		int multiplier = 9;
		int sum = 0;
		
		for (int index = algarisms.length - 1; index >= 0; --index) {
			sum += Integer.valueOf(algarisms[index]) * multiplier--;
		}
		
		int rest = sum % 11;
		return rest == 10 ? "X" : String.valueOf(rest); 
	}

}
