package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISSTImplTest {
    @org.junit.Test
    public void testPISSTInterface() {
        PISST pISST = new PISSTImpl().withVBC(new BigDecimal(1)).withPPIS(new BigDecimal(1)).withQuantidadeVendida(
                new BigDecimal(1)).withAliquota(new BigDecimal(1)).withVPIS(new BigDecimal(1));
        assertModelWasFilled(pISST);
    }

    private void assertModelWasFilled(final PISST pISST) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISST).assertModelWasFilled();
    }
}