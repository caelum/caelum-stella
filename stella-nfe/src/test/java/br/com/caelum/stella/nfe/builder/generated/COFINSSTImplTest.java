package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class COFINSSTImplTest {
    @org.junit.Test
    public void testCOFINSSTInterface() {
        COFINSSubstituicaoTributaria<Object> cOFINSST = new COFINSSubstituicaoTributariaImpl<Object>(new Object())
                                                                                                                  .withValorDaBaseDeCalculo(
                                                                                                                          new BigDecimal(
                                                                                                                                  1))
                                                                                                                  .withAliquotaEmPercentual(
                                                                                                                          new BigDecimal(
                                                                                                                                  1))
                                                                                                                  .withQuantidadeVendida(
                                                                                                                          new BigDecimal(
                                                                                                                                  "1"))
                                                                                                                  .withAliquota(
                                                                                                                          new BigDecimal(
                                                                                                                                  "1"))
                                                                                                                  .withValor(
                                                                                                                          new BigDecimal(
                                                                                                                                  "1"));
        BuilderTestHelper.assertModelWasFilled(cOFINSST);
    }
}