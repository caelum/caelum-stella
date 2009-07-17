package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TAtuCadEmiDFeImplTest {
    @org.junit.Test
    public void testTAtuCadEmiDFeInterface() {
        TAtuCadEmiDFe<Object> tAtuCadEmiDFe = new TAtuCadEmiDFeImpl<Object>(new Object()).withInfAtuCadEmiDFe(
                new InfAtuCadEmiDFeImpl<Object>(new Object())).withSignature(new SignatureType()).withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tAtuCadEmiDFe);
    }

}