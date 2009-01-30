package br.com.caelum.stella.nfe.builder.cofins;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.builder.COFINSBuilder;

public class COFINSInterfaceTest {

    @Test
    public void testCOFINSTributadoPelaAliquota() {
        COFINS target = new COFINSBuilder().cofinsAliquotaDiferenciada().withAliquotaEmPercentual(new BigDecimal(1))
                .withValor(new BigDecimal(1)).withValorBaseCalculo(new BigDecimal(1));
        new BuilderTestHelper(target).assertModelWasFilled();
    }

    @Test
    public void testCOFINSNaoTributado() {
        COFINS target = new COFINSBuilder().cofinsAliquotaZero();
        new BuilderTestHelper(target).assertModelWasFilled();
    }

    @Test
    public void testCOFINSSubstituicaoTributaria() {
        COFINS target = new COFINSBuilder().cofinsSubstituicaoTributaria().withAliquotaEmPercentual(new BigDecimal(1))
                .withAliquotaEmReais(new BigDecimal(1)).withQuantidadeVendida(1).withValor(new BigDecimal(1))
                .withValorBaseCalculo(new BigDecimal(1));
        new BuilderTestHelper(target).assertModelWasFilled();
    }

    @Test
    public void testCOFINSOutrasOperacoes() {
        COFINS target = new COFINSBuilder().cofinsOutrasOperacoes().withAliquotaEmPercentual(new BigDecimal(1))
                .withAliquotaEmReais(new BigDecimal(1)).withQuantidadeVendida(1).withValor(new BigDecimal(1))
                .withValorBaseCalculo(new BigDecimal(1));
        new BuilderTestHelper(target).assertModelWasFilled();
    }

    @Test
    public void testCOFINSTributadoPorQuantidade() {
        COFINS target = new COFINSBuilder().cofinsTributadoPorQuantidade().withAliquotaEmReais(new BigDecimal(1))
                .withQuantidadeVendida(1).withValor(new BigDecimal(1));
        new BuilderTestHelper(target).assertModelWasFilled();
    }

}
