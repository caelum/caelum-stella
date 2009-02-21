package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.Impostos;

public interface Det {
    public Det withProd(Prod prod);

    public Det withImposto(Impostos impostos);

    public Det withInfAdProd(String string);

    public Det withNItem(String string);
}