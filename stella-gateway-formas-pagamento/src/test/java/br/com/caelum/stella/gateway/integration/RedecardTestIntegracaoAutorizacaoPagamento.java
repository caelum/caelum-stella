package br.com.caelum.stella.gateway.integration;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.net.Socket;

import javax.servlet.http.HttpServletRequest;

import junit.framework.Assert;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.server.SeleniumServer;

import br.com.caelum.seleniumdsl.Browser;
import br.com.caelum.seleniumdsl.DefaultBrowser;
import br.com.caelum.stella.gateway.core.GatewaysConf;
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

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class RedecardTestIntegracaoAutorizacaoPagamento {

	private static Checkout checkout;
	private static Selenium selenium;
	private static SeleniumServer seleniumServer;
	private static String pathPastaPagina;

	@BeforeClass
	public static void setUp() throws Exception {
		pathPastaPagina = new File("").getAbsolutePath()+File.separator;
		checkout = new Checkout(BigDecimal.ONE, Parcelamento
				.newParcelamentoAVista(), Bandeira.MASTERCARD, "123456", "");
		subirSeleniumServerEConfigurarContexo();		

	}
	

	private static void subirSeleniumServerEConfigurarContexo() throws Exception{
		SeleniumServer seleniumServer = new SeleniumServer(4444);
		seleniumServer.start();
		selenium = new DefaultSelenium("localhost",4444,"*firefox","file:///"+pathPastaPagina);
		/*
		 * aqui, ele ta abrindo o FF e travando...
		 */
		selenium.start();
		selenium.setContext("Testando abertura de tela do master");		
	}

	public static void shutDown(){
		selenium.stop();
		seleniumServer.stop();
	}
	
	@Test
	public void testSolicitaDeAberturaDeTelaParaAutorizacaoDePagamento() throws Exception {
		/*
		 * talvez esse teste não devesse ficar aqui, mas como ele apenas testa
		 * se a tela foi aberta com sucesso...
		 */
		RedecardDadosAutorizacaoPagamento dadosAutorizacaoPagamento = new RedecardSolicitacaoAutorizacaoPagamento(
				checkout, new Socket().getLocalAddress().getHostAddress())
				.handle();
		abrirPaginaHTMLComOsDadosDeAutorizacao(dadosAutorizacaoPagamento);

	}

	private void abrirPaginaHTMLComOsDadosDeAutorizacao(
			RedecardDadosAutorizacaoPagamento dadosAutorizacaoPagamento) throws Exception {		
		StringBuilder paginaTemporaria = new StringBuilder("<html><body onload=document.getElementById('teste').submit();>");
		paginaTemporaria.append("<form method='post' action='"+new GatewaysConf().getUrlParaComponenteDeAutorizacaoDaRedeCard()+"' name='teste' id='teste'>");
		paginaTemporaria.append(generateInput("TOTAL",dadosAutorizacaoPagamento.getTotalComDuasCasasDecimais()));
		paginaTemporaria.append(generateInput("TRANSACAO",dadosAutorizacaoPagamento.getParcelamento().getTipoTransacao()));
		paginaTemporaria.append(generateInput("PARCELAS",dadosAutorizacaoPagamento.getParcelamento().getNumeroDeParcelasComNoMinimoDoisDigitos()));
		paginaTemporaria.append(generateInput("FILIACAO",dadosAutorizacaoPagamento.getFiliacao()));
		paginaTemporaria.append(generateInput("DISTRIBUIDOR",dadosAutorizacaoPagamento.getFiliacaoDistribuidor()));
		paginaTemporaria.append(generateInput("BANDEIRA",dadosAutorizacaoPagamento.getBandeira()));
		paginaTemporaria.append(generateInput("NUMPEDIDO",dadosAutorizacaoPagamento.getNumeroDoPedido()));
		paginaTemporaria.append(generateInput("PAX1",dadosAutorizacaoPagamento.getPax1()));
		paginaTemporaria.append(generateInput("CODVER",dadosAutorizacaoPagamento.getCodVer()));
		paginaTemporaria.append(generateInput("URLBACK","http://www.acharuma.com.br"));
		paginaTemporaria.append(generateInput("URLCIMA",dadosAutorizacaoPagamento.getUrlCima()));
		paginaTemporaria.append(generateInput("TARGET",dadosAutorizacaoPagamento.getTarget()));
		paginaTemporaria.append("</form> </body> </html>");
		
		File pagina = new File(pathPastaPagina+"post_dados_master.html");
		FileOutputStream writer = new FileOutputStream(pagina);		
		writer.write(paginaTemporaria.toString().getBytes());
		
		Browser browser = new DefaultBrowser(selenium);
		browser.open("post_dados_master.html");		
		browser.currentPage().span("txtDescricao").contains("R$"+dadosAutorizacaoPagamento.getTotalComDuasCasasDecimais()+" à vista");

		
		// TODO Auto-generated method stub

	}
	
	private String generateInput(String name,Object value){
		return "<input type='hidden' name='"+name+"' value='"+value+"'/>";
	}

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
				request).handle();
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
			new RedecardVerificaRetornoAutorizacao(request).handle();
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
	public void testVerificadorDeRetornoDaConfirmacaoDaTransacaoCasoOsDadosDeRetornoNãoSejamRetornados() {
		String retorno = "";
		RedecardConfirmacaoTransacaoReturn confirmacaoTransacaoReturn = new RedecardVerificadorRetornoConfirmacaoTransacao(
				retorno).verificaRetorno();
		Assert.assertEquals(confirmacaoTransacaoReturn.getCodigoRetorno(), 0);
		Assert.assertEquals(confirmacaoTransacaoReturn.getMensagemRetorno(),
				"CONFIRMACAO COM SUCESSO");
	}

}
