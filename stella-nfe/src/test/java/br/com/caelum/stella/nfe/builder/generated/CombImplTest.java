package br.com.caelum.stella.nfe.builder.generated;

public final class CombImplTest {
    @org.junit.Test
    public void testCombInterface() {
        Comb comb = new CombImpl().withCProdANP("abc").withCODIF("abc").withQTemp("abc").withCIDE(new CIDEImpl())
                .withICMSComb(new ICMSCombImpl()).withICMSInter(new ICMSInterImpl()).withICMSCons(new ICMSConsImpl());
        assertModelWasFilled(comb);
    }

    private void assertModelWasFilled(final Comb comb) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(comb).assertModelWasFilled();
    }
}