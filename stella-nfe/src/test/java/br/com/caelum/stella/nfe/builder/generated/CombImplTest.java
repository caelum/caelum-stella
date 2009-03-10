package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class CombImplTest {
    @org.junit.Test
    public void testCombInterface() {
        Combustivel comb = new CombImpl().withCProdANP(1).withCODIF(new BigInteger("1")).withQTemp(new BigDecimal("1"))
                .withCIDE(new CIDEImpl()).withICMSComb(new ICMSCombImpl()).withICMSInter(new ICMSInterImpl())
                .withICMSCons(new ICMSConsImpl());
        assertModelWasFilled(comb);
    }

    private void assertModelWasFilled(final Combustivel comb) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(comb).assertModelWasFilled();
    }
}