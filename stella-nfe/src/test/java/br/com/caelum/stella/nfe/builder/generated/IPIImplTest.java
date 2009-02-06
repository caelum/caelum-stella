package br.com.caelum.stella.nfe.builder.generated;

public final class IPIImplTest {
    @org.junit.Test
    public void testIPIInterface() {
        IPI iPI = new IPIImpl().withClEnq("abc").withCNPJProd("abc").withCSelo("abc").withQSelo("abc").withCEnq("abc")
                .withIPITrib(new IPITribImpl()).withIPINT(new IPINTImpl());
        assertModelWasFilled(iPI);
    }

    private void assertModelWasFilled(final IPI iPI) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iPI).assertModelWasFilled();
    }
}