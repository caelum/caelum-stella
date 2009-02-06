package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSOutrImpl implements COFINSOutr, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSOutr cOFINSOutr;

    public COFINSOutrImpl() {
        cOFINSOutr = new br.com.caelum.stella.nfe.modelo.COFINSOutr();
    }

    public br.com.caelum.stella.nfe.modelo.COFINSOutr getInstance() {
        return cOFINSOutr;
    }

    public COFINSOutr withCST(final String string) {
        cOFINSOutr.setCodigoSituacaoTributaria(string);
        return this;
    }

    public COFINSOutr withVBC(final String string) {
        cOFINSOutr.setValorBaseCalculo(string);
        return this;
    }

    public COFINSOutr withPCOFINS(final String string) {
        cOFINSOutr.setAliquotaEmPercentual(string);
        return this;
    }

    public COFINSOutr withQbcProd(final String string) {
        cOFINSOutr.setQuantidadeVendida(string);
        return this;
    }

    public COFINSOutr withVAliqProd(final String string) {
        cOFINSOutr.setAliquota(string);
        return this;
    }

    public COFINSOutr withVCOFINS(final String string) {
        cOFINSOutr.setValor(string);
        return this;
    }
}