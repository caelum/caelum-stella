package br.com.caelum.stella.nfe.builder;

import java.math.BigDecimal;

import org.junit.Test;

public class ImpostoDeImportacaoInterfaceTest {
	
	@Test
	public void testImpostoDeImportacaoInterface(){
		ImpostoDeImportacao.create()
		.withBaseDeCalculo(new BigDecimal(1))
		.withDespesasAduaneiras(new BigDecimal(1))
		.withValor(new BigDecimal(1))
		.withValorDoIOF(new BigDecimal(1));
	}

}
