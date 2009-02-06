package br.com.caelum.stella.nfe.builder.generated;

public final class PISImplTest {
    @org.junit.Test
    public void testPISInterface() {
        PIS pIS = new PISImpl().withPISAliq(new PISAliqImpl()).withPISQtde(new PISQtdeImpl())
                .withPISNT(new PISNTImpl()).withPISOutr(new PISOutrImpl());
        assertModelWasFilled(pIS);
    }

    private void assertModelWasFilled(final PIS pIS) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pIS).assertModelWasFilled();
    }
}