 package br.com.caelum.stella.nfe.builder.impl;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.IPITributacao;
import br.com.caelum.stella.nfe.builder.enums.SituacaoTributaria;
import br.com.caelum.stella.nfe.modelo.IPI;
import br.com.caelum.stella.nfe.modelo.IPINT;
import br.com.caelum.stella.nfe.modelo.IPITrib;

public class IPIImpl implements br.com.caelum.stella.nfe.builder.IPI, ObjectCreator{

    private IPI ipi;

    public IPIImpl() {
        ipi = new IPI();
    }
    
    public IPIImpl withClasseDeEnquadramento(String classeDeEnquadramento) {
        ipi.setClasseEnquadramento(classeDeEnquadramento);
        return this;
    }

    public IPIImpl withCNPJDoProdutor(String cnpj) {
        ipi.setCnpjProdutor(cnpj);
        return this;
    }

    public IPIImpl withCodigoDoSeloDeControle(String seloDeControle) {
        ipi.setCodigoSelo(seloDeControle);
        return this;
    }

    public IPIImpl withQuantidadeDeSelos(long quantidadeDeSelos) {
        ipi.setQuantidadeSelo("" + quantidadeDeSelos);
        return this;
    }

    public IPIImpl withCodigoDeEnquandramento(String codigoDeEnquadramento) {
        ipi.setCodigoEnquadramento(codigoDeEnquadramento);
        return this;
    }

    public IPIImpl withIPITrib(IPITributacao ipiTrib) {
        ipi.setIpiTributacao((IPITrib)((ObjectCreator)ipiTrib).getInstance());
        return this;
    }

    public IPIImpl withIPIInt(SituacaoTributaria situacaoTributaria) {
        IPINT ipint = new IPINT();
        ipint.setCodigoSituacaoTributaria("" + situacaoTributaria.getCodigo());
        ipi.setIpint(ipint);
        return this;
    }

    public Object getInstance() {
        return ipi;
    }

}
