package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.tinytype.CNPJ;

public final class RefNFImplTest {
    @org.junit.Test
    public void testRefNFInterface() {
        NFReferenciada<Object> refNF = new NFReferenciadaImpl<Object>(new Object())
                                                                                   .withCodigoUF("abc")
                                                                                   .withAAMM("abc")
                                                                                   .withCNPJ(new CNPJ("abc"))
                                                                                   .withSerie("abc")
                                                                                   .withNumero("abc");
        BuilderTestHelper.assertModelWasFilled(refNF);
    }

}