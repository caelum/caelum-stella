package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.TUf;

public final class TEmissorImplTest {
    @org.junit.Test
    public void testTEmissorInterface() {
        TEmissor<Object> tEmissor = new TEmissorImpl<Object>(new Object())
                                                                          .withUF(TUf.AC)
                                                                          .withCNPJ("abc")
                                                                          .withCNPJMatriz("abc")
                                                                          .withIE("abc")
                                                                          .withDFe(new ArrayList<DFe<?>>());
        BuilderTestHelper.assertModelWasFilled(tEmissor);
    }

}