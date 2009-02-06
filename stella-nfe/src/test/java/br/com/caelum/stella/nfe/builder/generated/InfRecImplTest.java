package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class InfRecImplTest {
    @org.junit.Test
    public void testInfRecInterface() {
        InfRec infRec = new InfRecImpl().withNRec("abc").withDhRecbto(Calendar.getInstance()).withTMed("abc");
        assertModelWasFilled(infRec);
    }

    private void assertModelWasFilled(InfRec infRec) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(infRec).assertModelWasFilled();
    }
}