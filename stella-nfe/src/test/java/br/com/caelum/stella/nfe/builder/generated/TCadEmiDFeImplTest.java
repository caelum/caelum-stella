package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TCadEmiDFeImplTest {
    @org.junit.Test
    public void testTCadEmiDFeInterface() {
        TCadEmiDFe<Object> tCadEmiDFe = new TCadEmiDFeImpl<Object>(new Object()).withInfCadEmiDFe(
                new InfCadEmiDFeImpl<Object>(new Object())).withSignature(new SignatureType()).withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tCadEmiDFe);
    }

}