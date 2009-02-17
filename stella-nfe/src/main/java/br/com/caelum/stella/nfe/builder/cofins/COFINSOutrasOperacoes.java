package br.com.caelum.stella.nfe.builder.cofins;

import java.math.BigDecimal;

public interface COFINSOutrasOperacoes extends COFINS,COFINSTributavel {

	public COFINSOutrasOperacoes withValorDaBaseDeCalculo(BigDecimal valorDaBaseDeCalculo);
	
	public COFINSOutrasOperacoes withAliquotaEmPercentual(BigDecimal aliquotaEmPercentual);
	
	public COFINSOutrasOperacoes withQuantidadeVendida(Integer quantidadeVendida);
	
	public COFINSOutrasOperacoes withAliquotaEmReais(BigDecimal aliquotaEmReais);
	
	public COFINSOutrasOperacoes withValor(BigDecimal valor);
}
