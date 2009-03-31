package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class DupImplTest {
    @org.junit.Test
    public void testDupInterface() {
        Duplicata dup = new DuplicataImpl().withNumero("abc").withDataDeVencimento(Calendar.getInstance()).withValorDaDuplicata("abc");
        assertModelWasFilled(dup);
    }

    private void assertModelWasFilled(Duplicata dup) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(dup).assertModelWasFilled();
    }
}