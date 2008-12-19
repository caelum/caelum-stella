package br.com.caelum.stella.nfe.builder;

import java.math.BigDecimal;

import org.junit.Test;

public class ImpostoDeImportacaoInterfaceTest {
	
	@Test
	public void testImpostoDeImportacaoInterface(){
		ImpostoDeImportacao.create()
		.withBaseDeCalulo(new BigDecimal(""))
		.withDespesasAduaneiras(new BigDecimal(""))
		.withValor(new BigDecimal(""))
		.withValorDoIOF(new BigDecimal(""));
	}

}
