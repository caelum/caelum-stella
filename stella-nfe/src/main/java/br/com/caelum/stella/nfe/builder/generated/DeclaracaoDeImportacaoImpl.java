package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.UF;

public final class DeclaracaoDeImportacaoImpl implements DeclaracaoDeImportacao, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.DI dI;

    public DeclaracaoDeImportacaoImpl() {
        dI = new br.com.caelum.stella.nfe.modelo.DI();
    }

    public br.com.caelum.stella.nfe.modelo.DI getInstance() {
        return dI;
    }

    public DeclaracaoDeImportacao withNumeroDoDocumentoDeImportacao(final String string) {
        dI.setNDI(string);
        return this;
    }

    public DeclaracaoDeImportacao withDataDaDeclaracaoDeImportacao(final Calendar calendar) {
        dI.setDDI(calendar);
        return this;
    }

    public DeclaracaoDeImportacao withLocalDeDesenbaraco(final String string) {
        dI.setXLocDesemb(string);
        return this;
    }

    public DeclaracaoDeImportacao withUFDoDesembaraco(final UF tUf) {
        dI.setUFDesemb(tUf);
        return this;
    }

    public DeclaracaoDeImportacao withDataDoDeembaraco(final Calendar calendar) {
        dI.setDDesemb(calendar);
        return this;
    }

    public DeclaracaoDeImportacao withCodigoDoExportador(final String string) {
        dI.setCExportador(string);
        return this;
    }

    public DeclaracaoDeImportacao withAdicoes(final Adicao... adis) {
        List<br.com.caelum.stella.nfe.modelo.Adi> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Adi>();
        for (Adicao p : adis) {
            list.add((br.com.caelum.stella.nfe.modelo.Adi) ((ObjectCreator) p).getInstance());
        }
        dI.setAdi(list);
        return this;
    }
}