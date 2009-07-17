package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class COFINSOutrImplTest {
    @org.junit.Test
    public void testCOFINSOutrInterface() {
        COFINSOutrasOperacoes<Object> cOFINSOutr = new COFINSOutrasOperacoesImpl<Object>(new Object())
                                                                                                      .withCodigoSituacaoTributaria(
                                                                                                              "abc")
                                                                                                      .withValorDaBaseDeCalculo(
                                                                                                              new BigDecimal(
                                                                                                                      1))
                                                                                                      .withAliquotaEmPercentual(
                                                                                                              new BigDecimal(
                                                                                                                      1))
                                                                                                      .withQuantidadeVendida(
                                                                                                              "abc")
                                                                                                      .withAliquota(
                                                                                                              "abc")
                                                                                                      .withValor("abc");
        BuilderTestHelper.assertModelWasFilled(cOFINSOutr);
    }

}