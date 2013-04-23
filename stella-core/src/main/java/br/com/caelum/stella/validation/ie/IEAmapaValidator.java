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
 * href="http://www.sintegra.gov.br/Cad_Estados/cad_AP.html">SINTEGRA - ROTEIRO
 * DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a>
 * 
 */
public class IEAmapaValidator extends AbstractIEValidator {

    private static final int MOD = 11;

    private static final int DVX_POSITION = 5 + 9;

    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P1;

    private static final RotinaDeDigitoVerificador[] ROTINAS_CASO1 = { IEConstraints.Rotina.C, IEConstraints.Rotina.E,
            IEConstraints.Rotina.POS_IE };

    private static final RotinaDeDigitoVerificador[] ROTINAS_CASO2 = ROTINAS_CASO1;

    private static final RotinaDeDigitoVerificador[] ROTINAS_CASO3 = { IEConstraints.Rotina.E,
            IEConstraints.Rotina.POS_IE };

    private static final DigitoVerificadorInfo DVX_INFO_CASO1 = new DigitoVerificadorInfo(0, ROTINAS_CASO1, MOD,
            DVX_MULTIPLIERS, DVX_POSITION);

    private static final DigitoVerificadorInfo DVX_INFO_CASO2 = new DigitoVerificadorInfo(1, ROTINAS_CASO2, MOD,
            DVX_MULTIPLIERS, DVX_POSITION);

    private static final DigitoVerificadorInfo DVX_INFO_CASO3 = new DigitoVerificadorInfo(0, ROTINAS_CASO3, MOD,
            DVX_MULTIPLIERS, DVX_POSITION);

    private static final ValidadorDeDV DVX_CHECKER_CASO1 = new ValidadorDeDV(DVX_INFO_CASO1);

    private static final ValidadorDeDV DVX_CHECKER_CASO2 = new ValidadorDeDV(DVX_INFO_CASO2);

    private static final ValidadorDeDV DVX_CHECKER_CASO3 = new ValidadorDeDV(DVX_INFO_CASO3);

    public static final Pattern FORMATED = Pattern.compile("(03)[.](\\d{3})\\.?(\\d{3})[-](\\d{1})");

    public static final Pattern UNFORMATED = Pattern.compile("(03)(\\d{3})(\\d{3})(\\d{1})");
	/**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IEAmapaValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IEAmapaValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IEAmapaValidator(MessageProducer messageProducer, boolean isFormatted) {
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
	
    @Override
	protected boolean hasValidCheckDigits(String value) {
        int ie = Integer.parseInt(value) / 10;
        boolean result;
        /*
         * http://www.sintegra.gov.br/Cad_Estados/cad_AP.html
         * 
         * De 03000001X a 03017000X => CASO 1
         * 
         * De 03017001X a 03019022X => CASO 2
         * 
         * De 03019023X em diante => CASO 3
         */
        String testedValue = IEConstraints.PRE_VALIDATION_FORMATTER.format(value);
        ValidadorDeDV validadorDeDV = null;
        if ((3000001 <= ie) && (ie <= 3017000)) {
            validadorDeDV = DVX_CHECKER_CASO1;
        } else if ((3017001 <= ie) && (ie <= 3019022)) {
            validadorDeDV = DVX_CHECKER_CASO2;
        } else if (3019023 <= ie) {
            validadorDeDV = DVX_CHECKER_CASO3;
        }
        result = validadorDeDV.isDVValid(testedValue);

        return result;
    }


}
