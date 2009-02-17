package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class COFINSOutrImplTest {
    @org.junit.Test
    public void testCOFINSOutrInterface() {
        COFINSOutr cOFINSOutr = new COFINSOutrImpl().withCodigoSituacaoTributaria("abc").withValorDaBaseDeCalculo(
                new BigDecimal(1)).withAliquotaEmPercentual("abc")
        .withQuantidadeVendida("abc").withAliquota("abc").withValor("abc");
        assertModelWasFilled(cOFINSOutr);
    }

    private void assertModelWasFilled(COFINSOutr cOFINSOutr) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cOFINSOutr).assertModelWasFilled();
    }
}