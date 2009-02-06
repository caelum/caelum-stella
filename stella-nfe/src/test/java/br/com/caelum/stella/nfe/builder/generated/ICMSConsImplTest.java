package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class ICMSConsImplTest {
    @org.junit.Test
    public void testICMSConsInterface() {
        ICMSCons iCMSCons = new ICMSConsImpl().withVBCICMSSTCons("abc").withVICMSSTCons("abc").withUFCons(TUf.AC);
        assertModelWasFilled(iCMSCons);
    }

    private void assertModelWasFilled(final ICMSCons iCMSCons) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iCMSCons).assertModelWasFilled();
    }
}