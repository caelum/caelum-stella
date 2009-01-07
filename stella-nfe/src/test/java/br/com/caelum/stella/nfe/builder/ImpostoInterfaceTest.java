package br.com.caelum.stella.nfe.builder;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import net.vidageek.mirror.Mirror;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.icms.ICMSComReducaoBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.ICMSComReducaoBaseDeCalculoESubstituicaoTributaria;
import br.com.caelum.stella.nfe.builder.icms.ICMSDiferimento;
import br.com.caelum.stella.nfe.builder.icms.ICMSCobradoAnteriormentePorSubstituicao;
import br.com.caelum.stella.nfe.builder.icms.ICMSNaoTributado;
import br.com.caelum.stella.nfe.builder.icms.ICMSOutros;
import br.com.caelum.stella.nfe.builder.icms.ICMSTributadoComSubstituicaoTributaria;
import br.com.caelum.stella.nfe.builder.icms.ICMSTributadoIntegralmente;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeSubstituicaoTributaria;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.builder.icms.enums.TributacaoICMS;

public class ImpostoInterfaceTest {

    @Test
    public void testImpostosInterface() {

        Impostos
                .create()
                    .withICMS()
                    .withIPI()
                    .withII()
                    .withPIS()
                    .withPISST()
                    .withCOFINS()
                    .withCOFINSST()
                    .withISSQN();

    }

    @Test
    public void testICMSTributadoIntegralmenteInterface() {
        ICMSTributadoIntegralmente icms = new ICMSBuilder()
                .createICMSTributadoIntegralmente()
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
                .createICMSTributadoComSubstituicaoTributaria()
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
                .createICMSComReducaoBaseCalculo()
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
                .createICMSNaoTributado()
                    .withOrigem(OrigemICMS.NACIONAL)
                    .withTributacao(TributacaoICMS.ISENTO);
        assertModelWasFilled(icms);
    }

    @Test
    public void testICMSDiferimentoInterface() {
        ICMSDiferimento icms = new ICMSBuilder()
                .createICMSDiferimento()
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
                .createICMSCobradoAnteriormentePorSubstituicao()
                    .withOrigem(OrigemICMS.NACIONAL)
                    .withValorBaseCalculoSubstituicaoTributaria(new BigDecimal(1))
                    .withValorSubstituicaoTributaria(new BigDecimal(1));
        assertModelWasFilled(icms);
    }

    @Test
    public void testICMSComReducaoBaseDeCalculoESubstituicaoTributariaInterface() {
        ICMSComReducaoBaseDeCalculoESubstituicaoTributaria icms = new ICMSBuilder()
                .createICMSComReducaoBaseDeCalculoESubstituicaoTributaria()
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
                .createICMSOutros()
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
        Object instance = ((ObjectCreator) icms)
                .getInstance();
        for (Field field : Mirror.on(instance.getClass()).reflectAll().fields()) {
            Assert.assertNotNull("O campo " + field.getName() + " da classe " + icms.getClass() + " deveria ter sido preenchido.", 
                    Mirror.on(instance).get().field(field));
        }
    }
}
