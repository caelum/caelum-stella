package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSSTImpl implements COFINSST, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSST cOFINSST;

    public COFINSSTImpl() {
        cOFINSST = new br.com.caelum.stella.nfe.modelo.COFINSST();
    }

    public br.com.caelum.stella.nfe.modelo.COFINSST getInstance() {
        return cOFINSST;
    }

    public COFINSST withValorDaBaseDeCalculo(final String string) {
        cOFINSST.setvalorDaBaseDeCalculo(string);
        return this;
    }

    public COFINSST withAliquotaEmPercentual(final String string) {
        cOFINSST.setAliquotaEmPercentual(string);
        return this;
    }

    public COFINSST withQuantidadeVendida(final String string) {
        cOFINSST.setQuantidadeVendida(string);
        return this;
    }

    public COFINSST withAliquota(final String string) {
        cOFINSST.setAliquota(string);
        return this;
    }

    public COFINSST withValor(final String string) {
        cOFINSST.setValor(string);
        return this;
    }
}