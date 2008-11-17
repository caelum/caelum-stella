package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.constraint.TituloDeEleitorConstraints;
import br.com.caelum.stella.constraint.TituloDeEleitorConstraints.Rotina;
import br.com.caelum.stella.validation.error.TituloEleitoralError;

/**
 * http://www.tre-al.gov.br/unidades/corregedoria/resolucoes/res21538.pdf
 * <p>
 * Art. 12. Os tribunais regionais eleitorais farão distribuir, observada a
 * seqüência numérica fornecida pela secretaria de informática, às zonas
 * eleitorais da respectiva circunscrição, séries de números de inscrição
 * eleitoral, a serem utilizados na forma deste artigo.
 * </p>
 * <p>
 * Parágrafo único. O número de inscrição compor-se-á de até 12 algarismos, por
 * unidade da Federação, assim discriminados:
 * <p>
 * 
 * a) os oito primeiros algarismos serão seqüenciados,desprezando-se, na
 * emissão, os zeros à esquerda;
 * 
 * b) os dois algarismos seguintes serão representativos da unidade da Federação
 * de origem da inscrição, conforme códigos constantes da seguinte tabela:
 * 
 * 01 - São Paulo 
 * 02 - Minas Gerais 
 * 03 - Rio de Janeiro 
 * 04 - Rio Grande do Sul
 * 05 - Bahia 
 * 06 - Paraná 
 * 07 - Ceará 
 * 08 - Pernambuco 
 * 09 - Santa Catarina 
 * 10 - Goiás 
 * 11 - Maranhão 
 * 12 - Paraíba 
 * 13 - Pará 
 * 14 - Espírito Santo 
 * 15 - Piauí 
 * 16 - Rio Grande do Norte
 * 17 - Alagoas
 * 18 - Mato Grosso 
 * 19 - Mato Grosso do Sul 
 * 20 - Distrito Federal 
 * 21 - Sergipe 
 * 22 - Amazonas 
 * 23 - Rondônia 
 * 24 - Acre 
 * 25 - Amapá 
 * 26 - Roraima 
 * 27 - Tocantins 
 * 28 - Exterior (ZZ)
 * 
 * <p>
 * c) os dois últimos algarismos constituirão dígitos verificadores,
 * determinados com base no módulo 11, sendo o primeiro calculado sobre o número
 * seqüencial e o último sobre o código da unidade da Federação seguido do
 * primeiro dígito verificador.
 * <p>
 * 
 * @author Leonardo Bessa
 */
public class TituloEleitoralValidator implements Validator<String> {

    private final BaseValidator baseValidator;

    private static final int MOD = 11;

    private static final int DV1_POSITION = 11;

    private static final int DV2_POSITION = 12;

    private static final Integer[] DV1_MULTIPLIERS = { 9, 8, 7, 6, 5, 4, 3, 2 };

    private static final Integer[] DV2_MULTIPLIERS = { 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 2 };

    private static final DigitoVerificadorInfo DV1_INFO = new DigitoVerificadorInfo(0,
            new Rotina[] { Rotina.POS_PRODUTO_INTERNO }, MOD, DV1_MULTIPLIERS, DV1_POSITION);

    private static final DigitoVerificadorInfo DV2_INFO = new DigitoVerificadorInfo(0,
            new Rotina[] { Rotina.POS_PRODUTO_INTERNO }, MOD, DV2_MULTIPLIERS, DV2_POSITION);

    private static final ValidadorDeDV DV1_CHECKER = new ValidadorDeDV(DV1_INFO);

    private static final ValidadorDeDV DV2_CHECKER = new ValidadorDeDV(DV2_INFO);

    /**
     * Utiliza um {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public TituloEleitoralValidator() {
        this.baseValidator = new BaseValidator();
    }

    /**
     * <p>
     * Construtor do Validador de Titulo De Eleitor.
     * </p>
     * <p>
     * 
     * @param messageProducer
     *            produtor de mensagem de erro.
     */
    public TituloEleitoralValidator(MessageProducer messageProducer) {
        this.baseValidator = new BaseValidator(messageProducer);
    }

    private List<InvalidValue> getInvalidValues(String tituloDeEleitor) {
        List<InvalidValue> errors = new ArrayList<InvalidValue>();
        errors.clear();
        if (tituloDeEleitor != null) {
            if (!isEligible(tituloDeEleitor)) {
                errors.add(TituloEleitoralError.INVALID_FORMAT);
            } 
            else if (hasCodigoDeEstadoInvalido(tituloDeEleitor)) {
                errors.add(TituloEleitoralError.INVALID_CODIGO_DE_ESTADO);
            }
            else {
                String unformated;
                unformated = tituloDeEleitor;
                if (!hasValidCheckDigits(unformated)) {
                    errors.add(TituloEleitoralError.INVALID_CHECK_DIGITS);
                }
            }
        }
        return errors;
    }

    private boolean hasCodigoDeEstadoInvalido(String tituloDeEleitor) {
        final int length = tituloDeEleitor.length();
        int codigo = Integer.parseInt(tituloDeEleitor.substring(length-4, length-2));
        return !(codigo>=01 && codigo<=28);
    }

    private boolean hasValidCheckDigits(String value) {
        return (DV1_CHECKER.isDVValid(value)) && (DV2_CHECKER.isDVValid(value));
    }

    public boolean isEligible(String value) {
        boolean result;
        result = TituloDeEleitorConstraints.TITULO_DE_ELEITOR_PATTERN.matcher(value).matches();
        return result;
    }

    public void assertValid(String tituloDeEleitor) {
        baseValidator.assertValid(getInvalidValues(tituloDeEleitor));
    }

    public List<ValidationMessage> invalidMessagesFor(String tituloDeEleitor) {
        return baseValidator.generateValidationMessages(getInvalidValues(tituloDeEleitor));
    }

}
