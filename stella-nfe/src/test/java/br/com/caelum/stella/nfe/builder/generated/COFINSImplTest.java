package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSImplTest {
    @org.junit.Test
    public void testCOFINSInterface() {
        COFINS cOFINS = new COFINSImpl().withTributacaoPelaAliquota(new COFINSTributadoPelaAliquotaImpl()).withTributacaoPelaQuantidade(new COFINSTributadoPelaQuantidadeImpl())
                .withNaoTributado(new COFINSNaoTributadoImpl()).withTributacaoDeOutrasOperacoes(new COFINSOutrasOperacoesImpl());
        assertModelWasFilled(cOFINS);
    }

    private void assertModelWasFilled(final COFINS cOFINS) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(cOFINS).assertModelWasFilled();
    }
}