package br.com.caelum.stella.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import br.com.caelum.stella.DigitoGenerator;
import br.com.caelum.stella.DigitoPara;
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

    public static final Pattern FORMATED = Pattern.compile("(\\d{10})/(\\d{2})");
    public static final Pattern UNFORMATED = Pattern.compile("(\\d{10})(\\d{2})");
    
    private boolean isFormatted = false;
    private MessageProducer messageProducer;

    
    /**
     * Construtor do TituloEleitoralValidator. Considera por padrão que as cadeias não estão formatadas.
     * Utiliza um {@linkplain SimpleMessageProducer} para geração de mensagens.
     */
    public TituloEleitoralValidator(){
    	this.messageProducer = new SimpleMessageProducer();
    }

    /**
     * Considera se cadeias não estão formatadas ou não.
     * Utiliza um {@linkplain SimpleMessageProducer} para geração de mensagens.
     * @param isFormatted indica se o número está formatado.
     */
    public TituloEleitoralValidator(boolean isFormatted) {
    	this.messageProducer = new SimpleMessageProducer();
        this.isFormatted = isFormatted;
    }
    
    /**
     * <p>
     * Construtor do Validador de Titulo de Eleitor.
     * </p>
     * 
     * @param messageProducer
     *            produtor de mensagem de erro.
     * @param isFormatted indica se o número está formatado.
     */
    public TituloEleitoralValidator(MessageProducer messageProducer,boolean isFormatted) {
    	this.messageProducer = messageProducer;
        this.isFormatted = isFormatted;
    }
    
    public TituloEleitoralValidator(MessageProducer messageProducer) {
    	this.messageProducer = messageProducer;
    }
    

    private List<ValidationMessage> getInvalidValues(String tituloDeEleitor) {
        List<ValidationMessage> errors = new ArrayList<ValidationMessage>();
        if (tituloDeEleitor != null) { 
        	
			if (isFormatted && !FORMATED.matcher(tituloDeEleitor).matches()) {
				errors.add(messageProducer.getMessage(TituloEleitoralError.INVALID_FORMAT));
			}

			String unformatedTitulo = null;
			try {
				unformatedTitulo = new TituloEleitoralFormatter().unformat(tituloDeEleitor);
			} catch (IllegalArgumentException e) {
				errors.add(messageProducer.getMessage(TituloEleitoralError.INVALID_DIGITS));
				return errors;
			}

			if (unformatedTitulo.length() != 12 || !unformatedTitulo.matches("[0-9]*")) {
				errors.add(messageProducer.getMessage(TituloEleitoralError.INVALID_DIGITS));
			}
			
			if (hasCodigoDeEstadoInvalido(unformatedTitulo)) {
				errors.add(messageProducer.getMessage(TituloEleitoralError.INVALID_CODIGO_DE_ESTADO));
			} else {
				
				String tituloSemDigito = unformatedTitulo.substring(0, unformatedTitulo.length() - 2);
				String digitos = unformatedTitulo.substring(unformatedTitulo.length() - 2);
				
				String digitosCalculados = calculaDigitos(tituloSemDigito);
				
				if (!digitos.equals(digitosCalculados)) {
					errors.add(messageProducer.getMessage(TituloEleitoralError.INVALID_CHECK_DIGITS));
				}
				
			}

			
        }
        return errors;
    }

    private String calculaDigitos(String tituloSemDigito) {
    	int length = tituloSemDigito.length();

    	String sequencial = tituloSemDigito.substring(0,length - 2);
		String digito1 = new DigitoPara(sequencial).complementarAoModulo().trocandoPorSeEncontrar("0",10,11).mod(11).calcula();
    	
		String codigoEstado = tituloSemDigito.substring(length - 2, length);
		String digito2 = new DigitoPara(codigoEstado + digito1).complementarAoModulo().trocandoPorSeEncontrar("0",10,11).mod(11).calcula();

		return digito1 + digito2;
	}

	private boolean hasCodigoDeEstadoInvalido(String tituloDeEleitor) {
        int codigo= Integer.parseInt(tituloDeEleitor.substring(tituloDeEleitor.length() - 4, tituloDeEleitor.length() - 2));
        return !(codigo >= 01 && codigo <= 28);
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
		List<ValidationMessage> errors = getInvalidValues(tituloDeEleitor);
		if (!errors.isEmpty()) {
			throw new InvalidStateException(errors);
		}
	}

	public List<ValidationMessage> invalidMessagesFor(String tituloDeEleitor) {
		return getInvalidValues(tituloDeEleitor);
	}

	@Override
	public String generateRandomValid() {
		final String digitosSequenciais = new DigitoGenerator().generate(8);
		final String digitosEstado = String.format("%02d", new Random().nextInt(28) + 1);
		final String tituloSemDigito = digitosSequenciais + digitosEstado;
		final String tituloComDigito = tituloSemDigito + calculaDigitos(tituloSemDigito);
		if (isFormatted) {
			return new TituloEleitoralFormatter().format(tituloComDigito);
		}
		return tituloComDigito;
	}
}
