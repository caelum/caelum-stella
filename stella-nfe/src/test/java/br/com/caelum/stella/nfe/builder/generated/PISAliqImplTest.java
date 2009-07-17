package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class PISAliqImplTest {
    @org.junit.Test
    public void testPISAliqInterface() {
        PISTributadoPelaAliquota<Object> pISAliq = new PISTributadoPelaAliquotaImpl<Object>(new Object())
                                                                                                         .withCodigoSituacaoTributaria(
                                                                                                                 "abc")
                                                                                                         .withValorDaBaseDeCalculo(
                                                                                                                 new BigDecimal(
                                                                                                                         1))
                                                                                                         .withAliquotaDoPIS(
                                                                                                                 new BigDecimal(
                                                                                                                         1))
                                                                                                         .withValorDoPIS(
                                                                                                                 new BigDecimal(
                                                                                                                         1));
        BuilderTestHelper.assertModelWasFilled(pISAliq);
    }

}