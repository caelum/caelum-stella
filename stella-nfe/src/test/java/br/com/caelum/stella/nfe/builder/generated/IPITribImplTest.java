package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.builder.IPITributacao;
import br.com.caelum.stella.nfe.builder.enums.SituacaoTributaria;
import br.com.caelum.stella.nfe.builder.impl.IPITributacaoImpl;

public final class IPITribImplTest {
    @org.junit.Test
    public void testIPITribInterface() {
        IPITributacao<Object> iPITrib = new IPITributacaoImpl<Object>(new Object()).withSituacaoTributaria(
                SituacaoTributaria.SAIDA_COM_SUSPENSAO).withValorDaBaseDeCalculo(new BigDecimal(1)).withAliquota(
                new BigDecimal(1)).withQuantidadeTotal(new BigDecimal("1")).withValorPorUnidadeTributavel(
                new BigDecimal("1")).withValorDoIPI(new BigDecimal("1"));
        BuilderTestHelper.assertModelWasFilled(iPITrib);
    }

}