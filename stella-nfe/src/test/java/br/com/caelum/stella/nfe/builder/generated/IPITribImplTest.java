package br.com.caelum.stella.nfe.builder.generated;

public final class IPITribImplTest {
    @org.junit.Test
    public void testIPITribInterface() {
        IPITrib iPITrib = new IPITribImpl().withCST("abc").withVBC("abc").withPIPI("abc").withQUnid("abc").withVUnid(
                "abc").withVIPI("abc");
        assertModelWasFilled(iPITrib);
    }

    private void assertModelWasFilled(IPITrib iPITrib) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iPITrib).assertModelWasFilled();
    }
}