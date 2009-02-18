package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISSTImplTest {
    @org.junit.Test
    public void testPISSTInterface() {
        PISST pISST = new PISSTImpl().withVBC("abc").withPPIS(new BigDecimal(1)).withQuantidadeVendida("abc")
                .withAliquota("abc").withVPIS(
        "abc");
        assertModelWasFilled(pISST);
    }

    private void assertModelWasFilled(PISST pISST) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISST).assertModelWasFilled();
    }
}