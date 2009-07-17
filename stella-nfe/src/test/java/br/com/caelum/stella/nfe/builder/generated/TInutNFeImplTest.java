package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TInutNFeImplTest {
    @org.junit.Test
    public void testTInutNFeInterface() {
        TInutNFe<Object> tInutNFe = new TInutNFeImpl<Object>(new Object()).withInfInut(
                new InfInutImpl<Object>(new Object())).withSignature(new SignatureType()).withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tInutNFe);
    }

}