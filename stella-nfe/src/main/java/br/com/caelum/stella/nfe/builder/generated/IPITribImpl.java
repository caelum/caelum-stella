package br.com.caelum.stella.nfe.builder.generated;

public final class IPITribImpl implements IPITrib, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.IPITrib iPITrib;

    public IPITribImpl() {
        iPITrib = new br.com.caelum.stella.nfe.modelo.IPITrib();
    }

    public br.com.caelum.stella.nfe.modelo.IPITrib getInstance() {
        return iPITrib;
    }

    public IPITrib withCST(final String string) {
        iPITrib.setCodigoSituacaoTributaria(string);
        return this;
    }

    public IPITrib withVBC(final String string) {
        iPITrib.setValorBaseCalculo(string);
        return this;
    }

    public IPITrib withPIPI(final String string) {
        iPITrib.setAliquotaIPI(string);
        return this;
    }

    public IPITrib withQUnid(final String string) {
        iPITrib.setQuantidade(string);
        return this;
    }

    public IPITrib withVUnid(final String string) {
        iPITrib.setValorUnidade(string);
        return this;
    }

    public IPITrib withVIPI(final String string) {
        iPITrib.setValorIPI(string);
        return this;
    }
}