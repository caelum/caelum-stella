package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSImplTest {
    @org.junit.Test
    public void testCOFINSInterface() {
        COFINS cOFINS = new COFINSImpl().withCOFINSAliq(new COFINSAliqImpl()).withCOFINSQtde(new COFINSQtdeImpl())
                .withCOFINSNT(new COFINSNTImpl()).withCOFINSOutr(new COFINSOutrImpl());
        assertModelWasFilled(cOFINS);
    }

    private void assertModelWasFilled(final COFINS cOFINS) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cOFINS).assertModelWasFilled();
    }
}