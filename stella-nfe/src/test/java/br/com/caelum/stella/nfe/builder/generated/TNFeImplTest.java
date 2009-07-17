package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TNFeImplTest {
    @org.junit.Test
    public void testTNFeInterface() {
        NFE<Object> tNFe = new NFEImpl<Object>(new Object())
                                                            .withInformacoesDaNFE(new InfNFeImpl<Object>(new Object()))
                                                            .withSignature(new SignatureType());
        BuilderTestHelper.assertModelWasFilled(tNFe);
    }

}