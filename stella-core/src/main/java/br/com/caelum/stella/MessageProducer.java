package br.com.caelum.stella;

/**
 * <p>
 * MessageProducers são responsáveis por buscar mensagens de validação.
 * </p>
 * <p>
 * Possíveis implementações incluem a busca em base de dados, arquivos xml e
 * ResourceBundles.
 * </p>
 *
 * @author Fabio Kung
 */
@SuppressWarnings("unchecked")
public interface MessageProducer<T extends Enum> {
    ValidationMessage getMessage(T error);
}
