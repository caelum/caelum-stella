package br.com.caelum.stella.gateway.visa;

/**
 * Contém as informações de retorno da verificacao de autorizacao de pagamento.
 * 
 * @author Alberto Pc
 * 
 */
public class VISAAutorizacaoReturn implements VISAIntegrationReturn {

	private String pan;
	private VISABasicDataReturn dadosBasicoDeRetorno;	
	private VISACheckout checkout;
	

	public VISAAutorizacaoReturn(VISABasicDataReturn dadosBasicoDeRetorno,
			String arp, String pan, VISACheckout checkout) {
		super();
		this.pan = pan;		
		this.dadosBasicoDeRetorno = dadosBasicoDeRetorno;
		this.checkout = checkout;
	}

	public String getPan() {
		return pan;
	}

	public VISACheckout getCheckout() {
		return checkout;
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
