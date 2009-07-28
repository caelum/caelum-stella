package br.com.caelum.stella.gateway.amex;


/**
 * 
 * @author Alberto Souza
 *
 */
public class AmexFormaPagamento {

	private int numeroDeParcelas;
	private AmexTipoTransacao tipoTransacao;
	private AmexTipoCartao tipoCartao;


	public AmexFormaPagamento(int numeroDeParcelas,
			AmexTipoTransacao tipoTransacao, AmexTipoCartao tipoCartao) {
		super();
		this.numeroDeParcelas = numeroDeParcelas;
		this.tipoTransacao = tipoTransacao;
		this.tipoCartao = tipoCartao;
	}

	
	
	/**
	 * Construtor usado de forma controlada, quando não se tiver todas as
	 * informações necessárias sobre a forma de pagamento.
	 * 
	 * @param tipoCartao
	 */
	AmexFormaPagamento(AmexTipoCartao tipoCartao) {
		super();
		this.numeroDeParcelas = 0;
		this.tipoTransacao = null;
		this.tipoCartao = tipoCartao;
	}

	
	public static AmexFormaPagamento newPagamentoAVista(AmexTipoCartao tipoCartao){
		return new AmexFormaPagamento(0,AmexTipoTransacao.A_VISTA,tipoCartao);
	}
	
	public static AmexFormaPagamento newPagamentoParceladoJurosLojista(
			int numeroDeParcelas,AmexTipoCartao tipoCartao) {
		return new AmexFormaPagamento(
				 numeroDeParcelas,AmexTipoTransacao.PARCELADO_JUROS_LOJISTA,tipoCartao);
	}

	public static AmexFormaPagamento newPagamentoParceladoJurosEmissor(
			int numeroDeParcelas,AmexTipoCartao tipoCartao) {
		return new AmexFormaPagamento(
				 numeroDeParcelas,AmexTipoTransacao.PARCELADO_JUROS_EMISSOR,tipoCartao);
	}

	
	public int getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public AmexTipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public AmexTipoCartao getTipoCartao() {
		return tipoCartao;
	}

	public String getNumeroDeParcelasFormatado() {
		return String.format("%02d", numeroDeParcelas);
	}
	
	
}
