package br.com.caelum.stella.gateway.core;



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
