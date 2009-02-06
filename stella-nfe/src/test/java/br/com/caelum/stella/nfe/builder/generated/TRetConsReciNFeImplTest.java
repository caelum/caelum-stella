package br.com.caelum.stella.nfe.builder.generated;

public final class TRetConsReciNFeImplTest {
    @org.junit.Test
    public void testTRetConsReciNFeInterface() {
        TRetConsReciNFe tRetConsReciNFe = new TRetConsReciNFeImpl().withTpAmb("abc").withVerAplic("abc")
                .withNRec("abc").withCStat("abc").withXMotivo("abc").withCUF("abc").withProtNFe(new TProtNFeImpl())
                .withVersao("abc");
        assertModelWasFilled(tRetConsReciNFe);
    }

    private void assertModelWasFilled(final TRetConsReciNFe tRetConsReciNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tRetConsReciNFe).assertModelWasFilled();
    }
}