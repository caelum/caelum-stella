package br.com.caelum.stella.nfe.builder.generated;

public final class TRetEnviNFeImplTest {
    @org.junit.Test
    public void testTRetEnviNFeInterface() {
        TRetEnviNFe tRetEnviNFe = new TRetEnviNFeImpl().withTpAmb("abc").withVerAplic("abc").withCStat("abc")
                .withXMotivo("abc").withCUF("abc").withInfRec(new InfRecImpl()).withVersao("abc");
        assertModelWasFilled(tRetEnviNFe);
    }

    private void assertModelWasFilled(final TRetEnviNFe tRetEnviNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tRetEnviNFe).assertModelWasFilled();
    }
}