package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.TEndereco;
import br.com.caelum.stella.nfe.modelo.TUf;

public interface InfCad<T> extends NFeBuilder<T> {
    public InfCad<T> withIE(String string);

    public InfCad<T> withCNPJ(String string);

    public InfCad<T> withCPF(String string);

    public InfCad<T> withUF(TUf tUf);

    public InfCad<T> withCSit(String string);

    public InfCad<T> withXNome(String string);

    public InfCad<T> withXFant(String string);

    public InfCad<T> withXRegApur(String string);

    public InfCad<T> withCNAE(String string);

    public InfCad<T> withDIniAtiv(Calendar calendar);

    public InfCad<T> withDUltSit(Calendar calendar);

    public InfCad<T> withDBaixa(Calendar calendar);

    public InfCad<T> withIEUnica(String string);

    public InfCad<T> withIEAtual(String string);

    public InfCad<T> withEnder(TEndereco tEndereco);
}