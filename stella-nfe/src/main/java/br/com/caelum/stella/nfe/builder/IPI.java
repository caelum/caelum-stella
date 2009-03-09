package br.com.caelum.stella.nfe.builder;

import br.com.caelum.stella.nfe.builder.enums.SituacaoTributaria;

public interface IPI {

    public IPI withClasseDeEnquadramento(String classeDeEnquadramento);

    public IPI withCnpjDoProdutor(String cnpj);

    public IPI withCodigoDoSelo(String seloDeControle);

    public IPI withQuantidadeDeSelos(long quantidadeDeSelos);

    public IPI withCodigoDeEnquadramento(String codigoDeEnquadramento);

    public IPI withTributacao(IPITributacao ipiTrib);

    public IPI withIPIInt(SituacaoTributaria situacaoTributaria);
}
