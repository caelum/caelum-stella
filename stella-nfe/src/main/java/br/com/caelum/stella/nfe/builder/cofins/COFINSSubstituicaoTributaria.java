package br.com.caelum.stella.nfe.builder.cofins;

import java.math.BigDecimal;

public interface COFINSSubstituicaoTributaria extends COFINS {

	public COFINSSubstituicaoTributaria withValorDaBaseDeCalculo(BigDecimal valorDaBaseDeCalculo);
	
	public COFINSSubstituicaoTributaria withAliquotaEmPercentual(BigDecimal aliquotaEmPercentual);
	
	public COFINSSubstituicaoTributaria withQuantidadeVendida(Integer quantidadeVendida);
	
	public COFINSSubstituicaoTributaria withAliquotaEmReais(BigDecimal aliquotaEmReais);
	
	public COFINSSubstituicaoTributaria withValor(BigDecimal valor);
}
