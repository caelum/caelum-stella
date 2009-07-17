package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class PISSTImplTest {
    @org.junit.Test
    public void testPISSTInterface() {
        PISSubstituicaoTributaria<Object> pISST = new PISSubstituicaoTributariaImpl<Object>(new Object())
                                                                                                         .withValorDaBaseDeCalculo(
                                                                                                                 new BigDecimal(
                                                                                                                         1))
                                                                                                         .withAliquotaDaSubstituicaoTributaria(
                                                                                                                 new BigDecimal(
                                                                                                                         1))
                                                                                                         .withQuantidadeVendida(
                                                                                                                 new BigDecimal(
                                                                                                                         1))
                                                                                                         .withAliquota(
                                                                                                                 new BigDecimal(
                                                                                                                         1))
                                                                                                         .withValor(
                                                                                                                 new BigDecimal(
                                                                                                                         1));
        BuilderTestHelper.assertModelWasFilled(pISST);
    }

}