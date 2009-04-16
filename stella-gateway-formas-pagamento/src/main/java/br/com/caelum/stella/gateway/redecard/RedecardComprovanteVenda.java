package br.com.caelum.stella.gateway.redecard;

public class RedecardComprovanteVenda {

	private static final String CODIGO_EXIBICAO_CUPOM = "201";
	private RedecardAutorizacaoReturn autorizacaoReturn;	
	
	
	public RedecardComprovanteVenda(
			RedecardAutorizacaoReturn autorizacaoReturn) {		
		this.autorizacaoReturn = autorizacaoReturn;		
	}


	public String getDataFormatada() {
		return autorizacaoReturn.getDataFormatada();
	}


	public String getNumAutor() {
		return autorizacaoReturn.getNumAutor();
	}


	public String getNumCV() {
		return autorizacaoReturn.getNumCV();
	}


	public String getTransacao() {
		return CODIGO_EXIBICAO_CUPOM;
	}


	public RedecardIdiomaOperacao getIdiomaOperacao() {
		return autorizacaoReturn.getIdiomaOperacao();
	}
	
	
	
}
