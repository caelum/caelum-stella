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
import br.com.caelum.stella.validation.error.CNPJError;

/**
 * Representa um validador de CNPJ.
 * 
 * @author Leonardo Bessa
 */
public class CNPJValidator implements Validator<String> {

    public static final Pattern FORMATED = Pattern.compile("(\\d{2})[.](\\d{3})[.](\\d{3})/(\\d{4})-(\\d{2})");
    public static final Pattern UNFORMATED = Pattern.compile("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})");
	
    private boolean isFormatted = false;
    private boolean isIgnoringRepeatedDigits;
	private MessageProducer messageProducer;

    /**
     * Este considera, por padrão, que as cadeias não estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public CNPJValidator() {
    	messageProducer = new SimpleMessageProducer();
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens. Leva em conta se o valor está ou não formatado.
     * 
     * @param isFormatted
     *            considera cadeia no formato de CNPJ: "dd.ddd.ddd/dddd-dd" onde
     *            "d" é um dígito decimal.
     */
    public CNPJValidator(boolean isFormatted) {
		this.isFormatted  = isFormatted;
		this.messageProducer = new SimpleMessageProducer();
    }
    
    public CNPJValidator(boolean isFormatted, boolean isIgnoringRepeatedDigits) {
        this.isFormatted = isFormatted;
        this.isIgnoringRepeatedDigits = isIgnoringRepeatedDigits;
        this.messageProducer = new SimpleMessageProducer();
    }

    public CNPJValidator(MessageProducer messageProducer, boolean isFormatted, boolean isIgnoringRepeatedDigits) {
        this.messageProducer = messageProducer;
        this.isFormatted = isFormatted;
        this.isIgnoringRepeatedDigits = isIgnoringRepeatedDigits;
    }

    /**
     * <p>
     * Construtor do Validador de CNPJ. Leva em consideração se o valor está formatado.
     * </p>
     * <p>
     * 
     * @param messageProducer
     *            produtor de mensagem de erro.
     * @param isFormatted
     *            considera cadeia no formato de CNPJ: "dd.ddd.ddd/dddd-dd" onde
     *            "d" é um dígito decimal.
     */
    public CNPJValidator(MessageProducer messageProducer, boolean isFormatted) {
		this.messageProducer = messageProducer;
		this.isFormatted  = isFormatted;
    }
    
    public CNPJValidator(MessageProducer messageProducer){
		this.messageProducer = messageProducer;
    }

    private List<ValidationMessage> getInvalidValues(String cnpj) {

    	List<ValidationMessage> errors = new ArrayList<ValidationMessage>();    	
        
        if (cnpj != null) {

        	if(isFormatted != FORMATED.matcher(cnpj).matches()) {
        		errors.add(messageProducer.getMessage(CNPJError.INVALID_FORMAT));
        	}
        	
        	String unformatedCNPJ = null;
        	try{
				unformatedCNPJ = new CNPJFormatter().unformat(cnpj);
        	}catch(IllegalArgumentException e){
        		errors.add(messageProducer.getMessage(CNPJError.INVALID_DIGITS));
        		return errors;
        	}
        	
            if(unformatedCNPJ.length() != 14 || !unformatedCNPJ.matches("[0-9]*")){
            	errors.add(messageProducer.getMessage(CNPJError.INVALID_DIGITS));
            }
            
            if ((!isIgnoringRepeatedDigits) && hasAllRepeatedDigits(unformatedCNPJ)) {
                errors.add(messageProducer.getMessage(CNPJError.REPEATED_DIGITS));
            }
           
            String cnpjSemDigito = unformatedCNPJ.substring(0, unformatedCNPJ.length() - 2);
            String digitos = unformatedCNPJ.substring(unformatedCNPJ.length() - 2);

			String digitosCalculados = calculaDigitos(cnpjSemDigito);

            if(!digitos.equals(digitosCalculados)){
            	errors.add(messageProducer.getMessage(CNPJError.INVALID_CHECK_DIGITS));
            }
            
        }
        return errors;
    }

	/**
	 * Faz o cálculo dos digitos usando a lógica de CNPJ
	 * 
	 * @return String os dois dígitos calculados.
	 */
	private String calculaDigitos(String cnpjSemDigito) {
		DigitoPara digitoPara = new DigitoPara(cnpjSemDigito);
		digitoPara.complementarAoModulo().trocandoPorSeEncontrar("0",10,11).mod(11);
		
		String digito1 = digitoPara.calcula();
		digitoPara.addDigito(digito1);
		String digito2 = digitoPara.calcula();
		
		return digito1 + digito2;
	}

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
    public void assertValid(String cnpj) {
    	
        List<ValidationMessage> errors = getInvalidValues(cnpj);
		if (!errors.isEmpty()) {
            throw new InvalidStateException(errors);
        }
    }

    @Override
    public List<ValidationMessage> invalidMessagesFor(String cnpj) {
        return getInvalidValues(cnpj);
    }

    @Override
	public String generateRandomValid() {
		final String cnpjSemDigitos = new DigitoGenerator().generate(12);
		final String cnpjComDigitos = cnpjSemDigitos + calculaDigitos(cnpjSemDigitos);
		if (isFormatted) {
			return new CNPJFormatter().format(cnpjComDigitos);
		}
		return cnpjComDigitos;
	}
    
    private boolean hasAllRepeatedDigits(String cnpj) {
        for (int i = 1; i < cnpj.length(); i++) {
            if (cnpj.charAt(i) != cnpj.charAt(0)) {
                return false;
            }
        }
        return true;
    }
    
}