package br.com.caelum.stella.nfe.builder;

import java.math.BigDecimal;

import org.junit.Test;

public class IPIInterfaceTest {

	@Test
	public void testIPIInterface(){
		IPI.create()
		.withClasseDeEnquadramento("")
		.withCNPJDoProdutor("")
		.withCodigoDoSeloDeControle("")
		.withQuantidadeDeSelos(123456789012L)
		.withCodigoDeEnquandramento("")
		.withIPITrib(IPITrib.create())
		.withIPIInt(IPIInt.withSituacaoTribuaria(SituacaoTributaria.ENTRADA_COM_RECUPERACAO_DE_CREDITO));
	}
	
	@Test
	public void testIPIIntInterface(){
		IPIInt.withSituacaoTribuaria(SituacaoTributaria.ENTRADA_COM_RECUPERACAO_DE_CREDITO);
	}
	
	@Test
	public void testIPIIntTrib(){
		IPITrib.create()
		.withSituacaoTribuaria(SituacaoTributaria.ENTRADA_COM_RECUPERACAO_DE_CREDITO)
		.withValorDaBaseDeCalculo(new BigDecimal(""))
		.withAliquota(new BigDecimal(""))
		.withQuantidadeTotal(new BigDecimal(""))
		.withValorPorUnidadeTributavel(new BigDecimal(""))
		.withValorDoIPI(new BigDecimal(""));
	}
}
