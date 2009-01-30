package br.com.caelum.stella.nfe.builder.icms;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.builder.ICMSBuilder;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeSubstituicaoTributaria;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.builder.icms.enums.TributacaoICMS;


public class ICMSInterfaceTest {
    
    @Test
    public void testICMSTributadoIntegralmenteInterface() {
        ICMSTributadoIntegralmente icms = new ICMSBuilder()
                .tributadoIntegralmente()
                    .withOrigem(OrigemICMS.NACIONAL)
                    .withModalidade(ModalidadeBaseCalculo.MARGEM_VALOR_AGREGADO)
                    .withBaseDeCalculo(new BigDecimal(1))
                    .withAliquota(new BigDecimal(1))
                    .withValor(new BigDecimal(1));
        assertModelWasFilled(icms);
    }

    @Test
    public void testICMSTributadoComSubstituicaoTributariaInterface() {
        ICMSTributadoComSubstituicaoTributaria icms = new ICMSBuilder()
                .tributadoComSubstituicaoTributaria()
                    .withOrigem(OrigemICMS.NACIONAL)
                    .withModalidade(ModalidadeBaseCalculo.MARGEM_VALOR_AGREGADO)
                    .withBaseDeCalculo(new BigDecimal(1))
                    .withAliquota(new BigDecimal(1))
                    .withValor(new BigDecimal(1))
                    .withModalidadeSubstituicaoTributaria(ModalidadeSubstituicaoTributaria.PAUTA)
                    .withPercentualAdicionado(new BigDecimal(1))
                    .withPercentualReducaoBaseCalculo(new BigDecimal(1))
                    .withValorBaseCalculoSubstituicaoTributaria(new BigDecimal(1))
                    .withAliquotaSubstituicaoTributaria(new BigDecimal(1))
                    .withValorSubstituicaoTributaria(new BigDecimal(1));
        assertModelWasFilled(icms);
    }

    @Test
    public void testICMSComReducaoDeBaseDeCalculoInterface() {
        ICMSComReducaoBaseCalculo icms = new ICMSBuilder()
                .comReducaoBaseCalculo()
                    .withOrigem(OrigemICMS.NACIONAL)
                    .withModalidade(ModalidadeBaseCalculo.MARGEM_VALOR_AGREGADO)
                    .withPercentualReducaoBaseCalculo(new BigDecimal(1))
                    .withBaseCalculo(new BigDecimal(1))
                    .withAliquota(new BigDecimal(1))
                    .withValor(new BigDecimal(1));
        assertModelWasFilled(icms);
    }

    @Test
    public void testNaoTributadoInterface() {
        ICMSNaoTributado icms = new ICMSBuilder()
                .naoTributado()
                    .withOrigem(OrigemICMS.NACIONAL)
                    .withTributacao(TributacaoICMS.ISENTO);
        assertModelWasFilled(icms);
    }

    @Test
    public void testICMSDiferimentoInterface() {
        ICMSDiferimento icms = new ICMSBuilder()
                .diferimento()
                    .withOrigem(OrigemICMS.NACIONAL)
                    .withModalidade(ModalidadeBaseCalculo.MARGEM_VALOR_AGREGADO)
                    .withPercentualReducaoBaseCalculo(new BigDecimal(1))
                    .withBaseCalculo(new BigDecimal(1))
                    .withAliquota(new BigDecimal(1))
                    .withValor(new BigDecimal(1));
        assertModelWasFilled(icms);
    }

    @Test
    public void testICMSCobradoAnteriormentePorSubstituicaoInterface() {
        ICMSCobradoAnteriormentePorSubstituicao icms = new ICMSBuilder()
                .cobradoAnteriormentePorSubstituicao()
                    .withOrigem(OrigemICMS.NACIONAL)
                    .withValorBaseCalculoSubstituicaoTributaria(new BigDecimal(1))
                    .withValorSubstituicaoTributaria(new BigDecimal(1));
        assertModelWasFilled(icms);
    }

    @Test
    public void testICMSComReducaoBaseDeCalculoESubstituicaoTributariaInterface() {
        ICMSComReducaoBaseDeCalculoESubstituicaoTributaria icms = new ICMSBuilder()
                .comReducaoBaseDeCalculoESubstituicaoTributaria()
                    .withOrigem(OrigemICMS.NACIONAL)
                    .withModalidade(ModalidadeBaseCalculo.MARGEM_VALOR_AGREGADO)
                    .withPercentualReducaoBaseCalculo(new BigDecimal(1))
                    .withBaseDeCalculo(new BigDecimal(1))
                    .withAliquota(new BigDecimal(1))
                    .withValor(new BigDecimal(1))
                    .withModalidadeSubstituicaoTributaria(ModalidadeSubstituicaoTributaria.PAUTA)
                    .withPercentualAdicionadoSubstituicaoTributaria(new BigDecimal(1))
                    .withPercentualReducaoBaseCalculoSubstituicaoTributaria(new BigDecimal(1))
                    .withValorBaseCalculoSubstituicaoTributaria(new BigDecimal(1))
                    .withAliquotaSubstituicaoTributaria(new BigDecimal(1))
                    .withValorSubstituicaoTributaria(new BigDecimal(1));
        assertModelWasFilled(icms);
    }

    @Test
    public void testICMSOutrosInterface() {
        ICMSOutros icms = new ICMSBuilder()
                .outros()
                    .withOrigem(OrigemICMS.NACIONAL)
                    .withModalidade(ModalidadeBaseCalculo.MARGEM_VALOR_AGREGADO)
                    .withBaseDeCalculo(new BigDecimal(1))
                    .withPercentualReducaoBaseCalculo(new BigDecimal(1))
                    .withAliquota(new BigDecimal(1))
                    .withValor(new BigDecimal(1))
                    .withModalidadeSubstituicaoTributaria(ModalidadeSubstituicaoTributaria.PAUTA)
                    .withPercentualAdicionadoSubstituicaoTributaria(new BigDecimal(1))
                    .withValorBaseCalculoSubstituicaoTributaria(new BigDecimal(1))
                    .withAliquotaSubstituicaoTributaria(new BigDecimal(1))
                    .withValorSubstituicaoTributaria(new BigDecimal(1))
                    .withPercentualReducaoBaseCalculoSubstituicaoTributaria(new BigDecimal(1));

        assertModelWasFilled(icms);
    }

    private void assertModelWasFilled(ICMS icms) {
    	new BuilderTestHelper(icms).assertModelWasFilled();
    }
}
