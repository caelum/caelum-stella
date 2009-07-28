package br.com.caelum.stella.gateway.visa;

import br.com.caelum.stella.gateway.core.InvalidCheckoutException;

public class VISAFormaPagamento {

	private  VISATipoTransacao tipoTransacao;
	private  int numeroDeParcelas;
	
	
	
	public VISAFormaPagamento( VISATipoTransacao formaParcelamento,
			 int numeroDeParcelas) {
		super();
		if(numeroDeParcelas<=0){
			throw new InvalidCheckoutException("O número de parcelas não pode ser igual ou menor que 0");
		}
		else{
			if((formaParcelamento.equals(VISATipoTransacao.DEBITO) || formaParcelamento.equals(VISATipoTransacao.CREDITO_A_VISTA)) && numeroDeParcelas>1){
				throw new InvalidCheckoutException("Com débito ou crédito a vista só pode pagar em 1 parcela");
			}
		}		
		this.tipoTransacao = formaParcelamento;
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	public static VISAFormaPagamento newPagamentoAVistaComCredito(){
		return new VISAFormaPagamento(VISATipoTransacao.CREDITO_A_VISTA,1);
	}
	
	public static VISAFormaPagamento newPagamentoComDebito(){
		return new VISAFormaPagamento(VISATipoTransacao.DEBITO,1);
	}
	
	public VISAFormaPagamento newPagamentoParceladoJurosLojista(int numeroDeParcelas){
		return new VISAFormaPagamento(VISATipoTransacao.PARCELADO_JUROS_LOJISTA,numeroDeParcelas);
	}
	
	public VISAFormaPagamento newPagamentoParceladoJurosEmissor(int numeroDeParcelas){
		return new VISAFormaPagamento(VISATipoTransacao.PARCELADO_JUROS_EMISSOR,numeroDeParcelas);
	}	
	
	public VISATipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public int getNumeroDeParcelas() {
		return numeroDeParcelas;
	}
	
	
	/**
	 * Retorna o codigo levando em consideracao a forma do parcelamento e o numero de parcelas
	 * @return
	 * @throws InvalidCheckoutException caso algum atributo do parcelamento esteja em estado inválido
	 */
	public String getCodigoDePagamento(){
		String numeroDeParcelasFormatadoParaTresDigitos = String.format("%03d",numeroDeParcelas);
		return tipoTransacao.getCodigo()+numeroDeParcelasFormatadoParaTresDigitos;
	}
	
	
}
