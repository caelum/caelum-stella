package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class PISQtdeImplTest {
    @org.junit.Test
    public void testPISQtdeInterface() {
        PISTributadoPorQuantidade<Object> pISQtde = new PISTributadoPorQuantidadeImpl<Object>(new Object())
                                                                                                           .withQuantidadeVendida(
                                                                                                                   new BigDecimal(
                                                                                                                           1))
                                                                                                           .withAliquota(
                                                                                                                   new BigDecimal(
                                                                                                                           1))
                                                                                                           .withValorDoPIS(
                                                                                                                   new BigDecimal(
                                                                                                                           1));
        BuilderTestHelper.assertModelWasFilled(pISQtde);
    }

}