package br.com.caelum.stella.gateway.visa;


public class VISACancelamentoReturn implements VISAIntegrationReturn {

	private VISABasicDataReturn dadosBasicoDeRetorno;

	public VISACancelamentoReturn(VISABasicDataReturn dadosBasicoDeRetorno) {
		super();
		this.dadosBasicoDeRetorno = dadosBasicoDeRetorno;

	}

	public String getArs() {
		return dadosBasicoDeRetorno.getArs();
	}

	public int getLr() {
		return dadosBasicoDeRetorno.getLr();
	}

	public String getTid() {
		return dadosBasicoDeRetorno.getTid();
	}

}
