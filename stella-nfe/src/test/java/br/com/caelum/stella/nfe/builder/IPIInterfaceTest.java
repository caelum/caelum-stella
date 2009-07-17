package br.com.caelum.stella.nfe.builder;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.caelum.stella.nfe.builder.enums.SituacaoTributaria;
import br.com.caelum.stella.nfe.builder.impl.IPIImpl;
import br.com.caelum.stella.nfe.builder.impl.IPITributacaoImpl;

public class IPIInterfaceTest {

    @Test
    public void testIPIInterface() {
        new IPIImpl<Object>(new Object())
                                         .withClasseDeEnquadramento("")
                                         .withCnpjDoProdutor("")
                                         .withCodigoDoSelo("")
                                         .withQuantidadeDeSelos(123456789012L)
                                         .withCodigoDeEnquadramento("")
                                         .withTributacao(new IPITributacaoImpl<Object>(new Object()))
                                         .withIPIInt(SituacaoTributaria.ENTRADA_COM_RECUPERACAO_DE_CREDITO);
    }

    @Test
    public void testIPIIntTrib() {
        new IPITributacaoImpl<Object>(new Object())
                                                   .withSituacaoTributaria(
                                                           SituacaoTributaria.ENTRADA_COM_RECUPERACAO_DE_CREDITO)
                                                   .withValorDaBaseDeCalculo(new BigDecimal(1))
                                                   .withAliquota(new BigDecimal(1))
                                                   .withQuantidadeTotal(new BigDecimal(1))
                                                   .withValorPorUnidadeTributavel(new BigDecimal(1))
                                                   .withValorDoIPI(new BigDecimal(1));
    }
}
