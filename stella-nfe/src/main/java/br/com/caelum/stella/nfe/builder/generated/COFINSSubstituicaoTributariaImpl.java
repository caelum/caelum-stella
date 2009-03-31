package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class COFINSSubstituicaoTributariaImpl implements COFINSSubstituicaoTributaria, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSST cOFINSST;

    public COFINSSubstituicaoTributariaImpl() {
        cOFINSST = new br.com.caelum.stella.nfe.modelo.COFINSST();
    }

    public br.com.caelum.stella.nfe.modelo.COFINSST getInstance() {
        return cOFINSST;
    }

    public COFINSSubstituicaoTributaria withValorDaBaseDeCalculo(final BigDecimal baseDeCalculo) {
        cOFINSST.setvalorDaBaseDeCalculo(baseDeCalculo.toPlainString());
        return this;
    }

    public COFINSSubstituicaoTributaria withAliquotaEmPercentual(final BigDecimal percentual) {
        cOFINSST.setAliquotaEmPercentual(percentual.toPlainString());
        return this;
    }

    public COFINSSubstituicaoTributaria withQuantidadeVendida(final BigDecimal string) {
        cOFINSST.setQuantidadeVendida(string.toString());
        return this;
    }

    public COFINSSubstituicaoTributaria withAliquota(final BigDecimal string) {
        cOFINSST.setAliquota(string.toString());
        return this;
    }

    public COFINSSubstituicaoTributaria withValor(final BigDecimal string) {
        cOFINSST.setValor(string.toString());
        return this;
    }
}