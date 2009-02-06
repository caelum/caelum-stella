package br.com.caelum.stella.nfe.builder.generated;

public final class ObsFiscoImplTest {
    @org.junit.Test
    public void testObsFiscoInterface() {
        ObsFisco obsFisco = new ObsFiscoImpl().withXTexto("abc").withXCampo("abc");
        assertModelWasFilled(obsFisco);
    }

    private void assertModelWasFilled(ObsFisco obsFisco) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(obsFisco).assertModelWasFilled();
    }
}