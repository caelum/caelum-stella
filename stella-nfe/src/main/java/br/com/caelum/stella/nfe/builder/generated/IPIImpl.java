package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class IPIImpl implements IPI, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.IPI iPI;

    public IPIImpl() {
        iPI = new br.com.caelum.stella.nfe.modelo.IPI();
    }

    public br.com.caelum.stella.nfe.modelo.IPI getInstance() {
        return iPI;
    }

    public IPI withClEnq(final String string) {
        iPI.setClasseEnquadramento(string);
        return this;
    }

    public IPI withCNPJProd(final String string) {
        iPI.setCnpjProdutor(string);
        return this;
    }

    public IPI withCSelo(final String string) {
        iPI.setCodigoSelo(string);
        return this;
    }

    public IPI withQSelo(final String string) {
        iPI.setQuantidadeSelo(string);
        return this;
    }

    public IPI withCEnq(final String string) {
        iPI.setCodigoEnquadramento(string);
        return this;
    }

    public IPI withIPITrib(final IPITrib iPITrib) {
        iPI.setIpiTributacao((br.com.caelum.stella.nfe.modelo.IPITrib) ((ObjectCreator) iPITrib).getInstance());
        return this;
    }

    public IPI withIPINT(final IPINT iPINT) {
        iPI.setIpint((br.com.caelum.stella.nfe.modelo.IPINT) ((ObjectCreator) iPINT).getInstance());
        return this;
    }
}