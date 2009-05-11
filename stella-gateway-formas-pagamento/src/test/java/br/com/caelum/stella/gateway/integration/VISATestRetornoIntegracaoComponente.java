package br.com.caelum.stella.gateway.integration;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import junit.framework.Assert;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.gateway.visa.VISAAutorizacaoReturn;
import br.com.caelum.stella.gateway.visa.VISACancelamentoReturn;
import br.com.caelum.stella.gateway.visa.VISACapturaReturn;
import br.com.caelum.stella.gateway.visa.VISAConsultaReturn;
import br.com.caelum.stella.gateway.visa.VISAHttpReturnBuilder;
import br.com.caelum.stella.gateway.visa.VISAVerificacaoRetornoIntegracaoViaHttp;

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
				one(request).getParameter("Price");will(returnValue("100"));
				one(request).getParameter("ars");will(returnValue("autorizada"));
				one(request).getParameter("tid");will(returnValue("12345678"));
				one(request).getParameter("arp");will(returnValue("1332"));
				one(request).getParameter("Pan");will(returnValue("4739856348950"));				
			}
		});
		VISAVerificacaoRetornoIntegracaoViaHttp retornoIntegracaoViaHttp = new VISAVerificacaoRetornoIntegracaoViaHttp(request,VISAHttpReturnBuilder.AUTORIZACAO_RETORNO_BUILDER);
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
		VISAVerificacaoRetornoIntegracaoViaHttp retornoIntegracaoViaHttp = new VISAVerificacaoRetornoIntegracaoViaHttp(request,VISAHttpReturnBuilder.CAPTURA_RETORNO_BUILDER);
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
						
				one(request).getParameter("ars");will(returnValue("autorizada"));
				one(request).getParameter("tid");will(returnValue("12345678"));				
			}
		});
		VISAVerificacaoRetornoIntegracaoViaHttp retornoIntegracaoViaHttp = new VISAVerificacaoRetornoIntegracaoViaHttp(request,VISAHttpReturnBuilder.CANCELAMENTO_RETORNO_BUILDER);
		VISACancelamentoReturn cancelamentoReturn = (VISACancelamentoReturn)retornoIntegracaoViaHttp.handle();
		
		
	}	
	
	@Test
	public void testRetornoConsulta(){
		Mockery mockery = new Mockery();
		final HttpServletRequest request = mockery.mock(HttpServletRequest.class);
		mockery.checking(new Expectations(){
			{
				one(request).getParameter("lr");will(returnValue("00"));
				one(request).getParameter("orderid");will(returnValue("123456"));
				one(request).getParameter("free");will(returnValue("free"));
				one(request).getParameter("price");will(returnValue("100"));
				one(request).getParameter("ars");will(returnValue("autorizada"));
				one(request).getParameter("tid");will(returnValue("12345678"));
				one(request).getParameter("arp");will(returnValue("1332"));
				one(request).getParameter("bank");will(returnValue("4739"));
				one(request).getParameter("Authent");will(returnValue("0"));
			}
		});
		VISAVerificacaoRetornoIntegracaoViaHttp retornoIntegracaoViaHttp = new VISAVerificacaoRetornoIntegracaoViaHttp(request,VISAHttpReturnBuilder.CONSULTA_RETORNO_BUILDER);
		VISAConsultaReturn consultaReturn = (VISAConsultaReturn)retornoIntegracaoViaHttp.handle();
		
		
	}	
}
