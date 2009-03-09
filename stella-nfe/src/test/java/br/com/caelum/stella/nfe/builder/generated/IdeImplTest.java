package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.generated.enums.FormaDePagamento;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDocumentoFiscal;

public final class IdeImplTest {
    @org.junit.Test
    public void testIdeInterface() {
        Ide ide = new IdeImpl().withCUF("abc").withCNF(1).withNatOp("abc").withIndPag(FormaDePagamento.A_PRAZO)
                .withMod("abc").withSerie("abc").withNNF("abc").withDEmi(Calendar.getInstance()).withDSaiEnt(
                        Calendar.getInstance()).withTpNF(TipoDocumentoFiscal.ENTRADA).withCMunFG("abc").withNFref(
                        new NFrefImpl()).withTpImp("abc").withTpEmis("abc").withCDV("abc").withTpAmb("abc").withFinNFe(
                        "abc").withProcEmi("abc").withVerProc("abc");
        assertModelWasFilled(ide);
    }

    private void assertModelWasFilled(final Ide ide) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(ide).assertModelWasFilled();
    }
}