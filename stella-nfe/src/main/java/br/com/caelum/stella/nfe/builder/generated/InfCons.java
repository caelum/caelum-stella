package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;
import java.util.List;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.TUfCons;

public interface InfCons<T> extends NFeBuilder<T> {
    public InfCons<T> withVerAplic(String string);

    public InfCons<T> withCStat(String string);

    public InfCons<T> withXMotivo(String string);

    public InfCons<T> withUF(TUfCons tUfCons);

    public InfCons<T> withIE(String string);

    public InfCons<T> withCNPJ(String string);

    public InfCons<T> withCPF(String string);

    public InfCons<T> withDhCons(Calendar calendar);

    public InfCons<T> withCUF(String string);

    public InfCons<T> withInfCad(List<InfCad<?>> list);
}