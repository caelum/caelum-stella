package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.SimpleMessageProducer;
import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.format.TituloEleitoralFormatter;
import br.com.caelum.stella.validation.error.TituloEleitoralError;

/**
 * Representa um validador de Título de Eleitor. O algoritmo utilzado foi
 * basaedo na seguinte referência.
 * 
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
 * </p>
 * 
 * a) os oito primeiros algarismos serão seqüenciados,desprezando-se, na
 * emissão, os zeros à esquerda;
 * 
 * b) os dois algarismos seguintes serão representativos da unidade da Federação
 * de origem da inscrição, conforme códigos constantes da seguinte tabela:
 * 
 * <ul>
 * <li>01 - São Paulo</li>
 * <li>02 - Minas Gerais</li>
 * <li>03 - Rio de Janeiro</li>
 * <li>04 - Rio Grande do Sul</li>
 * <li>05 - Bahia</li>
 * <li>06 - Paraná</li>
 * <li>07 - Ceará</li>
 * <li>08 - Pernambuco</li>
 * <li>09 - Santa Catarina</li>
 * <li>10 - Goiás</li>
 * <li>11 - Maranhão</li>
 * <li>12 - Paraíba</li>
 * <li>13 - Pará</li>
 * <li>14 - Espírito Santo</li>
 * <li>15 - Piauí</li>
 * <li>16 - Rio Grande do Norte</li>
 * <li>17 - Alagoas</li>
 * <li>18 - Mato Grosso</li>
 * <li>19 - Mato Grosso do Sul</li>
 * <li>20 - Distrito Federal</li>
 * <li>21 - Sergipe</li>
 * <li>22 - Amazonas</li>
 * <li>23 - Rondônia</li>
 * <li>24 - Acre</li>
 * <li>25 - Amapá</li>
 * <li>26 - Roraima</li>
 * <li>27 - Tocantins</li>
 * <li>28 - Exterior (ZZ)</li>
 * </ul>
 * 
 * <p>
 * c) os dois últimos algarismos constituirão dígitos verificadores,
 * determinados com base no módulo 11, sendo o primeiro calculado sobre o número
 * seqüencial e o último sobre o código da unidade da Federação seguido do
 * primeiro dígito verificador.
 * </p>
 * 
 * @author Leonardo Bessa
 */
public class TituloEleitoralValidator implements Validator<String> {

    private final BaseValidator baseValidator;
    
    private final boolean isFormatted;

    private static final int MOD = 11;

    private static final int DV1_POSITION = 11;

    private static final int DV2_POSITION = 12;

    private static final Integer[] DV1_MULTIPLIERS = { 9, 8, 7, 6, 5, 4, 3, 2 };

    private static final Integer[] DV2_MULTIPLIERS = { 0, 0, 0, 0, 0, 0, 0, 0, 4, 3, 2 };

    public static final Pattern FORMATED = Pattern.compile("(\\d{10})/(\\d{2})");

    public static final Pattern UNFORMATED = Pattern.compile("(\\d{10})(\\d{2})");

    private enum Rotina implements RotinaDeDigitoVerificador {
        POS_PRODUTO_INTERNO {
            public Integer transform(RotinaParameters parameter) {
                Integer mod = parameter.getDigitoVerificadorInfo().getMod();
                Integer result = parameter.getResult() % mod;
                if (result < 2) {
                    result = 0;
                } else {
                    result = 11 - result;
                }
                return result;
            }
        }
    }

    private static final DigitoVerificadorInfo DV1_INFO = new DigitoVerificadorInfo(0,
            new Rotina[] { Rotina.POS_PRODUTO_INTERNO }, MOD, DV1_MULTIPLIERS, DV1_POSITION);

    private static final DigitoVerificadorInfo DV2_INFO = new DigitoVerificadorInfo(0,
            new Rotina[] { Rotina.POS_PRODUTO_INTERNO }, MOD, DV2_MULTIPLIERS, DV2_POSITION);

    private static final ValidadorDeDV DV1_CHECKER = new ValidadorDeDV(DV1_INFO);

    private static final ValidadorDeDV DV2_CHECKER = new ValidadorDeDV(DV2_INFO);

    /**
     * Utiliza um {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public TituloEleitoralValidator(boolean isFormatted) {
        this.baseValidator = new BaseValidator();
        this.isFormatted = isFormatted;
    }
    public TituloEleitoralValidator(){
    	this(false);
    }

 
    /**
     * <p>
     * Construtor do Validador de Titulo de Eleitor.
     * </p>
     * 
     * @param messageProducer
     *            produtor de mensagem de erro.
     */
    public TituloEleitoralValidator(MessageProducer messageProducer,boolean isFormatted) {
        this.baseValidator = new BaseValidator(messageProducer);
        this.isFormatted = isFormatted;
    }
    
    public TituloEleitoralValidator(MessageProducer messageProducer) {
        this.baseValidator = new BaseValidator(messageProducer);
        this.isFormatted = false;
    }
    

    private List<InvalidValue> getInvalidValues(String tituloDeEleitor) {
        List<InvalidValue> errors = new ArrayList<InvalidValue>();
        errors.clear();
        if (tituloDeEleitor != null) { 
        	
        	if (!isEligible(tituloDeEleitor)) {
                 if (isFormatted) {
                     errors.add(TituloEleitoralError.INVALID_FORMAT);
                 } else {
                     errors.add(TituloEleitoralError.INVALID_DIGITS);
                 }
        	}
        	
            else {
                String unformated;
                if(isFormatted){
                	 TituloEleitoralFormatter formatter = new TituloEleitoralFormatter();
                     unformated = formatter.unformat(tituloDeEleitor);
                }
                else {
                    unformated = tituloDeEleitor;
                }
                if (!hasValidCheckDigits(unformated)) {
                    errors.add(TituloEleitoralError.INVALID_CHECK_DIGITS);
                }
                if (hasCodigoDeEstadoInvalido(tituloDeEleitor)) {
                    errors.add(TituloEleitoralError.INVALID_CODIGO_DE_ESTADO);
                }
            }
        }
        return errors;
    }

    private boolean hasCodigoDeEstadoInvalido(String tituloDeEleitor) {
        final int length = tituloDeEleitor.length();
        int codigo;
        if(isFormatted){
        	codigo = Integer.parseInt(tituloDeEleitor.substring(length - 5, length - 3));
        }
        else{
        	codigo= Integer.parseInt(tituloDeEleitor.substring(length - 4, length - 2));
        }
        return !(codigo >= 01 && codigo <= 28);
    }

    private boolean hasValidCheckDigits(String value) {
        return (DV1_CHECKER.isDVValid(value)) && (DV2_CHECKER.isDVValid(value));
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

    public void assertValid(String tituloDeEleitor) {
        baseValidator.assertValid(getInvalidValues(tituloDeEleitor));
    }

    public List<ValidationMessage> invalidMessagesFor(String tituloDeEleitor) {
        return baseValidator.generateValidationMessages(getInvalidValues(tituloDeEleitor));
    }

}
