package br.com.caelum.stella.gateway.integration;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import junit.framework.Assert;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.stella.gateway.CalendarCompareHelper;
import br.com.caelum.stella.gateway.core.BigDecimalFormatter;
import br.com.caelum.stella.gateway.pagseguro.NaoEhRoboPagSeguroException;
import br.com.caelum.stella.gateway.pagseguro.PagSeguroRequisicaoInvalidaException;
import br.com.caelum.stella.gateway.pagseguro.PagSeguroAutorizacaoReturn;
import br.com.caelum.stella.gateway.pagseguro.PagSeguroDadosConfiguracao;
import br.com.caelum.stella.gateway.pagseguro.PagSeguroStatusTransacao;
import br.com.caelum.stella.gateway.pagseguro.PagSeguroTipoFrete;
import br.com.caelum.stella.gateway.pagseguro.PagSeguroTipoPagamento;
import br.com.caelum.stella.gateway.pagseguro.PagSeguroVerificaRetornoAutorizacao;
import br.com.caelum.stella.gateway.pagseguro.PagSeguroVerificadorRetorno;

public class PagSeguroTestRetornoIntegracao {

	private Mockery mockery;
	private PagSeguroVerificadorRetorno verificadorRetorno;
	private HttpServletRequest request;
	private static final PagSeguroDadosConfiguracao configuracao = new PagSeguroDadosConfiguracao();

	@Before
	public void prepareMocks() {
		mockery = new Mockery();
		request = mockery.mock(HttpServletRequest.class);
		verificadorRetorno = mockery.mock(PagSeguroVerificadorRetorno.class);
	}

	@Test(expected = PagSeguroRequisicaoInvalidaException.class)
	public void testSimulacaoDeAprovacaoIndevidaDeCompra() {
		mockery.checking(new Expectations() {
			{
				one(request).getParameter("TransacaoID");
				will(returnValue("123456"));
				one(verificadorRetorno)
						.verificaSeRetornoFoiEnviadoPelaPagSeguro(configuracao);
				will(returnValue(false));
			}

		});
		new PagSeguroVerificaRetornoAutorizacao(request, verificadorRetorno,
				configuracao).handle();
		mockery.assertIsSatisfied();

	}


	@Test(expected = NaoEhRoboPagSeguroException.class)
	public void testRetornoFeitoPeloBrowser() {
		mockery.checking(new Expectations() {
			{
				one(request).getParameter("TransacaoID");
				will(returnValue(""));
			}
		});
		new PagSeguroVerificaRetornoAutorizacao(request, verificadorRetorno,
				configuracao).handle();
	}

	@Test
	public void testRetornoValido() {
		mockery.checking(new Expectations() {
			{
				one(verificadorRetorno)
						.verificaSeRetornoFoiEnviadoPelaPagSeguro(configuracao);
				will(returnValue(true));
				one(request).getParameter("VendedorEmail");
				will(returnValue("vendedor@email.com.br"));
				one(request).getParameter("TransacaoID");
				will(returnValue("123456"));
				one(request).getParameter("Referencia");
				will(returnValue("7654763"));
				one(request).getParameter("TipoFrete");
				will(returnValue("SD"));
				one(request).getParameter("ValorFrete");
				will(returnValue("101,50"));
				one(request).getParameter("Anotacao");
				will(returnValue("qualquer coisa"));
				one(request).getParameter("DataTransacao");
				will(returnValue("25/04/2009 09:14:30"));
				one(request).getParameter("TipoPagamento");
				will(returnValue("CARTAO DE CREDITO"));
				one(request).getParameter("StatusTransacao");
				will(returnValue("EM ANALISE"));
				one(request).getParameter("CliTelefone");
				will(returnValue("71 33468900"));
				one(request).getParameter("CliCEP");
				will(returnValue("41900050"));
				one(request).getParameter("CliCidade");
				will(returnValue("Salvador"));
				one(request).getParameter("CliEndereco");
				will(returnValue("Endereco do cidadao"));
				one(request).getParameter("CliNome");
				will(returnValue("Alberto"));
				one(request).getParameter("CliEstado");
				will(returnValue("BA"));
				one(request).getParameter("CliNumero");
				will(returnValue("2626"));
				one(request).getParameter("CliComplemento");
				will(returnValue("Complementando meus dados"));
				one(request).getParameter("CliBairro");
				will(returnValue("Rio Vermelho"));
				one(request).getParameter("CliEmail");
				will(returnValue("comprador@email.com.br"));
				one(request).getParameter("NumItens");
				will(returnValue("2"));
				for (int i = 1; i <= 2; i++) {
					one(request).getParameter("ProdID_" + i);
					will(returnValue("12345" + i));
					one(request).getParameter("ProdDescricao_" + i);
					will(returnValue("descricao do item " + i));
					one(request).getParameter("ProdQuantidade_" + i);
					will(returnValue(i + ""));
					one(request).getParameter("ProdValor_" + i);
					will(returnValue("1000"));
					one(request).getParameter("ProdFrete_" + i);
					will(returnValue(49 + i + ",25"));
					one(request).getParameter("ProdExtras_" + i);
					will(returnValue("0,00"));
				}

			}

		});
		PagSeguroAutorizacaoReturn autorizacaoReturn = new PagSeguroVerificaRetornoAutorizacao(
				request, verificadorRetorno, configuracao).handle();
		Calendar dataTransacao = Calendar.getInstance();
		dataTransacao.set(Calendar.DAY_OF_MONTH, 25);
		dataTransacao.set(Calendar.MONTH, Calendar.APRIL);
		dataTransacao.set(Calendar.YEAR, 2009);
		dataTransacao.set(Calendar.HOUR_OF_DAY, 9);
		dataTransacao.set(Calendar.MINUTE, 14);
		dataTransacao.set(Calendar.SECOND, 30);
		Assert.assertTrue(new CalendarCompareHelper().compareCalendars(
				dataTransacao, autorizacaoReturn.getDataTransacao()));
		Assert.assertEquals(autorizacaoReturn.getStatusTransacao(),
				PagSeguroStatusTransacao.EM_ANALISE);
		Assert.assertEquals(autorizacaoReturn.getTipoPagamento(),
				PagSeguroTipoPagamento.CARTAO_CREDITO);
		Assert.assertEquals(autorizacaoReturn.getTipoFrete(),
				PagSeguroTipoFrete.SEDEX);
		Assert.assertEquals(new BigDecimal(101.50).setScale(
				BigDecimalFormatter.SCALE, BigDecimalFormatter.ROUNDING_MODE),
				autorizacaoReturn.getValorTotalFrete());
		Assert.assertEquals(new BigDecimal(101.50).setScale(
				BigDecimalFormatter.SCALE, BigDecimalFormatter.ROUNDING_MODE),
				autorizacaoReturn.getValorTotalFreteCheckout());
		Assert.assertEquals(new BigDecimal(20).setScale(
				BigDecimalFormatter.SCALE, BigDecimalFormatter.ROUNDING_MODE),
				autorizacaoReturn.getValorTotalItens());
		mockery.assertIsSatisfied();

	}

}
