package br.com.caelum.stella.nfe.builder.generated;

public final class FatImplTest {
    @org.junit.Test
    public void testFatInterface() {
        Fat fat = new FatImpl().withNFat("abc").withVOrig("abc").withVDesc("abc").withVLiq("abc");
        assertModelWasFilled(fat);
    }

    private void assertModelWasFilled(Fat fat) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(fat).assertModelWasFilled();
    }
}