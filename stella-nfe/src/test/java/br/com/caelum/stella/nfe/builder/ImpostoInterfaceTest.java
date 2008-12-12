package br.com.caelum.stella.nfe.builder;

import org.junit.Test;

import br.com.caelum.stella.nfe.builder.icms.ICMSTributadoIntegralmente;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeICMS;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;

public class ImpostoInterfaceTest {

    @Test
    public void testaInterfaceDeImpostos() {

        Impostos.create().withICMS().withIPI().withII().withPIS().withPISST().withCOFINS().withCOFINSST().withISSQN();

    }

    @Test
    public void testaInterfaceDoICMSTributadoIntegralmente() {
        ICMSTributadoIntegralmente.create().withOrigem(OrigemICMS.NACIONAL).withModalidade(
                ModalidadeICMS.MARGEM_VALOR_AGREGADO).withBaseDeCalculo("").withAliquota("").withValor("");
    }
}
