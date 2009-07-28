package br.com.caelum.stella.gateway.redecard;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.stella.gateway.core.InvalidCheckoutException;
import br.com.caelum.stella.gateway.redecard.RedecardFormaPagamento;
import br.com.caelum.stella.gateway.redecard.RedecardTipoTransacao;

public class TestParcelamento {

	@Test
	public void testParcelamentoComTipoDeTransacaoAVistaENumeroDeParcelasMaiorQue1(){
		try{
			new RedecardFormaPagamento(RedecardTipoTransacao.A_VISTA,2);
		}
		catch (InvalidCheckoutException e) {
			// TODO: handle exception
			Assert.assertEquals("Para transação a vista o número de parcelas deve ser igual a 0",e.getMessage());
		}
	}
	
	@Test
	public void testParcelamentoComTipoDeTransacaoAPrazoENumeroDeParcelasMenorOuIgualA1(){
		try{
			new RedecardFormaPagamento(RedecardTipoTransacao.A_VISTA,1);
		}
		catch (InvalidCheckoutException e) {
			// TODO: handle exception
			Assert.assertEquals("Para transação a vista o número de parcelas deve ser igual a 0",e.getMessage());
		}
	}	
	
	@Test
	public void testFormatacaoDeNumeroDeParcelasAVista(){
		Assert.assertEquals("00",RedecardFormaPagamento.newPagamentoAVista().getNumeroDeParcelasComNoMinimoDoisDigitos());
	}
	

}
