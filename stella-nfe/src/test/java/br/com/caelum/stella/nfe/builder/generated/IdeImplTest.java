package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

public final class IdeImplTest {
    @org.junit.Test
    public void testIdeInterface() {
        Ide ide = new IdeImpl().withCUF("abc").withCNF("abc").withNatOp("abc").withIndPag("abc").withMod("abc")
                .withSerie("abc").withNNF("abc").withDEmi(Calendar.getInstance()).withDSaiEnt(Calendar.getInstance())
                .withTpNF("abc").withCMunFG("abc").withNFref(new NFrefImpl()).withTpImp("abc").withTpEmis("abc")
                .withCDV("abc").withTpAmb("abc").withFinNFe("abc").withProcEmi("abc").withVerProc("abc");
        assertModelWasFilled(ide);
    }

    private void assertModelWasFilled(final Ide ide) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(ide).assertModelWasFilled();
    }
}