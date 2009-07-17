package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class PISImplTest {
    @org.junit.Test
    public void testPISInterface() {
        PIS<Object> pIS = new PISImpl<Object>(new Object()).withPISTributadoPelaAliquota(
                new PISTributadoPelaAliquotaImpl<Object>(new Object())).withPISTributadoPorQuantidade(
                new PISTributadoPorQuantidadeImpl<Object>(new Object())).withPISNaoTributado(
                new PISNaoTributadoImpl<Object>(new Object())).withPISOutrasOperacoes(
                new PISOutrasOperacoesImpl<Object>(new Object()));
        BuilderTestHelper.assertModelWasFilled(pIS);
    }

}