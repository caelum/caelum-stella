package br.com.caelum.stella.nfe.builder;

import java.math.BigDecimal;

import org.junit.Test;

public class IIInterfaceTest {

    @Test
    public void testIIInterface() {

        new ImpostoBuilder()
                .createII()
                    .withValorDaBaseDeCalculo(new BigDecimal(1))
                    .withValorAduaneira(new BigDecimal(1))
                    .withValorII(new BigDecimal(1))
                    .withValorIOF(new BigDecimal(1));

    }

}
