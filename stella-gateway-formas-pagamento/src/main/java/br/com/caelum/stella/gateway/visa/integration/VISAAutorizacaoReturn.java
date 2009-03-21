package br.com.caelum.stella.gateway.visa.integration;

import br.com.caelum.stella.gateway.visa.Checkout;
import br.com.caelum.stella.gateway.visa.BasicDataReturn;

/**
 * Contém as informações de retorno da verificacao de autorizacao de pagamento.
 * @author Alberto Pc
 *
 */
public class VISAAutorizacaoReturn implements IntegrationReturn{

	private String pan;
	private BasicDataReturn dadosBasicoDeRetorno;
	private String bank;	
	private Checkout checkout;
	
	public VISAAutorizacaoReturn(BasicDataReturn dadosBasicoDeRetorno,final String arp, final String pan,String bank,Checkout checkout) {
		super();			
		this.pan = pan;				
		this.bank = bank;		
		this.dadosBasicoDeRetorno = dadosBasicoDeRetorno;
		this.checkout = checkout;
	}
		
	
	

	public String getPan() {
		return pan;
	}


	public Checkout getCheckout() {
		return checkout;
	}




	public String getBank() {
		return bank;
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
