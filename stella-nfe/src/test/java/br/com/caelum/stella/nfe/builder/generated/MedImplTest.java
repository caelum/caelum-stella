package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.Calendar;

public final class MedImplTest {
    @org.junit.Test
    public void testMedInterface() {
        Medicamento med = new MedImpl().withNLote("abc").withQLote("abc").withDFab(Calendar.getInstance()).withDVal(
                Calendar.getInstance()).withVPMC(new BigDecimal(1));
        assertModelWasFilled(med);
    }

    private void assertModelWasFilled(final Medicamento med) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(med).assertModelWasFilled();
    }
}