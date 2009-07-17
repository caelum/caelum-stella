package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TCancNFeImplTest {
    @org.junit.Test
    public void testTCancNFeInterface() {
        TCancNFe<Object> tCancNFe = new TCancNFeImpl<Object>(new Object()).withInfCanc(
                new InfCancImpl<Object>(new Object())).withSignature(new SignatureType()).withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tCancNFe);
    }

}