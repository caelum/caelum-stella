package br.com.caelum.stella.gateway.pagseguro;

import java.math.BigDecimal;
import java.util.Collection;

import br.com.caelum.stella.gateway.core.BigDecimalFormatter;

public class PagSeguroCheckout {

	private static final String TIPO_POST = "CP";
	private String tipo;
	private PagSeguroMoeda moeda;
	private Collection<PagSeguroItem> itens;
	private String urlBotaoSubmit;
	private String refTransacao;
	private PagSeguroTipoFrete tipoFrete;
	private PagSeguroDadosCliente dadosCliente;

	
	/**
	 * Usado de forma controlada para gerar o PagSeguroAutorizacaoReturn
	 * @param refTransacao
	 * @param tipoFrete
	 * @param dadosCliente
	 * @param itens
	 */
	PagSeguroCheckout(String refTransacao,PagSeguroTipoFrete tipoFrete,PagSeguroDadosCliente dadosCliente,Collection<PagSeguroItem> itens){
		this(null,itens,null,refTransacao,tipoFrete,dadosCliente);
	}
	
	private PagSeguroCheckout(PagSeguroMoeda moeda,
			Collection<PagSeguroItem> itens, String urlBotaoSubmit,
			String refTransacao, PagSeguroTipoFrete tipoFrete,
			PagSeguroDadosCliente dadosCliente) {
		super();
		this.tipo = TIPO_POST;
		this.moeda = moeda;
		this.itens = itens;
		this.urlBotaoSubmit = urlBotaoSubmit;
		this.refTransacao = refTransacao;
		this.tipoFrete = tipoFrete;
		this.dadosCliente = dadosCliente;
	}

	public static PagSeguroCheckout newCheckoutComFreteParaUsuarioDecidir(
			PagSeguroMoeda moeda, Collection<PagSeguroItem> itens,
			String urlBotaoSubmit, String refTransacao) {
		return new PagSeguroCheckout(moeda, itens, urlBotaoSubmit,
				refTransacao, PagSeguroTipoFrete.USUARIO_DECIDE, null);
	}

	public static PagSeguroCheckout newCheckoutComFrete(
			PagSeguroMoeda moeda, Collection<PagSeguroItem> itens,
			String urlBotaoSubmit, String refTransacao,
			PagSeguroTipoFrete tipoFrete) {
		return new PagSeguroCheckout(moeda, itens, urlBotaoSubmit,
				refTransacao, tipoFrete, null);
	}

	public static PagSeguroCheckout newCheckoutComFreteParaUsuarioDecidirEComDadosDoUsuario(
			PagSeguroMoeda moeda, Collection<PagSeguroItem> itens,
			String urlBotaoSubmit, String refTransacao,
			PagSeguroDadosCliente dadosCliente) {
		return new PagSeguroCheckout(moeda, itens, urlBotaoSubmit,
				refTransacao, PagSeguroTipoFrete.USUARIO_DECIDE, dadosCliente);
	}

	public static PagSeguroCheckout newCheckoutComFreteEComDadosDoUsuario(
			PagSeguroMoeda moeda, Collection<PagSeguroItem> itens,
			String urlBotaoSubmit, String refTransacao,
			PagSeguroTipoFrete tipoFrete, PagSeguroDadosCliente dadosCliente) {
		return new PagSeguroCheckout(moeda, itens, urlBotaoSubmit,
				refTransacao, tipoFrete, dadosCliente);
	}



	public String getTipo() {
		return tipo;
	}

	public PagSeguroMoeda getMoeda() {
		return moeda;
	}

	public Collection<PagSeguroItem> getItens() {
		return itens;
	}

	public String getUrlBotaoSubmit() {
		return urlBotaoSubmit;
	}

	public String getRefTransacao() {
		return refTransacao;
	}

	public PagSeguroTipoFrete getTipoFrete() {
		return tipoFrete;
	}

	public PagSeguroCheckout adicionaItem(PagSeguroItem item) {
		itens.add(item);
		return this;
	}

	public String getBairro() {
		return dadosCliente.getBairro();
	}

	public String getCep() {
		return dadosCliente.getCep();
	}

	public String getCidade() {
		return dadosCliente.getCidade();
	}

	public String getComplemento() {
		return dadosCliente.getComplemento();
	}

	public String getDdd() {
		return dadosCliente.getDdd();
	}

	public String getEmail() {
		return dadosCliente.getEmail();
	}

	public String getEndereco() {
		return dadosCliente.getEndereco();
	}

	public String getEstado() {
		return dadosCliente.getEstado();
	}

	public String getNome() {
		return dadosCliente.getNome();
	}

	public String getNumero() {
		return dadosCliente.getNumero();
	}

	public String getTelefone() {
		return dadosCliente.getTelefone();
	}

	public String getPais() {
		return dadosCliente.getPais();
	}
	
	public boolean hasDadosDoCliente(){
		return dadosCliente!=null;
	}

	public BigDecimal getValorTotalItens(){
		BigDecimal total = BigDecimal.ZERO;
		for(PagSeguroItem item : itens){
			total = total.add(item.getValor());
		}		
		return new BigDecimalFormatter().normalizaBigDecimal(total);
	}
	
	public BigDecimal getValorTotalFrete(){
		BigDecimal total = BigDecimal.ZERO;
		for(PagSeguroItem item : itens){
			total = total.add(item.getFrete());
		}			
		return new BigDecimalFormatter().normalizaBigDecimal(total);
		
	}
}
