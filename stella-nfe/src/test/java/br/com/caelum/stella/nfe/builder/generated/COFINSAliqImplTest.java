package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class COFINSAliqImplTest {
    @org.junit.Test
    public void testCOFINSAliqInterface() {
        COFINSTributadoPelaAliquota cOFINSAliq = new COFINSTributadoPelaAliquotaImpl().withCodigoSituacaoTributaria("abc").withValorDaBaseDeCalculo(
                new BigDecimal(1)).withAliquotaEmPercentual(new BigDecimal(1))
                .withValor("abc");
        assertModelWasFilled(cOFINSAliq);
    }

    private void assertModelWasFilled(COFINSTributadoPelaAliquota cOFINSAliq) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cOFINSAliq).assertModelWasFilled();
    }
}