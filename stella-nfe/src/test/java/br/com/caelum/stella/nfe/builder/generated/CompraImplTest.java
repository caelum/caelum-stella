package br.com.caelum.stella.nfe.builder.generated;

public final class CompraImplTest {
    @org.junit.Test
    public void testCompraInterface() {
        Compra compra = new CompraImpl().withXNEmp("abc").withXPed("abc").withXCont("abc");
        assertModelWasFilled(compra);
    }

    private void assertModelWasFilled(Compra compra) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(compra).assertModelWasFilled();
    }
}