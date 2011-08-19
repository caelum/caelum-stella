package br.com.caelum.stella.gateway.integration;

import java.io.File;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.stella.gateway.HtmlViewerHelper;
import br.com.caelum.stella.gateway.visa.TIDGenerator;
import br.com.caelum.stella.gateway.visa.VISACheckout;
import br.com.caelum.stella.gateway.visa.VISADadosAutorizacao;
import br.com.caelum.stella.gateway.visa.VISADadosConferencia;
import br.com.caelum.stella.gateway.visa.VISADadosConfiguracao;
import br.com.caelum.stella.gateway.visa.VISAFormaPagamento;
import br.com.caelum.stella.gateway.visa.VISASolicitaAutorizacaoPagamentoViaHttp;
import br.com.caelum.stella.gateway.visa.VISASolicitacaoConferenciaViaHttp;
import br.com.caelum.stella.gateway.visa.VISATipoSolicitacaoIntegracao;
import br.com.caelum.stella.gateway.visa.VISATipoTransacao;

public class VISATestSolicitacaoDeIntegracao {

	/*
	 * Precisa configurar um ambiente correto para testar isso aqui
	 */

	private static VISACheckout checkout;
	private static VISADadosConfiguracao dadosConfiguracao = new VISADadosConfiguracao();
	private static final long NUMERO_FILIACAO_TESTE = 1001734898;
	private static String tid;

	@BeforeClass
	public static void before() {
		Calendar dataQueExpira = Calendar.getInstance();
		dataQueExpira.set(Calendar.MONTH, Calendar.DECEMBER + 1);
		dataQueExpira.set(Calendar.YEAR, 2010);
		checkout = new VISACheckout("123456",
				"Alberto Souza, Av Juracy Magalhaes,Salvador,Bahia,Brasil",
				"Testando checkout", BigDecimal.ONE, new VISAFormaPagamento(
						VISATipoTransacao.CREDITO_A_VISTA, 1));
		tid = new TIDGenerator().getTid(checkout.getFormaPagamento(), Calendar
				.getInstance(), NUMERO_FILIACAO_TESTE);

	}

	private void gerarPaginaDeTeste(String nomePagina,VISATipoSolicitacaoIntegracao tipoSolicitacaoIntegracao) {
		Map<String, Object> fields = new HashMap<String, Object>();
		fields.put("tid", tid);
		fields.put("merchid", NUMERO_FILIACAO_TESTE + "");
		gerarPaginaDeTeste(nomePagina, tipoSolicitacaoIntegracao,fields);



	}

	
	private void gerarPaginaDeTeste(String nomePagina,VISATipoSolicitacaoIntegracao tipoSolicitacaoIntegracao,Map<String,Object> fields) {
		new HtmlViewerHelper().body("onload=document.getElementById('pagamento').submit()").form(
				tipoSolicitacaoIntegracao.getUrlComponente(),
				"get", "pagamento").createInputsHidden(fields)
				.criarPaginaTemporariaNoDisco(
						new File("").getAbsolutePath() + File.separator + "/"
								+ nomePagina);
	}
	

	@Test
	public void testSolicitacaoDeAutorizacaoDePagamento() {
		VISADadosAutorizacao dadosAutorizacao = new VISASolicitaAutorizacaoPagamentoViaHttp(
				checkout, dadosConfiguracao).handle();
		Map<String,Object> fields = new HashMap<String, Object>();
		fields.put("tid",tid);
		fields.put("order",dadosAutorizacao.getOrder());
		fields.put("orderid",dadosAutorizacao.getOrderId());
		fields.put("free",dadosAutorizacao.getFree());
		fields.put("merchid",dadosConfiguracao.getNomeArquivoConfiguracao());
		fields.put("price",dadosAutorizacao.getValorFormatado());
		gerarPaginaDeTeste("post_visa_autorizacao.html",VISATipoSolicitacaoIntegracao.AUTORIZACAO,fields);

	}

	@Test
	public void testSolicitacaoDeCaptura() {
		VISADadosConferencia dados = new VISASolicitacaoConferenciaViaHttp(tid,
				VISATipoSolicitacaoIntegracao.CAPTURA).handle();
		gerarPaginaDeTeste("post_visa_captura.html",VISATipoSolicitacaoIntegracao.CAPTURA);
	}

	@Test
	public void testSolicitacaoDeCancelamento() {
		VISADadosConferencia dados = new VISASolicitacaoConferenciaViaHttp(tid,
				VISATipoSolicitacaoIntegracao.CANCELAMENTO).handle();
		gerarPaginaDeTeste("post_visa_cancelamento.html",VISATipoSolicitacaoIntegracao.CANCELAMENTO);
	}

	@Test
	public void testSolicitacaoDeConsulta() {
		VISADadosConferencia dados = new VISASolicitacaoConferenciaViaHttp(tid,
				VISATipoSolicitacaoIntegracao.CONSULTA).handle();
		gerarPaginaDeTeste("post_visa_consulta.html",VISATipoSolicitacaoIntegracao.CONSULTA);
	}

}
