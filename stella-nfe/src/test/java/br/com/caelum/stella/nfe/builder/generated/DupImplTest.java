package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class DupImplTest {
    @org.junit.Test
    public void testDupInterface() {
        Dup dup = new DupImpl().withNDup("abc").withDVenc(Calendar.getInstance()).withVDup("abc");
        assertModelWasFilled(dup);
    }

    private void assertModelWasFilled(Dup dup) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(dup).assertModelWasFilled();
    }
}