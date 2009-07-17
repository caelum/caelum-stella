package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class COFINSAliqImplTest {
    @org.junit.Test
    public void testCOFINSAliqInterface() {
        COFINSTributadoPelaAliquota<Object> cOFINSAliq = new COFINSTributadoPelaAliquotaImpl<Object>(new Object())
                                                                                                                  .withCodigoSituacaoTributaria(
                                                                                                                          "abc")
                                                                                                                  .withValorDaBaseDeCalculo(
                                                                                                                          new BigDecimal(
                                                                                                                                  1))
                                                                                                                  .withAliquotaEmPercentual(
                                                                                                                          new BigDecimal(
                                                                                                                                  1))
                                                                                                                  .withValor(
                                                                                                                          "abc");
        BuilderTestHelper.assertModelWasFilled(cOFINSAliq);
    }

}