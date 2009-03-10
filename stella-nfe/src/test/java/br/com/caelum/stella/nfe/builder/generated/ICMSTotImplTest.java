package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSTotImplTest {
    @org.junit.Test
    public void testICMSTotInterface() {
        ICMSTotal iCMSTot = new ICMSTotImpl().withVBC(new BigDecimal("1")).withVICMS(new BigDecimal("1")).withVBCST(
                new BigDecimal("1")).withVST(new BigDecimal("1")).withVProd(new BigDecimal("1")).withVFrete(
                new BigDecimal("1")).withVSeg(new BigDecimal("1")).withVDesc(new BigDecimal("1")).withVII(
                new BigDecimal("1")).withVIPI(new BigDecimal("1")).withVPIS(new BigDecimal("1")).withValor(
                new BigDecimal("1")).withVOutro(new BigDecimal("1")).withVNF(new BigDecimal("1"));
        assertModelWasFilled(iCMSTot);
    }

    private void assertModelWasFilled(final ICMSTotal iCMSTot) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iCMSTot).assertModelWasFilled();
    }
}