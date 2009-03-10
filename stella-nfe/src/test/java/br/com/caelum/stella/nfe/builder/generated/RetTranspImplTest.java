package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class RetTranspImplTest {
    @org.junit.Test
    public void testRetTranspInterface() {
        ICMSRetidoPeloTransporte retTransp = new ICMSRetidoPeloTransporteImpl().withValorDoServico(new BigDecimal(1)).withValorDaBaseDeCalculoDeRetencaoDoICMS(new BigDecimal(1))
                .withAliquotaDaRetencaoDoICMS(new BigDecimal(1)).withValorDoICMSRetido(new BigDecimal(1)).withCodigoFiscalDeOperacoesEPrestacoes("abc").withCodigoDoMunicipio("abc");
        assertModelWasFilled(retTransp);
    }

    private void assertModelWasFilled(final ICMSRetidoPeloTransporte retTransp) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(retTransp).assertModelWasFilled();
    }
}