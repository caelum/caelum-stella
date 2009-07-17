package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface Produto<T> extends NFeBuilder<T> {
    public Produto<T> withCodigoDoProduto(String string);

    public Produto<T> withCodigoEAN(String string);

    public Produto<T> withDescricaoDoProduto(String string);

    public Produto<T> withCodigoNCM(String string);

    public Produto<T> withCodigoEXTIPI(String string);

    public Produto<T> withGenero(String string);

    public Produto<T> withCodigoFiscalDeOperacoesEPrestacoes(String string);

    public Produto<T> withUnidadeComercial(String string);

    public Produto<T> withQuantidadeComercial(BigDecimal string);

    public Produto<T> withValorUnitarioDeComercializacao(BigDecimal string);

    public Produto<T> withValorBrutoDoProduto(BigDecimal string);

    public Produto<T> withCodigoEANDaUnidadeTributavel(String string);

    public Produto<T> withUnidadeTributavel(String string);

    public Produto<T> withQuantidadeTributavel(BigDecimal string);

    public Produto<T> withValorUnitarioDeTributacao(BigDecimal string);

    public Produto<T> withValorDoFrete(BigDecimal string);

    public Produto<T> withValorDoSeguro(BigDecimal string);

    public Produto<T> withValorDeDesconto(BigDecimal string);

    public Produto<T> withDI(DeclaracaoDeImportacao<?>... di);

    public Produto<T> withVeiculoNovo(VeiculoNovo<?> veicProd);

    public Produto<T> withMedicamento(Medicamento<?>... meds);

    public Produto<T> withArmamento(Armamento<?>... armas);

    public Produto<T> withCombustivel(Combustivel<?> comb);
}