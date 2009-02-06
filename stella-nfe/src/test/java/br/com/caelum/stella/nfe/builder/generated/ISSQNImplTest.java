package br.com.caelum.stella.nfe.builder.generated;

public final class ISSQNImplTest {
    @org.junit.Test
    public void testISSQNInterface() {
        ISSQN iSSQN = new ISSQNImpl().withVBC("abc").withVAliq("abc").withVISSQN("abc").withCMunFG("abc")
                .withCListServ("abc");
        assertModelWasFilled(iSSQN);
    }

    private void assertModelWasFilled(ISSQN iSSQN) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iSSQN).assertModelWasFilled();
    }
}