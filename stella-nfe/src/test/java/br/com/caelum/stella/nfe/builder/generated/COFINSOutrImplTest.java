package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class COFINSOutrImplTest {
    @org.junit.Test
    public void testCOFINSOutrInterface() {
        COFINSOutrasOperacoes cOFINSOutr = new COFINSOutrasOperacoesImpl().withCodigoSituacaoTributaria("abc").withValorDaBaseDeCalculo(
                new BigDecimal(1)).withAliquotaEmPercentual(new BigDecimal(1))
                .withQuantidadeVendida("abc").withAliquota("abc").withValor("abc");
        assertModelWasFilled(cOFINSOutr);
    }

    private void assertModelWasFilled(COFINSOutrasOperacoes cOFINSOutr) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cOFINSOutr).assertModelWasFilled();
    }
}