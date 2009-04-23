package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class TEmissorImplTest {
    @org.junit.Test
    public void testTEmissorInterface() {
        TEmissor tEmissor = new TEmissorImpl()
                                              .withUF(TUf.AC)
                                              .withCNPJ("abc")
                                              .withCNPJMatriz("abc")
                                              .withIE("abc")
                                              .withDFe(new ArrayList<DFe>());
        assertModelWasFilled(tEmissor);
    }

    private void assertModelWasFilled(final TEmissor tEmissor) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tEmissor).assertModelWasFilled();
    }
}