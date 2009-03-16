package br.com.caelum.stella.nfe.builder.generated;

public final class ObsFiscoImplTest {
    @org.junit.Test
    public void testObsFiscoInterface() {
        ObservacaoFisco obsFisco = new ObservacaoFiscoImpl().withDescricaoDoTexto("abc").withDescricaoDoCampo("abc");
        assertModelWasFilled(obsFisco);
    }

    private void assertModelWasFilled(ObservacaoFisco obsFisco) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(obsFisco).assertModelWasFilled();
    }
}