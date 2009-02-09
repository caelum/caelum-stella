package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;
import br.com.caelum.stella.tinytype.CNPJ;

public interface TLocal {
    public TLocal withCNPJ(CNPJ cnpj);

    public TLocal withXLgr(String string);

    public TLocal withNro(String string);

    public TLocal withXCpl(String string);

    public TLocal withXBairro(String string);

    public TLocal withCMun(String string);

    public TLocal withXMun(String string);

    public TLocal withUF(TUf tUf);
}