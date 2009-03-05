package br.com.caelum.stella.gateway.integration;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import junit.framework.Assert;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.gateway.visa.integration.AutorizacaoReturn;
import br.com.caelum.stella.gateway.visa.integration.CancelamentoReturn;
import br.com.caelum.stella.gateway.visa.integration.CapturaReturn;
import br.com.caelum.stella.gateway.visa.integration.ConsultaReturn;
import br.com.caelum.stella.gateway.visa.integration.HttpReturnBuilder;
import br.com.caelum.stella.gateway.visa.integration.VerificaRetornoIntegracaoViaHttp;

public class TestRetornoIntegracaoComponenteDoVisa {

	@Test
	public void testRetornoAutorizacao(){
		Mockery mockery = new Mockery();
		final HttpServletRequest request = mockery.mock(HttpServletRequest.class);
		mockery.checking(new Expectations(){
			{
				atLeast(2).of(request).getParameter("lr");will(returnValue("00"));
				one(request).getParameter("orderid");will(returnValue("123456"));
				one(request).getParameter("free");will(returnValue("free"));
				one(request).getParameter("price");will(returnValue("100"));
				one(request).getParameter("ars");will(returnValue("autorizada"));
				one(request).getParameter("tid");will(returnValue("12345678"));
				one(request).getParameter("arp");will(returnValue("1332"));
				one(request).getParameter("pan");will(returnValue("4739856348950"));
				one(request).getParameter("bank");will(returnValue("347"));
			}
		});
		VerificaRetornoIntegracaoViaHttp retornoIntegracaoViaHttp = new VerificaRetornoIntegracaoViaHttp(request,HttpReturnBuilder.AUTORIZACAO_RETORNO_BUILDER);
		AutorizacaoReturn autorizacaoReturn = (AutorizacaoReturn)retornoIntegracaoViaHttp.handle();
		Assert.assertEquals(BigDecimal.ONE.setScale(2),autorizacaoReturn.getCheckout().getPrice());
		
	}
	
	@Test
	public void testRetornoCaptura(){
		Mockery mockery = new Mockery();
		final HttpServletRequest request = mockery.mock(HttpServletRequest.class);
		mockery.checking(new Expectations(){
			{
				atLeast(2).of(request).getParameter("lr");will(returnValue("00"));				
				one(request).getParameter("free");will(returnValue("free"));				
				one(request).getParameter("ars");will(returnValue("autorizada"));
				one(request).getParameter("tid");will(returnValue("12345678"));
				one(request).getParameter("cap");will(returnValue("200"));
			}
		});
		VerificaRetornoIntegracaoViaHttp retornoIntegracaoViaHttp = new VerificaRetornoIntegracaoViaHttp(request,HttpReturnBuilder.CAPTURA_RETORNO_BUILDER);
		CapturaReturn capturaReturn = (CapturaReturn)retornoIntegracaoViaHttp.handle();
		Assert.assertEquals(new BigDecimal(2).setScale(2),capturaReturn.getCap());
		
	}	
	
	@Test
	public void testRetornoCancelamento(){
		Mockery mockery = new Mockery();
		final HttpServletRequest request = mockery.mock(HttpServletRequest.class);
		mockery.checking(new Expectations(){
			{
				atLeast(2).of(request).getParameter("lr");will(returnValue("00"));				
				one(request).getParameter("free");will(returnValue("free"));				
				one(request).getParameter("ars");will(returnValue("autorizada"));
				one(request).getParameter("tid");will(returnValue("12345678"));
				one(request).getParameter("cancel_amount");will(returnValue("200"));
			}
		});
		VerificaRetornoIntegracaoViaHttp retornoIntegracaoViaHttp = new VerificaRetornoIntegracaoViaHttp(request,HttpReturnBuilder.CANCELAMENTO_RETORNO_BUILDER);
		CancelamentoReturn cancelamentoReturn = (CancelamentoReturn)retornoIntegracaoViaHttp.handle();
		Assert.assertEquals(new BigDecimal(2).setScale(2),cancelamentoReturn.getCancel_amount());
		
	}	
	
	@Test
	public void testRetornoConsulta(){
		Mockery mockery = new Mockery();
		final HttpServletRequest request = mockery.mock(HttpServletRequest.class);
		mockery.checking(new Expectations(){
			{
				atLeast(2).of(request).getParameter("lr");will(returnValue("00"));
				one(request).getParameter("orderid");will(returnValue("123456"));
				one(request).getParameter("free");will(returnValue("free"));
				one(request).getParameter("price");will(returnValue("100"));
				one(request).getParameter("ars");will(returnValue("autorizada"));
				one(request).getParameter("tid");will(returnValue("12345678"));
				one(request).getParameter("arp");will(returnValue("1332"));
				one(request).getParameter("bank");will(returnValue("4739856348950"));
				one(request).getParameter("authent");will(returnValue("0"));
			}
		});
		VerificaRetornoIntegracaoViaHttp retornoIntegracaoViaHttp = new VerificaRetornoIntegracaoViaHttp(request,HttpReturnBuilder.CONSULTA_RETORNO_BUILDER);
		ConsultaReturn consultaReturn = (ConsultaReturn)retornoIntegracaoViaHttp.handle();
		
		
	}	
}
