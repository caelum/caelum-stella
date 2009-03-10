package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.tinytype.CNPJ;

public final class RefNFImplTest {
    @org.junit.Test
    public void testRefNFInterface() {
        NFReferenciada refNF = new NFReferenciadaImpl().withCodigoUF("abc").withAAMM("abc").withCNPJ(new CNPJ("abc"))
                .withSerie("abc").withNumero("abc");
        assertModelWasFilled(refNF);
    }

    private void assertModelWasFilled(final NFReferenciada refNF) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(refNF).assertModelWasFilled();
    }
}