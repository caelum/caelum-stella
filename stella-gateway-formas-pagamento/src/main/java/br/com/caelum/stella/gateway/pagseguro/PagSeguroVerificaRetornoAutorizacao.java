package br.com.caelum.stella.gateway.pagseguro;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.stella.gateway.core.BigDecimalFormatter;
import br.com.caelum.stella.gateway.core.CalendarFormatter;
import br.com.caelum.stella.gateway.core.EnumComCodigoFinder;
import br.com.caelum.stella.gateway.core.IntegrationHandler;

/**
 * Classe para montar o retorno baseado na requisição do PagSeguro.
 * 
 * @author Alberto Pc
 * 
 */
public class PagSeguroVerificaRetornoAutorizacao implements
		IntegrationHandler<PagSeguroAutorizacaoReturn> {
	private HttpServletRequest request;
	private PagSeguroVerificadorRetorno verificadorRetorno;
	private PagSeguroDadosConfiguracao dadosConfiguracao;
	private final RemoverAcentos removedorAcentos = new RemoverAcentos();

	public PagSeguroVerificaRetornoAutorizacao(HttpServletRequest request,
			PagSeguroVerificadorRetorno pagSeguroVerificadorRetorno,
			PagSeguroDadosConfiguracao dadosConfiguracao) {
		this.request = request;
		this.verificadorRetorno = pagSeguroVerificadorRetorno;
		this.dadosConfiguracao = dadosConfiguracao;
	}

	public PagSeguroVerificaRetornoAutorizacao(HttpServletRequest request,
			PagSeguroVerificadorRetorno verificadorRetorno) {
		this(request, verificadorRetorno, new PagSeguroDadosConfiguracao());
	}

	public PagSeguroAutorizacaoReturn handle() {
		// TODO Auto-generated method stub
		String transacaoId = request.getParameter("TransacaoID");
		if (transacaoId != null && !"".equals(transacaoId)) {
			if (verificadorRetorno
					.verificaSeRetornoFoiEnviadoPelaPagSeguro(dadosConfiguracao)) {
				String emailVendedor = request.getParameter("VendedorEmail");
				String referencia = request.getParameter("Referencia");
				EnumComCodigoFinder enumFinder = new EnumComCodigoFinder();
				PagSeguroTipoFrete tipoFrete = enumFinder
						.descobreAEnumPeloCodigo(PagSeguroTipoFrete.class,
								request.getParameter("TipoFrete"));
				BigDecimal valorTotalFrete = transformaValorComVirgulaParaBigDecimal(request
						.getParameter("ValorFrete"));
				String anotacao = request.getParameter("Anotacao");
				Calendar dataTransacao = new CalendarFormatter()
						.stringToCalendar(
								request.getParameter("DataTransacao"),
								"dd/MM/yyyy HH:mm:ss");
				PagSeguroTipoPagamento tipoPagamento = enumFinder
						.descobreAEnumPeloCodigo(PagSeguroTipoPagamento.class,
								removeAcentoEDeixarComLetraMaiscula(request
										.getParameter("TipoPagamento")));
				PagSeguroStatusTransacao statusTransacao = enumFinder
						.descobreAEnumPeloCodigo(
								PagSeguroStatusTransacao.class,
								removeAcentoEDeixarComLetraMaiscula(request
										.getParameter("StatusTransacao")));
				PagSeguroDadosCliente dadosCliente = criarDadosCliente();
				int numeroItens = Integer.valueOf(request
						.getParameter("NumItens"));
				Collection<PagSeguroItem> itens = montaItensDoCarrinho(numeroItens);
				PagSeguroCheckout checkout = new PagSeguroCheckout(referencia,
						tipoFrete, dadosCliente, itens);
				PagSeguroAutorizacaoReturn autorizacaoReturn = new PagSeguroAutorizacaoReturn(
						dadosConfiguracao, transacaoId, checkout,
						valorTotalFrete, anotacao, dataTransacao,
						tipoPagamento, statusTransacao);
				return autorizacaoReturn;

			} else {
				throw new PagSeguroRequisicaoInvalidaException(
						"Provavelmente foi realizada uma requisição maliciosa para aprovar a compra ");
			}

		}
		throw new NaoEhRoboPagSeguroException("A requisição foi feita a partir do browser.");

	}

	private Collection<PagSeguroItem> montaItensDoCarrinho(int numeroItens) {
		Collection<PagSeguroItem> itens = new ArrayList<PagSeguroItem>();
		for (int i = 1; i <= numeroItens; i++) {
			PagSeguroItem item = new PagSeguroItem(request
					.getParameter("ProdID_" + i), request
					.getParameter("ProdDescricao_" + i), Integer
					.valueOf(request.getParameter("ProdQuantidade_" + i)),
					new BigDecimalFormatter().stringInCentsToBigDecimal(request
							.getParameter("ProdValor_" + i)),
					transformaValorComVirgulaParaBigDecimal(request
							.getParameter("ProdFrete_" + i)),

					transformaValorComVirgulaParaBigDecimal(request
							.getParameter("ProdExtras_" + i)));
			itens.add(item);
		}
		return itens;
	}

	private PagSeguroDadosCliente criarDadosCliente() {
		String[] telefoneCompletoComDDD = request.getParameter("CliTelefone")
				.split(" ");
		return new PagSeguroDadosCliente(request.getParameter("CliCEP"),
				request.getParameter("CliCidade"), request
						.getParameter("CliEndereco"), request
						.getParameter("CliNome"), request
						.getParameter("CliEstado"), request
						.getParameter("CliNumero"), request
						.getParameter("CliComplemento"), request
						.getParameter("CliBairro"), telefoneCompletoComDDD[0],
				telefoneCompletoComDDD[1], request.getParameter("CliEmail"));
	}

	private BigDecimal transformaValorComVirgulaParaBigDecimal(String valor) {
		return new BigDecimal(valor.replace(",", ".")).setScale(
				BigDecimalFormatter.SCALE, BigDecimalFormatter.ROUNDING_MODE);
	}

	private String removeAcentoEDeixarComLetraMaiscula(String valor) {
		return removedorAcentos.remover(valor).toUpperCase();
	}
}
