package br.com.caelum.stella.gateway.integration;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.stella.gateway.core.CartaoCredito;
import br.com.caelum.stella.gateway.core.GatewaysConf;
import br.com.caelum.stella.gateway.visa.Checkout;
import br.com.caelum.stella.gateway.visa.TipoTransacao;
import br.com.caelum.stella.gateway.visa.Parcelamento;
import br.com.caelum.stella.gateway.visa.integration.VISASolicitacaoAutorizacaoPagamentoViaHttp;
import br.com.caelum.stella.gateway.visa.integration.VISASolicitacaoConferenciaViaHttp;
import br.com.caelum.stella.gateway.visa.integration.VISATipoSolicitacaoIntegracao;

public class VISATestSolicitacaoDeIntegracaoComComponente {

	/*
	 * Precisa configurar um ambiente correto para testar isso aqui
	 */

	private static Checkout checkout;
	private static GatewaysConf gatewaysConf = new GatewaysConf();

	@BeforeClass
	public static void before() {
		Calendar dataQueExpira = Calendar.getInstance();
		dataQueExpira.set(Calendar.MONTH, Calendar.DECEMBER + 1);
		dataQueExpira.set(Calendar.YEAR, 2010);
		checkout = new Checkout("123456",
				"Alberto Souza, Av Juracy Magalhaes,Salvador,Bahia,Brasil",
				"Testando checkout", BigDecimal.ONE, new Parcelamento(
						TipoTransacao.CREDITO_A_VISTA, 1), new CartaoCredito(
						"4551870000000183", dataQueExpira, "123"));
	}

	/**
	 * Configurar o test aqui vai ser uma arte... tem que ter ip fixo e não sei
	 * o que lá... Para testar mockado, eu teria que criar uma classe que se
	 * comportasse como o componente... vou pensar no assunto
	 * 
	 */
	@Test
	public void testSolicitacaoDeAutorizacaoDePagamento() {
		String telaDeResultadoQueDeveSerApresentadaAoCliente = new VISASolicitacaoAutorizacaoPagamentoViaHttp(
				checkout).handle();		
		System.out.println(telaDeResultadoQueDeveSerApresentadaAoCliente);
	}


	public void testSolicitacaoDeCaptura() {
		String retorno = new VISASolicitacaoConferenciaViaHttp(checkout.getTid(
				Calendar.getInstance(), gatewaysConf
						.getNumeroDeFiliacaoDoVisa()),
				VISATipoSolicitacaoIntegracao.CAPTURA).handle();
		System.out.println(retorno);
	}

	public void testSolicitacaoDeCancelamento() {
		String retorno = new VISASolicitacaoConferenciaViaHttp(checkout.getTid(
				Calendar.getInstance(), gatewaysConf
						.getNumeroDeFiliacaoDoVisa()),
				VISATipoSolicitacaoIntegracao.CANCELAMENTO).handle();
		System.out.println(retorno);
	}

	public void testSolicitacaoDeConsulta() {
		String retorno = new VISASolicitacaoConferenciaViaHttp(checkout.getTid(
				Calendar.getInstance(), gatewaysConf
						.getNumeroDeFiliacaoDoVisa()),
				VISATipoSolicitacaoIntegracao.CONSULTA).handle();
		System.out.println(retorno);
	}

}
