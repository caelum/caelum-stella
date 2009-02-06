package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSQtdeImplTest {
    @org.junit.Test
    public void testCOFINSQtdeInterface() {
        COFINSQtde cOFINSQtde = new COFINSQtdeImpl().withCST("abc").withQBCProd("abc").withVAliqProd("abc")
                .withVCOFINS("abc");
        assertModelWasFilled(cOFINSQtde);
    }

    private void assertModelWasFilled(COFINSQtde cOFINSQtde) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cOFINSQtde).assertModelWasFilled();
    }
}