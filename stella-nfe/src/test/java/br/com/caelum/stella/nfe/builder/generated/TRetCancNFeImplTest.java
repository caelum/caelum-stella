package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TRetCancNFeImplTest {
    @org.junit.Test
    public void testTRetCancNFeInterface() {
        TRetCancNFe<Object> tRetCancNFe = new TRetCancNFeImpl<Object>(new Object()).withInfCanc(
                new InfCancImpl<Object>(new Object())).withSignature(new SignatureType()).withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tRetCancNFe);
    }

}