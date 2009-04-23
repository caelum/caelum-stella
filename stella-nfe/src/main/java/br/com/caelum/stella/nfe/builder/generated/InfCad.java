package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.modelo.TEndereco;
import br.com.caelum.stella.nfe.modelo.TUf;

public interface InfCad {
    public InfCad withIE(String string);

    public InfCad withCNPJ(String string);

    public InfCad withCPF(String string);

    public InfCad withUF(TUf tUf);

    public InfCad withCSit(String string);

    public InfCad withXNome(String string);

    public InfCad withXFant(String string);

    public InfCad withXRegApur(String string);

    public InfCad withCNAE(String string);

    public InfCad withDIniAtiv(Calendar calendar);

    public InfCad withDUltSit(Calendar calendar);

    public InfCad withDBaixa(Calendar calendar);

    public InfCad withIEUnica(String string);

    public InfCad withIEAtual(String string);

    public InfCad withEnder(TEndereco tEndereco);
}