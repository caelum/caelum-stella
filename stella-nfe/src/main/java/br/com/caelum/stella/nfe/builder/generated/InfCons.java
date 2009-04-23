package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;
import java.util.List;

import br.com.caelum.stella.nfe.modelo.TUfCons;

public interface InfCons {
    public InfCons withVerAplic(String string);

    public InfCons withCStat(String string);

    public InfCons withXMotivo(String string);

    public InfCons withUF(TUfCons tUfCons);

    public InfCons withIE(String string);

    public InfCons withCNPJ(String string);

    public InfCons withCPF(String string);

    public InfCons withDhCons(Calendar calendar);

    public InfCons withCUF(String string);

    public InfCons withInfCad(List<InfCad> list);
}