package br.com.caelum.stella.gateway.integration;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import br.com.caelum.stella.gateway.HtmlViewerHelper;
import br.com.caelum.stella.gateway.SeleniumHelper;
import br.com.caelum.stella.gateway.amex.AmexCheckout;
import br.com.caelum.stella.gateway.amex.AmexDadosAutorizacaoPagamento;
import br.com.caelum.stella.gateway.amex.AmexDadosConfiguracao;
import br.com.caelum.stella.gateway.amex.AmexFormaPagamento;
import br.com.caelum.stella.gateway.amex.AmexLocale;
import br.com.caelum.stella.gateway.amex.AmexSolicitaAutorizacaoPagamento;
import br.com.caelum.stella.gateway.amex.AmexTipoCartao;
import br.com.caelum.stella.gateway.amex.AmexTipoTransacao;

/**
 * Os testes na verdade estão apenas gerando paginas html que quando abertas
 * fazem comunicação com o Amex.
 * 
 * @author Alberto Pc
 * 
 */
public class AmexTestSolicitacaoIntegracao {

	private static SeleniumHelper seleniumHelper;

	@Test
	public void testSolicitarPagamentoAVista() throws IOException {
		AmexCheckout amexCheckout = new AmexCheckout("12345678", "12345678",
				BigDecimal.TEN, AmexLocale.EN, new AmexFormaPagamento(0,
						AmexTipoTransacao.A_VISTA,
						AmexTipoCartao.AMERICA_EXPRESS));
		AmexDadosAutorizacaoPagamento amexDadosAutorizacaoPagamento = new AmexSolicitaAutorizacaoPagamento(
				amexCheckout).handle();
		Map<String, Object> fields = gerarInputs(amexDadosAutorizacaoPagamento);
		new HtmlViewerHelper().body("").form(
				new AmexDadosConfiguracao().getUrlComponenteAutorizacao(),
				"get", "pagamento").createInputsHidden(fields)
				.criarPaginaTemporariaNoDisco(
						new File("").getAbsolutePath() + File.separator
								+ "/post_dados_amex.html");		

	}

	@Test
	public void testSolicitarPagamentoParcelado() throws IOException {
		AmexCheckout amexCheckout = new AmexCheckout("12345678", "12345678",
				BigDecimal.TEN, AmexLocale.EN, AmexFormaPagamento
						.newPagamentoParceladoJurosLojista(2,
								AmexTipoCartao.AMERICA_EXPRESS));
		AmexDadosAutorizacaoPagamento amexDadosAutorizacaoPagamento = new AmexSolicitaAutorizacaoPagamento(
				amexCheckout).handle();
		Map<String, Object> fields = gerarInputs(amexDadosAutorizacaoPagamento);
		new HtmlViewerHelper().body(
				"onload=document.getElementById('pagamento').submit();").form(
				new AmexDadosConfiguracao().getUrlComponenteAutorizacao(),
				"get", "pagamento").createInputsHidden(fields)
				.criarPaginaTemporariaNoDisco(
						new File("").getAbsolutePath() + File.separator
								+ "/post_dados_amex_parcelado.html");

	}

	private Map<String, Object> gerarInputs(
			AmexDadosAutorizacaoPagamento amexDadosAutorizacaoPagamento) {
		Map<String, Object> fields = new HashMap<String, Object>();
		fields.put("vpc_Version", amexDadosAutorizacaoPagamento
				.getVpc_Version());
		fields.put("vpc_Merchant", amexDadosAutorizacaoPagamento
				.getVpc_Merchant());
		fields.put("vpc_OrderInfo", amexDadosAutorizacaoPagamento
				.getVpc_OrderInfo());
		fields.put("vpc_OrderInfo", amexDadosAutorizacaoPagamento
				.getVpc_OrderInfo());
		fields.put("vpc_Amount", amexDadosAutorizacaoPagamento
				.getVpc_AmountFormatado());
		fields.put("vpc_ReturnURL", amexDadosAutorizacaoPagamento
				.getVpc_ReturnUrl());
		fields.put("vpc_Card", amexDadosAutorizacaoPagamento
				.getFormaPagamento().getTipoCartao());
		fields.put("vpc_Command", amexDadosAutorizacaoPagamento
				.getVpc_Command());
		fields.put("vpc_AccessCode", amexDadosAutorizacaoPagamento
				.getVpc_AcessCode());
		fields.put("vpc_Locale", amexDadosAutorizacaoPagamento.getVpc_Locale());
		fields.put("vpc_MerchTxnRef", amexDadosAutorizacaoPagamento
				.getVpc_MerchTxnRef());
		fields.put("vpc_PaymentPlan", amexDadosAutorizacaoPagamento
				.getFormaPagamento().getTipoTransacao());
		fields.put("vpc_NumPayments", amexDadosAutorizacaoPagamento
				.getFormaPagamento().getNumeroDeParcelasFormatado());
		return fields;
	}
}
