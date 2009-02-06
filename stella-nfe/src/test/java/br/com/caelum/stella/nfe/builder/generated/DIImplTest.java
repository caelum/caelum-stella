package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class DIImplTest {
    @org.junit.Test
    public void testDIInterface() {
        DI dI = new DIImpl().withNDI("abc").withDDI(Calendar.getInstance()).withXLocDesemb("abc").withUFDesemb(TUf.AC)
                .withDDesemb(Calendar.getInstance()).withCExportador("abc").withAdi(new AdiImpl());
        assertModelWasFilled(dI);
    }

    private void assertModelWasFilled(final DI dI) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(dI).assertModelWasFilled();
    }
}