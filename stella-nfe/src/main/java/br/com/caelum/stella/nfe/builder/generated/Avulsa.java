package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.modelo.TUf;
import br.com.caelum.stella.tinytype.CNPJ;

public interface Avulsa {
    public Avulsa withCNPJ(CNPJ cnpj);

    public Avulsa withXOrgao(String string);

    public Avulsa withMatr(String string);

    public Avulsa withXAgente(String string);

    public Avulsa withFone(String string);

    public Avulsa withUF(TUf tUf);

    public Avulsa withNDAR(String string);

    public Avulsa withDEmi(Calendar calendar);

    public Avulsa withVDAR(String string);

    public Avulsa withRepEmi(String string);

    public Avulsa withDPag(Calendar calendar);
}