package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSSTImpl implements COFINSST, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSST cOFINSST;

    public COFINSSTImpl() {
        cOFINSST = new br.com.caelum.stella.nfe.modelo.COFINSST();
    }

    public br.com.caelum.stella.nfe.modelo.COFINSST getInstance() {
        return cOFINSST;
    }

    public COFINSST withVBC(final String string) {
        cOFINSST.setValorBaseCalculo(string);
        return this;
    }

    public COFINSST withPCOFINS(final String string) {
        cOFINSST.setAliquotaEmPercentual(string);
        return this;
    }

    public COFINSST withQBCProd(final String string) {
        cOFINSST.setQuantidadeVendida(string);
        return this;
    }

    public COFINSST withVAliqProd(final String string) {
        cOFINSST.setAliquota(string);
        return this;
    }

    public COFINSST withVCOFINS(final String string) {
        cOFINSST.setValor(string);
        return this;
    }
}