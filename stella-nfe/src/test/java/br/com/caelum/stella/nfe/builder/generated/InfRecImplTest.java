package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class InfRecImplTest {
    @org.junit.Test
    public void testInfRecInterface() {
        ReciboDoLote infRec = new InfRecImpl().withNRec("abc").withDhRecbto(Calendar.getInstance()).withTMed("abc");
        assertModelWasFilled(infRec);
    }

    private void assertModelWasFilled(ReciboDoLote infRec) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(infRec).assertModelWasFilled();
    }
}