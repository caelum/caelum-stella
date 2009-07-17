package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;
import br.com.caelum.stella.nfe.modelo.UF;

public final class ICMSConsImplTest {
    @org.junit.Test
    public void testICMSConsInterface() {
        ICMSSobreConsumo<Object> iCMSCons = new ICMSSobreConsumoImpl<Object>(new Object())
                                                                                          .withValorDaBaseDeCalculoDoICMSDeSubstituicaoTributariaSobreConsumo(
                                                                                                  new BigDecimal("1"))
                                                                                          .withValorDoICMSSubstituicaoTributariaSobreConsumo(
                                                                                                  new BigDecimal("1"))
                                                                                          .withUF(UF.AC);
        BuilderTestHelper.assertModelWasFilled(iCMSCons);
    }

}