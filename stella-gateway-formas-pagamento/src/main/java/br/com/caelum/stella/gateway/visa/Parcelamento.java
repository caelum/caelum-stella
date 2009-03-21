package br.com.caelum.stella.gateway.visa;

import br.com.caelum.stella.gateway.core.InvalidCheckoutException;

public class Parcelamento {

	private TipoTransacao tipoTransacao;
	private int numeroDeParcelas;
	
	
	
	public Parcelamento(TipoTransacao formaParcelamento,
			int numeroDeParcelas) {
		super();
		if(numeroDeParcelas<=0){
			throw new InvalidCheckoutException("O número de parcelas não pode ser igual ou menor que 0");
		}
		else{
			if((formaParcelamento.equals(TipoTransacao.DEBITO) || formaParcelamento.equals(TipoTransacao.CREDITO_A_VISTA)) && numeroDeParcelas>1){
				throw new InvalidCheckoutException("Com débito ou crédito a vista só pode pagar em 1 parcela");
			}
		}		
		this.tipoTransacao = formaParcelamento;
		this.numeroDeParcelas = numeroDeParcelas;
	}
	public TipoTransacao getTipoTransacao() {
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
