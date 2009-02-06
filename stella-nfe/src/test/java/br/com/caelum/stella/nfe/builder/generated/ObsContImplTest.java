package br.com.caelum.stella.nfe.builder.generated;

public final class ObsContImplTest {
    @org.junit.Test
    public void testObsContInterface() {
        ObsCont obsCont = new ObsContImpl().withXTexto("abc").withXCampo("abc");
        assertModelWasFilled(obsCont);
    }

    private void assertModelWasFilled(ObsCont obsCont) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(obsCont).assertModelWasFilled();
    }
}