package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public final class TConsReciNFeImplTest {
    @org.junit.Test
    public void testTConsReciNFeInterface() {
        PedidoDeConsultaDoRecidoDoLoteDeNFE<Object> tConsReciNFe = new PedidoDeConsultaDoRecidoDoLoteDeNFEImpl<Object>(
                new Object())
                             .withTipoDoAmbiente(TipoDoAmbiente.HOMOLOGACAO)
                             .withNumeroDoRecibo("abc")
                             .withVersao("abc");
        BuilderTestHelper.assertModelWasFilled(tConsReciNFe);
    }

}