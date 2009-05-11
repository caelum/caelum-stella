package br.com.caelum.stella.gateway.integration;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.caelum.stella.gateway.HtmlViewerHelper;
import br.com.caelum.stella.gateway.core.GatewaysConf;
import br.com.caelum.stella.gateway.pagseguro.PagSeguroCheckout;
import br.com.caelum.stella.gateway.pagseguro.PagSeguroDadosAutorizacaoPagamento;
import br.com.caelum.stella.gateway.pagseguro.PagSeguroDadosCliente;
import br.com.caelum.stella.gateway.pagseguro.PagSeguroDadosConfiguracao;
import br.com.caelum.stella.gateway.pagseguro.PagSeguroItem;
import br.com.caelum.stella.gateway.pagseguro.PagSeguroMoeda;
import br.com.caelum.stella.gateway.pagseguro.PagSeguroSolicitaAutorizacaoPagamento;
import br.com.caelum.stella.gateway.pagseguro.PagSeguroTipoFrete;

public class PagSeguroTestSolicitacaoIntegracao {

	private static PagSeguroDadosConfiguracao configuracao;

	@BeforeClass
	public static void setUp() {
		GatewaysConf conf = new GatewaysConf();
		configuracao = new PagSeguroDadosConfiguracao(conf
				.getPagSeguroUrlComponenteDeAutorizacao(), "123456",
				"teste@teste.com.br", conf.getPagSeguroUrlVerificacaoToken());

	}

	@Test
	public void testSolicitacaoAutorizacaoComFreteESemDadosDoUsuario() {
		PagSeguroCheckout checkout = PagSeguroCheckout.newCheckoutComFrete(
				PagSeguroMoeda.BRASIL_REAL, new HashSet<PagSeguroItem>(),
				"http://www.qqsite.com.br/botao.jpg", "1234567890",
				PagSeguroTipoFrete.SEDEX);
		adicionaItens(checkout);
		criarPaginaDeTeste(checkout,
				"post_dados_pagseguro_frete_sem_dados_cliente.html");
	}

	@Test
	public void testSolicitacaoAutorizacaoComFreteParaUsuarioDecidirESemDadosDoUsuario() {
		PagSeguroCheckout checkout = PagSeguroCheckout
				.newCheckoutComFreteParaUsuarioDecidir(
						PagSeguroMoeda.BRASIL_REAL,
						new HashSet<PagSeguroItem>(),
						"http://www.qqsite.com.br/botao.jpg", "1234567890");
		adicionaItens(checkout);
		criarPaginaDeTeste(checkout,
				"post_dados_pagseguro_sem_frete_sem_dados_cliente.html");
	}

	@Test
	public void testSolicitacaoAutorizacaoComFreteEComDadosDoUsuario() {
		PagSeguroDadosCliente cliente = new PagSeguroDadosCliente("40000000",
				"Salvador", "Av Marques de Caravelas", "Cliente", "BA", "2626",
				"Edf XXX", "Rio Vermelho", "71", "33333333",
				"cliente@email.com.br");
		PagSeguroCheckout checkout = PagSeguroCheckout
				.newCheckoutComFreteEComDadosDoUsuario(
						PagSeguroMoeda.BRASIL_REAL,
						new HashSet<PagSeguroItem>(),
						"http://www.qqsite.com.br/botao.jpg", "1234567890",
						PagSeguroTipoFrete.SEDEX, cliente);
		adicionaItens(checkout);
		criarPaginaDeTeste(checkout,
				"post_dados_pagseguro_frete_com_dados_cliente.html");
	}

	@Test
	public void testSolicitacaoAutorizacaoComFreteParaUsuarioDecidirEComDadosDoUsuario() {
		PagSeguroDadosCliente cliente = new PagSeguroDadosCliente("40000000",
				"Salvador", "Av Marques de Caravelas", "Cliente", "BA", "2626",
				"Edf XXX", "Rio Vermelho", "71", "33333333",
				"cliente@email.com.br");
		PagSeguroCheckout checkout = PagSeguroCheckout
				.newCheckoutComFreteParaUsuarioDecidirEComDadosDoUsuario(
						PagSeguroMoeda.BRASIL_REAL,
						new HashSet<PagSeguroItem>(),
						"http://www.qqsite.com.br/botao.jpg", "1234567890",
						cliente);
		adicionaItens(checkout);
		criarPaginaDeTeste(checkout,
				"post_dados_pagseguro_sem_frete_com_dados_cliente.html");
	}

	private void adicionaItens(PagSeguroCheckout checkout) {
		checkout
				.adicionaItem(
						new PagSeguroItem("123", "produto1", 2, BigDecimal.TEN))
				.adicionaItem(
						new PagSeguroItem("1234", "produto2", 3, BigDecimal.ONE));
	}

	private void criarPaginaDeTeste(PagSeguroCheckout checkout,
			String nomeArquivo) {
		PagSeguroDadosAutorizacaoPagamento dadosAutorizacaoPagamento = new PagSeguroSolicitaAutorizacaoPagamento(
				checkout).handle();

		new HtmlViewerHelper().body("")
				.form(configuracao.getUrlComponenteAutorizacao(), "post",
						"pagamento").createInputsHidden(
						criarCampos(dadosAutorizacaoPagamento))
				.criarPaginaTemporariaNoDisco(
						new File("").getAbsolutePath() + File.separator + "/"
								+ nomeArquivo);

	}

	private Map<String, Object> criarCampos(
			PagSeguroDadosAutorizacaoPagamento pagamento) {
		Map<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("email_cobranca", configuracao.getEmailCobranca());
		mapa.put("tipo", pagamento.getTipo());
		mapa.put("moeda", pagamento.getMoeda());
		mapa.put("moeda", pagamento.getMoeda());
		int i = 1;
		for (PagSeguroItem item : pagamento.getItens()) {
			mapa.put("item_id_" + i, item.getId());
			mapa.put("item_descr_" + i, item.getDescricao());
			mapa.put("item_quant_" + i, item.getQuantidade());
			mapa.put("item_valor_" + i, item.getValorFormatado());
			mapa.put("item_frete_" + i, item.getValorFreteFormatado());
			mapa.put("item_peso_" + i, item.getPesoFormatado());
			i++;
		}
		if (pagamento.hasDadosDoCliente()) {

			mapa.put("cliente_nome", pagamento.getNomeCliente());
			mapa.put("cliente_cep", pagamento.getCep());
			mapa.put("cliente_end", pagamento.getEndereco());
			mapa.put("cliente_num", pagamento.getNumero());
			mapa.put("cliente_compl", pagamento.getComplemento());
			mapa.put("cliente_bairro", pagamento.getBairro());
			mapa.put("cliente_cidade", pagamento.getCidade());
			mapa.put("cliente_uf", pagamento.getEstado());
			mapa.put("cliente_pais", pagamento.getPais());
			mapa.put("cliente_ddd", pagamento.getDdd());
			mapa.put("cliente_tel", pagamento.getTelefone());
			mapa.put("cliente_email", pagamento.getEmail());
		}
		mapa.put("tipo_frete", pagamento.getTipoFrete());
		return mapa;
	}
}
