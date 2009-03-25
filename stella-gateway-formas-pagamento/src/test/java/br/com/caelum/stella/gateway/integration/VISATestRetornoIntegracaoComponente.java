package br.com.caelum.stella.gateway.integration;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import junit.framework.Assert;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.gateway.visa.integration.VISAAutorizacaoReturn;
import br.com.caelum.stella.gateway.visa.integration.VISACancelamentoReturn;
import br.com.caelum.stella.gateway.visa.integration.VISACapturaReturn;
import br.com.caelum.stella.gateway.visa.integration.VISAConsultaReturn;
import br.com.caelum.stella.gateway.visa.integration.VISAHttpReturnBuilder;
import br.com.caelum.stella.gateway.visa.integration.VISAVerificacaoRetornoAutorizacaoViaHttp;

public class VISATestRetornoIntegracaoComponente {

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
		VISAVerificacaoRetornoAutorizacaoViaHttp retornoIntegracaoViaHttp = new VISAVerificacaoRetornoAutorizacaoViaHttp(request,VISAHttpReturnBuilder.AUTORIZACAO_RETORNO_BUILDER);
		VISAAutorizacaoReturn autorizacaoReturn = (VISAAutorizacaoReturn)retornoIntegracaoViaHttp.handle();
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
		VISAVerificacaoRetornoAutorizacaoViaHttp retornoIntegracaoViaHttp = new VISAVerificacaoRetornoAutorizacaoViaHttp(request,VISAHttpReturnBuilder.CAPTURA_RETORNO_BUILDER);
		VISACapturaReturn capturaReturn = (VISACapturaReturn)retornoIntegracaoViaHttp.handle();
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
		VISAVerificacaoRetornoAutorizacaoViaHttp retornoIntegracaoViaHttp = new VISAVerificacaoRetornoAutorizacaoViaHttp(request,VISAHttpReturnBuilder.CANCELAMENTO_RETORNO_BUILDER);
		VISACancelamentoReturn cancelamentoReturn = (VISACancelamentoReturn)retornoIntegracaoViaHttp.handle();
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
		VISAVerificacaoRetornoAutorizacaoViaHttp retornoIntegracaoViaHttp = new VISAVerificacaoRetornoAutorizacaoViaHttp(request,VISAHttpReturnBuilder.CONSULTA_RETORNO_BUILDER);
		VISAConsultaReturn consultaReturn = (VISAConsultaReturn)retornoIntegracaoViaHttp.handle();
		
		
	}	
}
