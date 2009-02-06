package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.modelo.TUf;

public interface DI {
    public DI withNDI(String string);

    public DI withDDI(Calendar calendar);

    public DI withXLocDesemb(String string);

    public DI withUFDesemb(TUf tUf);

    public DI withDDesemb(Calendar calendar);

    public DI withCExportador(String string);

    public DI withAdi(Adi... adis);
}