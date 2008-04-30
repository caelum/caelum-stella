package br.com.caelum.stella.boleto;

import org.jboleto.JBoleto;
import org.jboleto.JBoletoBean;

public class BoletoFactory {
	
	public JBoletoBean generateBoleto(Boleto boleto) {

		JBoletoBean jBoletoBean = generateOnlyBoleto(boleto);
		return jBoletoBean;
	}
	
	public JBoletoBean generateOnlyBoleto(Boleto boleto) {
		JBoletoBean jBoletoBean = new JBoletoBean();
		
		jBoletoBean.setAceite(boleto.getAceite());
		jBoletoBean.setAgencia(boleto.getAgencia());
		jBoletoBean.setCaminho(boleto.getCaminho());
		jBoletoBean.setCarteira(boleto.getCarteira());
		jBoletoBean.setCedente(boleto.getCedente());
		
		JBoleto jBoleto = new JBoleto();
		jBoleto.addBoleto(jBoletoBean, boleto.getBanco().ordinal());
		
		return jBoletoBean;
		
	}
}
