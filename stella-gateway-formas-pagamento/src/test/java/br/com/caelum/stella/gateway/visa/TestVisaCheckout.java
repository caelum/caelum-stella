package br.com.caelum.stella.gateway.visa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.stella.gateway.core.CartaoCredito;
import br.com.caelum.stella.gateway.core.GatewaysConf;

public class TestVisaCheckout {
	
	private static final long NUMERO_FILIACAO_TESTE = 1001734898;
	private GatewaysConf gatewaysConf = new GatewaysConf();
	
	@Test
	public void testFormatacaoDaDataDeValidadeDoCartao(){
		Calendar data = Calendar.getInstance();
		data.set(Calendar.YEAR,2009);
		data.set(Calendar.MONTH,Calendar.MARCH);
		Assert.assertEquals("0309",new CartaoCredito(1234567890123456l,data,123).getExpFormatado());
	}

	@Test
	public void testValorDaCompraFormatado() {
		Assert.assertEquals("1234548", new VISACheckout(null,null,null,new BigDecimal(12345.48),null).getValorFormatado());
	}
	
	@Test
	public void testFormatandoParaBigDecimalOValor(){
		Assert.assertEquals(new BigDecimal(12345.45).setScale(2,RoundingMode.HALF_EVEN), new VISACheckout(null,null,null,"1234545",null).getPrice());
	}

	@Test
	public void testGeracaoDoTidComCreditoAVista() {
		Calendar dataReferencia = getDataReferencia();
		Assert.assertEquals("73489405115052541001",new TIDGenerator().getTid(new VISAFormaPagamento(VISATipoTransacao.CREDITO_A_VISTA,1),dataReferencia,NUMERO_FILIACAO_TESTE));
	}
	
	@Test
	public void testGeracaoDoTidComCreditoParceladoPelaLoja() {
		// data montada pegando a referencia da documentacao do visa
		Calendar dataReferencia = getDataReferencia();
		Assert.assertEquals("73489405115052542003",new TIDGenerator().getTid(new VISAFormaPagamento(VISATipoTransacao.PARCELADO_JUROS_LOJISTA,3),dataReferencia,NUMERO_FILIACAO_TESTE));
	}

	private Calendar getDataReferencia() {
		Calendar dataReferencia = Calendar.getInstance();
		dataReferencia.set(Calendar.DAY_OF_MONTH, 20);
		dataReferencia.set(Calendar.MONDAY, Calendar.FEBRUARY);
		dataReferencia.set(Calendar.YEAR, 2004);
		dataReferencia.set(Calendar.HOUR_OF_DAY, 15);
		dataReferencia.set(Calendar.MINUTE, 5);
		dataReferencia.set(Calendar.SECOND, 25);
		dataReferencia.set(Calendar.MILLISECOND, 400);
		return dataReferencia;
	}	
	
	@Test
	public void testGeracaoDoTidComCreditoParceladoPelaAdministrador() {
		Calendar dataReferencia = getDataReferencia();
		Assert.assertEquals("73489405115052543006",new TIDGenerator().getTid(new VISAFormaPagamento(VISATipoTransacao.PARCELADO_JUROS_EMISSOR,6),dataReferencia,NUMERO_FILIACAO_TESTE));
	}	
	
	@Test
	public void testGeracaoDoTidComDebito() {
		Calendar dataReferencia = getDataReferencia();
		Assert.assertEquals("7348940511505254A001",new TIDGenerator().getTid(new VISAFormaPagamento(VISATipoTransacao.DEBITO,1),dataReferencia,NUMERO_FILIACAO_TESTE));		
	}	

}
