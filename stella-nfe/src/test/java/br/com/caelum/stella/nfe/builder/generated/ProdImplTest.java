package br.com.caelum.stella.nfe.builder.generated;

public final class ProdImplTest {
    @org.junit.Test
    public void testProdInterface() {
        Prod prod = new ProdImpl().withCProd("abc").withCEAN("abc").withXProd("abc").withNCM("abc").withEXTIPI("abc")
                .withGenero("abc").withCFOP("abc").withUCom("abc").withQCom("abc").withVUnCom("abc").withVProd("abc")
                .withCEANTrib("abc").withUTrib("abc").withQTrib("abc").withVUnTrib("abc").withVFrete("abc").withVSeg(
                        "abc").withVDesc("abc").withDI(new DIImpl()).withVeicProd(new VeicProdImpl()).withMed(
                        new MedImpl()).withArma(new ArmaImpl()).withComb(null);
        assertModelWasFilled(prod);
    }

    private void assertModelWasFilled(final Prod prod) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(prod).assertModelWasFilled();
    }
}