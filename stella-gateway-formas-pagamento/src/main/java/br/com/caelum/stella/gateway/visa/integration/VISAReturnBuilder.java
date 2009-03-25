package br.com.caelum.stella.gateway.visa.integration;



/**
 * Interface que as classes responsáveis por criaram objetos a partir da integração
 * com a forma de pagamento, devem implementar.
 * @author Alberto
 *
 * @param <T> tipo do parametro que ele vai receber
 */
public interface VISAReturnBuilder<T> {

	public VISAIntegrationReturn buildRetorno(T source);
}
