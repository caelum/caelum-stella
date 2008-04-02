package br.com.caelum.stella;

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
 * @param <T> <code>enum</code> onde os erros estão declarados.
 */
@SuppressWarnings("unchecked")
public interface MessageProducer<T extends Enum> {
    /**
     * @param error erro ao qual se procura a mensagem associada.
     * @return mensagem de validação associada ao erro.
     */
    ValidationMessage getMessage(T error);
}
