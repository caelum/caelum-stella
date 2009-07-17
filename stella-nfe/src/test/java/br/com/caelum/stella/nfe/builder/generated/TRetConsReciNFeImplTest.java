package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public final class TRetConsReciNFeImplTest {
    @org.junit.Test
    public void testTRetConsReciNFeInterface() {
        RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<Object> tRetConsReciNFe = new RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFEImpl<Object>(
                new Object())
                             .withTipoDeAmbiente(TipoDoAmbiente.HOMOLOGACAO)
                             .withVersaoDaAplicativo("abc")
                             .withNumeroDoReciboConsultado("abc")
                             .withCodigoDeStatus("abc")
                             .withDescricaoDoStatus("abc")
                             .withCodigoDaUF("abc")
                             .withProtocoloDoResultadoDeProcessamento(
                                     new ProtocoloDoResultadoDeProcessamentoImpl<Object>(new Object()))
                             .withVersaoNFE("abc");
        BuilderTestHelper.assertModelWasFilled(tRetConsReciNFe);
    }

}