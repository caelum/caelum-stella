package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.IPITributacao;
import br.com.caelum.stella.nfe.builder.enums.SituacaoTributaria;
import br.com.caelum.stella.nfe.builder.impl.IPITributacaoImpl;

public final class IPITribImplTest {
    @org.junit.Test
    public void testIPITribInterface() {
        IPITributacao iPITrib = new IPITributacaoImpl().withSituacaoTributaria(SituacaoTributaria.SAIDA_COM_SUSPENSAO)
                .withValorDaBaseDeCalculo(new BigDecimal(1)).withAliquota(new BigDecimal(1)).withQuantidadeTotal(
                        new BigDecimal("1")).withValorPorUnidadeTributavel(new BigDecimal("1")).withValorDoIPI(
                        new BigDecimal("1"));
        assertModelWasFilled(iPITrib);
    }

    private void assertModelWasFilled(final IPITributacao iPITrib) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iPITrib).assertModelWasFilled();
    }
}