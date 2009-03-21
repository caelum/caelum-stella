package br.com.caelum.stella.gateway.integration;

import java.math.BigDecimal;
import java.net.Socket;

import javax.servlet.http.HttpServletRequest;

import junit.framework.Assert;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.BeforeClass;
import org.junit.Test;

import sun.security.krb5.internal.ccache.au;

import br.com.caelum.stella.gateway.core.ProblematicTransactionException;
import br.com.caelum.stella.gateway.redecard.Bandeira;
import br.com.caelum.stella.gateway.redecard.Checkout;
import br.com.caelum.stella.gateway.redecard.Parcelamento;
import br.com.caelum.stella.gateway.redecard.integration.RedecardAutorizacaoReturn;
import br.com.caelum.stella.gateway.redecard.integration.RedecardConfirmacaoSemDadosException;
import br.com.caelum.stella.gateway.redecard.integration.RedecardConfirmacaoTransacaoReturn;
import br.com.caelum.stella.gateway.redecard.integration.RedecardDadosAutorizacaoPagamento;
import br.com.caelum.stella.gateway.redecard.integration.RedecardSolicitacaoAutorizacaoPagamento;
import br.com.caelum.stella.gateway.redecard.integration.RedecardVerificaRetornoAutorizacao;
import br.com.caelum.stella.gateway.redecard.integration.RedecardVerificadorRetornoConfirmacaoTransacao;

public class RedecardTestIntegracaoAutorizacaoPagamento {

	private static Checkout checkout;
	
	@BeforeClass
	public static void setUp(){
		 checkout = new Checkout(BigDecimal.ONE,Parcelamento.newParcelamentoAVista(),Bandeira.MASTERCARD,"123456","");
	}
		
	@Test
	public void testSolicitaDeAberturaDeTelaParaAutorizacaoDePagamento(){			
		RedecardDadosAutorizacaoPagamento dadosAutorizacaoPagamento = new RedecardSolicitacaoAutorizacaoPagamento(checkout,new Socket().getLocalAddress().getHostAddress()).handle();
		abrirPaginaHTMLComOsDadosDeAutorizacao(dadosAutorizacaoPagamento);
	}

	private void abrirPaginaHTMLComOsDadosDeAutorizacao(
			RedecardDadosAutorizacaoPagamento dadosAutorizacaoPagamento) {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	public void testVerificaRetornoValidoDaTransacao(){
		Mockery mockery = new Mockery();
		final HttpServletRequest request = mockery.mock(HttpServletRequest.class);
		mockery.checking(new Expectations(){
			{
				one(request).getParameter("DATA");will(returnValue("20090320"));
				one(request).getParameter("NUMPEDIDO");will(returnValue("123456"));
				one(request).getParameter("NR_CARTAO");will(returnValue("1234567890123456"));
				one(request).getParameter("ORIGEM_BIN");will(returnValue("BRA"));
				one(request).getParameter("NUMAUTOR");will(returnValue("123456"));
				one(request).getParameter("NUMCV");will(returnValue("123456789"));
				one(request).getParameter("NUMAUTENT");will(returnValue("463294639534953535657687"));
				one(request).getParameter("NUMSQN");will(returnValue("123456789012"));
				one(request).getParameter("CODRET");will(returnValue("00"));
				one(request).getParameter("MSGRET");will(returnValue("TRANSAÇÃO APROVADA"));
			}
		});		
		RedecardAutorizacaoReturn autorizacaoReturn =  new RedecardVerificaRetornoAutorizacao(request).handle();
		Assert.assertEquals("20090320",autorizacaoReturn.getDataFormatada());
		Assert.assertEquals(autorizacaoReturn.getCodigoRetorno(),0);		
	}
	
	@Test
	public void testVerificaRetornoInvalidoDaTransacao(){
		Mockery mockery = new Mockery();
		final HttpServletRequest request = mockery.mock(HttpServletRequest.class);
		mockery.checking(new Expectations(){
			{
				one(request).getParameter("DATA");will(returnValue("20090320"));
				one(request).getParameter("NUMPEDIDO");will(returnValue("123456"));
				one(request).getParameter("NR_CARTAO");will(returnValue("1234567890123456"));
				one(request).getParameter("ORIGEM_BIN");will(returnValue("BRA"));
				one(request).getParameter("NUMAUTOR");will(returnValue("123456"));
				one(request).getParameter("NUMCV");will(returnValue("123456789"));
				one(request).getParameter("NUMAUTENT");will(returnValue("463294639534953535657687"));
				one(request).getParameter("NUMSQN");will(returnValue("123456789012"));
				one(request).getParameter("CODRET");will(returnValue("55"));
				one(request).getParameter("MSGRET");will(returnValue("TRANSAÇÃO NÃO APROVADA"));
			}
		});		
		try{
			new RedecardVerificaRetornoAutorizacao(request).handle();
		}
		catch(ProblematicTransactionException problematicTransactionException){
			Assert.assertEquals("TRANSAÇÃO NÃO APROVADA",problematicTransactionException.getMessage());
		}
	}
	
	@Test
	public void testVerificadorDeRetornoDaConfirmacaoDaTransacao(){
		String retorno = "CODRET=0&MSGRET=CONFIRMACAO COM SUCESSO";
		RedecardConfirmacaoTransacaoReturn confirmacaoTransacaoReturn = new RedecardVerificadorRetornoConfirmacaoTransacao(retorno).verificaRetorno();
		Assert.assertEquals(confirmacaoTransacaoReturn.getCodigoRetorno(),0);
		Assert.assertEquals(confirmacaoTransacaoReturn.getMensagemRetorno(),"CONFIRMACAO COM SUCESSO");
	}
	
	@Test(expected=RedecardConfirmacaoSemDadosException.class)
	public void testVerificadorDeRetornoDaConfirmacaoDaTransacaoCasoOsDadosDeRetornoNãoSejamRetornados(){
		String retorno = "";
		RedecardConfirmacaoTransacaoReturn confirmacaoTransacaoReturn = new RedecardVerificadorRetornoConfirmacaoTransacao(retorno).verificaRetorno();
		Assert.assertEquals(confirmacaoTransacaoReturn.getCodigoRetorno(),0);
		Assert.assertEquals(confirmacaoTransacaoReturn.getMensagemRetorno(),"CONFIRMACAO COM SUCESSO");
	}	
	
	
}
