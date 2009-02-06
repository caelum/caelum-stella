package br.com.caelum.stella.nfe.builder.generated;

public final class ICMSCombImplTest {
    @org.junit.Test
    public void testICMSCombInterface() {
        ICMSComb iCMSComb = new ICMSCombImpl().withVBCICMS("abc").withVICMS("abc").withVBCICMSST("abc").withVICMSST(
                "abc");
        assertModelWasFilled(iCMSComb);
    }

    private void assertModelWasFilled(ICMSComb iCMSComb) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iCMSComb).assertModelWasFilled();
    }
}