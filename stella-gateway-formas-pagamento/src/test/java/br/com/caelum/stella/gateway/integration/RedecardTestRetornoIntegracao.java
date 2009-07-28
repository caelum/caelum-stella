package br.com.caelum.stella.gateway.integration;

import javax.servlet.http.HttpServletRequest;

import junit.framework.Assert;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import br.com.caelum.stella.gateway.core.ProblematicTransactionException;
import br.com.caelum.stella.gateway.redecard.RedecardAutorizacaoReturn;
import br.com.caelum.stella.gateway.redecard.RedecardConfirmacaoSemDadosException;
import br.com.caelum.stella.gateway.redecard.RedecardConfirmacaoTransacaoReturn;
import br.com.caelum.stella.gateway.redecard.RedecardIdiomaOperacao;
import br.com.caelum.stella.gateway.redecard.RedecardVerificaRetornoAutorizacao;
import br.com.caelum.stella.gateway.redecard.RedecardVerificadorRetornoConfirmacaoTransacao;

public class RedecardTestRetornoIntegracao {

	@Test
	public void testVerificaRetornoValidoDaTransacao() {
		Mockery mockery = new Mockery();
		final HttpServletRequest request = mockery
				.mock(HttpServletRequest.class);
		mockery.checking(new Expectations() {
			{
				one(request).getParameter("DATA");
				will(returnValue("20090320"));
				one(request).getParameter("NUMPEDIDO");
				will(returnValue("123456"));
				one(request).getParameter("NR_CARTAO");
				will(returnValue("1234567890123456"));
				one(request).getParameter("ORIGEM_BIN");
				will(returnValue("BRA"));
				one(request).getParameter("NUMAUTOR");
				will(returnValue("123456"));
				one(request).getParameter("NUMCV");
				will(returnValue("123456789"));
				one(request).getParameter("NUMAUTENT");
				will(returnValue("463294639534953535657687"));
				one(request).getParameter("NUMSQN");
				will(returnValue("123456789012"));
				one(request).getParameter("CODRET");
				will(returnValue(null));
				one(request).getParameter("MSGRET");
				will(returnValue("TRANSAÇÃO APROVADA"));
			}
		});
		RedecardAutorizacaoReturn autorizacaoReturn = new RedecardVerificaRetornoAutorizacao(
				request,RedecardIdiomaOperacao.INGLES).handle();
		Assert.assertEquals("20090320", autorizacaoReturn.getDataFormatada());
		Assert.assertEquals(autorizacaoReturn.getCodigoRetorno(), 0);
	}

	@Test
	public void testVerificaRetornoInvalidoDaTransacao() {
		Mockery mockery = new Mockery();
		final HttpServletRequest request = mockery
				.mock(HttpServletRequest.class);
		mockery.checking(new Expectations() {
			{
				one(request).getParameter("DATA");
				will(returnValue("20090320"));
				one(request).getParameter("NUMPEDIDO");
				will(returnValue("123456"));
				one(request).getParameter("NR_CARTAO");
				will(returnValue("1234567890123456"));
				one(request).getParameter("ORIGEM_BIN");
				will(returnValue("BRA"));
				one(request).getParameter("NUMAUTOR");
				will(returnValue("123456"));
				one(request).getParameter("NUMCV");
				will(returnValue("123456789"));
				one(request).getParameter("NUMAUTENT");
				will(returnValue("463294639534953535657687"));
				one(request).getParameter("NUMSQN");
				will(returnValue("123456789012"));
				one(request).getParameter("CODRET");
				will(returnValue("55"));
				one(request).getParameter("MSGRET");
				will(returnValue("TRANSAÇÃO NÃO APROVADA"));
			}
		});
		try {
			new RedecardVerificaRetornoAutorizacao(request,RedecardIdiomaOperacao.INGLES).handle();
		} catch (ProblematicTransactionException problematicTransactionException) {
			Assert.assertEquals("TRANSAÇÃO NÃO APROVADA",
					problematicTransactionException.getMessage());
		}
	}

	@Test
	public void testVerificadorDeRetornoDaConfirmacaoDaTransacao() {
		String retorno = "CODRET=0&MSGRET=CONFIRMACAO COM SUCESSO";
		RedecardConfirmacaoTransacaoReturn confirmacaoTransacaoReturn = new RedecardVerificadorRetornoConfirmacaoTransacao(
				retorno).verificaRetorno();
		Assert.assertEquals(confirmacaoTransacaoReturn.getCodigoRetorno(), 0);
		Assert.assertEquals(confirmacaoTransacaoReturn.getMensagemRetorno(),
				"CONFIRMACAO COM SUCESSO");
	}

	@Test(expected = RedecardConfirmacaoSemDadosException.class)
	public void testVerificadorDeRetornoDaConfirmacaoDaTransacaoCasoOsDadosDeRetornoNaoSejamRetornados() {
		String retorno = "";
		RedecardConfirmacaoTransacaoReturn confirmacaoTransacaoReturn = new RedecardVerificadorRetornoConfirmacaoTransacao(
				retorno).verificaRetorno();
		Assert.assertEquals(confirmacaoTransacaoReturn.getCodigoRetorno(), 0);
		Assert.assertEquals(confirmacaoTransacaoReturn.getMensagemRetorno(),
				"CONFIRMACAO COM SUCESSO");
	}
	
}
