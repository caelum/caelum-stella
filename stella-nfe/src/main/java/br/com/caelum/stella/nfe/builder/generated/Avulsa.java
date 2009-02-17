package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.modelo.TUf;
import br.com.caelum.stella.tinytype.CNPJ;

public interface Avulsa {
    public Avulsa withCnpj(CNPJ cnpj);

    public Avulsa withXOrgao(String string);

    public Avulsa withMatr(String string);

    public Avulsa withXAgente(String string);

    public Avulsa withFone(String string);

    public Avulsa withUf(TUf tUf);

    public Avulsa withNdar(String string);

    public Avulsa withDEmi(Calendar calendar);

    public Avulsa withVdar(String string);

    public Avulsa withRepEmi(String string);

    public Avulsa withDPag(Calendar calendar);
}