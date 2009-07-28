package br.com.caelum.stella.gateway.core;

/**
 * Interface que deve ser implementada por toda classe que queira
 * fazer uma integração.
 * @author Alberto Pc
 *
 * @param <T> Como as integrações podem gerar diferentes retornos, o mesmo é especificado pela classe que implementa
 */
public interface IntegrationHandler<T> {
	
	public T handle();
}
