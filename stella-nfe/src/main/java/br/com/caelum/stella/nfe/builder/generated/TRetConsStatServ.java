package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface TRetConsStatServ<T> extends NFeBuilder<T> {
    public TRetConsStatServ<T> withTpAmb(String string);

    public TRetConsStatServ<T> withVerAplic(String string);

    public TRetConsStatServ<T> withCStat(String string);

    public TRetConsStatServ<T> withXMotivo(String string);

    public TRetConsStatServ<T> withCUF(String string);

    public TRetConsStatServ<T> withDhRecbto(Calendar calendar);

    public TRetConsStatServ<T> withTMed(String string);

    public TRetConsStatServ<T> withDhRetorno(Calendar calendar);

    public TRetConsStatServ<T> withXObs(String string);

    public TRetConsStatServ<T> withVersao(String string);
}