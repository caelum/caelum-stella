package br.com.caelum.stella.nfe.builder.cofins;

import java.math.BigDecimal;

public interface COFINSTributadoPorQuantidade extends COFINS,COFINSTributavel {

	public COFINSTributadoPorQuantidade withQuantidadeVendida(Integer quantidadeVendida);
	
	public COFINSTributadoPorQuantidade withAliquotaEmReais(BigDecimal aliquotaEmReais);
	
	public COFINSTributadoPorQuantidade withValor(BigDecimal valor);
}
