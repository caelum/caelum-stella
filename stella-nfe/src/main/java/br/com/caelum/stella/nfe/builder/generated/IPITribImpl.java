package br.com.caelum.stella.nfe.builder.generated;

public final class IPITribImpl implements IPITrib, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.IPITrib iPITrib;

    public IPITribImpl() {
        iPITrib = new br.com.caelum.stella.nfe.modelo.IPITrib();
    }

    public br.com.caelum.stella.nfe.modelo.IPITrib getInstance() {
        return iPITrib;
    }

    public IPITrib withCodigoSituacaoTributaria(final String string) {
        iPITrib.setCodigoSituacaoTributaria(string);
        return this;
    }

    public IPITrib withValorDaBaseDeCalculo(final String string) {
        iPITrib.setvalorDaBaseDeCalculo(string);
        return this;
    }

    public IPITrib withAliquota(final String string) {
        iPITrib.setAliquotaIPI(string);
        return this;
    }

    public IPITrib withQuantidade(final String string) {
        iPITrib.setQuantidade(string);
        return this;
    }

    public IPITrib withValorPorUnidade(final String string) {
        iPITrib.setValorUnidade(string);
        return this;
    }

    public IPITrib withValor(final String string) {
        iPITrib.setValorIPI(string);
        return this;
    }
}