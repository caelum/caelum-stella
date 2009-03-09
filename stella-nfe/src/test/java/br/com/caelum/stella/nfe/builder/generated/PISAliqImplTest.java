package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISAliqImplTest {
    @org.junit.Test
    public void testPISAliqInterface() {
        PISAliq pISAliq = new PISAliqImpl().withCodigoSituacaoTributaria("abc").withVBC(new BigDecimal(1)).withPPIS(
                new BigDecimal(1)).withVPIS(new BigDecimal(1));
        assertModelWasFilled(pISAliq);
    }

    private void assertModelWasFilled(final PISAliq pISAliq) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISAliq).assertModelWasFilled();
    }
}