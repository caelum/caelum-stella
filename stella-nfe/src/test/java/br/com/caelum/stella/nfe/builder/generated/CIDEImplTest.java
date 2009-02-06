package br.com.caelum.stella.nfe.builder.generated;

public final class CIDEImplTest {
    @org.junit.Test
    public void testCIDEInterface() {
        CIDE cIDE = new CIDEImpl().withQBCProd("abc").withVAliqProd("abc").withVCIDE("abc");
        assertModelWasFilled(cIDE);
    }

    private void assertModelWasFilled(CIDE cIDE) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cIDE).assertModelWasFilled();
    }
}