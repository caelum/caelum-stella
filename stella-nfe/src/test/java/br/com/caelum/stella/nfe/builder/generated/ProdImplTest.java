package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class ProdImplTest {
    @org.junit.Test
    public void testProdInterface() {
        Produto prod = new ProdutoImpl().withCodigoDoProduto("abc").withCodigoEAN("abc").withDescricaoDoProduto("abc").withCodigoNCM("abc").withCodigoEXTIPI("abc")
                .withGenero("abc").withCodigoFiscalDeOperacoesEPrestacoes("abc").withUnidadeComercial("abc").withQuantidadeComercial(new BigDecimal(1)).withValorUnitarioDeComercializacao(
                        new BigDecimal(1)).withValorBrutoDoProduto(new BigDecimal(1)).withCodigoEANDaUnidadeTributavel("abc").withUnidadeTributavel("abc").withQuantidadeTributavel(
                        new BigDecimal(1)).withValorUnitarioDeTributacao(new BigDecimal(1)).withValorDoFrete(new BigDecimal(1)).withValorDoSeguro(
                        new BigDecimal(1)).withValorDeDesconto(new BigDecimal(1)).withDI(new DIImpl()).withVeiculoNovo(
                        new VeiculoNovoImpl()).withMedicamento(new MedImpl()).withArmamento(new ArmamentoImpl()).withCombustivel(
                        new CombImpl());
        assertModelWasFilled(prod);
    }

    private void assertModelWasFilled(final Produto prod) {
        new br.com.caelum.stella.nfe.builder.BuilderTestHelper(prod).assertModelWasFilled();
    }
}