package br.com.caelum.stella.nfe.builder.impl;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.IPI;
import br.com.caelum.stella.nfe.builder.IPITributacao;
import br.com.caelum.stella.nfe.builder.enums.SituacaoTributaria;
import br.com.caelum.stella.nfe.modelo.IPINT;
import br.com.caelum.stella.nfe.modelo.IPITrib;

public class IPIImpl<T> implements IPI<T>, ObjectCreator {

    private final br.com.caelum.stella.nfe.modelo.IPI ipi;
    private final T parent;

    public IPIImpl(final T parent) {
        this.parent = parent;
        ipi = new br.com.caelum.stella.nfe.modelo.IPI();
    }

    public T build() {
        return parent;
    }

    public IPI<T> withClasseDeEnquadramento(final String classeDeEnquadramento) {
        ipi.setClasseEnquadramento(classeDeEnquadramento);
        return this;
    }

    public IPI<T> withCnpjDoProdutor(final String cnpj) {
        ipi.setCnpjProdutor(cnpj);
        return this;
    }

    public IPI<T> withCodigoDoSelo(final String seloDeControle) {
        ipi.setCodigoSelo(seloDeControle);
        return this;
    }

    public IPI<T> withQuantidadeDeSelos(final long quantidadeDeSelos) {
        ipi.setQuantidadeSelo("" + quantidadeDeSelos);
        return this;
    }

    public IPI<T> withCodigoDeEnquadramento(final String codigoDeEnquadramento) {
        ipi.setCodigoEnquadramento(codigoDeEnquadramento);
        return this;
    }

    public IPI<T> withTributacao(final IPITributacao<?> ipiTrib) {
        ipi.setIpiTributacao((IPITrib) ((ObjectCreator) ipiTrib).getInstance());
        return this;
    }

    public IPI<T> withIPIInt(final SituacaoTributaria situacaoTributaria) {
        IPINT ipint = new IPINT();
        ipint.setCodigoSituacaoTributaria("" + situacaoTributaria.getCodigo());
        ipi.setIpint(ipint);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) ipi;
    }

}
