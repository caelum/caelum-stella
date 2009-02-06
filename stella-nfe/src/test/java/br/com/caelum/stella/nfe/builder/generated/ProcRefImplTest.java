package br.com.caelum.stella.nfe.builder.generated;

public final class ProcRefImplTest {
    @org.junit.Test
    public void testProcRefInterface() {
        ProcRef procRef = new ProcRefImpl().withNProc("abc").withIndProc("abc");
        assertModelWasFilled(procRef);
    }

    private void assertModelWasFilled(ProcRef procRef) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(procRef).assertModelWasFilled();
    }
}