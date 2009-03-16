package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISAliqImplTest {
    @org.junit.Test
    public void testPISAliqInterface() {
        PISTributadoPelaAliquota pISAliq = new PISTributadoPelaAliquotaImpl().withCodigoSituacaoTributaria("abc").withValorDaBaseDeCalculo(new BigDecimal(1)).withAliquotaDoPIS(
                new BigDecimal(1)).withValorDoPIS(new BigDecimal(1));
        assertModelWasFilled(pISAliq);
    }

    private void assertModelWasFilled(final PISTributadoPelaAliquota pISAliq) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISAliq).assertModelWasFilled();
    }
}