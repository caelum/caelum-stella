package br.com.caelum.stella.gateway.core;



/**
 * Interface que as classes responsáveis por criaram objetos a partir da integração
 * com a forma de pagamento, devem implementar.
 * @author Alberto
 *
 * @param <P> tipo do retorno do metodo
 * @param <T> tipo do parametro que ele vai receber
 * 
 */
public interface ReturnBuilder<P,T> {

	public P buildRetorno(T source);
}
