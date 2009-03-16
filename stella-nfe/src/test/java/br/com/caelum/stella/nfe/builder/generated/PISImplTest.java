package br.com.caelum.stella.nfe.builder.generated;

public final class PISImplTest {
    @org.junit.Test
    public void testPISInterface() {
        PIS pIS = new PISImpl().withPISTributadoPelaAliquota(new PISTributadoPelaAliquotaImpl()).withPISTributadoPorQuantidade(new PISTributadoPorQuantidadeImpl())
                .withPISNaoTributado(new PISNaoTributadoImpl()).withPISOutrasOperacoes(new PISOutrasOperacoesImpl());
        assertModelWasFilled(pIS);
    }

    private void assertModelWasFilled(final PIS pIS) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(pIS).assertModelWasFilled();
    }
}