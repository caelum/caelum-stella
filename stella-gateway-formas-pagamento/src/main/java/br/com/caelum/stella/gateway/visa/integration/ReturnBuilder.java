package br.com.caelum.stella.gateway.visa.integration;

public interface ReturnBuilder<T> {

	public IntegrationReturn buildRetorno(T source);
}
