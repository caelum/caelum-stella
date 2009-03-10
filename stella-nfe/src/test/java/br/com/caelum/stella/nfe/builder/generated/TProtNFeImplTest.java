package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.SignatureType;

public final class TProtNFeImplTest {
    @org.junit.Test
    public void testTProtNFeInterface() {
        ProtocoloDoResultadoDeProcessamento tProtNFe = new ProtocoloDoResultadoDeProcessamentoImpl()
                                .withDadosDoProtocolo(new InfProtImpl())
                                .withVersao("abc")
                                .withSignature(new SignatureType());
        assertModelWasFilled(tProtNFe);
    }

    private void assertModelWasFilled(final ProtocoloDoResultadoDeProcessamento tProtNFe) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(tProtNFe).assertModelWasFilled();
    }
}