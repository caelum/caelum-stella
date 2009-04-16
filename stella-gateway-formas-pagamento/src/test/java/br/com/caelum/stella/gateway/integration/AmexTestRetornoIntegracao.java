package br.com.caelum.stella.gateway.integration;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import junit.framework.Assert;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.gateway.amex.AmexAutorizacaoReturn;
import br.com.caelum.stella.gateway.amex.AmexTipoCartao;
import br.com.caelum.stella.gateway.amex.AmexVerificaRetornoAutorizacao;
import br.com.caelum.stella.gateway.core.ProblematicTransactionException;

public class AmexTestRetornoIntegracao {

	@Test
	public void testRetornoValido(){
		Mockery mockery = new Mockery();
		final HttpServletRequest request = mockery.mock(HttpServletRequest.class);
		mockery.checking(new Expectations(){
			{				
				one(request).getParameter("vpc_TxnResponseCode");will(returnValue("0"));
				one(request).getParameter("vpc_Message");will(returnValue("Sucesso"));
				one(request).getParameter("vpc_SecureHash");will(returnValue("123456789012345"));
				one(request).getParameter("vpc_Merchant");will(returnValue("123456"));
				one(request).getParameter("vpc_Command");will(returnValue("command"));
				one(request).getParameter("vpc_MerchTxnRef");will(returnValue("123456"));
				one(request).getParameter("vpc_OrderInfo");will(returnValue("123456"));
				one(request).getParameter("vpc_Amount");will(returnValue("1000"));
				one(request).getParameter("vpc_Card");will(returnValue("AE"));
				one(request).getParameter("vpc_AcqResponseCode");will(returnValue("00"));
				one(request).getParameter("vpc_TransactionNo");will(returnValue("2345678787987980890"));
				one(request).getParameter("vpc_BatchNo");will(returnValue("20060115"));
				one(request).getParameter("vpc_ReceiptNo");will(returnValue("RP12345"));
				one(request).getParameter("vpc_AuthorizeId");will(returnValue("2345678787987980890"));
			}
		});		
		AmexAutorizacaoReturn amexAutorizacaoReturn = new AmexVerificaRetornoAutorizacao(request).handle();
		Assert.assertEquals(BigDecimal.TEN.setScale(2),amexAutorizacaoReturn.getVpc_Amount());
		Assert.assertEquals(AmexTipoCartao.AMERICA_EXPRESS,amexAutorizacaoReturn.getVpc_Card());
	}
	
	@Test(expected=ProblematicTransactionException.class)
	public void testRetornoInValido(){
		Mockery mockery = new Mockery();
		final HttpServletRequest request = mockery.mock(HttpServletRequest.class);
		mockery.checking(new Expectations(){
			{				
				one(request).getParameter("vpc_TxnResponseCode");will(returnValue("1"));
				one(request).getParameter("vpc_Message");will(returnValue("Erro"));
				one(request).getParameter("vpc_SecureHash");will(returnValue("123456789012345"));
				one(request).getParameter("vpc_Merchant");will(returnValue("123456"));
				one(request).getParameter("vpc_Command");will(returnValue("command"));
				one(request).getParameter("vpc_MerchTxnRef");will(returnValue("123456"));
				one(request).getParameter("vpc_OrderInfo");will(returnValue("123456"));
				one(request).getParameter("vpc_Amount");will(returnValue("1000"));
				one(request).getParameter("vpc_Card");will(returnValue("AE"));
				one(request).getParameter("vpc_AcqResponseCode");will(returnValue("00"));
				one(request).getParameter("vpc_TransactionNo");will(returnValue("2345678787987980890"));
				one(request).getParameter("vpc_BatchNo");will(returnValue("20060115"));
				one(request).getParameter("vpc_ReceiptNo");will(returnValue("RP12345"));
				one(request).getParameter("vpc_AuthorizeId");will(returnValue("2345678787987980890"));
			}
		});		
		AmexAutorizacaoReturn amexAutorizacaoReturn = new AmexVerificaRetornoAutorizacao(request).handle();
	}	
}
