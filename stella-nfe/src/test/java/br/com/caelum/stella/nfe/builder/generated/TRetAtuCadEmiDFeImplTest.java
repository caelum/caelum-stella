package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TRetAtuCadEmiDFeImplTest {
    @org.junit.Test
    public void testTRetAtuCadEmiDFeInterface() {
        TRetAtuCadEmiDFe<Object> tRetAtuCadEmiDFe = new TRetAtuCadEmiDFeImpl<Object>(new Object())
                                                                                                  .withInfRetAtuCadEmiDFe(
                                                                                                          new InfRetAtuCadEmiDFeImpl<Object>(
                                                                                                                  new Object()))
                                                                                                  .withSignature(
                                                                                                          new SignatureType())
                                                                                                  .withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tRetAtuCadEmiDFe);
    }

}