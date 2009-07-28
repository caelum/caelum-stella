package br.com.caelum.stella.gateway.pagseguro;

import java.math.BigDecimal;

import br.com.caelum.stella.gateway.core.BigDecimalFormatter;

/**
 * Representa um item do carrinho que deve ser enviado ao UOL.
 * @author Alberto Pc
 *
 */
public class PagSeguroItem {

	private String id;
	private String descricao;
	private int quantidade;
	private BigDecimal valor;
	private BigDecimal frete;
	private Double pesoGramas;
	private BigDecimal taxaExtra;
	
	
	
	/**
	 * Uso controlado para montar a autorizacao.
	 * @param id
	 * @param descricao
	 * @param quantidade
	 * @param valor
	 * @param frete
	 * @param pesoGramas
	 * @param taxaExtra
	 */
	PagSeguroItem(String id, String descricao, int quantidade, BigDecimal valor,
			BigDecimal frete,BigDecimal taxaExtra) {
		// TODO Auto-generated constructor stub
		this(id,descricao,quantidade,valor,frete,null,taxaExtra);
	}
	
	/**
	 * Usado para itens que não precisam de frete
	 * @param id
	 * @param descricao
	 * @param quantidade
	 * @param valor
	 */
	public PagSeguroItem(String id, String descricao, int quantidade, BigDecimal valor) {
		this(id,descricao,quantidade,valor,BigDecimal.ZERO,0d);
	}


	/**
	 * Usado para itens que precisam de frete.
	 * @param id
	 * @param descricao
	 * @param quantidade
	 * @param valor
	 * @param frete
	 * @param pesoGramas
	 */
	public PagSeguroItem(String id, String descricao, int quantidade, BigDecimal valor,
			BigDecimal frete, Double pesoGramas) {
		this(id,descricao,quantidade,valor,frete,pesoGramas,BigDecimal.ZERO);
	}
	
	/**
	 * 
	 * @param id
	 * @param descricao
	 * @param quantidade
	 * @param valor
	 * @param frete
	 * @param pesoGramas
	 * @param taxaExtra
	 */
	private PagSeguroItem(String id, String descricao, int quantidade, BigDecimal valor,
			BigDecimal frete, Double pesoGramas,BigDecimal taxaExtra) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
		this.frete = frete;
		this.pesoGramas = pesoGramas;
		this.taxaExtra = taxaExtra;
	}	


	public String getId() {
		return id;
	}


	public String getDescricao() {
		return descricao;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public BigDecimal getFrete() {
		return frete;
	}


	public Double getPesoGramas() {
		return pesoGramas;
	}
	
	
	/**
	 * 
	 * @return o valor em centavos.
	 */
	public String getValorFormatado(){
		return new BigDecimalFormatter().bigDecimalToStringInCents(valor);
	}
	
	/**
	 * 
	 * @return o frete em centavos
	 */
	public String getValorFreteFormatado(){
		return new BigDecimalFormatter().bigDecimalToStringInCents(frete);
	}
	
	/**
	 * 
	 * @return o peso sem casas decimais
	 */
	public String getPesoFormatado(){
		return String.format("%.0f",pesoGramas);
	}

	/**
	 * 
	 * @return taxa extra aplicada sobre o item.
	 */
	public BigDecimal getTaxaExtra() {
		if(taxaExtra==null){
			taxaExtra = BigDecimal.ZERO;
		}
		return taxaExtra;
	}
	
	
	
	
	
	
	
}
