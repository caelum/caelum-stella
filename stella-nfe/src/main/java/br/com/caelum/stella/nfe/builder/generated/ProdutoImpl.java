package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class ProdutoImpl implements Produto, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Prod prod;

    public ProdutoImpl() {
        prod = new br.com.caelum.stella.nfe.modelo.Prod();
    }

    public br.com.caelum.stella.nfe.modelo.Prod getInstance() {
        return prod;
    }

    public Produto withCodigoDoProduto(final String string) {
        prod.setCProd(string);
        return this;
    }

    public Produto withCodigoEAN(final String string) {
        prod.setCEAN(string);
        return this;
    }

    public Produto withDescricaoDoProduto(final String string) {
        prod.setXProd(string);
        return this;
    }

    public Produto withCodigoNCM(final String string) {
        prod.setNCM(string);
        return this;
    }

    public Produto withCodigoEXTIPI(final String string) {
        prod.setEXTIPI(string);
        return this;
    }

    public Produto withGenero(final String string) {
        prod.setGenero(string);
        return this;
    }

    public Produto withCodigoFiscalDeOperacoesEPrestacoes(final String string) {
        prod.setCFOP(string);
        return this;
    }

    public Produto withUnidadeComercial(final String string) {
        prod.setUCom(string);
        return this;
    }

    public Produto withQuantidadeComercial(final BigDecimal string) {
        prod.setQCom(string.toString());
        return this;
    }

    public Produto withValorUnitarioDeComercializacao(final BigDecimal string) {
        prod.setVUnCom(string.toString());
        return this;
    }

    public Produto withValorBrutoDoProduto(final BigDecimal string) {
        prod.setVProd(string.toString());
        return this;
    }

    public Produto withCodigoEANDaUnidadeTributavel(final String string) {
        prod.setCEANTrib(string);
        return this;
    }

    public Produto withUnidadeTributavel(final String string) {
        prod.setUTrib(string);
        return this;
    }

    public Produto withQuantidadeTributavel(final BigDecimal string) {
        prod.setQTrib(string.toString());
        return this;
    }

    public Produto withValorUnitarioDeTributacao(final BigDecimal string) {
        prod.setVUnTrib(string.toString());
        return this;
    }

    public Produto withValorDoFrete(final BigDecimal string) {
        prod.setVFrete(string.toString());
        return this;
    }

    public Produto withValorDoSeguro(final BigDecimal string) {
        prod.setVSeg(string.toString());
        return this;
    }

    public Produto withValorDeDesconto(final BigDecimal string) {
        prod.setVDesc(string.toString());
        return this;
    }

    public Produto withDI(final DI... di) {
        List<br.com.caelum.stella.nfe.modelo.DI> list = new ArrayList<br.com.caelum.stella.nfe.modelo.DI>();
        for (DI p : di) {
            list.add((br.com.caelum.stella.nfe.modelo.DI) ((ObjectCreator) p).getInstance());
        }
        prod.setDI(list);
        return this;
    }

    public Produto withVeiculoNovo(final VeiculoNovo veicProd) {
        prod.setVeicProd((br.com.caelum.stella.nfe.modelo.VeicProd) ((ObjectCreator) veicProd).getInstance());
        return this;
    }

    public Produto withMedicamento(final Medicamento... meds) {
        List<br.com.caelum.stella.nfe.modelo.Med> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Med>();
        for (Medicamento p : meds) {
            list.add((br.com.caelum.stella.nfe.modelo.Med) ((ObjectCreator) p).getInstance());
        }
        prod.setMed(list);
        return this;
    }

    public Produto withArmamento(final Armamento... armas) {
        List<br.com.caelum.stella.nfe.modelo.Arma> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Arma>();
        for (Armamento p : armas) {
            list.add((br.com.caelum.stella.nfe.modelo.Arma) ((ObjectCreator) p).getInstance());
        }
        prod.setArma(list);
        return this;
    }

    public Produto withCombustivel(final Combustivel comb) {
        prod.setComb((br.com.caelum.stella.nfe.modelo.Comb) ((ObjectCreator) comb).getInstance());
        return this;
    }
}