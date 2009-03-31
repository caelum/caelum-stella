package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.modelo.UF;

public final class ICMSConsImplTest {
    @org.junit.Test
    public void testICMSConsInterface() {
        ICMSSobreConsumo iCMSCons = new ICMSSobreConsumoImpl().withValorDaBaseDeCalculoDoICMSDeSubstituicaoTributariaSobreConsumo(new BigDecimal("1")).withValorDoICMSSubstituicaoTributariaSobreConsumo(
                new BigDecimal("1")).withUF(UF.AC);
        assertModelWasFilled(iCMSCons);
    }

    private void assertModelWasFilled(final ICMSSobreConsumo iCMSCons) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iCMSCons).assertModelWasFilled();
    }
}