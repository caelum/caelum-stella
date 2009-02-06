package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public interface TEndereco {
    public TEndereco withXLgr(String string);

    public TEndereco withNro(String string);

    public TEndereco withXCpl(String string);

    public TEndereco withXBairro(String string);

    public TEndereco withCMun(String string);

    public TEndereco withXMun(String string);

    public TEndereco withUF(TUf tUf);

    public TEndereco withCEP(String string);

    public TEndereco withCPais(String string);

    public TEndereco withXPais(String string);

    public TEndereco withFone(String string);
}