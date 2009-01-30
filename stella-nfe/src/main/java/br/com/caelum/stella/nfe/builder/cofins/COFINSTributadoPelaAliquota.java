package br.com.caelum.stella.nfe.builder.cofins;

import java.math.BigDecimal;

public interface COFINSTributadoPelaAliquota extends COFINS,COFINSTributavel{
	public COFINSTributadoPelaAliquota withValorBaseCalculo(BigDecimal valorBaseCalculo);
	
	public COFINSTributadoPelaAliquota withAliquotaEmPercentual(BigDecimal aliquotaEmPercentual);
	
	public COFINSTributadoPelaAliquota withValor(BigDecimal valor);
}
