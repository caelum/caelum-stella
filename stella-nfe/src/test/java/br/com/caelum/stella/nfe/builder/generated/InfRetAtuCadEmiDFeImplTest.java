package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.TUf;

public final class InfRetAtuCadEmiDFeImplTest {
    @org.junit.Test
    public void testInfRetAtuCadEmiDFeInterface() {
        InfRetAtuCadEmiDFe<Object> infRetAtuCadEmiDFe = new InfRetAtuCadEmiDFeImpl<Object>(new Object())
                                                                                                        .withUF(TUf.AC)
                                                                                                        .withCNPJ(
                                                                                                                new Object())
                                                                                                        .withOpe("abc")
                                                                                                        .withResOpe(
                                                                                                                "abc")
                                                                                                        .withId("abc");
        BuilderTestHelper.assertModelWasFilled(infRetAtuCadEmiDFe);
    }

}