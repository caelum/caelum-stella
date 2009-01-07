package br.com.caelum.stella.nfe.builder;

import br.com.caelum.stella.nfe.builder.enums.SituacaoTributaria;

public interface IPI {

    public IPI withClasseDeEnquadramento(String classeDeEnquadramento);

    public IPI withCNPJDoProdutor(String cnpj);

    public IPI withCodigoDoSeloDeControle(String seloDeControle);

    public IPI withQuantidadeDeSelos(long quantidadeDeSelos);

    public IPI withCodigoDeEnquandramento(String codigoDeEnquadramento);

    public IPI withIPITrib(IPITributacao ipiTrib);

    public IPI withIPIInt(SituacaoTributaria situacaoTributaria);
}
