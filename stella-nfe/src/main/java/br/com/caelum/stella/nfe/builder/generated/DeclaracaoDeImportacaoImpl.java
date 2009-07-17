package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.UF;

public final class DeclaracaoDeImportacaoImpl<T> implements DeclaracaoDeImportacao<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.DI dI;
    private final T parent;

    public DeclaracaoDeImportacaoImpl(final T parent) {
        this.parent = parent;
        dI = new br.com.caelum.stella.nfe.modelo.DI();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.dI;
    }

    public DeclaracaoDeImportacao<T> withNumeroDoDocumentoDeImportacao(final String string) {
        dI.setNDI(string);
        return this;
    }

    public DeclaracaoDeImportacao<T> withDataDaDeclaracaoDeImportacao(final Calendar calendar) {
        dI.setDDI(calendar);
        return this;
    }

    public DeclaracaoDeImportacao<T> withLocalDeDesenbaraco(final String string) {
        dI.setXLocDesemb(string);
        return this;
    }

    public DeclaracaoDeImportacao<T> withUFDoDesembaraco(final UF tUf) {
        dI.setUFDesemb(tUf);
        return this;
    }

    public DeclaracaoDeImportacao<T> withDataDoDeembaraco(final Calendar calendar) {
        dI.setDDesemb(calendar);
        return this;
    }

    public DeclaracaoDeImportacao<T> withCodigoDoExportador(final String string) {
        dI.setCExportador(string);
        return this;
    }

    public DeclaracaoDeImportacao<T> withAdicoes(final Adicao<?>... adis) {
        List<br.com.caelum.stella.nfe.modelo.Adi> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Adi>();
        for (Adicao<?> p : adis) {
            list.add((br.com.caelum.stella.nfe.modelo.Adi) ((ObjectCreator) p).getInstance());
        }
        dI.setAdi(list);
        return this;
    }
}