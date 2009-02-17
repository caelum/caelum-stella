package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class COFINSSTImplTest {
    @org.junit.Test
    public void testCOFINSSTInterface() {
        COFINSST cOFINSST = new COFINSSTImpl().withValorDaBaseDeCalculo(new BigDecimal(1)).withAliquotaEmPercentual(
                "abc").withQuantidadeVendida("abc")
        .withAliquota("abc").withValor("abc");
        assertModelWasFilled(cOFINSST);
    }

    private void assertModelWasFilled(COFINSST cOFINSST) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cOFINSST).assertModelWasFilled();
    }
}