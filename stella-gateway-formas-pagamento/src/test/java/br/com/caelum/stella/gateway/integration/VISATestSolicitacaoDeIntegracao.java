package br.com.caelum.stella.gateway.integration;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.stella.gateway.core.CartaoCredito;
import br.com.caelum.stella.gateway.core.GatewaysConf;
import br.com.caelum.stella.gateway.visa.VISACheckout;
import br.com.caelum.stella.gateway.visa.VISATipoTransacao;
import br.com.caelum.stella.gateway.visa.VISAFormaPagamento;
import br.com.caelum.stella.gateway.visa.VISASolicitacaoAutorizacaoPagamentoViaHttp;
import br.com.caelum.stella.gateway.visa.VISASolicitacaoConferenciaViaHttp;
import br.com.caelum.stella.gateway.visa.VISATipoSolicitacaoIntegracao;

public class VISATestSolicitacaoDeIntegracao {

	/*
	 * Precisa configurar um ambiente correto para testar isso aqui
	 */

	private static VISACheckout checkout;
	private static GatewaysConf gatewaysConf = new GatewaysConf();
	private static final long NUMERO_FILIACAO_TESTE = 1001734898;

	@BeforeClass
	public static void before() {
		Calendar dataQueExpira = Calendar.getInstance();
		dataQueExpira.set(Calendar.MONTH, Calendar.DECEMBER + 1);
		dataQueExpira.set(Calendar.YEAR, 2010);
		checkout = new VISACheckout("123456",
				"Alberto Souza, Av Juracy Magalhaes,Salvador,Bahia,Brasil",
				"Testando checkout", BigDecimal.ONE, new VISAFormaPagamento(
						VISATipoTransacao.CREDITO_A_VISTA, 1), new CartaoCredito(
						4551870000000183l, dataQueExpira, 123));
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
				Calendar.getInstance(),NUMERO_FILIACAO_TESTE),
				VISATipoSolicitacaoIntegracao.CAPTURA).handle();
		System.out.println(retorno);
	}

	public void testSolicitacaoDeCancelamento() {
		String retorno = new VISASolicitacaoConferenciaViaHttp(checkout.getTid(
				Calendar.getInstance(),NUMERO_FILIACAO_TESTE),
				VISATipoSolicitacaoIntegracao.CANCELAMENTO).handle();
		System.out.println(retorno);
	}

	public void testSolicitacaoDeConsulta() {
		String retorno = new VISASolicitacaoConferenciaViaHttp(checkout.getTid(
				Calendar.getInstance(),NUMERO_FILIACAO_TESTE),
				VISATipoSolicitacaoIntegracao.CONSULTA).handle();
		System.out.println(retorno);
	}

}
