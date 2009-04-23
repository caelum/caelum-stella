package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

public final class InfCadEmiDFeImplTest {

    @Test
    public void testInfCadEmiDFeInterface() {
        InfCadEmiDFe infCadEmiDFe = new InfCadEmiDFeImpl().withDPubCad(Calendar.getInstance()).withEmissor(
                new ArrayList<TEmissor>()).withId("abc");
        assertModelWasFilled(infCadEmiDFe);
    }

    private void assertModelWasFilled(final InfCadEmiDFe infCadEmiDFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(infCadEmiDFe).assertModelWasFilled();
    }
}