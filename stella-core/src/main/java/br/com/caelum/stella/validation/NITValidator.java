package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.stella.DigitoGenerator;
import br.com.caelum.stella.DigitoPara;
import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.format.NITFormatter;
import br.com.caelum.stella.validation.error.NITError;

/**
 * <p>
 * Validador do Número de Identificação do Trabalhador. Este documento contém 11
 * (onze) caracteres numéricos, no formato ddd.ddddd.dd-d.
 * </p>
 * <p>
 * O NIT corresponde ao número do <b>PIS/PASEP/CI</b> sendo que, no caso de
 * Contribuinte Individual (CI), pode ser utilizado o número de inscrição no
 * Sistema Único de Saúde (SUS) ou na Previdência Social.
 * </p>
 * 
 * @author Leonardo Bessa
 */
public class NITValidator implements Validator<String> {

    public static final Pattern FORMATED = Pattern.compile("(\\d{3})[.](\\d{5})[.](\\d{2})-(\\d{1})");
    public static final Pattern UNFORMATED = Pattern.compile("(\\d{3})(\\d{5})(\\d{2})(\\d{1})");

    private boolean isFormatted = false;
    private MessageProducer messageProducer;

    /**
     * Este considera, por padrão, que as cadeias não estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public NITValidator() {
    	this.messageProducer = new SimpleMessageProducer();
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens.

     * @param isFormatted
     *            considera cadeia no formato de NIT: "ddd.ddddd.dd-d" onde "d"
     *            é um dígito decimal.
     */
    public NITValidator(boolean isFormatted) {
    	this.messageProducer = new SimpleMessageProducer();
        this.isFormatted = isFormatted;
    }

    /**
     * <p>
     * Construtor do Validador de NIT.
     * </p>
     * 
     * @param messageProducer
     *            produtor de mensagem de erro.
     * @param isFormatted
     *            considera cadeia no formato de NIT: "ddd.ddddd.dd-d" onde "d"
     *            é um dígito decimal.
     */
    public NITValidator(MessageProducer messageProducer, boolean isFormatted) {
        this.messageProducer = messageProducer;
        this.isFormatted = isFormatted;
    }

    private List<ValidationMessage> getInvalidValues(String nit) {
		List<ValidationMessage> errors = new ArrayList<ValidationMessage>();
		if (nit != null) {
		
			if(isFormatted && !FORMATED.matcher(nit).matches()){
				errors.add(messageProducer.getMessage(NITError.INVALID_FORMAT));
			}
			
			String unformatedNIT = null;
			try{
				unformatedNIT = new NITFormatter().unformat(nit);
			}catch(IllegalArgumentException e){
				errors.add(messageProducer.getMessage(NITError.INVALID_DIGITS));
				return errors;
			}
			
		    if(unformatedNIT.length() != 11 || !unformatedNIT.matches("[0-9]*")){
		    	errors.add(messageProducer.getMessage(NITError.INVALID_DIGITS));
		    }
		   
		    String nitSemDigito = unformatedNIT.substring(0, unformatedNIT.length() - 1);
		    String digitos = unformatedNIT.substring(unformatedNIT.length() - 1);
		
			String digitosCalculados = calculaDigitos(nitSemDigito);
		
		    if(!digitos.equals(digitosCalculados)){
		    	errors.add(messageProducer.getMessage(NITError.INVALID_CHECK_DIGITS));
		
			}
		}
		return errors;
    }

    private String calculaDigitos(String nitSemDigito) {
    	return new DigitoPara(nitSemDigito).complementarAoModulo().trocandoPorSeEncontrar("0",10,11).mod(11).calcula();
	}

	public boolean isEligible(String value) {
        boolean result;
        if (isFormatted) {
            result = FORMATED.matcher(value).matches();
        } else {
            result = UNFORMATED.matcher(value).matches();
        }
        return result;
    }

    public void assertValid(String nit) {
        List<ValidationMessage> errors = getInvalidValues(nit);
        if (!errors.isEmpty()) {
			throw new InvalidStateException(errors);
		}
    }

    public List<ValidationMessage> invalidMessagesFor(String nit) {
        return getInvalidValues(nit);
    }
    
    @Override
    public String generateRandomValid() {
    	final String nitSemDigito = new DigitoGenerator().generate(10);
    	final String nitComDigito = nitSemDigito + calculaDigitos(nitSemDigito);
    	if (isFormatted) {
    		return new NITFormatter().format(nitComDigito);
    	}
        return nitComDigito;
    }
}
