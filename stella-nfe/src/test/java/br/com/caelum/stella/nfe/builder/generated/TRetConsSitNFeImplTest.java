package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.InfProt;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TRetConsSitNFeImplTest {
    @org.junit.Test
    public void testTRetConsSitNFeInterface() {
        TRetConsSitNFe<Object> tRetConsSitNFe = new TRetConsSitNFeImpl<Object>(new Object())
                                                                                            .withInfProt(new InfProt())
                                                                                            .withSignature(
                                                                                                    new SignatureType())
                                                                                            .withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tRetConsSitNFe);
    }

}