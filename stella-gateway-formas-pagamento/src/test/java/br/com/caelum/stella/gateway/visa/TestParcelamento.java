package br.com.caelum.stella.gateway.visa;

import org.junit.Test;

import br.com.caelum.stella.gateway.core.CheckoutInvalidoException;

import junit.framework.Assert;

public class TestParcelamento {

	@Test
	public void testFormatacaoCodigoParcelamentoComVisaElectron(){
		Assert.assertEquals("A001",new Parcelamento(FormaParcelamento.DEBITO,1).getCodigoDePagamento());
	}
	
	@Test
	public void testFormatacaoCodigoParcelamentoComVisaElectronOuCreditoAVisaEMaisDeUmaParcela(){
		/*
		 * nao sei direito como testar as exceptions já que por enquanto só tem um tipo... esse não é o melhor jeito, mas fica como solução temporaria...
		 */
		try{
			new Parcelamento(FormaParcelamento.DEBITO,2).getCodigoDePagamento();
		}
		catch(CheckoutInvalidoException numeroDeParcelasMaiorQuePermitidoException){
			Assert.assertEquals("Com débito ou crédito a vista só pode pagar em 1 parcela",numeroDeParcelasMaiorQuePermitidoException.getMessage());
		}
		try{
			new Parcelamento(FormaParcelamento.CREDITO_A_VISTA,2).getCodigoDePagamento();
		}
		catch(CheckoutInvalidoException numeroDeParcelasMaiorQuePermitidoException){
			Assert.assertEquals("Com débito ou crédito a vista só pode pagar em 1 parcela",numeroDeParcelasMaiorQuePermitidoException.getMessage());
		}		
	}
	
	@Test
	public void testFormatacaoCodigoComNumeroDeParcelasIgualAZero(){
		try{
			new Parcelamento(FormaParcelamento.CREDITO_A_VISTA,0).getCodigoDePagamento();
		}
		catch(CheckoutInvalidoException numeroDeParcelasMaiorQuePermitidoException){
			Assert.assertEquals("O número de parcelas não pode ser igual ou menor que 0",numeroDeParcelasMaiorQuePermitidoException.getMessage());
		}		
	}
	
	@Test
	public void testFormatacaoCodigoComJurosDaAdministradora(){
		Assert.assertEquals("3012",new Parcelamento(FormaParcelamento.PARCELADO_COM_JUROS_DA_ADMINISTRADORA,12).getCodigoDePagamento());
	}
	
	@Test
	public void testFormatacaoCodigoComJurosDaLoja(){
		Assert.assertEquals("2012",new Parcelamento(FormaParcelamento.PARCELADO_COM_JUROS_DA_LOJA,12).getCodigoDePagamento());
	}	
	
	@Test
	public void testFormatacaoCodigoComCreditoAVisa(){
		Assert.assertEquals("1001",new Parcelamento(FormaParcelamento.CREDITO_A_VISTA,1).getCodigoDePagamento());
	}	
	
	
	
	
}
