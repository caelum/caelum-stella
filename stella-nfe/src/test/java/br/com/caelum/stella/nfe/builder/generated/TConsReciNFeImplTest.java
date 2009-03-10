package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public final class TConsReciNFeImplTest {
    @org.junit.Test
    public void testTConsReciNFeInterface() {
        PedidoDeConsultaDoRecidoDoLoteDeNFE tConsReciNFe = new PedidoDeConsultaDoRecidoDoLoteDeNFEImpl()
                .withTipoDoAmbiente(TipoDoAmbiente.HOMOLOGACAO).withNumeroDoRecibo("abc").withVersao("abc");
        assertModelWasFilled(tConsReciNFe);
    }

    private void assertModelWasFilled(final PedidoDeConsultaDoRecidoDoLoteDeNFE tConsReciNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tConsReciNFe).assertModelWasFilled();
    }
}