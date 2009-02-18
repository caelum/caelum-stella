package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISOutrImplTest {
    @org.junit.Test
    public void testPISOutrInterface() {
        PISOutr pISOutr = new PISOutrImpl().withCodigoSituacaoTributaria("abc").withVBC("abc").withPPIS(
                new BigDecimal(1)).withQuantidadeVendida("abc")
        .withAliquota("abc").withVPIS("abc");
        assertModelWasFilled(pISOutr);
    }

    private void assertModelWasFilled(PISOutr pISOutr) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISOutr).assertModelWasFilled();
    }
}