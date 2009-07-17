package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class COFINSQtdeImplTest {
    @org.junit.Test
    public void testCOFINSQtdeInterface() {
        COFINSTributadoPelaQuantidade<Object> cOFINSQtde = new COFINSTributadoPelaQuantidadeImpl<Object>(new Object())
                                                                                                                      .withCodigoSituacaoTributaria(
                                                                                                                              "abc")
                                                                                                                      .withQuantidadeVendida(
                                                                                                                              new BigDecimal(
                                                                                                                                      "1"))
                                                                                                                      .withAliquota(
                                                                                                                              new BigDecimal(
                                                                                                                                      "1"))
                                                                                                                      .withValor(
                                                                                                                              new BigDecimal(
                                                                                                                                      "1"));
        BuilderTestHelper.assertModelWasFilled(cOFINSQtde);
    }

}