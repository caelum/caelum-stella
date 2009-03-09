package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.modelo.TUf;

public interface ICMSCons {
    public ICMSCons withVBCICMSSTCons(BigDecimal string);

    public ICMSCons withVICMSSTCons(BigDecimal string);

    public ICMSCons withUFCons(TUf tUf);
}