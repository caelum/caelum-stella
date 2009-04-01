package br.com.caelum.stella.gateway.integration;

import java.io.File;
import java.math.BigDecimal;
import java.net.Socket;
import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.seleniumdsl.Browser;
import br.com.caelum.seleniumdsl.DefaultBrowser;
import br.com.caelum.stella.gateway.HtmlViewerHelper;
import br.com.caelum.stella.gateway.SeleniumHelper;
import br.com.caelum.stella.gateway.core.GatewaysConf;
import br.com.caelum.stella.gateway.redecard.Bandeira;
import br.com.caelum.stella.gateway.redecard.Checkout;
import br.com.caelum.stella.gateway.redecard.FormaPagamento;
import br.com.caelum.stella.gateway.redecard.integration.RedecardDadosAutorizacaoPagamento;
import br.com.caelum.stella.gateway.redecard.integration.RedecardSolicitacaoAutorizacaoPagamento;

public class RedecardTestSolicitacaoDeIntegracao {

	private static Checkout checkout;
	private static SeleniumHelper seleniumHelper;
	private static String pathPastaPagina;

	@BeforeClass
	public static void setUp() throws Exception {
		pathPastaPagina = new File("").getAbsolutePath()+File.separator;
		checkout = new Checkout(BigDecimal.ONE, FormaPagamento
				.newPagamentoAVista(), Bandeira.MASTERCARD, "123456", "");
		//seleniumHelper.iniciarSelenium().configurarContextoDoTeste("file:///"+pathPastaPagina,"Testando integracao com Komerci");		

	}
	
	@AfterClass
	public static void shutDown(){
		//seleniumHelper.finalizar();
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
		HtmlViewerHelper htmlViewerHelper = new HtmlViewerHelper();
		htmlViewerHelper.body("onload=document.getElementById('teste').submit();").form(new GatewaysConf().getRedeCardUrlParaComponenteDeAutorizacao(), "post","teste");				
		HashMap<String,Object> fields = new HashMap<String, Object>();				
		fields.put("TOTAL",dadosAutorizacaoPagamento.getTotalComDuasCasasDecimais());
		fields.put("TRANSACAO",dadosAutorizacaoPagamento.getParcelamento().getTipoTransacao());
		fields.put("PARCELAS",dadosAutorizacaoPagamento.getParcelamento().getNumeroDeParcelasComNoMinimoDoisDigitos());
		fields.put("FILIACAO",dadosAutorizacaoPagamento.getFiliacao());
		fields.put("DISTRIBUIDOR",dadosAutorizacaoPagamento.getFiliacaoDistribuidor());
		fields.put("BANDEIRA",dadosAutorizacaoPagamento.getBandeira());
		fields.put("NUMPEDIDO",dadosAutorizacaoPagamento.getNumeroDoPedido());
		fields.put("PAX1",dadosAutorizacaoPagamento.getPax1());
		fields.put("CODVER",dadosAutorizacaoPagamento.getCodVer());
		fields.put("URLBACK","http://www.acharuma.com.br");
		fields.put("URLCIMA",dadosAutorizacaoPagamento.getUrlCima());
		fields.put("TARGET",dadosAutorizacaoPagamento.getTarget());
		htmlViewerHelper.createInputsHidden(fields).criarPaginaTemporariaNoDisco(pathPastaPagina+"post_dados_master.html");			
		Browser browser = new DefaultBrowser(seleniumHelper.getSelenium());	
		browser.open("post_dados_master.html");		
		browser.currentPage().span("txtDescricao").contains("R$"+dadosAutorizacaoPagamento.getTotalComDuasCasasDecimais()+" à vista");

		
		// TODO Auto-generated method stub

	}
	


}
