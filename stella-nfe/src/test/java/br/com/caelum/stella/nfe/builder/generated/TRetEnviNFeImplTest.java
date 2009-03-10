package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public final class TRetEnviNFeImplTest {
    @org.junit.Test
    public void testTRetEnviNFeInterface() {
        RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE tRetEnviNFe = new RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFEImpl()
                .withTipoDoAmbiente(TipoDoAmbiente.HOMOLOGACAO).withVersaoAplicativo("abc").withCodigoDeStatus("abc")
                .withDescricaoDoStatus("abc").withCodigoDaUF("abc").withReciboDoLote(new InfRecImpl()).withVersaoDaNFE(
                        "abc");
        assertModelWasFilled(tRetEnviNFe);
    }

    private void assertModelWasFilled(final RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE tRetEnviNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tRetEnviNFe).assertModelWasFilled();
    }
}