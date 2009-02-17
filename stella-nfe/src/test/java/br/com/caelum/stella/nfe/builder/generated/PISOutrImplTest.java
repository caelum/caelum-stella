package br.com.caelum.stella.nfe.builder.generated;

public final class PISOutrImplTest {
    @org.junit.Test
    public void testPISOutrInterface() {
        PISOutr pISOutr = new PISOutrImpl().withCodigoSituacaoTributaria("abc").withVBC("abc").withPPIS("abc").withQuantidadeVendida("abc")
                .withAliquota("abc").withVPIS("abc");
        assertModelWasFilled(pISOutr);
    }

    private void assertModelWasFilled(PISOutr pISOutr) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISOutr).assertModelWasFilled();
    }
}