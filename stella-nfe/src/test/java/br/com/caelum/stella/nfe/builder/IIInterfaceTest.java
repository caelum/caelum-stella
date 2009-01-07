package br.com.caelum.stella.nfe.builder;

import java.math.BigDecimal;

import org.junit.Test;

public class IIInterfaceTest {

    @Test
    public void testIIInterface() {

        new ImpostoBuilder()
                .createII()
                    .withValorBaseCalculo(new BigDecimal(1))
                    .withValorAduaneira(new BigDecimal(1))
                    .withValorImpostoImportacao(new BigDecimal(1))
                    .withValorImpostoSobreOperacoesFinanceiras(new BigDecimal(1));

    }

}
