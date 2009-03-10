package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISSubstituicaoTributariaImpl implements PISSubstituicaoTributaria,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISST pISST;

    public PISSubstituicaoTributariaImpl() {
        pISST = new br.com.caelum.stella.nfe.modelo.PISST();
    }

    public br.com.caelum.stella.nfe.modelo.PISST getInstance() {
        return pISST;
    }

    public PISSubstituicaoTributaria withValorDaBaseDeCalculo(final BigDecimal string) {
        pISST.setVBC(string.toString());
        return this;
    }

    public PISSubstituicaoTributaria withAliquotaDaSubstituicaoTributaria(final BigDecimal string) {
        pISST.setPPIS(string.toString());
        return this;
    }

    public PISSubstituicaoTributaria withQuantidadeVendida(final BigDecimal string) {
        pISST.setQBCProd(string.toString());
        return this;
    }

    public PISSubstituicaoTributaria withAliquota(final BigDecimal string) {
        pISST.setVAliqProd(string.toString());
        return this;
    }

    public PISSubstituicaoTributaria withValor(final BigDecimal string) {
        pISST.setVPIS(string.toString());
        return this;
    }
}