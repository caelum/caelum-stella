package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class MedImplTest {
    @org.junit.Test
    public void testMedInterface() {
        Med med = new MedImpl().withNLote("abc").withQLote("abc").withDFab(Calendar.getInstance()).withDVal(
                Calendar.getInstance()).withVPMC("abc");
        assertModelWasFilled(med);
    }

    private void assertModelWasFilled(Med med) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(med).assertModelWasFilled();
    }
}