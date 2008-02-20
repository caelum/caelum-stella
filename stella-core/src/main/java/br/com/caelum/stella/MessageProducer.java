package br.com.caelum.stella;

/**
 * @Author Fabio Kung
 */
public interface MessageProducer<T extends Enum> {
    ValidationMessage getMessage(T error);
}
