package br.com.caelum.stella.gateway.core;



/**
 * Exception que deve ser lançada quando o retorno da integração não
 * for o que deveria ser. Ex: a transação falhou...
 * @author Alberto Pc
 *
 */
public class ProblematicTransactionException extends RuntimeException {
	
	private Object someReturn;
		
		
	public ProblematicTransactionException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProblematicTransactionException(String message,Object someReturn) {
		super(message);
		this.someReturn = someReturn;
		// TODO Auto-generated constructor stub
	}

	public ProblematicTransactionException(String message, Throwable throwable,Object someReturn) {
		super(message, throwable);
		this.someReturn = someReturn;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return gerado pela tentativa de transação.
	 */
	public Object getSomeReturn() {
		return someReturn;
	}
	
	
	

	
	
	
	

}
