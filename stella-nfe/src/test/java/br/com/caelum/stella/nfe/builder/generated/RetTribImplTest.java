package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class RetTribImplTest {
    @org.junit.Test
    public void testRetTribInterface() {
        RetTrib retTrib = new RetTribImpl().withVRetPIS(new BigDecimal(1)).withVRetCOFINS(new BigDecimal(1))
                .withVRetCSLL(new BigDecimal(1)).withVBCIRRF(new BigDecimal(1)).withVIRRF(new BigDecimal(1))
                .withVBCRetPrev(new BigDecimal(1)).withVRetPrev(new BigDecimal(1));
        assertModelWasFilled(retTrib);
    }

    private void assertModelWasFilled(final RetTrib retTrib) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(retTrib).assertModelWasFilled();
    }
}