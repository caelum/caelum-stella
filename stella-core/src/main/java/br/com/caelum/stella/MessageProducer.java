package br.com.caelum.stella;

import br.com.caelum.stella.validation.InvalidValue;

/**
 * <p>
 * MessageProducers são responsáveis pela busca de mensagens de validação.
 * </p>
 * <p>
 * Possíveis implementações incluem a busca em base de dados, arquivos xml e
 * ResourceBundles.
 * </p>
 * 
 * @author Fabio Kung
 * @author Leonardo Bessa
 */
public interface MessageProducer {
    /**
     * @param invalidValue
     *            valor inválido ao qual se procura a mensagem associada.
     * @return mensagem de validação associada ao erro.
     */
    ValidationMessage getMessage(InvalidValue invalidValue);
}
