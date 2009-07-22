package br.com.caelum.stella.nfe.builder;

import br.com.caelum.stella.nfe.builder.enums.ICMSSituacaoTributaria;

public interface IPI<T> extends NFeBuilder<T> {

    public IPI<T> withClasseDeEnquadramento(String classeDeEnquadramento);

    public IPI<T> withCnpjDoProdutor(String cnpj);

    public IPI<T> withCodigoDoSelo(String seloDeControle);

    public IPI<T> withQuantidadeDeSelos(long quantidadeDeSelos);

    public IPI<T> withCodigoDeEnquadramento(String codigoDeEnquadramento);

    public IPI<T> withTributacao(IPITributacao<?> ipiTrib);

    public IPI<T> withIPIInt(ICMSSituacaoTributaria situacaoTributaria);
}
