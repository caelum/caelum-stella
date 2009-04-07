package br.com.caelum.stella.gateway.core;



/**
 * Interface que as classes responsáveis por criaram objetos a partir da integração
 * com a forma de pagamento, devem implementar.
 * @author Alberto
 *
 * @param <R> tipo do retorno do metodo
 * @param <T> tipo do parametro que ele vai receber
 * 
 */
public interface ReturnBuilder<R,T> {

	public R buildRetorno(T source);
}
