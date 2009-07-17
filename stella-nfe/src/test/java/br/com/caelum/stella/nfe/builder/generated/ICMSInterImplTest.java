package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class ICMSInterImplTest {
    @org.junit.Test
    public void testICMSInterInterface() {
        ICMSSobreOperacoesInterestaduais<Object> iCMSInter = new ICMSSobreOperacoesInterestaduaisImpl<Object>(
                new Object())
                             .withValorDaBaseDeCalculoDoICMSSubstituicaoTributariaDoDestino(new BigDecimal("1"))
                             .withValorDoICMSSubstituicaoTributariaDoDestino(new BigDecimal("1"));
        BuilderTestHelper.assertModelWasFilled(iCMSInter);
    }

}