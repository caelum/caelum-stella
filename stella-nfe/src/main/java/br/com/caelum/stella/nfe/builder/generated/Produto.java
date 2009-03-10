package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public interface Produto {
    public Produto withCodigoDoProduto(String string);

    public Produto withCodigoEAN(String string);

    public Produto withDescricaoDoProduto(String string);

    public Produto withCodigoNCM(String string);

    public Produto withCodigoEXTIPI(String string);

    public Produto withGenero(String string);

    public Produto withCodigoFiscalDeOperacoesEPrestacoes(String string);

    public Produto withUnidadeComercial(String string);

    public Produto withQuantidadeComercial(BigDecimal string);

    public Produto withValorUnitarioDeComercializacao(BigDecimal string);

    public Produto withValorBrutoDoProduto(BigDecimal string);

    public Produto withCodigoEANDaUnidadeTributavel(String string);

    public Produto withUnidadeTributavel(String string);

    public Produto withQuantidadeTributavel(BigDecimal string);

    public Produto withValorUnitarioDeTributacao(BigDecimal string);

    public Produto withValorDoFrete(BigDecimal string);

    public Produto withValorDoSeguro(BigDecimal string);

    public Produto withValorDeDesconto(BigDecimal string);

    public Produto withDI(DI... di);

    public Produto withVeiculoNovo(VeiculoNovo veicProd);

    public Produto withMedicamento(Medicamento... meds);

    public Produto withArmamento(Armamento... armas);

    public Produto withCombustivel(Combustivel comb);
}