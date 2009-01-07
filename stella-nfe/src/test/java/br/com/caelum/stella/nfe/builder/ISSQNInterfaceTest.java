package br.com.caelum.stella.nfe.builder;

import java.math.BigDecimal;

import org.junit.Test;

public class ISSQNInterfaceTest {

    @Test
    public void testISSQNInterface() {
        new ImpostoBuilder()
                .createISSQN()
                    .withValorBaseCalculo(new BigDecimal(1))
                    .withAliquota(new BigDecimal(1))
                    .withValor(new BigDecimal(1))
                    .withCodigoMunicipio(1)
                    .withCodigoListaServicos(1);
    }

}
