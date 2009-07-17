package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface RetencaoDeTributosFederais<T> extends NFeBuilder<T> {
    public RetencaoDeTributosFederais<T> withVRetPIS(BigDecimal string);

    public RetencaoDeTributosFederais<T> withVRetCOFINS(BigDecimal string);

    public RetencaoDeTributosFederais<T> withVRetCSLL(BigDecimal string);

    public RetencaoDeTributosFederais<T> withVBCIRRF(BigDecimal string);

    public RetencaoDeTributosFederais<T> withVIRRF(BigDecimal string);

    public RetencaoDeTributosFederais<T> withVBCRetPrev(BigDecimal string);

    public RetencaoDeTributosFederais<T> withVRetPrev(BigDecimal string);
}