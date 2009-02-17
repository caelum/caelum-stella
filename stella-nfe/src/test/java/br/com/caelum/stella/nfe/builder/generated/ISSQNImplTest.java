package br.com.caelum.stella.nfe.builder.generated;

public final class ISSQNImplTest {
    @org.junit.Test
    public void testISSQNInterface() {
        ISSQN iSSQN = new ISSQNImpl().withValorDaBaseDeCalculo("abc").withAliquota("abc").withValorISSQN("abc").withCodigoMunicipio("abc")
                .withCodigoListaServicos("abc");
        assertModelWasFilled(iSSQN);
    }

    private void assertModelWasFilled(ISSQN iSSQN) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iSSQN).assertModelWasFilled();
    }
}