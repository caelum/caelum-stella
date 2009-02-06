package br.com.caelum.stella.nfe.builder.generated;

public final class ICMSInterImplTest {
    @org.junit.Test
    public void testICMSInterInterface() {
        ICMSInter iCMSInter = new ICMSInterImpl().withVBCICMSSTDest("abc").withVICMSSTDest("abc");
        assertModelWasFilled(iCMSInter);
    }

    private void assertModelWasFilled(ICMSInter iCMSInter) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iCMSInter).assertModelWasFilled();
    }
}