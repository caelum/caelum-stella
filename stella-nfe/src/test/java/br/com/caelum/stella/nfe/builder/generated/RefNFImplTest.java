package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.tinytype.CNPJ;

public final class RefNFImplTest {
    @org.junit.Test
    public void testRefNFInterface() {
        RefNF refNF = new RefNFImpl().withCUF("abc").withAAMM("abc").withCNPJ(new CNPJ("abc")).withMod("abc").withSerie("abc")
                .withNNF("abc");
        assertModelWasFilled(refNF);
    }

    private void assertModelWasFilled(RefNF refNF) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(refNF).assertModelWasFilled();
    }
}