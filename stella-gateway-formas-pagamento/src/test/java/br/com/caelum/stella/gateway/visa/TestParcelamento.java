package br.com.caelum.stella.gateway.visa;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.stella.gateway.core.InvalidCheckoutException;

public class TestParcelamento {

	@Test
	public void testFormatacaoCodigoParcelamentoComVisaElectron(){		
		Assert.assertEquals("A001",new VISAFormaPagamento(VISATipoTransacao.DEBITO,1).getCodigoDePagamento());
	}
	
	@Test
	public void testFormatacaoCodigoParcelamentoComVisaElectronOuCreditoAVisaEMaisDeUmaParcela(){
		/*
		 * nao sei direito como testar as exceptions já que por enquanto só tem um tipo... esse não é o melhor jeito, mas fica como solução temporaria...
		 */
		try{
			new VISAFormaPagamento(VISATipoTransacao.DEBITO,2);
		}
		catch(InvalidCheckoutException numeroDeParcelasMaiorQuePermitidoException){			
			Assert.assertEquals("Com débito ou crédito a vista só pode pagar em 1 parcela",numeroDeParcelasMaiorQuePermitidoException.getMessage());
		}
		try{
			new VISAFormaPagamento(VISATipoTransacao.CREDITO_A_VISTA,2);
		}
		catch(InvalidCheckoutException numeroDeParcelasMaiorQuePermitidoException){
			Assert.assertEquals("Com débito ou crédito a vista só pode pagar em 1 parcela",numeroDeParcelasMaiorQuePermitidoException.getMessage());
		}		
	}
	
	@Test
	public void testFormatacaoCodigoComNumeroDeParcelasIgualAZero(){
		try{
			new VISAFormaPagamento(VISATipoTransacao.CREDITO_A_VISTA,0);
		}
		catch(InvalidCheckoutException numeroDeParcelasMaiorQuePermitidoException){
			Assert.assertEquals("O número de parcelas não pode ser igual ou menor que 0",numeroDeParcelasMaiorQuePermitidoException.getMessage());
		}		
	}
	
	@Test
	public void testFormatacaoCodigoComJurosDaAdministradora(){
		Assert.assertEquals("3012",new VISAFormaPagamento(VISATipoTransacao.PARCELADO_JUROS_EMISSOR,12).getCodigoDePagamento());
	}
	
	@Test
	public void testFormatacaoCodigoComJurosDaLoja(){
		Assert.assertEquals("2012",new VISAFormaPagamento(VISATipoTransacao.PARCELADO_JUROS_LOJISTA,12).getCodigoDePagamento());
	}	
	
	@Test
	public void testFormatacaoCodigoComCreditoAVisa(){
		Assert.assertEquals("1001",new VISAFormaPagamento(VISATipoTransacao.CREDITO_A_VISTA,1).getCodigoDePagamento());
	}	
		
	
}
