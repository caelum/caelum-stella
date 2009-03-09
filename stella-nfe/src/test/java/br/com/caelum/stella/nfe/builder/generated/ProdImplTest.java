package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ProdImplTest {
    @org.junit.Test
    public void testProdInterface() {
        Prod prod = new ProdImpl().withCProd("abc").withCEAN("abc").withXProd("abc").withNCM("abc").withEXTIPI("abc")
                .withGenero("abc").withCFOP("abc").withUCom("abc").withQCom(new BigDecimal(1)).withVUnCom(
                        new BigDecimal(1)).withVProd(new BigDecimal(1)).withCEANTrib("abc").withUTrib("abc").withQTrib(
                        new BigDecimal(1)).withVUnTrib(new BigDecimal(1)).withVFrete(new BigDecimal(1)).withVSeg(
                        new BigDecimal(1)).withVDesc(new BigDecimal(1)).withDI(new DIImpl()).withVeicProd(
                        new VeicProdImpl()).withMed(new MedImpl()).withArma(new ArmamentoImpl()).withComb(
                        new CombImpl());
        assertModelWasFilled(prod);
    }

    private void assertModelWasFilled(final Prod prod) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(prod).assertModelWasFilled();
    }
}