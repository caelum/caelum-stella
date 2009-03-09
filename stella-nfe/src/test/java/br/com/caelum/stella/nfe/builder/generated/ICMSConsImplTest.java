package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class ICMSConsImplTest {
    @org.junit.Test
    public void testICMSConsInterface() {
        ICMSCons iCMSCons = new ICMSConsImpl().withVBCICMSSTCons(new BigDecimal("1")).withVICMSSTCons(
                new BigDecimal("1")).withUFCons(TUf.AC);
        assertModelWasFilled(iCMSCons);
    }

    private void assertModelWasFilled(final ICMSCons iCMSCons) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iCMSCons).assertModelWasFilled();
    }
}