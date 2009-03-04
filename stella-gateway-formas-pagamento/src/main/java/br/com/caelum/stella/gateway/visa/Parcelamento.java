package br.com.caelum.stella.gateway.visa;

import br.com.caelum.stella.gateway.core.CheckoutInvalidoException;

public class Parcelamento {

	private FormaParcelamento formaParcelamento;
	private int numeroDeParcelas;
	
	
	
	public Parcelamento(FormaParcelamento formaParcelamento,
			int numeroDeParcelas) {
		super();
		this.formaParcelamento = formaParcelamento;
		this.numeroDeParcelas = numeroDeParcelas;
	}
	public FormaParcelamento getFormaParcelamento() {
		return formaParcelamento;
	}

	public int getNumeroDeParcelas() {
		return numeroDeParcelas;
	}
	
	
	/**
	 * Retorna o codigo levando em consideracao a forma do parcelamento e o numero de parcelas
	 * @return
	 */
	public String getCodigoDePagamento(){
		if(numeroDeParcelas<=0){
			throw new CheckoutInvalidoException("O número de parcelas não pode ser igual ou menor que 0");
		}
		else{
			if((formaParcelamento.equals(FormaParcelamento.DEBITO) || formaParcelamento.equals(FormaParcelamento.CREDITO_A_VISTA)) && numeroDeParcelas>1){
				throw new CheckoutInvalidoException("Com débito ou crédito a vista só pode pagar em 1 parcela");
			}
		}
		String numeroDeParcelasFormatadoParaTresDigitos = String.format("%03d",numeroDeParcelas);
		return formaParcelamento.getCodigo()+numeroDeParcelasFormatadoParaTresDigitos;
	}
	
	
}
