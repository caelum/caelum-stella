package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class COFINSImplTest {
    @org.junit.Test
    public void testCOFINSInterface() {
        COFINS<Object> cOFINS = new COFINSImpl<Object>(new Object()).withTributacaoPelaAliquota(
                new COFINSTributadoPelaAliquotaImpl<Object>(new Object())).withTributacaoPelaQuantidade(
                new COFINSTributadoPelaQuantidadeImpl<Object>(new Object())).withNaoTributado(
                new COFINSNaoTributadoImpl<Object>(new Object())).withTributacaoDeOutrasOperacoes(
                new COFINSOutrasOperacoesImpl<Object>(new Object()));
        BuilderTestHelper.assertModelWasFilled(cOFINS);
    }

}