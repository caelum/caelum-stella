package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISOutrImplTest {
    @org.junit.Test
    public void testPISOutrInterface() {
        PISOutr pISOutr = new PISOutrImpl().withCodigoSituacaoTributaria("abc").withVBC(new BigDecimal(1)).withPPIS(
                new BigDecimal(1)).withQuantidadeVendida(new BigDecimal(1)).withAliquota(new BigDecimal(1)).withVPIS(
                new BigDecimal(1));
        assertModelWasFilled(pISOutr);
    }

    private void assertModelWasFilled(final PISOutr pISOutr) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pISOutr).assertModelWasFilled();
    }
}