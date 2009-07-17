package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TProtNFeImplTest {
    @org.junit.Test
    public void testTProtNFeInterface() {
        ProtocoloDoResultadoDeProcessamento<Object> tProtNFe = new ProtocoloDoResultadoDeProcessamentoImpl<Object>(
                new Object())
                             .withDadosDoProtocolo(new ProtocoloImpl<Object>(new Object()))
                             .withVersao("abc")
                             .withSignature(new SignatureType());
        BuilderTestHelper.assertModelWasFilled(tProtNFe);
    }

}