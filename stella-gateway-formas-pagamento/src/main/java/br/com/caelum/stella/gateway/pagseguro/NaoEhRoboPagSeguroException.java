package br.com.caelum.stella.gateway.pagseguro;

/**
 * Exception que é lançada quando a requisição é feita diretamente pelo browser
 * e não pelo Robo da PagSeguro.
 * @author Alberto Pc
 *
 */
public class NaoEhRoboPagSeguroException extends RuntimeException {

	public NaoEhRoboPagSeguroException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
