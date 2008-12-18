package br.com.caelum.stella.nfe.builder;

public class IPI {

	private IPI(){
		
	}
	
	public static IPI create() {
		return new IPI();
	}

	public IPI withClasseDeEnquadramento(String classeDeEnquadramento) {
		// TODO Auto-generated method stub
		return this;
	}

	public IPI withCNPJDoProdutor(String cnpj) {
		// TODO Auto-generated method stub
		return this;
	}

	public IPI withCodigoDoSeloDeControle(String seloDeControle) {
		// TODO Auto-generated method stub
		return this;
	}

	public IPI withQuantidadeDeSelos(long quantidadeDeSelos) {
		// TODO Auto-generated method stub
		return this;
	}

	public IPI withCodigoDeEnquandramento(String codigoDeEnquadramento) {
		// TODO Auto-generated method stub
		return this;
	}

	public IPI withIPITrib(IPITrib ipiTrib) {
		// TODO Auto-generated method stub
		return this;
	}

	public IPI withIPIInt(IPIInt IPIInt) {
		// TODO Auto-generated method stub
		return this;
	}

}
