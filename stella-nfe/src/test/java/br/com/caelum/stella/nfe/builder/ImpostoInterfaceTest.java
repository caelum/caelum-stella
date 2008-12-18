package br.com.caelum.stella.nfe.builder;

import org.junit.Test;

import br.com.caelum.stella.nfe.builder.icms.ICMSComReducaoBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.ICMSTributadoComSubstituicaoTributaria;
import br.com.caelum.stella.nfe.builder.icms.ICMSTributadoIntegralmente;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeSubstituicaoTributaria;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;

public class ImpostoInterfaceTest {

    @Test
    public void testImpostosInterface() {

        Impostos.create().withICMS().withIPI().withII().withPIS().withPISST().withCOFINS().withCOFINSST().withISSQN();

    }

    @Test
    public void testICMSTributadoIntegralmenteInterface() {
        ICMSTributadoIntegralmente.create().withOrigem(OrigemICMS.NACIONAL).withModalidade(
                ModalidadeBaseCalculo.MARGEM_VALOR_AGREGADO).withBaseDeCalculo("").withAliquota("").withValor("");
    }

    @Test
    public void testICMSTributadoComSubstituicaoTributariaInterface() {
        ICMSTributadoComSubstituicaoTributaria.create().withOrigem(OrigemICMS.NACIONAL).withModalidade(
                ModalidadeBaseCalculo.MARGEM_VALOR_AGREGADO).withBaseDeCalculo("").withAliquota("").withValor("")
                .withModalidadeSubstituicaoTributaria(ModalidadeSubstituicaoTributaria.PAUTA).withPercentualAdicionado(
                        "").withPercentualReducaoBaseCalculo("").withValorBaseCalculoSubstituicaoTributaria("")
                .withAliquotaSubstituicaoTributaria("").withValorSubstituicaoTributaria("");
    }

    @Test
    public void testICMSComReducaoDeBaseDeCalculo() {
        ICMSComReducaoBaseCalculo.create().withOrigem(OrigemICMS.NACIONAL).withModalidade(
                ModalidadeBaseCalculo.MARGEM_VALOR_AGREGADO).withPercentualReducaoBaseCalculo("").withBaseCalculo(
                "").withAliquota("").withValor("");
    }
}
