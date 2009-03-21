package br.com.caelum.stella.gateway.redecard;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.stella.gateway.core.InvalidCheckoutException;
import br.com.caelum.stella.gateway.redecard.Parcelamento;
import br.com.caelum.stella.gateway.redecard.TipoTransacao;

public class TestParcelamento {

	@Test
	public void testParcelamentoComTipoDeTransacaoAVistaENumeroDeParcelasMaiorQue1(){
		try{
			new Parcelamento(TipoTransacao.A_VISTA,2);
		}
		catch (InvalidCheckoutException e) {
			// TODO: handle exception
			Assert.assertEquals("Para transação a vista o número de parcelas deve ser igual a 0",e.getMessage());
		}
	}
	
	@Test
	public void testParcelamentoComTipoDeTransacaoAPrazoENumeroDeParcelasMenorOuIgualA1(){
		try{
			new Parcelamento(TipoTransacao.A_VISTA,1);
		}
		catch (InvalidCheckoutException e) {
			// TODO: handle exception
			Assert.assertEquals("Para transações com 1 parcela(s), use o tipo de transação a vista",e.getMessage());
		}
	}	
	
	@Test
	public void testFormatacaoDeNumeroDeParcelasAVista(){
		Assert.assertEquals("00",Parcelamento.newParcelamentoAVista().getNumeroDeParcelasComNoMinimoDoisDigitos());
	}
	

}
