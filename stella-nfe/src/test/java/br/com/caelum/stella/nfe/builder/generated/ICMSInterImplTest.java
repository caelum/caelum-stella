package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ICMSInterImplTest {
    @org.junit.Test
    public void testICMSInterInterface() {
        ICMSSobreOperacoesInterestaduais iCMSInter = new ICMSSobreOperacoesInterestaduaisImpl().withValorDaBaseDeCalculoDoICMSSubstituicaoTributariaDoDestino(new BigDecimal("1")).withValorDoICMSSubstituicaoTributariaDoDestino(
                new BigDecimal("1"));
        assertModelWasFilled(iCMSInter);
    }

    private void assertModelWasFilled(final ICMSSobreOperacoesInterestaduais iCMSInter) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(iCMSInter).assertModelWasFilled();
    }
}