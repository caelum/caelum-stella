package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class COFINSSTImpl implements COFINSST, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSST cOFINSST;

    public COFINSSTImpl() {
        cOFINSST = new br.com.caelum.stella.nfe.modelo.COFINSST();
    }

    public br.com.caelum.stella.nfe.modelo.COFINSST getInstance() {
        return cOFINSST;
    }

    public COFINSST withValorDaBaseDeCalculo(final BigDecimal baseDeCalculo) {
        cOFINSST.setvalorDaBaseDeCalculo(baseDeCalculo.toPlainString());
        return this;
    }

    public COFINSST withAliquotaEmPercentual(final BigDecimal percentual) {
        cOFINSST.setAliquotaEmPercentual(percentual.toPlainString());
        return this;
    }

    public COFINSST withQuantidadeVendida(final BigDecimal string) {
        cOFINSST.setQuantidadeVendida(string.toString());
        return this;
    }

    public COFINSST withAliquota(final BigDecimal string) {
        cOFINSST.setAliquota(string.toString());
        return this;
    }

    public COFINSST withValor(final BigDecimal string) {
        cOFINSST.setValor(string.toString());
        return this;
    }
}