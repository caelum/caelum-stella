package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;
import java.util.List;

public interface InfCadEmiDFe {
    public InfCadEmiDFe withDPubCad(Calendar calendar);

    public InfCadEmiDFe withEmissor(List<TEmissor> list);

    public InfCadEmiDFe withId(String string);
}