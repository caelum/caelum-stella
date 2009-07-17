package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.TUf;

public final class InfAtuCadEmiDFeImplTest {
    @org.junit.Test
    public void testInfAtuCadEmiDFeInterface() {
        InfAtuCadEmiDFe<Object> infAtuCadEmiDFe = new InfAtuCadEmiDFeImpl<Object>(new Object())
                                                                                               .withUF(TUf.AC)
                                                                                               .withInclui(
                                                                                                       new TEmissorImpl<Object>(
                                                                                                               new Object()))
                                                                                               .withExclui(
                                                                                                       new ExcluiImpl<Object>(
                                                                                                               new Object()))
                                                                                               .withId("abc");
        BuilderTestHelper.assertModelWasFilled(infAtuCadEmiDFe);
    }

}