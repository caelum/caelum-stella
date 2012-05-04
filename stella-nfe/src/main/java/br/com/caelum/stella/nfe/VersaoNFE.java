package br.com.caelum.stella.nfe;

public enum VersaoNFE {
	V_2_00("2.00");
	
	private final String versao;

	VersaoNFE(String versao){
		this.versao = versao;
		
	}
	
	public String getVersao(){
		return this.versao;
	}
	
	
}
