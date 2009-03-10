package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public final class TRetConsReciNFeImplTest {
    @org.junit.Test
    public void testTRetConsReciNFeInterface() {
        RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE tRetConsReciNFe = new RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFEImpl()
                .withTipoDeAmbiente(TipoDoAmbiente.HOMOLOGACAO).withVersaoDaAplicativo("abc")
                .withNumeroDoReciboConsultado("abc").withCodigoDeStatus("abc").withDescricaoDoStatus("abc")
                .withCodigoDaUF("abc").withProtocoloDoResultadoDeProcessamento(new ProtocoloDoResultadoDeProcessamentoImpl()).withVersaoNFE("abc");
        assertModelWasFilled(tRetConsReciNFe);
    }

    private void assertModelWasFilled(final RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE tRetConsReciNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tRetConsReciNFe).assertModelWasFilled();
    }
}