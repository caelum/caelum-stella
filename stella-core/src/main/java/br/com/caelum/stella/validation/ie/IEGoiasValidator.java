package br.com.caelum.stella.validation.ie;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.constraint.IEConstraints;
import br.com.caelum.stella.validation.BaseValidator;
import br.com.caelum.stella.validation.DigitoVerificadorInfo;
import br.com.caelum.stella.validation.InvalidValue;
import br.com.caelum.stella.validation.RotinaDeDigitoVerificador;
import br.com.caelum.stella.validation.ValidadorDeDV;
import br.com.caelum.stella.validation.error.IEError;

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
public class IEGoiasValidator extends BaseValidator<String> {

    private static final int MOD = 11;

    private static final int DVX_POSITION = 5 + 9;

    private static final Integer[] DVX_MULTIPLIERS = IEConstraints.P1;

    private static final RotinaDeDigitoVerificador[] rotinas = {
            IEConstraints.Rotina.E, IEConstraints.Rotina.POS_IE_GOIAS };

    private static final DigitoVerificadorInfo DVX_INFO_FATOR1 = new DigitoVerificadorInfo(
            1, rotinas, MOD, DVX_MULTIPLIERS, DVX_POSITION);

    private static final DigitoVerificadorInfo DVX_INFO_FATOR0 = new DigitoVerificadorInfo(
            0, rotinas, MOD, DVX_MULTIPLIERS, DVX_POSITION);

    private static final ValidadorDeDV DVX_CHECKER_FATOR1 = new ValidadorDeDV(
            DVX_INFO_FATOR1);

    private static final ValidadorDeDV DVX_CHECKER_FATOR0 = new ValidadorDeDV(
            DVX_INFO_FATOR0);

    private final boolean isFormatted;

    /*
     * Formato da Inscrição: AB.CDE.FGH-I 8 dígitos (ABCDEFGH)+1 dígito
     * verificador (I); onde AB pode ser igual a 10 ou 11 ou 15.
     * 
     * CCE de Exemplo: 10.987.654-7
     * 
     * -Atribui-se um peso a cada dígito do CCE seguindo a ordem abaixo:
     * 
     * CCE= 1 0 9 8 7 6 5 4
     * 
     * PESOS= 9 8 7 6 5 4 3 2
     * 
     * 
     * Cálculo:
     * 
     * (9x1)+(8x0)+(7x9)+(6x8)+(5x7)+(4x6)+(3x5)+(2x4)= 202
     * 
     * Divide-se 202 por 11= 18 e sobra 4 (resto)
     * 
     * Quando a inscrição for 11094402 o dígito verificador pode ser zero (0) e
     * pode ser um (1);
     * 
     * Quando o resto da divisão for zero (0), o dígito verificador será zero
     * (0);
     * 
     * Quando o resto da divisão for um (1), e a inscrição for maior ou igual a
     * 10103105 e menor ou igual a 10119997, o dígito verificador será um (1);
     * 
     * Quando o resto da divisão for um (1), e a inscrição estiver fora do
     * intervalo citado acima, o dígito verificador será zero (0);
     * 
     * Quando o resto for diferente de um (1) ou zero (0), o dígito verificador
     * será onze (11) menos o resto. No exemplo acima onze (11) menos quatro (4)
     * é igual a sete (7) que é o dígito verificador da Inscrição 10.987.654-7
     */

    public static final Pattern FORMATED = Pattern
            .compile("(1[015])[.](\\d{3})[.](\\d{3})[-](\\d{1})");

    public static final Pattern UNFORMATED = Pattern
            .compile("(1[015])(\\d{3})(\\d{3})(\\d{1})");

    /**
     * Este considera, por padrão, que as cadeias estão formatadas e utiliza um
     * {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public IEGoiasValidator() {
        this(true);
    }

    /**
     * O validador utiliza um {@linkplain SimpleMessageProducer} para geração de
     * mensagens.
     * 
     * @param isFormatted
     *            considerar cadeia formatada quando <code>true</code>
     */
    public IEGoiasValidator(boolean isFormatted) {
        super();
        this.isFormatted = isFormatted;
    }

    public IEGoiasValidator(MessageProducer messageProducer, boolean isFormatted) {
        super(messageProducer);
        this.isFormatted = isFormatted;
    }

    @Override
    protected List<InvalidValue> getInvalidValues(String IE) {
        List<InvalidValue> errors = new ArrayList<InvalidValue>();
        errors.clear();
        if (IE != null) {
            String unformatedIE = checkForCorrectFormat(IE, errors);
            if (errors.isEmpty()) {
                if (!hasValidCheckDigits(unformatedIE)) {
                    errors.add(IEError.INVALID_CHECK_DIGITS);
                }
            }
        }
        return errors;
    }

    private String checkForCorrectFormat(String ie, List<InvalidValue> errors) {
        String unformatedIE = null;
        if (isFormatted) {
            if (!(FORMATED.matcher(ie).matches())) {
                errors.add(IEError.INVALID_FORMAT);
            }
            unformatedIE = ie.replaceAll("\\D", "");
        } else {
            if (!UNFORMATED.matcher(ie).matches()) {
                errors.add(IEError.INVALID_DIGITS);
            }
            unformatedIE = ie;
        }
        return unformatedIE;
    }

    private boolean hasValidCheckDigits(String value) {
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
            String testedValue = IEConstraints.PRE_VALIDATION_FORMATTER
                    .format(value);
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
