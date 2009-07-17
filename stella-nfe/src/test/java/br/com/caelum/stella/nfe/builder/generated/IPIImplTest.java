package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.builder.IPI;
import br.com.caelum.stella.nfe.builder.enums.SituacaoTributaria;
import br.com.caelum.stella.nfe.builder.impl.IPIImpl;
import br.com.caelum.stella.nfe.builder.impl.IPITributacaoImpl;

public final class IPIImplTest {
    @org.junit.Test
    public void testIPIInterface() {
        IPI<Object> iPI = new IPIImpl<Object>(new Object())
                                                           .withClasseDeEnquadramento("abc")
                                                           .withCnpjDoProdutor("abc")
                                                           .withCodigoDoSelo("abc")
                                                           .withQuantidadeDeSelos(1L)
                                                           .withCodigoDeEnquadramento("abc")
                                                           .withTributacao(new IPITributacaoImpl<Object>(new Object()))
                                                           .withIPIInt(
                                                                   SituacaoTributaria.ENTRADA_COM_RECUPERACAO_DE_CREDITO);
        BuilderTestHelper.assertModelWasFilled(iPI);
    }

}