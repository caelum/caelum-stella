package br.com.caelum.stella.validation.ie;

import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.validation.DigitoVerificadorInfo;
import br.com.caelum.stella.validation.RotinaDeDigitoVerificador;
import br.com.caelum.stella.validation.ValidadorDeDV;

/**
 * <p>
 * Documentação de referência:
 * </p>
 * <a href="http://www.pfe.fazenda.sp.gov.br/consist_ie.shtm">Secretaria da
 * Fazenda do Estado de São Paulo</a> <a
 * href="http://www.sintegra.gov.br/Cad_Estados/cad_BA.html">SINTEGRA - ROTEIRO
 * DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a>
 * 
 */
public class IEBahiaValidator extends AbstractIEValidator {

    private static final RotinaDeDigitoVerificador[] rotinas = { IEConstraints.Rotina.E, IEConstraints.Rotina.POS_IE };

    private static final int DVX_POSITION = 6 + 8;

    private static final int DVY_POSITION = 6 + 7;

    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P2;

    private static final Integer[] DVY_MULTIPLIERS = IEConstraints.P3;

    private static final DigitoVerificadorInfo DVX_INFO_MOD11 = new DigitoVerificadorInfo(0, rotinas, 11,
            DVX_MULTIPLIERS, DVX_POSITION);

    private static final ValidadorDeDV DVX_CHECKER_MOD11 = new ValidadorDeDV(DVX_INFO_MOD11);

    private static final DigitoVerificadorInfo DVY_INFO_MOD11 = new DigitoVerificadorInfo(0, rotinas, 11,
            DVY_MULTIPLIERS, DVY_POSITION);

    private static final ValidadorDeDV DVY_CHECKER_MOD11 = new ValidadorDeDV(DVY_INFO_MOD11);

    private static final DigitoVerificadorInfo DVX_INFO_MOD10 = new DigitoVerificadorInfo(0, rotinas, 10,
            DVX_MULTIPLIERS, DVX_POSITION);

    private static final ValidadorDeDV DVX_CHECKER_MOD10 = new ValidadorDeDV(DVX_INFO_MOD10);

    private static final DigitoVerificadorInfo DVY_INFO_MOD10 = new DigitoVerificadorInfo(0, rotinas, 10,
            DVY_MULTIPLIERS, DVY_POSITION);

    private static final ValidadorDeDV DVY_CHECKER_MOD10 = new ValidadorDeDV(DVY_INFO_MOD10);


    /*
     * 612345-57
     * 
     * 123456-63
     */
    public static final Pattern FORMATED = Pattern.compile("(\\d{6,7}-\\d{2})|(\\d{2,3}\\.\\d{3}\\.\\d{3})");

    public static final Pattern UNFORMATED = Pattern.compile("\\d{8,9}");

	/**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IEBahiaValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IEBahiaValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IEBahiaValidator(MessageProducer messageProducer, boolean isFormatted) {
		super(messageProducer, isFormatted);
	}


	@Override
	protected Pattern getUnformattedPattern() {
		return UNFORMATED;
	}

	@Override
	protected Pattern getFormattedPattern() {
		return FORMATED;
	}
  
    protected boolean hasValidCheckDigits(String value) {
        String testedValue = IEConstraints.PRE_VALIDATION_FORMATTER.format(value);
        boolean result = false;
        char charToCheck;
        
        if(value.length() == 8){
        	charToCheck= value.charAt(0);
        }else{
        	charToCheck= value.charAt(1);
        }
        
		switch (charToCheck) {
        case '6':
        case '7':
        case '9':
            result = DVX_CHECKER_MOD11.isDVValid(testedValue) && DVY_CHECKER_MOD11.isDVValid(testedValue);
            break;
        default:
            result = DVX_CHECKER_MOD10.isDVValid(testedValue) && DVY_CHECKER_MOD10.isDVValid(testedValue);
        }
        return result;
    }


}
