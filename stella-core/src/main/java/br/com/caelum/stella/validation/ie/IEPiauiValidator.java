package br.com.caelum.stella.validation.ie;

import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.validation.DigitoVerificadorInfo;
import br.com.caelum.stella.validation.RotinaDeDigitoVerificador;
import br.com.caelum.stella.validation.ValidadorDeDV;

/**
 * <p> Documentação de referência: </p>
 * <a href="http://www.sintegra.gov.br/Cad_Estados/cad_PI.html">
 * SINTEGRA - ROTEIRO DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a>
 * 
 * @author Leonardo Bessa
 */
public class IEPiauiValidator extends AbstractIEValidator {

    private static final int MOD = 11;

    private static final int DVX_POSITION = 5 + 9;

    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P1;

    private static final RotinaDeDigitoVerificador[] rotinas = { IEConstraints.Rotina.E, IEConstraints.Rotina.POS_IE };

    private static final DigitoVerificadorInfo DVX_INFO = new DigitoVerificadorInfo(0, rotinas, MOD, DVX_MULTIPLIERS,
            DVX_POSITION);

    private static final ValidadorDeDV DVX_CHECKER = new ValidadorDeDV(DVX_INFO);

    public static final Pattern FORMATED = Pattern.compile("\\d{2}(\\.\\d{3}){2}\\-\\d{1}");

    public static final Pattern UNFORMATED = Pattern.compile("\\d{9}");

	
    /**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IEPiauiValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IEPiauiValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IEPiauiValidator(MessageProducer messageProducer, boolean isFormatted) {
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
        return DVX_CHECKER.isDVValid(testedValue);
    }

}
