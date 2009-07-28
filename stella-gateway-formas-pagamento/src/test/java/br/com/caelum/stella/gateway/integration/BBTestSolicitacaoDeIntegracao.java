package br.com.caelum.stella.gateway.integration;

import java.io.File;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.stella.gateway.HtmlViewerHelper;
import br.com.caelum.stella.gateway.SeleniumHelper;
import br.com.caelum.stella.gateway.bb.BBDadosAutorizacaoPagamento;
import br.com.caelum.stella.gateway.bb.BBSolicitaAutorizacaoPagamento;
import br.com.caelum.stella.gateway.bb.BBCheckout;
import br.com.caelum.stella.gateway.bb.BBTipoTransacao;
import br.com.caelum.stella.gateway.core.DadosComprador;
import br.com.caelum.stella.gateway.core.GatewaysConf;

/**
 * Os testes estão gerando paginas html que fazem a comunicação com a forma de pagamento. 
 * @author Alberto Pc
 *
 */
public class BBTestSolicitacaoDeIntegracao {
	/*
	 * tenho que tentar abrir o browser corretamente ainda.
	 */
	
	private static SeleniumHelper seleniumHelper;
	private static String pathPastaPagina;

	@BeforeClass
	public static void setUp() throws Exception {
		pathPastaPagina = new File("").getAbsolutePath() + File.separator;
		// seleniumHelper.iniciarSelenium().configurarContextoDoTeste("file:///"+pathPastaPagina,"Testando integracao com Komerci");
	}

	@Test
	public void testSolicitarPagamentoComBoleto() throws Exception{
		BBCheckout checkout = new BBCheckout(BigDecimal.TEN,
				Calendar.getInstance(), BBTipoTransacao.BLOQUETO_BANCARIO,
				new DadosComprador("41900000", "Salvador", "Endereco de teste",
						"Alberto", "BA"), "Mensagem de teste", "123");
		// o numero a ser anexado pode ser diferente do numero do pedido
		BBDadosAutorizacaoPagamento dadosAutorizacaoPagamento = new BBSolicitaAutorizacaoPagamento(
				checkout, checkout.getNumeroDoPedido(), new Object[] { checkout
						.getNumeroDoPedido() }, new Object[] { checkout
						.getNumeroDoPedido() }).handle();
		HtmlViewerHelper htmlViewerHelper = new HtmlViewerHelper();
		Map<String, Object> fields = criarMapaComCampos(dadosAutorizacaoPagamento);
		htmlViewerHelper.body(
				"onload=document.getElementById('pagamento').submit();").form(
				new GatewaysConf().getBBUrlComponenteDeAutorizacao(), "post",
				"pagamento").createInputsHidden(fields)
				.criarPaginaTemporariaNoDisco(
						pathPastaPagina + "/post_dados_bb_bloqueto.html");

	}
	
	@Test
	public void testSolicitarPagamentoComDebito() throws Exception{
		BBCheckout checkout = new BBCheckout(BigDecimal.TEN,
				Calendar.getInstance(), BBTipoTransacao.DEBITO_EM_CONTA,
				new DadosComprador("41900000", "Salvador", "Endereco de teste",
						"Alberto", "BA"), "Mensagem de teste", "12345");
		// o numero a ser anexado pode ser diferente do numero do pedido
		BBDadosAutorizacaoPagamento dadosAutorizacaoPagamento = new BBSolicitaAutorizacaoPagamento(
				checkout, checkout.getNumeroDoPedido(), new Object[] { checkout
						.getNumeroDoPedido() }, new Object[] { checkout
						.getNumeroDoPedido() }).handle();
		HtmlViewerHelper htmlViewerHelper = new HtmlViewerHelper();
		Map<String, Object> fields = criarMapaComCampos(dadosAutorizacaoPagamento);
		htmlViewerHelper.body(
				"onload=document.getElementById('pagamento').submit();").form(
				new GatewaysConf().getBBUrlComponenteDeAutorizacao(), "post",
				"pagamento").createInputsHidden(fields)
				.criarPaginaTemporariaNoDisco(
						pathPastaPagina + "/post_dados_bb_debito.html");

	}
	
	@Test
	public void testSolicitarPagamentoComCrediario() throws Exception{
		BBCheckout checkout = new BBCheckout(BigDecimal.TEN,
				Calendar.getInstance(), BBTipoTransacao.CREDIARIO_INTERNET,
				new DadosComprador("41900000", "Salvador", "Endereco de teste",
						"Alberto", "BA"), "Mensagem de teste", "12345");
		// o numero a ser anexado pode ser diferente do numero do pedido
		BBDadosAutorizacaoPagamento dadosAutorizacaoPagamento = new BBSolicitaAutorizacaoPagamento(
				checkout, checkout.getNumeroDoPedido(), new Object[] { checkout
						.getNumeroDoPedido() }, new Object[] { checkout
						.getNumeroDoPedido() }).handle();
		HtmlViewerHelper htmlViewerHelper = new HtmlViewerHelper();
		Map<String, Object> fields = criarMapaComCampos(dadosAutorizacaoPagamento);
		htmlViewerHelper.body(
				"onload=document.getElementById('pagamento').submit();").form(
				new GatewaysConf().getBBUrlComponenteDeAutorizacao(), "post",
				"pagamento").createInputsHidden(fields)
				.criarPaginaTemporariaNoDisco(
						pathPastaPagina + "/post_dados_bb_crediario.html");

	}
	

	private Map<String, Object> criarMapaComCampos(
			BBDadosAutorizacaoPagamento dadosAutorizacaoPagamento) {
		Map<String, Object> fields = new HashMap<String, Object>();
		fields.put("idConv", dadosAutorizacaoPagamento.getIdConv());
		fields.put("refTran", dadosAutorizacaoPagamento.getRefTran());
		fields.put("valor", dadosAutorizacaoPagamento.getValorFormatado());
		fields.put("dtVenc", dadosAutorizacaoPagamento
				.getDataVencimentoFormatada());
		fields.put("tpPagamento", dadosAutorizacaoPagamento.getTipoTransacao());
		fields.put("urlRetorno", dadosAutorizacaoPagamento.getUrlRetornoFormatada());
		fields.put("urlInforma", dadosAutorizacaoPagamento.getUrlInformaFormatada());
		fields.put("nome", dadosAutorizacaoPagamento.getNome());
		fields.put("endereco", dadosAutorizacaoPagamento.getEndereco());
		fields.put("cidade", dadosAutorizacaoPagamento.getCidade());
		fields.put("uf", dadosAutorizacaoPagamento.getEstado());
		fields.put("cep", dadosAutorizacaoPagamento.getCep());
		fields.put("msgLoja", dadosAutorizacaoPagamento.getMensagemLoja());
		return fields;
	}

}
