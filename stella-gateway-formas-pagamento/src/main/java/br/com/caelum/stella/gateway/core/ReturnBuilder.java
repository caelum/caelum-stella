package br.com.caelum.stella.gateway.core;

import br.com.caelum.stella.gateway.visa.integration.IntegrationReturn;

/**
 * Interface que todas as classes responsáveis por criaram objetos a partir da integração
 * com a forma de pagamento, devem implementar.
 * @author Alberto
 *
 * @param <T> tipo do parametro que ele vai receber
 */
public interface ReturnBuilder<T> {

	public IntegrationReturn buildRetorno(T source);
}
