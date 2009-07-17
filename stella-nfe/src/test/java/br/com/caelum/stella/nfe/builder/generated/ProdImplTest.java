package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.BuilderTestHelper;

public final class ProdImplTest {
    @org.junit.Test
    public void testProdInterface() {
        Produto<Object> prod = new ProdutoImpl<Object>(new Object())
                                                                    .withCodigoDoProduto("abc")
                                                                    .withCodigoEAN("abc")
                                                                    .withDescricaoDoProduto("abc")
                                                                    .withCodigoNCM("abc")
                                                                    .withCodigoEXTIPI("abc")
                                                                    .withGenero("abc")
                                                                    .withCodigoFiscalDeOperacoesEPrestacoes("abc")
                                                                    .withUnidadeComercial("abc")
                                                                    .withQuantidadeComercial(new BigDecimal(1))
                                                                    .withValorUnitarioDeComercializacao(
                                                                            new BigDecimal(1))
                                                                    .withValorBrutoDoProduto(new BigDecimal(1))
                                                                    .withCodigoEANDaUnidadeTributavel("abc")
                                                                    .withUnidadeTributavel("abc")
                                                                    .withQuantidadeTributavel(new BigDecimal(1))
                                                                    .withValorUnitarioDeTributacao(new BigDecimal(1))
                                                                    .withValorDoFrete(new BigDecimal(1))
                                                                    .withValorDoSeguro(new BigDecimal(1))
                                                                    .withValorDeDesconto(new BigDecimal(1))
                                                                    .withDI(
                                                                            new DeclaracaoDeImportacaoImpl<Object>(
                                                                                    new Object()))
                                                                    .withVeiculoNovo(
                                                                            new VeiculoNovoImpl<Object>(new Object()))
                                                                    .withMedicamento(
                                                                            new MedicamentoImpl<Object>(new Object()))
                                                                    .withArmamento(
                                                                            new ArmamentoImpl<Object>(new Object()))
                                                                    .withCombustivel(
                                                                            new CombustivelImpl<Object>(new Object()));
        BuilderTestHelper.assertModelWasFilled(prod);
    }

}