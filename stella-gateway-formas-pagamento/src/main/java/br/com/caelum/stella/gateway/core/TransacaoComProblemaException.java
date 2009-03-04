package br.com.caelum.stella.gateway.core;

import br.com.caelum.stella.gateway.visa.ResultadoCheckout;

public class TransacaoComProblemaException extends RuntimeException {
	
	private ResultadoCheckout resultadoCheckout;

	public TransacaoComProblemaException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransacaoComProblemaException(String message,ResultadoCheckout resultadoCheckout) {
		super(message);
		this.resultadoCheckout = resultadoCheckout;
		// TODO Auto-generated constructor stub
	}

	public ResultadoCheckout getResultadoCheckout() {
		return resultadoCheckout;
	}
	
	

}
