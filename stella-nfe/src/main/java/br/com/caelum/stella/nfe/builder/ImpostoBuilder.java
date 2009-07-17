package br.com.caelum.stella.nfe.builder;

import br.com.caelum.stella.nfe.builder.impl.IIImpl;
import br.com.caelum.stella.nfe.builder.impl.IPIImpl;
import br.com.caelum.stella.nfe.builder.impl.ISSQNImpl;

public class ImpostoBuilder {

    public II createII() {
        return new IIImpl();
    }

    public IPI<ImpostoBuilder> createIPI() {
        return new IPIImpl<ImpostoBuilder>(this);
    }

    public ISS<ImpostoBuilder> createISS() {
        return new ISSQNImpl<ImpostoBuilder>(this);
    }

    public ICMSBuilder createICMS() {
        return new ICMSBuilder();
    }

    public COFINSBuilder createCOFINS() {
        return new COFINSBuilder();
    }

}
