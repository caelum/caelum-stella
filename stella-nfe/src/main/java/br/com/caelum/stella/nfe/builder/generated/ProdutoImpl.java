package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class ProdutoImpl<T> implements Produto<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Prod prod;
    private final T parent;

    public ProdutoImpl(final T parent) {
        this.parent = parent;
        prod = new br.com.caelum.stella.nfe.modelo.Prod();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.prod;
    }

    public Produto<T> withCodigoDoProduto(final String string) {
        prod.setCProd(string);
        return this;
    }

    public Produto<T> withCodigoEAN(final String string) {
        prod.setCEAN(string);
        return this;
    }

    public Produto<T> withDescricaoDoProduto(final String string) {
        prod.setXProd(string);
        return this;
    }

    public Produto<T> withCodigoNCM(final String string) {
        prod.setNCM(string);
        return this;
    }

    public Produto<T> withCodigoEXTIPI(final String string) {
        prod.setEXTIPI(string);
        return this;
    }

    public Produto<T> withGenero(final String string) {
        prod.setGenero(string);
        return this;
    }

    public Produto<T> withCodigoFiscalDeOperacoesEPrestacoes(final String string) {
        prod.setCFOP(string);
        return this;
    }

    public Produto<T> withUnidadeComercial(final String string) {
        prod.setUCom(string);
        return this;
    }

    public Produto<T> withQuantidadeComercial(final BigDecimal string) {
        prod.setQCom(string.toString());
        return this;
    }

    public Produto<T> withValorUnitarioDeComercializacao(final BigDecimal string) {
        prod.setVUnCom(string.toString());
        return this;
    }

    public Produto<T> withValorBrutoDoProduto(final BigDecimal string) {
        prod.setVProd(string.toString());
        return this;
    }

    public Produto<T> withCodigoEANDaUnidadeTributavel(final String string) {
        prod.setCEANTrib(string);
        return this;
    }

    public Produto<T> withUnidadeTributavel(final String string) {
        prod.setUTrib(string);
        return this;
    }

    public Produto<T> withQuantidadeTributavel(final BigDecimal string) {
        prod.setQTrib(string.toString());
        return this;
    }

    public Produto<T> withValorUnitarioDeTributacao(final BigDecimal string) {
        prod.setVUnTrib(string.toString());
        return this;
    }

    public Produto<T> withValorDoFrete(final BigDecimal string) {
        prod.setVFrete(string.toString());
        return this;
    }

    public Produto<T> withValorDoSeguro(final BigDecimal string) {
        prod.setVSeg(string.toString());
        return this;
    }

    public Produto<T> withValorDeDesconto(final BigDecimal string) {
        prod.setVDesc(string.toString());
        return this;
    }

    public Produto<T> withDI(final DeclaracaoDeImportacao<?>... di) {
        List<br.com.caelum.stella.nfe.modelo.DI> list = new ArrayList<br.com.caelum.stella.nfe.modelo.DI>();
        for (DeclaracaoDeImportacao<?> p : di) {
            list.add((br.com.caelum.stella.nfe.modelo.DI) ((ObjectCreator) p).getInstance());
        }
        prod.setDI(list);
        return this;
    }

    public Produto<T> withVeiculoNovo(final VeiculoNovo<?> veicProd) {
        prod.setVeicProd((br.com.caelum.stella.nfe.modelo.VeicProd) ((ObjectCreator) veicProd).getInstance());
        return this;
    }

    public Produto<T> withMedicamento(final Medicamento<?>... meds) {
        List<br.com.caelum.stella.nfe.modelo.Med> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Med>();
        for (Medicamento<?> p : meds) {
            list.add((br.com.caelum.stella.nfe.modelo.Med) ((ObjectCreator) p).getInstance());
        }
        prod.setMed(list);
        return this;
    }

    public Produto<T> withArmamento(final Armamento<?>... armas) {
        List<br.com.caelum.stella.nfe.modelo.Arma> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Arma>();
        for (Armamento<?> p : armas) {
            list.add((br.com.caelum.stella.nfe.modelo.Arma) ((ObjectCreator) p).getInstance());
        }
        prod.setArma(list);
        return this;
    }

    public Produto<T> withCombustivel(final Combustivel<?> comb) {
        prod.setComb((br.com.caelum.stella.nfe.modelo.Comb) ((ObjectCreator) comb).getInstance());
        return this;
    }
}