package br.com.caelum.stella.nfe.builder;

import org.junit.Test;

public class ImpostoInterfaceTest {

    @Test
    public void testImpostosInterface() {

        new Impostos()
                .withICMS(new ImpostoBuilder()
                        .createICMS()
                            .cobradoAnteriormentePorSubstituicao())
                    .withIPI(new ImpostoBuilder()
                            .createIPI())
                    .withII(new ImpostoBuilder()
                            .createII())
                    .withPIS()
                    .withPISST()
                    .withCOFINS()
                    .withCOFINSST()
                    .withISSQN(new ImpostoBuilder()
                            .createISS());
    }

}
