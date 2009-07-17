package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public final class TRetEnviNFeImplTest {
    @org.junit.Test
    public void testTRetEnviNFeInterface() {
        RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<Object> tRetEnviNFe = new RetornoDoPedidoDeConcessaoDeAutorizacaoDaNFEImpl<Object>(
                new Object())
                             .withTipoDoAmbiente(TipoDoAmbiente.HOMOLOGACAO)
                             .withVersaoAplicativo("abc")
                             .withCodigoDeStatus("abc")
                             .withDescricaoDoStatus("abc")
                             .withCodigoDaUF("abc")
                             .withReciboDoLote(new ReciboDoLoteImpl<Object>(new Object()))
                             .withVersaoDaNFE("abc");
        BuilderTestHelper.assertModelWasFilled(tRetEnviNFe);
    }

}