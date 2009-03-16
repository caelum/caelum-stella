package br.com.caelum.stella.nfe.builder.generated;

public final class ObsContImplTest {
    @org.junit.Test
    public void testObsContInterface() {
        ObservacoesDoContribuinte obsCont = new ObservacoesDoContribuinteImpl().withTextoDeDescricao("abc").withDescricaoDoCampo("abc");
        assertModelWasFilled(obsCont);
    }

    private void assertModelWasFilled(ObservacoesDoContribuinte obsCont) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(obsCont).assertModelWasFilled();
    }
}