package br.com.caelum.stella.nfe.builder.generated;

public final class ObsContImplTest {
    @org.junit.Test
    public void testObsContInterface() {
        ObservacaoDoContribuinte obsCont = new ObservacaoDoContribuinteImpl().withTextoDeDescricao("abc").withDescricaoDoCampo("abc");
        assertModelWasFilled(obsCont);
    }

    private void assertModelWasFilled(ObservacaoDoContribuinte obsCont) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(obsCont).assertModelWasFilled();
    }
}