package br.com.caelum.stella.gateway.redecard;

public class RedecardDadosFiliacao {

	private int filiacao;
	private Integer filiacaoDistribuidor;
	
	public RedecardDadosFiliacao(int filiacao, Integer filiacaoDistribuidor) {
		super();
		this.filiacao = filiacao;
		this.filiacaoDistribuidor = filiacaoDistribuidor;
	}

	public int getFiliacao() {
		return filiacao;
	}

	public Integer getFiliacaoDistribuidor() {
		return filiacaoDistribuidor;
	}
	
	
}
