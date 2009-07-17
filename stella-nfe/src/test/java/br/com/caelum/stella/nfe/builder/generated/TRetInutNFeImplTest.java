package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TRetInutNFeImplTest {
    @org.junit.Test
    public void testTRetInutNFeInterface() {
        TRetInutNFe<Object> tRetInutNFe = new TRetInutNFeImpl<Object>(new Object()).withInfInut(
                new InfInutImpl<Object>(new Object())).withSignature(new SignatureType()).withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tRetInutNFe);
    }

}