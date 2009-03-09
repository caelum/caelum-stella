package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.IPI;
import br.com.caelum.stella.nfe.builder.enums.SituacaoTributaria;
import br.com.caelum.stella.nfe.builder.impl.IPIImpl;
import br.com.caelum.stella.nfe.builder.impl.IPITributacaoImpl;

public final class IPIImplTest {
    @org.junit.Test
    public void testIPIInterface() {
        IPI iPI = new IPIImpl().withClasseDeEnquadramento("abc").withCnpjDoProdutor("abc").withCodigoDoSelo("abc")
                .withQuantidadeDeSelos(1L).withCodigoDeEnquadramento("abc").withTributacao(new IPITributacaoImpl())
                .withIPIInt(SituacaoTributaria.ENTRADA_COM_RECUPERACAO_DE_CREDITO);
        assertModelWasFilled(iPI);
    }

    private void assertModelWasFilled(final IPI iPI) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iPI).assertModelWasFilled();
    }
}