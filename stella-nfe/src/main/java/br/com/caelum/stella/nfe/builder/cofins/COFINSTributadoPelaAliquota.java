package br.com.caelum.stella.nfe.builder.cofins;

import java.math.BigDecimal;

public interface COFINSTributadoPelaAliquota extends COFINS,COFINSTributavel{
	public COFINSTributadoPelaAliquota withValorDaBaseDeCalculo(BigDecimal valorDaBaseDeCalculo);
	
	public COFINSTributadoPelaAliquota withAliquotaEmPercentual(BigDecimal aliquotaEmPercentual);
	
	public COFINSTributadoPelaAliquota withValor(BigDecimal valor);
}
