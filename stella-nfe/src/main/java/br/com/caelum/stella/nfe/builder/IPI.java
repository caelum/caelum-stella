package br.com.caelum.stella.nfe.builder;

public class IPI {

    private IPI() {

    }

    public static IPI create() {
        return new IPI();
    }

    public IPI withClasseDeEnquadramento(String classeDeEnquadramento) {

        return this;
    }

    public IPI withCNPJDoProdutor(String cnpj) {

        return this;
    }

    public IPI withCodigoDoSeloDeControle(String seloDeControle) {

        return this;
    }

    public IPI withQuantidadeDeSelos(long quantidadeDeSelos) {

        return this;
    }

    public IPI withCodigoDeEnquandramento(String codigoDeEnquadramento) {

        return this;
    }

    public IPI withIPITrib(IPITrib ipiTrib) {

        return this;
    }

    public IPI withIPIInt(SituacaoTributaria situacaoTributaria) {

        return this;
    }

}
