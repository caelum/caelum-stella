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
 * href="http://www.sintegra.gov.br/Cad_Estados/cad_GO.html">SINTEGRA - ROTEIRO
 * DE CRÍTICA DA INSCRIÇÃO ESTADUAL </a>
 * 
 * @author Leonardo Bessa
 * 
 */
public class IEGoiasValidator extends AbstractIEValidator {

    private static final int MOD = 11;

    private static final int DVX_POSITION = 5 + 9;

    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P1;

    private static final RotinaDeDigitoVerificador[] rotinas = { IEConstraints.Rotina.E,
            IEConstraints.Rotina.POS_IE_GOIAS };

    private static final DigitoVerificadorInfo DVX_INFO_FATOR1 = new DigitoVerificadorInfo(1, rotinas, MOD,
            DVX_MULTIPLIERS, DVX_POSITION);

    private static final DigitoVerificadorInfo DVX_INFO_FATOR0 = new DigitoVerificadorInfo(0, rotinas, MOD,
            DVX_MULTIPLIERS, DVX_POSITION);

    private static final ValidadorDeDV DVX_CHECKER_FATOR1 = new ValidadorDeDV(DVX_INFO_FATOR1);

    private static final ValidadorDeDV DVX_CHECKER_FATOR0 = new ValidadorDeDV(DVX_INFO_FATOR0);

    public static final Pattern FORMATED = Pattern.compile("(1[015])[.](\\d{3})[.](\\d{3})[-](\\d{1})");

    public static final Pattern UNFORMATED = Pattern.compile("(1[015])(\\d{3})(\\d{3})(\\d{1})");

	/**
	 * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
	 * {@linkplain SimpleMessageProducer} para geração de mensagens.
	 */
	public IEGoiasValidator() {
		super(true);
	}

	/**
	 * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
	 * mensagens.
	 * 
	 * @param isFormatted
	 *            considerar cadeia formatada quando <code>true</code>
	 */
	public IEGoiasValidator(boolean isFormatted) {
		super(isFormatted);
	}

	public IEGoiasValidator(MessageProducer messageProducer, boolean isFormatted) {
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
        int ie = Integer.parseInt(value);
        boolean result;
        /*
         * http://www.sintegra.gov.br/Cad_Estados/cad_GO.html
         * 
         * Quando a inscrição for 11094402 o dígito verificador pode ser zero
         * (0) e pode ser um (1);
         */
        if (ie == 110944020 || ie == 110944021) {
            result = true;
        } else {
            String testedValue = IEConstraints.PRE_VALIDATION_FORMATTER.format(value);
            ValidadorDeDV validadorDeDV = null;
            if (101031051 <= ie && ie <= 101199979) {
                validadorDeDV = DVX_CHECKER_FATOR1;
            } else {
                validadorDeDV = DVX_CHECKER_FATOR0;
            }
            result = validadorDeDV.isDVValid(testedValue);
        }

        return result;
    }


}
