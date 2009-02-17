package br.com.caelum.stella.nfe.builder.icms;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.builder.ICMSBuilder;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeST;
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
    public void testICMSTributadoComSTInterface() {
        ICMSTributadoComST icms = new ICMSBuilder()
                .tributadoComST()
                    .withOrigem(OrigemICMS.NACIONAL)
                    .withModalidade(ModalidadeBaseCalculo.MARGEM_VALOR_AGREGADO)
                    .withBaseDeCalculo(new BigDecimal(1))
                    .withAliquota(new BigDecimal(1))
                    .withValor(new BigDecimal(1))
                    .withModalidadeST(ModalidadeST.PAUTA)
                    .withPercentualAdicionado(new BigDecimal(1))
                    .withPercentualReducaoBaseCalculo(new BigDecimal(1))
                    .withValorDaBaseDeCalculoST(new BigDecimal(1))
                    .withAliquotaST(new BigDecimal(1))
                    .withValorST(new BigDecimal(1));
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
                    .withValorDaBaseDeCalculoST(new BigDecimal(1))
                    .withValorST(new BigDecimal(1));
        assertModelWasFilled(icms);
    }

    @Test
    public void testICMSComReducaoBaseDeCalculoESTInterface() {
        ICMSComReducaoBaseDeCalculoEST icms = new ICMSBuilder()
                .comReducaoBaseDeCalculoEST()
                    .withOrigem(OrigemICMS.NACIONAL)
                    .withModalidade(ModalidadeBaseCalculo.MARGEM_VALOR_AGREGADO)
                    .withPercentualReducaoBaseCalculo(new BigDecimal(1))
                    .withBaseDeCalculo(new BigDecimal(1))
                    .withAliquota(new BigDecimal(1))
                    .withValor(new BigDecimal(1))
                    .withModalidadeST(ModalidadeST.PAUTA)
                    .withPercentualAdicionadoST(new BigDecimal(1))
                    .withPercentualReducaoBaseCalculoST(new BigDecimal(1))
                    .withValorDaBaseDeCalculoST(new BigDecimal(1))
                    .withAliquotaST(new BigDecimal(1))
                    .withValorST(new BigDecimal(1));
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
                    .withModalidadeST(ModalidadeST.PAUTA)
                    .withPercentualAdicionadoST(new BigDecimal(1))
                    .withValorDaBaseDeCalculoST(new BigDecimal(1))
                    .withAliquotaST(new BigDecimal(1))
                    .withValorST(new BigDecimal(1))
                    .withPercentualReducaoBaseCalculoST(new BigDecimal(1));

        assertModelWasFilled(icms);
    }

    private void assertModelWasFilled(ICMS icms) {
    	new BuilderTestHelper(icms).assertModelWasFilled();
    }
}
