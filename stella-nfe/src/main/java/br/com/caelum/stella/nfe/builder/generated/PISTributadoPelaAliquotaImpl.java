package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISTributadoPelaAliquotaImpl implements PISTributadoPelaAliquota,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISAliq pISAliq;

    public PISTributadoPelaAliquotaImpl() {
        pISAliq = new br.com.caelum.stella.nfe.modelo.PISAliq();
    }

    public br.com.caelum.stella.nfe.modelo.PISAliq getInstance() {
        return pISAliq;
    }

    public PISTributadoPelaAliquota withCodigoSituacaoTributaria(final String string) {
        pISAliq.setCST(string);
        return this;
    }

    public PISTributadoPelaAliquota withValorDaBaseDeCalculo(final BigDecimal string) {
        pISAliq.setVBC(string.toString());
        return this;
    }

    public PISTributadoPelaAliquota withAliquotaDoPIS(final BigDecimal aliquota) {
        pISAliq.setPPIS(aliquota.toPlainString());
        return this;
    }

    public PISTributadoPelaAliquota withValorDoPIS(final BigDecimal string) {
        pISAliq.setVPIS(string.toString());
        return this;
    }
}