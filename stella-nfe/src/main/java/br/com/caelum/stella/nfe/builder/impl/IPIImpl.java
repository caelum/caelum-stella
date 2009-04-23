package br.com.caelum.stella.nfe.builder.impl;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.IPITributacao;
import br.com.caelum.stella.nfe.builder.enums.SituacaoTributaria;
import br.com.caelum.stella.nfe.modelo.IPI;
import br.com.caelum.stella.nfe.modelo.IPINT;
import br.com.caelum.stella.nfe.modelo.IPITrib;

public class IPIImpl implements br.com.caelum.stella.nfe.builder.IPI, ObjectCreator {

    private final IPI ipi;

    public IPIImpl() {
        ipi = new IPI();
    }

    public IPIImpl withClasseDeEnquadramento(final String classeDeEnquadramento) {
        ipi.setClasseEnquadramento(classeDeEnquadramento);
        return this;
    }

    public IPIImpl withCnpjDoProdutor(final String cnpj) {
        ipi.setCnpjProdutor(cnpj);
        return this;
    }

    public IPIImpl withCodigoDoSelo(final String seloDeControle) {
        ipi.setCodigoSelo(seloDeControle);
        return this;
    }

    public IPIImpl withQuantidadeDeSelos(final long quantidadeDeSelos) {
        ipi.setQuantidadeSelo("" + quantidadeDeSelos);
        return this;
    }

    public IPIImpl withCodigoDeEnquadramento(final String codigoDeEnquadramento) {
        ipi.setCodigoEnquadramento(codigoDeEnquadramento);
        return this;
    }

    public IPIImpl withTributacao(final IPITributacao ipiTrib) {
        ipi.setIpiTributacao((IPITrib) ((ObjectCreator) ipiTrib).getInstance());
        return this;
    }

    public IPIImpl withIPIInt(final SituacaoTributaria situacaoTributaria) {
        IPINT ipint = new IPINT();
        ipint.setCodigoSituacaoTributaria("" + situacaoTributaria.getCodigo());
        ipi.setIpint(ipint);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) ipi;
    }

}
